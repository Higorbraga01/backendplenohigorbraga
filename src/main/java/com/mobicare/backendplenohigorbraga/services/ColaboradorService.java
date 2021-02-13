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
import com.mobicare.backendplenohigorbraga.dto.ColaboradorDTO;
import com.mobicare.backendplenohigorbraga.repositories.ColaboradorRepository;
import com.mobicare.backendplenohigorbraga.services.exceptions.DataIntegrityException;
import com.mobicare.backendplenohigorbraga.services.exceptions.ObjectNotFoundException;


@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repo;
	
	public Colaborador insert(Colaborador obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produto");
		}
	}
	
	public Colaborador find(Integer id) {
		Optional<Colaborador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Colaborador.class.getName()));
		
	}
	
	public Colaborador update(Colaborador obj) {
		Colaborador  newObj = find(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}
	
	public List<Colaborador> findAll() {
		return repo.findAll();		                    
	}
	
	public Page<Colaborador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Colaborador fromDTO(ColaboradorDTO objDto) {
		return new Colaborador(
				objDto.getId(),objDto.getCpf(), objDto.getNome(), objDto.getTelefone(),
				objDto.getEmail(),objDto.getDataNascimento(), objDto.getSetor());
	}
	
	private void updateDate(Colaborador newObj, Colaborador obj) {
		newObj.setNome(obj.getNome());	
	}

	public Colaborador findByCpf(String cpf) {
		return repo.findByCpf(cpf);
	}

}
