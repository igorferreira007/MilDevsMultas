package br.com.mildevs.dao;

import java.util.List;

import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Multa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class MultaDAO {
	private EntityManager manager;

	public MultaDAO() {
		this.manager = Persistence.createEntityManagerFactory("mildevs_multas").createEntityManager();
	}
	
	//CADASTRAR
	public boolean cadastraMulta(Multa multa) {
		manager.getTransaction().begin();
		manager.persist(multa);
		manager.getTransaction().commit();
		return true;
	}
	
	//CONSULTAR
	public Multa consultaMulta(int codigoMulta) {
		return manager.find(Multa.class, codigoMulta);
	}
	
	//LISTAR
	public List<Multa> listaMulta() {
		Query query = manager.createQuery("select m from multa as m");
		return query.getResultList();
	}
	
	//REMOVER
	public boolean removeMulta(int codigoMulta) {
		Multa multaRemovida = manager.find(Multa.class, codigoMulta);
		if (multaRemovida == null) {
			return false;
		}
		manager.getTransaction().begin();
		manager.remove(multaRemovida);
		manager.getTransaction().commit();
		return true;
	}
	
	//ATUALIZAR
	public boolean atualizaPontuacao(Condutor condutor) {
		manager.getTransaction().begin();
		manager.merge(condutor);
		System.out.println(condutor);
		manager.getTransaction().commit();
		return true;
	}
	
	public void close() {
		manager.close();
	}
}
