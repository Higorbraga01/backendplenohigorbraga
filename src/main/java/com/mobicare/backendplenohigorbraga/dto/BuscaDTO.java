package com.mobicare.backendplenohigorbraga.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mobicare.backendplenohigorbraga.domain.Colaborador;


public class BuscaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String setor;
	private Integer id;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	private int idade;	
	
	public BuscaDTO() {
	}
	
	public BuscaDTO(Colaborador col) {
		super();
		this.setor = col.getSetor().getDescricao();
		this.id = col.getId();
		this.cpf = col.getCpf();
		this.nome = col.getNome();
		this.email = col.getEmail();
		this.telefone = col.getTelefone();
		this.dataNascimento = col.getDataNascimento();
		this.idade = col.getIdade();
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
