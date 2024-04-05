package br.edu.iftm.onetoone.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MensagemCorpo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String descricao;
}
