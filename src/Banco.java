import java.util.ArrayList;
import java.util.List;

public class Banco extends Conta{

	private List<String> nome = new ArrayList<>();
	private Conta contas;

	public Banco(Cliente cliente) {
		super(cliente);
	}

	public void adicionarBanco(String nomeBanco){
		nome.add(nomeBanco);
	}

	public List<String> getNome() {
		return nome;
	}

	public void setNome(List<String> nome) {
		this.nome = nome;
	}

	public Conta getContas() {
		return contas;
	}

	public void setContas(Conta contas) {
		this.contas = contas;
	}

}
