package com.church.api.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

import org.springframework.format.annotation.DateTimeFormat;

import com.church.api.domain.BaseDomain;
import com.church.api.entities.enums.TipoUsuario;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Usuario extends BaseDomain {
	
	@PrePersist
	private void prePersist() {
		this.dataCriacao = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String email;
	
	private String nome;
	private String sobrenome;
	private String senha;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCriacao;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	@ManyToMany
	@JoinTable(
		name="USUARIO_TEMPLO",
		joinColumns = @JoinColumn(name="usuario_id"),
		inverseJoinColumns = @JoinColumn(name="templo_id")
	)
	@Setter(value = AccessLevel.NONE)
	private List<Templo> templosFavoritos = new ArrayList<Templo>();

	public Usuario(Long id,  String nome, String sobrenome, String email, String senha, TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}
	
	public void addTemplo(Templo... templos) {
		for (Templo t : templos)
			this.templosFavoritos.add(t);
	}
}
