package com.codegroup.javatest.exception;

public class UnableDeleteException  extends RuntimeException {

	public UnableDeleteException(Long idProjeto) {
		super("O projeto com id " + idProjeto+ " não pode ser deletado.");
	}
}
