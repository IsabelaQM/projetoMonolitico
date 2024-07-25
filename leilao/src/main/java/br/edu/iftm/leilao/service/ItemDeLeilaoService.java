package br.edu.iftm.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.domain.ItemDeLeilao;
import br.edu.iftm.leilao.domain.Lance;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;
import br.edu.iftm.leilao.service.exception.LanceNaoEncontradoException;
import br.edu.iftm.leilao.service.exception.LeilaoFinalizadoException;

@Service
public class ItemDeLeilaoService {

	@Autowired
	private ItemDeLeilaoRepository repository;

	@Autowired
	private LanceService lanceService;

	public ItemDeLeilao findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new LanceNaoEncontradoException(id));
	}

	public List<ItemDeLeilao> getAll() {
		return repository.findAll();
	}

	public ItemDeLeilao save(ItemDeLeilao entity) {
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public ItemDeLeilao update(Integer id, ItemDeLeilao entity) {
		entity.setId(id);
		return repository.save(entity);
	}

	public ItemDeLeilao registrarLance(Integer id, Lance lance) {
		ItemDeLeilao itemDeLeilao = findById(id);
		if (itemDeLeilao.getLeilaoAberto()) {
			// salva o lance no banco de dados
			lance = lanceService.save(lance);
			// adiciona à lista de lances do item de leilão
			itemDeLeilao.getLancesRecebidos().add(lance);
			if (itemDeLeilao.getLanceVencedor() == null || 
			   (itemDeLeilao.getLanceVencedor() != null && lance.getValor() > itemDeLeilao.getLanceVencedor().getValor())) {
				itemDeLeilao.setLanceVencedor(lance);
			}
			return update(id, itemDeLeilao);
		}
		throw new LeilaoFinalizadoException();
	}

	public Lance update(Integer id) {
		ItemDeLeilao itemDeLeilao = findById(id);
		itemDeLeilao.setLeilaoAberto(false);
		repository.save(itemDeLeilao);
		return itemDeLeilao.getLanceVencedor();
	}
}
