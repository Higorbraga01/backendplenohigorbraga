package com.mobicare.backendplenohigorbraga.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.mobicare.backendplenohigorbraga.dto.ApiDTO;

@Service
public class ApiService {

	RestTemplate template = new RestTemplate();

	public List<ApiDTO> consumirAPI() {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("5e74cb4b9dff120016353b04.mockapi.io")
				.path("api/v1/blacklist")
				.build();

		ResponseEntity<List<ApiDTO>> responseEntity = template.exchange
				(uri.toUriString(),
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<List<ApiDTO>>() {});

		return responseEntity.getBody();
	}
}
