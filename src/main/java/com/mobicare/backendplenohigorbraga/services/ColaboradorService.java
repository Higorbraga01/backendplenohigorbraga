package com.mobicare.backendplenohigorbraga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.mobicare.backendplenohigorbraga.domain.Colaborador;
import com.mobicare.backendplenohigorbraga.dto.ApiDTO;
import com.mobicare.backendplenohigorbraga.dto.BuscaDTO;
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
		for (ApiDTO apiDTO : consumirAPI()) {
			apiDTO.getCpf();
			if (apiDTO.getCpf().equals(obj.getCpf())) {
				throw new DataIntegrityException("Cadastro não autorizado para este CPF!");
			}
		}
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

	public List<ApiDTO> consumirAPI() {
		RestTemplate template = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https")
				.host("5e74cb4b9dff120016353b04.mockapi.io").path("api/v1/blacklist").build();

		ResponseEntity<List<ApiDTO>> responseEntity = template.exchange(uri.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ApiDTO>>() {
				});
		return responseEntity.getBody();
	}

	public Colaborador update(Colaborador obj) {
		Colaborador newObj = find(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}

	public List<Colaborador> findAll() {
		return repo.findAll();
	}

	public Colaborador fromDTO(ColaboradorDTO objDto) {
		return new Colaborador(objDto.getId(), objDto.getCpf(), objDto.getNome(), objDto.getTelefone(),
				objDto.getEmail(), objDto.getDataNascimento(), objDto.getSetor());
	}

	public BuscaDTO fromOBJ(Colaborador obj) {
		return new BuscaDTO(obj);
	}

	private void updateDate(Colaborador newObj, Colaborador obj) {
		newObj.setNome(obj.getNome());
	}

	public Colaborador findByCpf(String cpf) {
		return repo.findByCpf(cpf);
	}

}
