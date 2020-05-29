package com.biotechacademia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biotechacademia.domain.ItemLista;

@Repository
public interface ItemListaRepository extends JpaRepository<ItemLista, Integer>{


}
