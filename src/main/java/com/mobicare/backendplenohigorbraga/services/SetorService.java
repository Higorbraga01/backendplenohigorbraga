package com.mobicare.backendplenohigorbraga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mobicare.backendplenohigorbraga.domain.Colaborador;
import com.mobicare.backendplenohigorbraga.domain.Setor;
import com.mobicare.backendplenohigorbraga.dto.SetorDTO;
import com.mobicare.backendplenohigorbraga.repositories.SetorRepository;
import com.mobicare.backendplenohigorbraga.services.exceptions.DataIntegrityException;
import com.mobicare.backendplenohigorbraga.services.exceptions.ObjectNotFoundException;


@Service
public class SetorService {
	
	@Autowired
	private SetorRepository repo;
	
	public Setor insert(Setor obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um Setor que possui colaboradores");
		}
	}
	
	public Setor find(Integer id) {
		Optional<Setor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Colaborador.class.getName()));
		
	}
	
	public Setor update(Setor obj) {
		Setor  newObj = find(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}
	
	public List<Setor> findAll() {
		return repo.findAll();		                    
	}
	
	public Page<Setor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Setor fromDTO(SetorDTO objDto) {
		return new Setor(objDto.getId(), objDto.getDescricao());
	}
	
	private void updateDate(Setor newObj, Setor obj) {
		newObj.setDescricao(obj.getDescricao());	
	}
}
