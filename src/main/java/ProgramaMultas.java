import java.util.Scanner;

public class ProgramaMultas {

	public static void main(String[] args) {
//		EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("mildevs_multas");
//		entityManager.close();
		
		Scanner ler = new Scanner(System.in);
		FormularioCondutor formCondutor = new FormularioCondutor();
		FormularioVeiculo formVeiculo = new FormularioVeiculo();
		FormularioMulta formMulta = new FormularioMulta();
		
		int opcao = 0;
		
		do {
			opcao = menuPrincipal(opcao, ler);
			
			switch (opcao) {
			case 1:
				System.out.println("CONDUTOR");
				opcao = menuSecundario(opcao, ler);
				if (opcao == 1) {
					formCondutor.cadastro(ler);
				} else if (opcao == 2) {
					formCondutor.exibeCondutor(ler);
				} else if (opcao == 3) {
					formCondutor.listaCondutor();
				} else if (opcao == 4) {
					formCondutor.removerCondutor(ler);
				}
				opcao = -1;
				break;
			case 2:
				System.out.println("MULTA");
				opcao = menuSecundario(opcao, ler);
				if (opcao == 1) {
					formMulta.cadastra(ler);
				} else if (opcao == 2) {
					formMulta.exibeMulta(ler);
				} else if (opcao == 3) {
					formMulta.listaMulta(ler);
				} else if (opcao == 4) {
					formMulta.removeMulta(ler);
				}
				opcao = -1;
				break;
			case 3:
				System.out.println("VEICULO");
				opcao = menuSecundario(opcao, ler);
				if (opcao == 1) {
					formVeiculo.cadastro(ler);
				} else if (opcao == 2) {
					formVeiculo.exibeVeiculo(ler);
				} else if (opcao == 3) {
					formVeiculo.listaVeiculo();
				} else if (opcao == 4) {
					formVeiculo.removeVeiculo(ler);
				}
				opcao = -1;
				break;
			}
		} while (opcao != 0);


	}

	private static int menuSecundario(int opcao, Scanner ler) {
		System.out.println("1. CADASTRAR");
		System.out.println("2. CONSULTAR");
		System.out.println("3. LISTAR");
		System.out.println("4. REMOVER");
		System.out.println("0. SAIR");
		return lerOpcao(opcao, ler, 0, 4);
	}

	private static int menuPrincipal(int opcao, Scanner ler) {
		System.out.println("=======MENU PRINCIPAL=======");
		System.out.println("1. CONDUTOR");
		System.out.println("2. MULTA");
		System.out.println("3. VEICULO");
		System.out.println("0. SAIR");
		System.out.println("============================");
		return lerOpcao(opcao, ler, 0, 3);
	}
	
	private static int lerOpcao(int opcao, Scanner ler, int opcaoIncial, int opcaoFinal) {
		do {
			opcao = ler.nextInt();
			ler.nextLine();
		} while (opcao < opcaoIncial || opcao > opcaoFinal);
		return opcao;
	}

}
