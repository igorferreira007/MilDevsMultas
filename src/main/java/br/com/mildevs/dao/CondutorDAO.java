package br.com.mildevs.dao;

import java.util.List;

import br.com.mildevs.entity.Condutor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
//import jakarta.persistence.Query;

public class CondutorDAO {
	private EntityManager manager;

	public CondutorDAO() {
		this.manager = Persistence.createEntityManagerFactory("mildevs_multas").createEntityManager();
	}
	
	//CADASTRAR
	public boolean cadastraCondutor(Condutor condutor) {
		manager.getTransaction().begin();
		manager.persist(condutor);
		manager.getTransaction().commit();
		return true;
	}
	
	//CONSULTAR
	public Condutor consultaCondutor(int numCnh) {
		return manager.find(Condutor.class, numCnh);
	}
	
	//LISTAR
	public List<Condutor> listaCondutor() {
		return manager.createQuery("select c from condutor as c", Condutor.class).getResultList();
	}
	
	//REMOVER
	public boolean removeCondutor(int numCnh) {
		Condutor condutorRemovido = manager.find(Condutor.class, numCnh);
		if (condutorRemovido == null) {
			return false;
		}
		manager.getTransaction().begin();
		manager.remove(condutorRemovido);
		manager.getTransaction().commit();
		return true;
	}
	
	public void closeDAO() {
		manager.close();
	}
	
}
