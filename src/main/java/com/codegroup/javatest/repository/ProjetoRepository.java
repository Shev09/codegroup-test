package com.codegroup.javatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegroup.javatest.domain.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
	
}
