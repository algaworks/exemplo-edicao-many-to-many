package com.algaworks.curso.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "imovel_do_corretor")
public class ImovelDoCorretor implements Serializable {

	private static final long serialVersionUID = 1L;

	private ImovelDoCorretorId id;
	private List<Proposta> propostas;

	@EmbeddedId
	public ImovelDoCorretorId getId() {
		return id;
	}
	public void setId(ImovelDoCorretorId id) {
		this.id = id;
	}

	@ManyToMany(mappedBy="imoveisDoCorretor")
	public List<Proposta> getPropostas() {
		return propostas;
	}
	public void setPropostas(List<Proposta> propostas) {
		this.propostas = propostas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ImovelDoCorretor other = (ImovelDoCorretor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
