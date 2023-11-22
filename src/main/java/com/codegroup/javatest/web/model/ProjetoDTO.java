package com.codegroup.javatest.web.model;

import java.util.Date;
import java.util.List;

import com.codegroup.javatest.domain.enumeration.Risco;
import com.codegroup.javatest.domain.enumeration.Status;

import lombok.Data;

@Data
public class ProjetoDTO {
	
    private String nome;
    
    private Date dataInicio;
    
    private Date dataPrevisaoFim;
    
    private Date dataFim;
    
    private String descricao;
    
    private Status status;
    
    private double orcamento;
    
    private Risco risco;
    
    private String nomeGerente;
    
    private List<MembroDTO> membros;
  
}
