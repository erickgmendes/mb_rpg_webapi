package com.erickgm.sharpsword.repository;

import com.erickgm.sharpsword.domain.entities.Alinhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AlinhamentoRepository extends JpaRepository<Alinhamento, Long>, PagingAndSortingRepository<Alinhamento, Long> {

    Alinhamento findById(long id);

    Alinhamento findByNome(String nome);

    List<Alinhamento> findByOrderByNomeAsc();

}
