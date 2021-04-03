package com.mobicare.backendplenohigorbraga.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mobicare.backendplenohigorbraga.domain.Colaborador;
import com.mobicare.backendplenohigorbraga.domain.Setor;

public class ColaboradorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	
	
	private Date dataNascimento;
	private int idade;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	private Setor setor;
	
	public ColaboradorDTO() {
	}
	
	public ColaboradorDTO(Colaborador obj) {
		super();
		this.id = obj.getId();
		this.cpf = obj.getCpf();
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
		this.email = obj.getEmail();
		this.dataNascimento = obj.getDataNascimento();
		this.idade = obj.getIdadeCalculada(dataNascimento);
		this.setor = obj.getSetor();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}


	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
