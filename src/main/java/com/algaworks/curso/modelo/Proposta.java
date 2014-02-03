package com.algaworks.curso.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="proposta")
public class Proposta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private BigDecimal valor;
	private List<ImovelDoCorretor> imoveisDoCorretor;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@ManyToMany
	@JoinTable(name="proposta_para_imovel_corretor"
			, joinColumns=@JoinColumn(name="codigo_proposta")
			, inverseJoinColumns={@JoinColumn(name="codigo_corretor"), @JoinColumn(name="codigo_imovel")})
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
		Proposta other = (Proposta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
