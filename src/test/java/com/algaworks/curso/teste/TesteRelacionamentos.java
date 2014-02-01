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
		
		joao.getImoveis().add(comercial);
		
		this.manager.merge(joao);
	}
	
	@Test
	public void deveRemoverTodosImoveis() {
		Corretor joao = this.manager.find(Corretor.class, 1L);
		joao.setNome("João da Silva");
		
		System.out.println(joao.getImoveis().size());
		
		joao.getImoveis().clear();
		
		this.manager.merge(joao);
	}
}
