package com.codegroup.javatest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.codegroup.javatest.domain.Membro;
import com.codegroup.javatest.web.model.MembroDTO;

@Mapper(componentModel = "spring")
public interface MembroMapper {

	@Mapping(target = "nomePessoa", source = "pessoa.nome")
	MembroDTO membroToMembroDTO(Membro membro);
	
	List<MembroDTO> membrosToMembroDTOs(List<Membro> membros);
	
}
