package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero){
		var conta = buscarNaCollection(numero);	
		
		if(conta != null) {
			conta.visualizar();
		}else {
			System.out.println("\n Conta numero: "+numero+" não encontrada!");
		}
	}
	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta numero "+ conta.getNumero() + " foi criada com sucesso!");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void atualizar(Conta conta) {
		var buscarConta = buscarNaCollection(conta.getNumero());
		
		if(buscarConta != null) {
			listaContas.set(listaContas.indexOf(buscarConta), conta);
			System.out.println("\n Conta numero: "+conta.getNumero()+" foi atualizada com sucesso");
		}
		else {
			System.out.println("\n Na conta numero "+conta.getNumero()+" não foi encontrada!");
		}
		
	}
	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true)
				System.out.println("\n A conta numero "+numero+" foi deletada com sucesso");
		}else {
			System.out.println("A conta numero "+numero+" não foi encontrada!");
		}
		
	}
	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor) == true) {
				System.out.println("\n Saque na conta numero "+numero+ " realizado com sucesso!");
			}
		}else {
			System.out.println("\nConta numero "+numero+" não encontrada!");
		}
		
		
	}
	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println("\nDeposito na conta numero "+numero+" depositado com sucesso!");
			
		}else {
			System.out.println("\n Conta numero "+numero+" não encontrada!");
			
		}
		
	}
	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nValor transferido com sucesso!!");
			}
		}else {
			System.out.println("\nA conta origem e/ou a conta destino não foram encontradas ");
		}
		
	}
	public int gerarNumero() {
		return ++ numero;
	}
	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
