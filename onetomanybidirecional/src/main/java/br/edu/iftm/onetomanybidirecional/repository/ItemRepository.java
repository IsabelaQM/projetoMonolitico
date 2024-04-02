package br.edu.iftm.onetomanybidirecional.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.iftm.onetomanybidirecional.domain.Item;

public interface ItemRepository extends CrudRepository<Item,Long> {
    
}
