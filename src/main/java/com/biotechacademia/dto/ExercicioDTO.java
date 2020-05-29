package com.biotechacademia.dto;

import java.io.Serializable;

import com.biotechacademia.domain.Exercicio;

public class ExercicioDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public ExercicioDTO () {
		
	}
	
	public ExercicioDTO(Exercicio obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}