package com.codegroup.javatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegroup.javatest.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
}
