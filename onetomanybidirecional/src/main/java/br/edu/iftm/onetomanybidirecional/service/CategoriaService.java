package br.edu.iftm.onetomanybidirecional.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.iftm.onetomanybidirecional.domain.Categoria;
import br.edu.iftm.onetomanybidirecional.repository.CategoriaRepository;

@Service
public class CategoriaService {

        CategoriaRepository repository;

        public CategoriaService(CategoriaRepository repository) {
                this.repository = repository;
        }

        public List<Categoria> getAll() {
                try {
                        List<Categoria> items = new ArrayList<Categoria>();
                        repository.findAll().forEach(items::add);
                        return items;
                } catch (Exception e) {
                        return null;
                }
        }

        public Categoria getById(Long id) {
                Optional<Categoria> categoria = repository.findById(id);
                if (categoria.isPresent()) {
                        return categoria.get();
                }
                return null;
        }

        public Categoria create(Categoria categoria) {
                return repository.save(categoria);
        }

        public Categoria update(Long id, Categoria item) {
                Optional<Categoria> existingItemOptional = repository.findById(id);

                if (existingItemOptional.isPresent()) {
                        Categoria existingItem = existingItemOptional.get();
                        existingItem.setNome(item.getNome());
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