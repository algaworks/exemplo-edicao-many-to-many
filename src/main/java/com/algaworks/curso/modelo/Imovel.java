package com.algaworks.curso.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "imovel")
public class Imovel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String descricao;
	//private List<Corretor> corretores;
	private List<ImovelDoCorretor> imoveisDoCorretor;
	
	public Imovel() {
	}

	public Imovel(String descricao) {
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/*@ManyToMany(mappedBy="imoveis")
	public List<Corretor> getCorretores() {
		return corretores;
	}
	public void setCorretores(List<Corretor> corretores) {
		this.corretores = corretores;
	}*/

	@OneToMany(mappedBy="id.imovel")
	public List<ImovelDoCorretor> getImoveisDoCorretor() {
		return imoveisDoCorretor;
	}
	public void setImoveisDoCorretor(List<ImovelDoCorretor> imoveisDoCorretor) {
		this.imoveisDoCorretor = imoveisDoCorretor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
