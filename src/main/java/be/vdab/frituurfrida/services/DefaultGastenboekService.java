package be.vdab.frituurfrida.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.frituurfrida.entities.GastenboekEntry;
import be.vdab.frituurfrida.repositories.GastenboekRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultGastenboekService implements GastenboekService {
	private final GastenboekRepository gastenboekRepository;
	
	DefaultGastenboekService (GastenboekRepository gastenboekRepository) {
		this.gastenboekRepository = gastenboekRepository;
	}
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void create(GastenboekEntry entry) {
		gastenboekRepository.create(entry);
	}
	@Override
	public List<GastenboekEntry> findAll() {
		return gastenboekRepository.findAll();
	}
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void delete(long[] ids) {
		Arrays.stream(ids).forEach(id -> gastenboekRepository.delete(id));
	}

}
