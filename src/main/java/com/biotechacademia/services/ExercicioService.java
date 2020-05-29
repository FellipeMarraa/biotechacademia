package com.biotechacademia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.biotechacademia.domain.Categoria;
import com.biotechacademia.domain.Exercicio;
import com.biotechacademia.dto.ExercicioDTO;
import com.biotechacademia.repositories.CategoriaRepository;
import com.biotechacademia.repositories.ExercicioRepository;
import com.biotechacademia.services.exceptions.DateIntegrityException;
import com.biotechacademia.services.exceptions.ObjectNotFoundException;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository repo;
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Exercicio find(Integer id) {
        Optional<Exercicio> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Exercicio.class.getName()));
    }

    public Page<Exercicio> search(String nome, List<Integer> ids,Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
		
	}
    
    public Exercicio insert(Exercicio obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Exercicio update(Exercicio obj) {
        Exercicio newObj = find(obj.getId());
        updateDate(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DateIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }

    public List<Exercicio> findAll() {
        return repo.findAll();
    }

    public Page<Exercicio> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Exercicio fromDTO(ExercicioDTO objDto) {
        return new Exercicio(objDto.getId(), objDto.getNome());
    }

    private void updateDate(Exercicio newObj, Exercicio obj) {
        newObj.setNome(obj.getNome());
    }


}

