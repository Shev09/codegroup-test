package com.codegroup.javatest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.codegroup.javatest.domain.Projeto;
import com.codegroup.javatest.web.model.NovoProjetoDTO;
import com.codegroup.javatest.web.model.ProjetoDTO;

@Mapper(componentModel = "spring", uses = MembroMapper.class )

public interface ProjetoMapper {

	@Mapping(target = "nomeGerente", source = "gerente.nome")
	ProjetoDTO projetoToProjetoDTO(Projeto projeto);
	
	List<ProjetoDTO> projetosToProjetoDTOs(List<Projeto> projetos);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "membros", ignore = true)
	@Mapping(target = "gerente", ignore = true)
	Projeto projetoDTOToProjeto(ProjetoDTO projetoDTO);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "membros", ignore = true)
	@Mapping(target = "gerente", ignore = true)
	Projeto novoProjetoDTOToProjeto(NovoProjetoDTO novoProjetoDTO);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "membros", ignore = true)
	Projeto updateProjeto(Projeto updatedProjeto, @MappingTarget Projeto projeto);
	
}
