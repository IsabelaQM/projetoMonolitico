package br.edu.iftm.onetoone.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.iftm.onetoone.domain.Mensagem;

public interface MensagemRepository extends CrudRepository<Mensagem,Long> {
    
}
