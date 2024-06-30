public class Main {

    public static void main(String[] args) {

        ContaCorrente cc = new ContaCorrente(new Banco("Banco Pan"), new Cliente("João", "123.465.789-00"));
        cc.depositar(100);
        cc.depositar(0);

        ContaPoupanca poupanca = new ContaPoupanca(new Banco("Santander"), new Cliente("Maria", "987.654.321=12"));
        cc.transferir(120, poupanca);
        cc.transferir(15, poupanca);

        cc.sacar(100);
        cc.sacar(25);

        cc.imprimirExtrato();
        System.out.println();
        poupanca.imprimirExtrato();
    }
}