package com.mobicare.backendplenohigorbraga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobicare.backendplenohigorbraga.domain.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>  {

	@Transactional
	Colaborador findByCpf(String cpf);

}
