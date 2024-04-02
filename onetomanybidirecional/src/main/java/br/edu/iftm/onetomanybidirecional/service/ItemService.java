package br.edu.iftm.onetomanybidirecional.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.iftm.onetomanybidirecional.domain.Item;
import br.edu.iftm.onetomanybidirecional.repository.ItemRepository;

@Service
public class ItemService {

        private final ItemRepository repository;

        public ItemService(ItemRepository repository) {
                this.repository = repository;
        }

        public List<Item> getAll() {
                try {
                        List<Item> items = new ArrayList<Item>();
                        repository.findAll().forEach(items::add);
                        return items;
                } catch (Exception e) {
                        return null;
                }
        }

        public Item getById(Long id) {
                Optional<Item> item = repository.findById(id);
                if (item.isPresent()) {
                        return item.get();
                }
                return null;
        }

        public Item create(Item item) {
                return repository.save(item);
        }

        public Item update(Long id, Item item) {
                Optional<Item> existingItemOptional = repository.findById(id);

                if (existingItemOptional.isPresent()) {
                        Item existingItem = existingItemOptional.get();
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
