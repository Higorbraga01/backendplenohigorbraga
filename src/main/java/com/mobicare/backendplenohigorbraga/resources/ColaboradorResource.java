package com.mobicare.backendplenohigorbraga.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mobicare.backendplenohigorbraga.domain.Colaborador;
import com.mobicare.backendplenohigorbraga.dto.BuscaDTO;
import com.mobicare.backendplenohigorbraga.dto.ColaboradorDTO;
import com.mobicare.backendplenohigorbraga.services.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ColaboradorDTO objDto) {
		Colaborador obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ColaboradorDTO objDto, @PathVariable Integer id){
		Colaborador obj = service.fromDTO(objDto);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BuscaDTO> find(@PathVariable Integer id) {
		BuscaDTO objDto = new BuscaDTO();
		Colaborador obj = service.find(id);
		objDto = service.fromOBJ(obj);
		return ResponseEntity.ok().body(objDto);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BuscaDTO>> findAll() {
		List<Colaborador> list = service.findAll();
		List<BuscaDTO> listDto = list.stream().map(obj -> new BuscaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<BuscaDTO> search(@RequestParam(name = "cpf") String cpf) {
		BuscaDTO objDto = new BuscaDTO();
		Colaborador obj = service.findByCpf(cpf);
		objDto = service.fromOBJ(obj);
		return ResponseEntity.ok().body(objDto);
	}

}
