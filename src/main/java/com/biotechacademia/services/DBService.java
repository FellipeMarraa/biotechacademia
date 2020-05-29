package com.biotechacademia.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biotechacademia.domain.Categoria;
import com.biotechacademia.domain.Cliente;
import com.biotechacademia.domain.Exercicio;
import com.biotechacademia.domain.ItemLista;
import com.biotechacademia.domain.enums.Perfil;
import com.biotechacademia.repositories.CategoriaRepository;
import com.biotechacademia.repositories.ClienteRepository;
import com.biotechacademia.repositories.ExercicioRepository;
import com.biotechacademia.repositories.ItemListaRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
    @Autowired
    private CategoriaRepository categoriaRepository;

    
    @Autowired
    private ExercicioRepository exercicioRepository;
    @Autowired
  
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ItemListaRepository itemListaRepository;

    public void instantiateTestDataBase() throws ParseException {
    	Categoria cat1 = new Categoria(null, "Alongamentos");
		Categoria cat2 = new Categoria(null, "Biceps");
		
		Exercicio ex1 = new Exercicio(null, "Alongamento");
		Exercicio ex2 = new Exercicio(null, "Rosca Direta");
		Exercicio ex3 = new Exercicio(null, "Rosca Concentrada");
		
		cat1.getExercicios().addAll(Arrays.asList(ex1));
		cat2.getExercicios().addAll(Arrays.asList(ex2, ex3));
		
		ex1.getCategorias().addAll(Arrays.asList(cat1));
		ex2.getCategorias().addAll(Arrays.asList(cat2));
		ex3.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		exercicioRepository.saveAll(Arrays.asList(ex1, ex2, ex3));
		
		Cliente cli1 = new Cliente(null, "Fellipe Marra", "fellipemarra@hotmail.com", "12298505624", pe.encode("123"));
		cli1.addPerfil(Perfil.ADMIN);
		cli1.getTelefones().addAll(Arrays.asList("(34) 9 9884-2288"));
		Cliente cli2 = new Cliente(null, "Alexsandro de Jesus", "aleki.jesus@gmail.com", "14633275607", pe.encode("123"));
		cli1.addPerfil(Perfil.CLIENTE);
		cli2.getTelefones().addAll(Arrays.asList("(34) 9 8855-3073" ));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		
		ItemLista il1 = new ItemLista(ex2, cli1);
		ItemLista il2 = new ItemLista(ex3, cli1);
		ItemLista il3 = new ItemLista(ex1, cli2);
		
		cli1.getItens().addAll(Arrays.asList(il1, il2));
		cli2.getItens().addAll(Arrays.asList(il3));
		
		ex1.getItens().add((ItemLista) Arrays.asList(cli2));
		ex2.getItens().add((ItemLista) Arrays.asList(cli1));
		ex3.getItens().add((ItemLista) Arrays.asList(cli1));
		
		itemListaRepository.saveAll(Arrays.asList(il1, il2, il3));
    }
}
