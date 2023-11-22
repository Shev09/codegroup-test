package com.codegroup.javatest.web.model;

import java.util.Date;

import lombok.Data;

@Data
public class PessoaDTO {
	
    private String nome;
    
    private Date dataNascimento;
    
    private String cpf;
      
    private Boolean funcionario;
  
}
