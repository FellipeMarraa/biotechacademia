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
    	Categoria cat2 = new Categoria(null, "Exercícios Abdominais");
		Categoria cat3 = new Categoria(null, "Exercício de Biceps");
		Categoria cat4 = new Categoria(null, "Exercício de Tríceps");
		Categoria cat5 = new Categoria(null, "Exercício de Costas");
		Categoria cat6 = new Categoria(null, "Exercícios de Ombro");
		Categoria cat7 = new Categoria(null, "Exercícios de Peito");
		Categoria cat8 = new Categoria(null, "Exercícios de Perna");
		
		//ALONGAMENTOS
		Exercicio ex1 = new Exercicio(null, "Alongamento");
		
		//EXERCICIOS ABDOMINAIS
		Exercicio ex2 = new Exercicio(null, "Elevação de Pernas");
		Exercicio ex3 = new Exercicio(null, "Frontal");
		Exercicio ex4 = new Exercicio(null,"Bike");
		Exercicio ex5 = new Exercicio(null, "Com inversão");
		
		//EXERCICIOS DE BICEPS
		Exercicio ex6 = new Exercicio(null,"Rosca Inversa");
		Exercicio ex7 = new Exercicio(null,"Rosca Concentrada");
		Exercicio ex8 = new Exercicio(null,"Rosca Martelo");
		Exercicio ex9 = new Exercicio(null,"Rosca Direta");
		Exercicio ex10 = new Exercicio(null,"Rosca Alternada");
		
		//EXERCICIOS DE TRICEPS
		Exercicio ex11 = new Exercicio(null,"Francês");
		Exercicio ex12 = new Exercicio(null,"Kick Back");
		Exercicio ex13 = new Exercicio(null,"Corda");
		Exercicio ex14 = new Exercicio(null,"Pulley");
		
		//EXERCICIOS DE COSTAS
		Exercicio ex15 = new Exercicio(null,"Remada Unilateral");
		Exercicio ex16 = new Exercicio(null,"Puxada na Frente com Triângulo e Polia Alta");
		Exercicio ex17 = new Exercicio(null,"Puxada na Frente com Polia Alta");
		Exercicio ex18 = new Exercicio(null,"Puxada Alta com Braços Estendidos");
		
		//EXERCICIOS DE OMBRO
		Exercicio ex19 = new Exercicio(null,"Remada Alta");
		Exercicio ex20 = new Exercicio(null,"Desenvolvimento com Halteres");
		Exercicio ex21 = new Exercicio(null,"Elevação Frontal");
		Exercicio ex22 = new Exercicio(null,"Elevação Lateral");
		
		//EXERCICIOS DE PEITO
		Exercicio ex23 = new Exercicio(null,"Crucifixo (ou Fly)");
		Exercicio ex24 = new Exercicio(null,"Crossover (ou Pulley Cruzado)");
		Exercicio ex25 = new Exercicio(null,"Supino Inclinado");
		Exercicio ex26 = new Exercicio(null,"Supino Reto");
		
		//EXERCICIOS DE PERNA
		Exercicio ex27 = new Exercicio(null,"Glúteos Quatro Apoios e Perna Estendida");
		Exercicio ex28 = new Exercicio(null,"Abdução de Quadril");
		Exercicio ex29 = new Exercicio(null,"Mesa Flexora");
		Exercicio ex30 = new Exercicio(null,"Cadeira Extensora");
		Exercicio ex31 = new Exercicio(null,"Gêmeos Sentado");
		Exercicio ex32 = new Exercicio(null,"Leg Press Inclinado");
		
		
		cat1.getExercicios().addAll(Arrays.asList(ex1));
		cat2.getExercicios().addAll(Arrays.asList(ex2, ex3, ex4, ex5));
		cat3.getExercicios().addAll(Arrays.asList(ex6, ex7, ex8, ex9, ex10));
		cat4.getExercicios().addAll(Arrays.asList(ex11, ex12, ex13, ex14));
		cat5.getExercicios().addAll(Arrays.asList(ex15, ex16, ex17, ex18));
		cat6.getExercicios().addAll(Arrays.asList(ex19, ex20, ex21, ex22));
		cat7.getExercicios().addAll(Arrays.asList(ex23, ex24, ex25, ex26));
		cat8.getExercicios().addAll(Arrays.asList(ex27, ex28, ex29, ex30,ex31,ex32));
		
				//ALONGAMENTOS
				ex1.getCategorias().addAll(Arrays.asList(cat1));	
				//EXERCICIOS ABDOMINAIS
				ex2.getCategorias().addAll(Arrays.asList(cat2));
				ex3.getCategorias().addAll(Arrays.asList(cat2));
				ex4.getCategorias().addAll(Arrays.asList(cat2));
				ex5.getCategorias().addAll(Arrays.asList(cat2));
				
				//EXERCICIOS DE BICEPS
				ex6.getCategorias().addAll(Arrays.asList(cat3));
				ex7.getCategorias().addAll(Arrays.asList(cat3));
				ex8.getCategorias().addAll(Arrays.asList(cat3));
				ex9.getCategorias().addAll(Arrays.asList(cat3));
				ex10.getCategorias().addAll(Arrays.asList(cat3));
				
				//EXERCICIOS DE TRICEPS
				ex11.getCategorias().addAll(Arrays.asList(cat4));
				ex12.getCategorias().addAll(Arrays.asList(cat4));
				ex13.getCategorias().addAll(Arrays.asList(cat4));
				ex14.getCategorias().addAll(Arrays.asList(cat4));
				
				//EXERCICIOS DE COSTAS
				ex15.getCategorias().addAll(Arrays.asList(cat5));
				ex16.getCategorias().addAll(Arrays.asList(cat5));
				ex17.getCategorias().addAll(Arrays.asList(cat5));
				ex18.getCategorias().addAll(Arrays.asList(cat5));
				
				//EXERCICIOS DE OMBRO
				ex19.getCategorias().addAll(Arrays.asList(cat6));
				ex20.getCategorias().addAll(Arrays.asList(cat6));
				ex21.getCategorias().addAll(Arrays.asList(cat6));
				ex22.getCategorias().addAll(Arrays.asList(cat6));
				
				//EXERCICIOS DE PEITO
				ex23.getCategorias().addAll(Arrays.asList(cat7));
				ex24.getCategorias().addAll(Arrays.asList(cat7));
				ex25.getCategorias().addAll(Arrays.asList(cat7));
				ex26.getCategorias().addAll(Arrays.asList(cat7));
				
				//EXERCICIOS DE PERNA
				ex27.getCategorias().addAll(Arrays.asList(cat8));
				ex28.getCategorias().addAll(Arrays.asList(cat8));
				ex29.getCategorias().addAll(Arrays.asList(cat8));
				ex30.getCategorias().addAll(Arrays.asList(cat8));
				ex31.getCategorias().addAll(Arrays.asList(cat8));
				ex32.getCategorias().addAll(Arrays.asList(cat8));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		exercicioRepository.saveAll(Arrays.asList(ex1, ex2, ex3, ex4, ex5, ex6, ex7, ex8, ex9, ex10, ex11, ex12, ex13, ex14, ex15, ex16, ex17, ex18, ex19, ex20, ex21, ex22, ex23, ex24, ex25, ex26, ex27, ex28, ex29, ex30, ex31, ex32));
		
		Cliente cli1 = new Cliente(null, "Fellipe Marra", "fellipemarra@hotmail.com", pe.encode("123"));
		cli1.addPerfil(Perfil.ADMIN);
		cli1.getTelefones().addAll(Arrays.asList("(34) 9 9884-2288"));
		
		Cliente cli2 = new Cliente(null, "Alexsandro", "nutelazy@gmail.com", pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("(34) 9 8835-3791"));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		
		ItemLista il1 = new ItemLista(ex2, cli1);
		ItemLista il2 = new ItemLista(ex3, cli1);
		ItemLista il3 = new ItemLista(ex1, cli2);
		
		cli1.getItens().addAll(Arrays.asList(il1, il2));
		cli2.getItens().addAll(Arrays.asList(il3));

		
		itemListaRepository.saveAll(Arrays.asList(il1, il2, il3));
    }
}
