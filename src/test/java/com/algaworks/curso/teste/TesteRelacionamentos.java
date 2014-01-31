package com.algaworks.curso.teste;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algaworks.curso.modelo.Corretor;
import com.algaworks.curso.modelo.Imovel;
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
	}
	
	@After
	public void end() {
	}
	
	@Test
	public void alterarCorretor() {
		Corretor joao = this.manager.find(Corretor.class, 1L);
		joao.setNome("João da Silva");
		
		Imovel comercial = new Imovel("Comercial");
		this.manager.persist(comercial);
		
		joao.getImoveis().add(comercial);
		
		this.manager.merge(joao);
	}
	
}
