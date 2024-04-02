package br.edu.iftm.onetomanybidirecional.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.onetomanybidirecional.domain.Categoria;
import br.edu.iftm.onetomanybidirecional.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Categoria getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return service.create(categoria);
    }

    @PutMapping("{id}")
    public Categoria update(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        return service.update(id, categoria);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
