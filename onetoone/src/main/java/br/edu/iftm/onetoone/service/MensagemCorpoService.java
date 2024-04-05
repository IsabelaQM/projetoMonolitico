package br.edu.iftm.onetoone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.iftm.onetoone.domain.MensagemCorpo;
import br.edu.iftm.onetoone.repository.MensagemCorpoRepository;

@Service
public class MensagemCorpoService {

        private final MensagemCorpoRepository repository;

        public MensagemCorpoService(MensagemCorpoRepository repository) {
                this.repository = repository;
        }

        public List<MensagemCorpo> getAll() {
                try {
                        List<MensagemCorpo> items = new ArrayList<MensagemCorpo>();
                        repository.findAll().forEach(items::add);
                        return items;
                } catch (Exception e) {
                        return null;
                }
        }

        public MensagemCorpo getById(Long id) {
                Optional<MensagemCorpo> item = repository.findById(id);
                if (item.isPresent()) {
                        return item.get();
                }
                return null;
        }

        public MensagemCorpo create(MensagemCorpo item) {
                return repository.save(item);
        }

        public MensagemCorpo update(Long id, MensagemCorpo item) {
                Optional<MensagemCorpo> existingItemOptional = repository.findById(id);

                if (existingItemOptional.isPresent()) {
                        MensagemCorpo existingItem = existingItemOptional.get();
                        existingItem.setDescricao(item.getDescricao());
                        return repository.save(existingItem);
                } else {
                        return null;
                }
        }

        public boolean delete(Long id) {
                try {
                        repository.deleteById(id);
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }

}
