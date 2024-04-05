package br.edu.iftm.onetoone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.onetoone.domain.Mensagem;
import br.edu.iftm.onetoone.service.MensagemService;

@RestController
@RequestMapping("/mensagens")
class MensagemController {

        MensagemService service;

        public MensagemController(MensagemService service) {
            this.service = service;
        }
    
        @GetMapping
        public List<Mensagem> getAll() {
                return service.getAll();
        }

        @GetMapping("{id}")
        public Mensagem getById(@PathVariable("id") Long id) {
                return service.getById(id);
        }

        @PostMapping
        public Mensagem create(@RequestBody Mensagem mensagem) {
                return service.create(mensagem);
        }

        @PutMapping("{id}")
        public Mensagem update(@PathVariable("id") Long id, @RequestBody Mensagem mensagem) {
                return service.update(id, mensagem);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return service.delete(id);
        }
}