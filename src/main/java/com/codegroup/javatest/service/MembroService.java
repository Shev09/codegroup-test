package com.codegroup.javatest.service;

import java.util.List;

import com.codegroup.javatest.web.model.PessoaDTO;

public interface MembroService {

	List<PessoaDTO> getPessoas();
	
	PessoaDTO create(PessoaDTO pessoaDTO);

}