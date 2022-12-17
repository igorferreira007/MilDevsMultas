package br.com.mildevs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "multa")
public class Multa {
	@Id
	private int codigoMulta;
	
	@Column(nullable = false)
	private double valor;
	
	@Column(nullable = false)
	private int pontuacao;
	
	@ManyToOne
	@JoinColumn(name = "placaVeiculo", referencedColumnName = "placa")
	private Veiculo veiculo;
	
	public Multa() {
	}

	public Multa(int codigoMulta, double valor, int pontuacao, Veiculo veiculo) {
		super();
		this.codigoMulta = codigoMulta;
		this.valor = valor;
		this.pontuacao = pontuacao;
		this.veiculo = veiculo;
	}

	public int getCodigoMulta() {
		return codigoMulta;
	}

	public void setCodigoMulta(int codigoMulta) {
		this.codigoMulta = codigoMulta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public String toString() {
		return "Codigo da multa: " + getCodigoMulta() + " Pontuacao: " + getPontuacao() + " Valor: " + getValor() + " Placa do veiculo: " + veiculo.getPlaca();
	}

}
