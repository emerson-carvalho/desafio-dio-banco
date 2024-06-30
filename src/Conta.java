import lombok.Data;

@Data
public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private Banco banco;
    private Cliente cliente;

    public Conta(Banco banco, Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.banco = banco;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            this.saldo -= valor;
        } else
            System.out.println("Saldo Insuficiente!");
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else
            System.out.println("Valor de depósito deve ser maior que 0!");
    }

    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo Insuficiente!");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(banco);
        System.out.printf("Agencia: %d%n", agencia);
        System.out.printf("Numero: %d%n", numero);
        System.out.printf("Saldo: %.2f%n", saldo);
        System.out.println(cliente);
    }
}