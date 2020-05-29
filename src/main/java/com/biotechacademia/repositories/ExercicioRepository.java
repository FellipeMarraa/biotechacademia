package com.biotechacademia.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biotechacademia.domain.Categoria;
import com.biotechacademia.domain.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Exercicio obj INNER JOIN obj.categorias cat WHERE obj.nome like %:nome% AND cat IN :categorias")
	Page<Exercicio> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}