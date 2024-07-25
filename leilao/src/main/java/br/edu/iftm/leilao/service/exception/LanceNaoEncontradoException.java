package br.edu.iftm.leilao.service.exception;

public class LanceNaoEncontradoException extends RuntimeException {

	public LanceNaoEncontradoException(Integer id) {
		super("Item não encontrado: " + id);
	}

}
