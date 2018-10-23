package be.vdab.frituurfrida.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import be.vdab.frituurfrida.repositories.SausRepository;
import be.vdab.frituurfrida.valueobjects.Saus;

@Service
class DefaultSausService implements SausService {
	
	private final SausRepository sausRepository;
	
	
	DefaultSausService (@Qualifier("properties") SausRepository sausRepository) {
		this.sausRepository = sausRepository;
	}
	
	@Override
	public List<Saus> findAll() {
		return sausRepository.findAll();
	}
}	
