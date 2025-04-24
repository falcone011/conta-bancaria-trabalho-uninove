public class Conta {

    private Usuario usuario;
    private double saldo;
    private String numero;

    public Conta(String nome, double saldo, String numero, Usuario usuario) {
        this.usuario = usuario;
        usuario.setNome(nome);
        this.saldo = saldo;
        this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito. Tente novamente.");
        } else {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
        } else if (valor > this.saldo) {
            System.out.println("Saldo insuficiente para saque.");
        } else {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }

    public void transferir(double valor, Conta destino) {
        if (valor <= 0) {
            System.out.println("Valor inválido para transferência.");
        } else if (valor > this.saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            this.saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso para " + destino.getUsuario().getNome());
        }
    }
}