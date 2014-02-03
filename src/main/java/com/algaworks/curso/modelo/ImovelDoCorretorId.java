package com.algaworks.curso.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ImovelDoCorretorId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Corretor corretor;
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name="codigo_corretor")
	public Corretor getCorretor() {
		return corretor;
	}
	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_imovel")
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((corretor == null) ? 0 : corretor.hashCode());
		result = prime * result + ((imovel == null) ? 0 : imovel.hashCode());
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
		ImovelDoCorretorId other = (ImovelDoCorretorId) obj;
		if (corretor == null) {
			if (other.corretor != null)
				return false;
		} else if (!corretor.equals(other.corretor))
			return false;
		if (imovel == null) {
			if (other.imovel != null)
				return false;
		} else if (!imovel.equals(other.imovel))
			return false;
		return true;
	}
	
}
