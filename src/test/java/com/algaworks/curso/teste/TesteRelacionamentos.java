package com.algaworks.curso.teste;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algaworks.curso.modelo.Corretor;
import com.algaworks.curso.modelo.Imovel;
import com.algaworks.curso.modelo.ImovelDoCorretor;
import com.algaworks.curso.modelo.ImovelDoCorretorId;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class TesteRelacionamentos {

	private JIntegrity helper;
	
	private EntityManager manager;
	
	@Before
	public void init() {
		helper = new JIntegrity();
		helper.useMySQL();
		
		helper.cleanAndInsert();
		
		this.manager = JPAHelper.currentEntityManager();
		
		if (!this.manager.getTransaction().isActive()) {
			this.manager.getTransaction().begin();
		}
	}
	
	@After
	public void end() {
		this.manager.getTransaction().commit();
	}
	
	@Test
	public void alterarCorretor() {
		Corretor joao = this.manager.find(Corretor.class, 1L);
		joao.setNome("João da Silva");
		
		Imovel comercial = new Imovel("Comercial");
		this.manager.persist(comercial);
		
		ImovelDoCorretor imovelDoCorretor = new ImovelDoCorretor();
		ImovelDoCorretorId idImovelDoCorretor = new ImovelDoCorretorId();
		idImovelDoCorretor.setCorretor(joao);
		idImovelDoCorretor.setImovel(comercial);
		imovelDoCorretor.setId(idImovelDoCorretor);

		this.manager.persist(imovelDoCorretor);
		
		// Se quiser usar como abaixo, tem que adicionar cascade=CascadeType.MERGE
//		joao.getImoveisDoCorretor().add(imovelDoCorretor);

		// Da forma abaixo não é possível.
//		joao.getImoveis().add(comercial);
		
		this.manager.merge(joao);
	}
	
}
