package com.codegroup.javatest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.codegroup.javatest.domain.Pessoa;
import com.codegroup.javatest.web.model.PessoaDTO;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

	PessoaDTO pessoaToPessoaDTO(Pessoa pessoa);
	
	List<PessoaDTO> pessoasToPessoasDTO(List<Pessoa> pessoa);
	
	@Mapping(target = "id", ignore = true)
	Pessoa pessoaDTOToPessoa(PessoaDTO pessoaDTO);
	
}
