package com.mobicare.backendplenohigorbraga.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mobicare.backendplenohigorbraga.domain.Colaborador;
import com.mobicare.backendplenohigorbraga.domain.Setor;


public class SetorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String descricao;
	private List<Colaborador> colaboradores = new ArrayList<>();

	public SetorDTO() {
	}

	public SetorDTO(Setor obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.colaboradores = obj.getColaboradores();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

}
