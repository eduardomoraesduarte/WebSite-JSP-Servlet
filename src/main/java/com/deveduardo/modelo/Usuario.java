package com.deveduardo.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario") // Nome da tabela no banco
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;	
	
	@Column(nullable = false, unique = true)
	private String cpf; 	
	

    @Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
    
    @Column(nullable = false, unique = true)
	private String email;		
    
    @Column(nullable = false)
	private String password;	
    
    @Column(nullable = false, unique = true)
	private String login;	
    
    @Column(nullable = false)
	private boolean ativo;
	
	
	
	public Usuario() {
		super();
	}
	
	
	public Usuario(String nome, String cpf, Date dataNascimento, String email, String password, String login,
			boolean ativo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.password = password;
		this.login = login;
		this.ativo = ativo;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email
				+ ", password=" + password + ", login=" + login + ", ativo=" + ativo + "]";
	}

}
