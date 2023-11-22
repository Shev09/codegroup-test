package com.codegroup.javatest.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.codegroup.javatest.domain.enumeration.Risco;
import com.codegroup.javatest.domain.enumeration.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@Entity
@Table(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "nome", length = 200)
    private String nome;
    
    @Column(name = "data_inicio")
    private Date dataInicio;
    
    @Column(name = "data_previsao_fim")
    private Date dataPrevisaoFim;
    
    @Column(name = "data_fim")
    private Date dataFim;
    
    @Column(name = "descricao", length = 5000)
    private String descricao;
    
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(name = "orcamento")
    private double orcamento;
    
    @Column(name = "risco", nullable = false)
    @Enumerated(EnumType.STRING)
    private Risco risco;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gerente_id", nullable=false)
    @EqualsAndHashCode.Exclude
    private Pessoa gerente;
    
    @EqualsAndHashCode.Exclude
    @Builder.Default
    @OneToMany(mappedBy="projeto", cascade = CascadeType.ALL)
    private List<Membro> membros = new ArrayList<>();

}
