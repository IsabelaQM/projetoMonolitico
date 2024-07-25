package br.edu.iftm.leilao.controller;

import java.util.List;

import br.edu.iftm.leilao.domain.Lance;
import br.edu.iftm.leilao.service.LanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lance")
public class LanceController {

	@Autowired
	private LanceService service;

	@GetMapping("/{id}")
	public ResponseEntity<Lance> lance(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<Lance>> lances() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Lance> atualiza(@PathVariable Integer id, @RequestBody Lance entity) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
	}
}

