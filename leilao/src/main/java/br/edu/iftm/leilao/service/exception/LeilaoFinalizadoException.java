package br.edu.iftm.leilao.service.exception;

public class LeilaoFinalizadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LeilaoFinalizadoException() {
		super("Leilao Encerrado!");
	}

}
