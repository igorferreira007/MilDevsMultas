package br.com.mildevs.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "condutor")
public class Condutor {
	@Id
	private int numCnh;
	
	@Column(nullable = false)
	private LocalDate dataEmissao;
	
	@Column(nullable = false)
	private String orgaoEmissor;
	
	@Column(nullable = false)
	private int pontuacao;
	
	@OneToOne (mappedBy = "condutor")
	private Veiculo veiculo;
	
	public Condutor() {
	}

	public Condutor(int numCnh, LocalDate dataEmissao, String orgaoEmissor, int pontuacao) {
		super();
		this.numCnh = numCnh;
		this.dataEmissao = dataEmissao;
		this.orgaoEmissor = orgaoEmissor;
		this.pontuacao = pontuacao;
	}

	public int getNumCnh() {
		return numCnh;
	}

	public void setNumCnh(int numCnh) {
		this.numCnh = numCnh;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
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
	
	@Override
	public String toString() {
		return "Numero CNH: " + getNumCnh() + " Data de emissao: " + getDataEmissao() + " Orgao emissor: " + getOrgaoEmissor() + " Pontuacao: " + getPontuacao();
	}

}
