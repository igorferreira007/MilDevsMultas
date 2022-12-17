import java.util.Scanner;

import br.com.mildevs.dao.CondutorDAO;
import br.com.mildevs.dao.VeiculoDAO;
import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Veiculo;

public class FormularioVeiculo {
	VeiculoDAO veiculoDAO = new VeiculoDAO();
	
	public void cadastro(Scanner ler) {
		System.out.print("Placa: ");
		String placa = ler.nextLine();
		if (veiculoDAO.consultaVeiculo(placa) != null) {
			System.out.println("Veiuclo ja existe!");
			return;
		}
		System.out.print("Ano: ");
		int ano = ler.nextInt();
		ler.nextLine();
		System.out.print("Modelo: ");
		String modelo = ler.nextLine();
		System.out.print("Marca: ");
		String marca = ler.nextLine();
		System.out.print("Condutor(CNH): ");
		int cnh = ler.nextInt();
		ler.nextLine();
		CondutorDAO condutorDAO = new CondutorDAO();
		Condutor condutor = condutorDAO.consultaCondutor(cnh);
		if (condutor != null) {
			Veiculo veiculo = new Veiculo(placa, ano, modelo, marca, condutor);
			veiculoDAO.cadastraVeiculo(veiculo);
		} else {
			System.out.println("Condutor nao cadastrado!");
		}
	}

	public void exibeVeiculo(Scanner ler) {
		Veiculo veiculo = consulta(ler);
		if (veiculo != null) {
			System.out.println(veiculo.toString());
		}		
	}

	public Veiculo consulta(Scanner ler) {
		System.out.print("Placa: ");
		String placa = ler.nextLine();
		if (veiculoDAO.consultaVeiculo(placa) == null) {
			System.out.println("Veiculo nao cadastrado!");
		}
		return veiculoDAO.consultaVeiculo(placa);
	}

	public void listaVeiculo() {
		for (Veiculo veiculo : veiculoDAO.listaVeiculo()) {
			System.out.println(veiculo.toString());
		}
	}

	public void removeVeiculo(Scanner ler) {
		Veiculo veiculo = consulta(ler);
		if (veiculo != null) {
			veiculoDAO.removeVeiculo(veiculo.getPlaca());
		}
	}

}
