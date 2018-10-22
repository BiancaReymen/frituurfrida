package be.vdab.frituurfrida.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.vdab.frituurfrida.repositories.SausRepository;
import be.vdab.frituurfrida.valueobjects.Saus;

@Service
class DefaultSausService implements SausService {
	
	private final SausRepository sausRepository;
	
	DefaultSausService (SausRepository sausRepository) {
		this.sausRepository = sausRepository;
	}
	
	@Override
	public List<Saus> findAll() {
		return sausRepository.findAll();
	}
	
	

}
