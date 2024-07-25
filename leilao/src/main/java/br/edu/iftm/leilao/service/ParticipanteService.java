package br.edu.iftm.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.domain.Participante;
import br.edu.iftm.leilao.repository.ParticipanteRepository;
import br.edu.iftm.leilao.service.exception.ParticipanteNaoEncontradoException;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository repository;

	public Participante findById(Integer id) {
		return repository.findById(id).
				orElseThrow(() -> new ParticipanteNaoEncontradoException(id));
	}

	public List<Participante> getAll() {
		return repository.findAll();
	}

	public Participante save(Participante entity) {
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Participante update(Integer id, Participante entity) {
		entity.setId(id);
		return repository.save(entity);
	}

}

