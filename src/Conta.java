import java.util.ArrayList;
import java.util.List;

public class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 001;
	private static int SEQUENCIAL = 001;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<Double> extrato = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		extrato.add(-valor);
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		extrato.add(valor);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		sacar(valor);
		extrato.add(-valor);
		contaDestino.depositar(valor);
	}

	@Override
	public String toString() {
		return "Transferencias = " + extrato;
	}

	@Override
	public void imprimirExtrato() {
	}

	@Override
	public List<Double> imprimirTransferencias() {
		return extrato;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
