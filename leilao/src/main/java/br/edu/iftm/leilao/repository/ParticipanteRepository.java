package br.edu.iftm.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.leilao.domain.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

}
