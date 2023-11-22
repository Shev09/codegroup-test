package com.codegroup.javatest.service;

import java.util.List;

import com.codegroup.javatest.web.model.NovoMembroDTO;
import com.codegroup.javatest.web.model.NovoProjetoDTO;
import com.codegroup.javatest.web.model.ProjetoDTO;

public interface ProjetoService {

	List<ProjetoDTO> getProjetos();
	
	ProjetoDTO create(NovoProjetoDTO novoProjetoDTO);
	
	ProjetoDTO addMembro(NovoMembroDTO novoMembroDTO, Long idProjeto);
	
	ProjetoDTO update(NovoProjetoDTO novoProjetoDTO, Long idProjeto);

	Void delete(Long idProjeto);

}