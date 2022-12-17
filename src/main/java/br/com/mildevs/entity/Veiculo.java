package br.com.mildevs.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "veiculo")
public class Veiculo {
	@Id
	private String placa;
	
	@Column(nullable = false)
	private int ano;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String marca;
	
	@OneToOne
	@JoinColumn(name = "condutor", referencedColumnName = "numCnh")
	private Condutor condutor;
	
	@OneToMany(mappedBy = "veiculo")
	private List<Multa> multas;
	
	public Veiculo() {
	}
	
	public Veiculo(String placa, int ano, String modelo, String marca, Condutor condutor) {
		super();
		this.placa = placa;
		this.ano = ano;
		this.modelo = modelo;
		this.marca = marca;
		this.condutor = condutor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}
	
	@Override
	public String toString() {
		return "Placa: " + getPlaca() + " Ano: " + getAno() + " Modelo: " + getModelo() + " Marca: " + getMarca() + " Condutor(CNH): " + getCondutor().getNumCnh();
	}

}
