package be.vdab.frituurfrida.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.frituurfrida.entities.GastenboekEntry;

@Repository
class JdbcGastenboekRepository implements GastenboekRepository {
	private final SimpleJdbcInsert insert;
	private final JdbcTemplate template;
	
	JdbcGastenboekRepository (JdbcTemplate template) {
		this.template = template;
		this.insert = new SimpleJdbcInsert(template);
		insert.withTableName("gastenboek");
		insert.usingGeneratedKeyColumns("id");
	}
	@Override
	public void create(GastenboekEntry entry) {
		Map<String, Object> kolomwaarden = new HashMap<>();
		kolomwaarden.put("naam", entry.getNaam());
		kolomwaarden.put("datumtijd", entry.getDatumtijd());
		kolomwaarden.put("bericht", entry.getBericht());
		Number id = insert.executeAndReturnKey(kolomwaarden);
		entry.setId(id.longValue());
		
	}
	private static final String SQL_SELECT_ALL = "select id, naam, datumtijd, bericht from gastenboek order by datumtijd desc";
	private final RowMapper<GastenboekEntry> entryRowMapper = 
			(resultSet, rowNum) -> new GastenboekEntry(resultSet.getLong("id"),
					resultSet.getString("naam"),
					resultSet.getTimestamp("datumtijd").toLocalDateTime(),
					resultSet.getString("bericht"));
	@Override
	public List<GastenboekEntry> findAll(){
		return template.query(SQL_SELECT_ALL, entryRowMapper);
		
	}
	private static final String SQL_DELETE = "delete from gastenboek where id=?";
	@Override
	public void delete(long id) {
		template.update(SQL_DELETE, id);
	}
}
