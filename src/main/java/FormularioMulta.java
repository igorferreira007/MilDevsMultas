import java.util.List;
import java.util.Scanner;

import br.com.mildevs.dao.MultaDAO;
import br.com.mildevs.dao.VeiculoDAO;
import br.com.mildevs.entity.Multa;
import br.com.mildevs.entity.Veiculo;

public class FormularioMulta {
	MultaDAO multaDAO = new MultaDAO();
	
	public void cadastra(Scanner ler) {
		System.out.print("Codigo da multa: ");
		int codigoMulta = ler.nextInt();
		ler.nextLine();
		System.out.print("Valor: ");
		double valor = ler.nextDouble();
		ler.nextLine();
		System.out.print("Pontucao: ");
		int pontuacao = ler.nextInt();
		ler.nextLine();
		System.out.print("Veiculo(Placa): ");
		String placa = ler.nextLine();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		Veiculo veiculo = veiculoDAO.consultaVeiculo(placa);
		if (veiculo != null) {
			Multa multa = new Multa(codigoMulta, valor, pontuacao, veiculo);
			multaDAO.cadastraMulta(multa);
			FormularioCondutor formCondutor = new FormularioCondutor();
			formCondutor.atualizaPontuacao(veiculo.getCondutor(), pontuacao);
			formCondutor.close();
		} else {
			System.out.println("Veiculo nao cadastrado!");
		}
		multaDAO.close();
	}
	
	public void exibeMulta(Scanner ler) {
		Multa multa = consulta(ler);
		if (multa != null) {
			System.out.println(multa.toString());
		}
	}
	
	public Multa consulta(Scanner ler) {
		System.out.print("Codigo da multa: ");
		int codigoMulta = ler.nextInt();
		ler.nextLine();
		Multa multa =  multaDAO.consultaMulta(codigoMulta);
		if (multa == null) {
			System.out.println("Multa nao cadastrada!");
		}
		return multa;
	}

	public void listaMulta(Scanner ler) {
		for (Multa multa : multaDAO.listaMulta()) {
			System.out.println(multa.toString());
		}
	}

	public void removeMulta(Scanner ler) {
		Multa multa = consulta(ler);
		if (multaDAO.removeMulta(multa.getCodigoMulta())) {
			System.out.println("Multa excluida com sucesso!");
		} else {
			System.out.println("Multa nao encontrada!");
		}
	}
	
	
}
