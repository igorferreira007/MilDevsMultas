package br.com.mildevs.dao;

import java.util.List;

import br.com.mildevs.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class VeiculoDAO {
	private EntityManager manager;

	public VeiculoDAO() {
		this.manager = Persistence.createEntityManagerFactory("mildevs_multas").createEntityManager();
	}
	
	//CADASTRAR
	public boolean cadastraVeiculo(Veiculo veiculo) {
		manager.getTransaction().begin();
		manager.persist(veiculo);
		manager.getTransaction().commit();
		return true;
	}
	
	//CONSULTAR
	public Veiculo consultaVeiculo(String placa) {
		return manager.find(Veiculo.class, placa);
	}
	
	//LISTAR
	public List<Veiculo> listaVeiculo() {
		Query query = manager.createQuery("select v from veiculo as v");
		return query.getResultList();
	}
	
	//REMOVER
	public boolean removeVeiculo(String placa) {
		Veiculo veiculoRemovido = manager.find(Veiculo.class, placa);
		if (veiculoRemovido == null) {
			return false;
		}
		manager.getTransaction().begin();
		manager.remove(veiculoRemovido);
		manager.getTransaction().commit();
		return true;
	}
}
