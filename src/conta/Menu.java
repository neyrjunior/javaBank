package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(1, 123, 1, "Adriana", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		Scanner sc = new Scanner(System.in);

		int option;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			option = sc.nextInt();

			if (option == 9) {
				System.out.println(Cores.TEXT_YELLOW_BOLD+"\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				about();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD+"Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW_BOLD+"Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW_BOLD+"Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW_BOLD+"Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW_BOLD+"Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_YELLOW_BOLD+"Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW_BOLD+"Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW_BOLD+"Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção Inválida!\n");
				break;
			}
		}

	}
	public static void about() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Ney Robson");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");
	}
}
