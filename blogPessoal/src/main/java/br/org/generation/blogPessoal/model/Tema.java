package br.org.generation.blogPessoal.model;

import java.util.List;//ok
import javax.persistence.CascadeType;//ok
import javax.persistence.Entity;//ok
import javax.persistence.GeneratedValue;//ok
import javax.persistence.GenerationType;//ok
import javax.persistence.Id;//ok
import javax.persistence.OneToMany;//ok
import javax.persistence.Table;//ok
import javax.validation.constraints.NotNull;//ok
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//ok


@Entity
@Table(name = "tb_tema")
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String descricao;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}
