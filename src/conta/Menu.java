package conta;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupança;

public class Menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
	
		Scanner sc = new Scanner(System.in);
		int option, agencia, tipo, aniversario, numero;
		String titular;
		float saldo, limite;



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

			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros");
				sc.nextLine();
				option = 0;
			}
			if (option == 9) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				about();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Criar Conta\n\n");
				
				System.out.println("Digite o numero da agencia:");
				agencia = sc.nextInt();
				System.out.println("Digite o nome do titular: ");
				sc.skip("\\R?");
				titular = sc.nextLine();
				
				do {
					System.out.println("Digite o tipo de conta: ");
					tipo = sc.nextInt();
					
				}
				while(tipo < 1 && tipo > 2); 
				
				System.out.println("Digite o saldo da conta: ");
				saldo = sc.nextFloat();
					
					switch(tipo) {
					
					case 1 -> {
						System.out.println("Digite o limite de credito: ");
						limite = sc.nextFloat();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversario da conta: ");
						aniversario = sc.nextInt();
						contas.cadastrar(new ContaPoupança(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					
			}
				
				KeyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();
				KeyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();
				
				contas.procurarPorNumero(numero);
				
				KeyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Atualizar dados da Conta\n\n");
				
				System.out.println("Atualiza dados da conta: ");
				
				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o numero  da agencia: ");
					agencia = sc.nextInt();
					System.out.println("Digite o nome do tituar: ");
					sc.skip("\\R?");
					titular = sc.nextLine();
					
					System.out.println("Digite o saldo da conta: ");
					saldo = sc.nextFloat();
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite de credito: ");
						limite = sc.nextFloat();
						
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Diite o dia do aniversario da conta: ");
						aniversario = sc.nextInt();
						
						contas.atualizar(new ContaPoupança(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo da conta invalido");
						
					}
					}
					System.out.println("A conta não foi encontrada");
				}
				
				KeyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Apagar a Conta\n\n");
				
				System.out.println("DIgite o numero da conta que deseja deletar: ");
				numero = sc.nextInt();
				
				contas.deletar(numero);
				
				KeyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Saque\n\n");
				
				KeyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Depósito\n\n");
				
				KeyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Transferência entre Contas\n\n");
				
				KeyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				
				KeyPress();
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
	public static void KeyPress() {
		
		try {
			System.out.println(Cores.TEXT_RESET + "\n\n Precione Enter continuar...");
			System.in.read();				
		}
		catch(IOException e) {
			System.out.println("Voce digitou uma tecla diferente");
		}
	}
}
