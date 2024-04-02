package br.edu.iftm.onetomanybidirecional.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.iftm.onetomanybidirecional.domain.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    
}