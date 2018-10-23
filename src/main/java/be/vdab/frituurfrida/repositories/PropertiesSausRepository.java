package be.vdab.frituurfrida.repositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import be.vdab.frituurfrida.exceptions.SausRepositoryException;
import be.vdab.frituurfrida.valueobjects.Saus;

@Component
@Qualifier("properties")
public class PropertiesSausRepository implements SausRepository {

	private static final Path PAD = Paths.get("/data/sauzen.properties");
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesSausRepository.class);
	
	@Override
	public List<Saus> findAll() {
		List<Saus> sauzen = new ArrayList<>();
		
		try (BufferedReader reader = Files.newBufferedReader(PAD)){
			for (String regel; (regel = reader.readLine()) != null;) {
				if(!regel.isEmpty()) {
					sauzen.add(maakSaus(regel));
				}
			}
		} catch (IOException ex) {
			String fout = "fout bij lezen" + PAD;
			LOGGER.error(fout, ex); 
			throw new SausRepositoryException(fout);
		}
		return sauzen;
	}
	private Saus maakSaus(String regel) {
		String[] onderdelen = regel.split(":");
		if (onderdelen.length < 2) {
			String fout = PAD + ":" + regel + " bevat minder dan 2 onderdelen";
			LOGGER.error(fout);
			throw new SausRepositoryException(fout);
			
		}
		try {
			String[] onderdelen2 = onderdelen[1].split(",");
			Saus saus = new Saus(Long.parseLong(onderdelen[0]), onderdelen2[0]);
			for (int index = 2; index < onderdelen2.length; index++) {
				saus.addIngredienten(onderdelen2[index]);
			}
		
			return saus;
		} catch (NumberFormatException ex) {
			String fout = PAD + ":" + regel + " bevat verkeerde id";
			LOGGER.error(fout);
			throw new SausRepositoryException(fout);
		}

	}
}
