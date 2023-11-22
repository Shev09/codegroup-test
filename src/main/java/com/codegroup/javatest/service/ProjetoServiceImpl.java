package com.codegroup.javatest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codegroup.javatest.domain.Membro;
import com.codegroup.javatest.domain.Pessoa;
import com.codegroup.javatest.domain.Projeto;
import com.codegroup.javatest.domain.enumeration.Status;
import com.codegroup.javatest.exception.NotFuncionarioException;
import com.codegroup.javatest.exception.ResourceNotFoundException;
import com.codegroup.javatest.exception.UnableDeleteException;
import com.codegroup.javatest.mapper.ProjetoMapper;
import com.codegroup.javatest.repository.MembroRepository;
import com.codegroup.javatest.repository.PessoaRepository;
import com.codegroup.javatest.repository.ProjetoRepository;
import com.codegroup.javatest.web.model.NovoMembroDTO;
import com.codegroup.javatest.web.model.NovoProjetoDTO;
import com.codegroup.javatest.web.model.ProjetoDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {
	
	private final ProjetoRepository repository;
	private final ProjetoMapper mapper;
	private final PessoaRepository pessoaRepository;
	private final MembroRepository membroRepository;

	@Override
	public List<ProjetoDTO> getProjetos() {
		return mapper.projetosToProjetoDTOs(repository.findAll());
	}

	@Override
	public ProjetoDTO create(NovoProjetoDTO novoProjetoDTO) {

		Pessoa gerente = pessoaRepository.findById(novoProjetoDTO.getIdGerente())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Gerente com o id: %s", novoProjetoDTO.getIdGerente())));
		
		Projeto projeto = mapper.novoProjetoDTOToProjeto(novoProjetoDTO);
		projeto.setGerente(gerente);
		repository.save(projeto);
	
		return mapper.projetoToProjetoDTO(projeto);
	}

	@Override
	public ProjetoDTO addMembro(NovoMembroDTO novoMembroDTO, Long idProjeto) {
		Projeto projeto = repository.findById(idProjeto)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Projeto com o id: %s", idProjeto)));
		
		Pessoa pessoa = pessoaRepository.findById(novoMembroDTO.getIdPessoa())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Pessoa com o id: %s", novoMembroDTO.getIdPessoa())));
		
		if(!pessoa.getFuncionario()) throw new NotFuncionarioException(idProjeto);
		
		membroRepository.save(
				Membro.builder()
				.cargo(novoMembroDTO.getCargo())
				.projeto(projeto)
				.pessoa(pessoa)
				.build()
				);
		
		return mapper.projetoToProjetoDTO(repository.findById(idProjeto).get());
	}
	
	@Override
	public ProjetoDTO update(NovoProjetoDTO updatedProjetoDTO, Long idProjeto) {
		
		Projeto actualProjeto = repository.findById(idProjeto)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Projeto com o id: %s", idProjeto)));
		

		Pessoa gerente = pessoaRepository.findById(updatedProjetoDTO.getIdGerente())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Gerente com o id: %s", updatedProjetoDTO.getIdGerente())));
		
		Projeto projeto = mapper.updateProjeto(mapper.novoProjetoDTOToProjeto(updatedProjetoDTO), actualProjeto);
		projeto.setGerente(gerente);
		repository.save(projeto);
	
		return mapper.projetoToProjetoDTO(projeto);
	}

	@Override
	public Void delete(Long idProjeto) {
		
		Projeto projeto = repository.findById(idProjeto)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Projeto com o id: %s", idProjeto)));

		if(projeto.getStatus().equals(Status.INICIADO) || 
		   projeto.getStatus().equals(Status.EM_ANDAMENTO) ||
		   projeto.getStatus().equals(Status.ENCERRADO)) {
			throw new UnableDeleteException(idProjeto);
		}
		
		repository.delete(projeto);
				
		return null;
	}
	
	

	
	

	
}
