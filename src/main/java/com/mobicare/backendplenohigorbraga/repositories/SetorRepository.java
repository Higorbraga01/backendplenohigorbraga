package com.mobicare.backendplenohigorbraga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobicare.backendplenohigorbraga.domain.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>  {
}
