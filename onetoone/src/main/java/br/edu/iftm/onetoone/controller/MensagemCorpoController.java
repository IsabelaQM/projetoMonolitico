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

import br.edu.iftm.onetoone.domain.MensagemCorpo;
import br.edu.iftm.onetoone.service.MensagemCorpoService;

@RestController
@RequestMapping("/mensagenscorpo")
public class MensagemCorpoController {

    private final MensagemCorpoService service;

    public MensagemCorpoController(MensagemCorpoService service) {
        this.service = service;
    }

    @GetMapping
    public List<MensagemCorpo> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public MensagemCorpo getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public MensagemCorpo create(@RequestBody MensagemCorpo categoria) {
        return service.create(categoria);
    }

    @PutMapping("{id}")
    public MensagemCorpo update(@PathVariable("id") Long id, @RequestBody MensagemCorpo categoria) {
        return service.update(id, categoria);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
