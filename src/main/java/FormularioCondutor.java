import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.mildevs.dao.CondutorDAO;
import br.com.mildevs.dao.MultaDAO;
import br.com.mildevs.entity.Condutor;

public class FormularioCondutor {
	CondutorDAO condutorDAO = new CondutorDAO();
	
	public void cadastro(Scanner ler) {
		System.out.print("Numero da CNH: ");
		int numCnh = ler.nextInt();
		ler.nextLine();
		if (condutorDAO.consultaCondutor(numCnh) != null) {
			System.out.println("Condutor ja cadastrado!");
			return;
		}
		System.out.print("Data de emissao CNH(DD/MM/AAAA): ");
		String data = ler.nextLine();
		System.out.print("Orgao emissor: ");
		String orgaoEmissor = ler.nextLine();
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao = LocalDate.parse(data, fmt);
		
		Condutor condutor = new Condutor(numCnh, dataEmissao, orgaoEmissor, 0);
		condutorDAO.cadastraCondutor(condutor);
	}
	
	public void exibeCondutor(Scanner ler) {
		Condutor condutor = consulta(ler);
		if (condutor != null) {
			System.out.println(condutor.toString());
		}		
	}
	
	public Condutor consulta(Scanner ler) {
		System.out.print("Numero da CNH: ");
		int numCnh = ler.nextInt();
		ler.nextLine();
		Condutor condutor = condutorDAO.consultaCondutor(numCnh);
		if (condutor == null) {
			System.out.println("Condutor nao cadastrado!");
		}
		return condutor;
	}

	
	public void listaCondutor() {
		for (Condutor condutor : condutorDAO.listaCondutor()) {
			System.out.println(condutor.toString());
		}
	}

	public void removerCondutor(Scanner ler) {
		Condutor condutor = consulta(ler);
		if (condutor != null) {
			condutorDAO.removeCondutor(condutor.getNumCnh());
		}
	}
	
	public void atualizaPontuacao(Condutor condutor, int pontuacao) {
		condutor.setPontuacao(pontuacao + condutor.getPontuacao());
		MultaDAO multaDAO = new MultaDAO();
		multaDAO.atualizaPontuacao(condutor);
	}
	
	public void close() {
		condutorDAO.closeDAO();
	}
}
