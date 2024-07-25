package br.edu.iftm.leilao.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ItemDeLeilao{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private double valorMinimo;
	private Boolean leilaoAberto;

    // Vários lances e um lance vencedor
	@OneToOne
	private Lance lanceVencedor;
	@OneToMany
	private List<Lance> lancesRecebidos = new ArrayList<Lance>();
	
}
