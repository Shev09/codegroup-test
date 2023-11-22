package com.codegroup.javatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegroup.javatest.domain.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {
	
}
