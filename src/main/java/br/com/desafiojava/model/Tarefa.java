package br.com.desafiojava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "tarefa")
public class Tarefa { 
	   
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(nullable = false)
    private long id;
	
	@Column(nullable = false)
    private String titulo;
	
	@Column(nullable = true)
    private String descricao;
    
    @Column(nullable = false)
    private int fl_status;
    
    @Column(nullable = false)
    private Date dt_criacao;
    
    @Column(nullable = true)
    private Date dt_edicao;
    
    @Column(nullable = true)
    private Date dt_remocao;
    
    @Column(nullable = true)
    private Date dt_conclusao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getFl_status() {
		return fl_status;
	}

	public void setFl_status(int fl_status) {
		this.fl_status = fl_status;
	}

	public Date getDt_criacao() {
		return dt_criacao;
	}

	public void setDt_criacao(Date dt_criacao) {
		this.dt_criacao = dt_criacao;
	}

	public Date getDt_edicao() {
		return dt_edicao;
	}

	public void setDt_edicao(Date dt_edicao) {
		this.dt_edicao = dt_edicao;
	}

	public Date getDt_remocao() {
		return dt_remocao;
	}

	public void setDt_remocao(Date dt_remocao) {
		this.dt_remocao = dt_remocao;
	}

	public Date getDt_conclusao() {
		return dt_conclusao;
	}

	public void setDt_conclusao(Date dt_conclusao) {
		this.dt_conclusao = dt_conclusao;
	}
    
    
}