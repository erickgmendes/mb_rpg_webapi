package com.erickgm.sharpsword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erickgm.sharpsword.domain.entities.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

	Equipamento findByNome(String nome);

	Equipamento findById(long id);

}