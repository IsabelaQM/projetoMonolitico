package br.edu.iftm.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.domain.Lance;
import br.edu.iftm.leilao.repository.LanceRepository;
import br.edu.iftm.leilao.service.exception.LanceNaoEncontradoException;

@Service
public class LanceService {

	@Autowired
	private LanceRepository repository;

	public Lance findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new LanceNaoEncontradoException(id));
	}

	public List<Lance> getAll() {
		return repository.findAll();
	}

	public Lance save(Lance entity) {
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Lance update(Integer id, Lance entity) {
		entity.setId(id);
		return repository.save(entity);
	}
	

}


