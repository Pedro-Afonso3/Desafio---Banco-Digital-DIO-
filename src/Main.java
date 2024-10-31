import java.util.*;

public class Main {

	public static void main(String[] args) { // APRIMORAR ESSE CODIGO

		Scanner scan = new Scanner(System.in);
		Cliente cliente = new Cliente();
		Conta contaEscolhida = null;

		System.out.println("Digite seu nome para a criação da conta: ");
		String nomeCliente = scan.nextLine();

		cliente.setNome(nomeCliente); // CRIA CONTA
		Banco banco = new Banco(cliente);

		System.out.println("Escolha o banco para criar sua conta(Digite o numero correspondente a sua escolha):\n 1 - Itau\n 2 - Bradesco\n 3 - Banco Do Brasil");
		int numB = scan.nextInt();
		List<String> bancoEscolhido = new ArrayList<>();

		switch (numB) {
			case (1):
				bancoEscolhido.add("Itau");
				banco.setNome(bancoEscolhido);
				break;
			case (2):
				bancoEscolhido.add("Bradesco");
				banco.setNome(bancoEscolhido);
				break;
			case (3):
				bancoEscolhido.add("Banco Do Brasil");
				banco.setNome(bancoEscolhido);
				break;
		}

		System.out.println("Escolha o tipo da Conta: \n1 - Corrente\n 2 - Poupança");
		int tipoConta = scan.nextInt();

		if (tipoConta == 1) {
			Conta cc = new ContaCorrente(cliente);
            contaEscolhida = cc;
		} else if (tipoConta == 2) {
			Conta cp = new ContaPoupanca(cliente);
			contaEscolhida = cp;
		}

		banco.setContas(contaEscolhida);

		System.out.println("Conta Criada com Sucesso:\n ");
		System.out.println("Nome do banco: " + banco.getNome());
		banco.imprimirInfosComuns();

		System.out.println(banco.imprimirTransferencias());

		//PERMITIR MANIPULAR O SALDO DA CONTA

//		cc.depositar(100);
//		cc.transferir(100, poupanca);
//
//		cc.imprimirExtrato();
//		poupanca.imprimirExtrato();

	}




}


