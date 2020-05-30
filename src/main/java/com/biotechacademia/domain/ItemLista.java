package com.biotechacademia.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemLista implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemListaPK id = new ItemListaPK();
	
	public ItemLista() {
		
	}

	public ItemLista(Exercicio exercicio, Cliente cliente) {
		super();
		id.setCliente(cliente);
		id.setExercicio(exercicio);
	}

	public ItemListaPK getId() {
		return id;
	}

	public void setId(ItemListaPK id) {
		this.id = id;
	}
	

	public Exercicio getExercicio() {
		return id.getExercicio();
	}
	
	@JsonIgnore
	public Cliente getCliente() {
		return id.getCliente();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLista other = (ItemLista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
