package com.algaworks.curso.teste.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploRelacionamentosPU");
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void main(String[] args) {
		// Executando esse código antes dos testes, irá fazer o hibernate gerar as tabelas a partir do arquivo persistence.xml
		EntityManager manager = GerarTabelas.createEntityManager();
		manager.close();
		System.exit(0);
		
	}
	
}
