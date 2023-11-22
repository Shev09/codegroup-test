package com.codegroup.javatest.exception;

public class NotFuncionarioException  extends RuntimeException {

	public NotFuncionarioException(Long idPessoa) {
		super("O membro com id " + idPessoa+ " não é um funcionário");
	}
}
