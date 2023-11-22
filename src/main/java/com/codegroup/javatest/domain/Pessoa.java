package com.codegroup.javatest.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@Entity
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "nome", length = 100)
    private String nome;
    
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    @Column(name = "cpf", length = 14)
    private String cpf;
    
    @Column(name = "funcionario", nullable = false)
    @Builder.Default
    private Boolean funcionario = false;
  

}
