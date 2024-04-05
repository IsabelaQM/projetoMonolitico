package br.edu.iftm.onetoone.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.iftm.onetoone.domain.MensagemCorpo;

public interface MensagemCorpoRepository extends CrudRepository<MensagemCorpo,Long> {
    
}
