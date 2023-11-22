package com.codegroup.javatest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codegroup.javatest.domain.Pessoa;
import com.codegroup.javatest.mapper.PessoaMapper;
import com.codegroup.javatest.repository.PessoaRepository;
import com.codegroup.javatest.web.model.PessoaDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembroServiceImpl implements MembroService {
	
	private final PessoaRepository repository;
	private final PessoaMapper mapper;
	
	@Override
	public List<PessoaDTO> getPessoas() {
		return mapper.pessoasToPessoasDTO(repository.findAll());
	}

	@Override
	public PessoaDTO create(PessoaDTO pessoaDTO) {
		Pessoa pessoa = repository.save(mapper.pessoaDTOToPessoa(pessoaDTO));
		return mapper.pessoaToPessoaDTO(pessoa);
	}

	
}
