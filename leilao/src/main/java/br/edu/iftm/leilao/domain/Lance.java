package br.edu.iftm.leilao.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Lance{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double valor;

	@ManyToOne
	private Participante participante;
}

