package br.edu.iftm.onetoone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.iftm.onetoone.domain.Mensagem;
import br.edu.iftm.onetoone.repository.MensagemRepository;

@Service
public class MensagemService {

    MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public List<Mensagem> getAll() {
        try {
            List<Mensagem> mensagens = new ArrayList<Mensagem>();
            mensagemRepository.findAll().forEach(mensagens::add);
            return mensagens;
        } catch (Exception e) {
            return null;
        }
    }

    public Mensagem getById(Long id) {
        Optional<Mensagem> mensagem = mensagemRepository.findById(id);
        if (mensagem.isPresent()) {
            return mensagem.get();
        }
        return null;
    }

    public Mensagem create(Mensagem mensagem) {
        return mensagemRepository.save(mensagem);
    }

    public Mensagem update(Long id, Mensagem mensagem) {
        Optional<Mensagem> mensagemOptional = mensagemRepository.findById(id);
        if (mensagemOptional.isPresent()) {
            Mensagem existingMensagem = mensagemOptional.get();
            existingMensagem.setAssunto(mensagem.getAssunto());
            return mensagemRepository.save(existingMensagem);
        }
        return null;
    }

    public boolean delete(Long id) {
        try {
            mensagemRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
