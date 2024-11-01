import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Cliente cliente = new Cliente();
		Conta contaEscolhida = null;
		Map<Integer, IConta> contas = new HashMap<>();

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

		boolean trueFalse = true;

		while(trueFalse){
			System.out.println("Escolha a operação desejada: \n 1 - Depositar\n 2 - Sacar\n 3 - Transferir\n 4 - Imprimir Dados da Conta\n 5 - Imprimir Extrato\n 6 - Sair");
			int temp = scan.nextInt();
			switch (temp){
				case 1:
					System.out.println("Quanto deseja depositar?");
					double deposito = scan.nextDouble();
					banco.depositar(deposito);
					break;
				case 2:
					double tempSaldo = banco.getSaldo();
					if(banco.getSaldo() > 0) {
						System.out.println("Você tem R$" + banco.getSaldo() + " de saldo disponivel");
						System.out.println("Quanto deseja sacar??");
						double saque = scan.nextDouble();
						banco.sacar(saque);
					}else {
						System.out.println("Você não tem saldo suficiente para sacar.");
					}
					break;
				case 3:
					if(banco.getSaldo() < 0){
						System.out.println("Quanto deseja transferir?");
						double transferencia = scan.nextDouble();

						System.out.println("Para qual conta deseja transferir?");
						int contaPTranferir = scan.nextInt();
						IConta contaPTrans = contas.get(contaPTranferir);

						if(contaPTrans != null) {
							banco.transferir(transferencia, contaPTrans);
						}else{
							System.out.println("Essa conta não existe!!!");
						}
					}else{
						System.out.println("Você não tem saldo suficiente.");
					}
					break;
				case 4:
					banco.imprimirInfosComuns();
					break;
				case 5:
					System.out.println(banco.imprimirTransferencias());
					break;
				case 6:
					trueFalse = false;
					break;
			}
		}



//		cc.depositar(100);
//		cc.transferir(100, poupanca);
//
//		cc.imprimirExtrato();
//		poupanca.imprimirExtrato();

	}




}


