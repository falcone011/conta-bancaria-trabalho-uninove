import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do usuário da conta:");
        String n = entrada.nextLine();

        System.out.println("Digite o saldo inicial da conta:");
        double s = entrada.nextDouble();

        Usuario usu = new Usuario();
        Conta c1 = new Conta(n, s, "123", usu);

        System.out.println("\nBem-vindo, " + c1.getUsuario().getNome());
        System.out.println("Saldo atual: R$" + c1.getSaldo());

        double valorDeposito;
        do {
            System.out.println("\nDigite o valor do depósito:");
            valorDeposito = entrada.nextDouble();
            if (valorDeposito <= 0) {
                System.out.println("Valor inválido! Digite um valor maior que zero.");
            }
        } while (valorDeposito <= 0);
        c1.depositar(valorDeposito);
        System.out.println("Saldo após depósito: R$" + c1.getSaldo());

        double valorSaque;
        do {
            System.out.println("\nDigite o valor desejado para saque:");
            valorSaque = entrada.nextDouble();
            if (valorSaque <= 0) {
                System.out.println("Valor inválido! Tente novamente.");
            } else if (valorSaque > c1.getSaldo()) {
                System.out.println("Saldo insuficiente. Seu saldo é: R$" + c1.getSaldo());
                valorSaque = -1;
            }
        } while (valorSaque <= 0);
        c1.sacar(valorSaque);
        System.out.println("Saldo após saque: R$" + c1.getSaldo());

        
        entrada.nextLine();

		System.out.print("\nDigite o nome do destinatário da transferência: ");
		String nomeDestinatario = entrada.nextLine();

		Usuario u2 = new Usuario();
		Conta c2 = new Conta(nomeDestinatario, 0, "578", u2);

        
	
if (c1.getSaldo() <= 0) {
    System.out.println("Você não tem saldo suficiente para fazer uma transferência.");
    System.out.println("Encerrando o processo...");
    System.exit(0);  
} else {
    
    double valorTransferencia;
    do {
        System.out.println("\nDigite o valor a ser transferido:\n" + "Seu saldo é: R$" +c1.getSaldo());
        valorTransferencia = entrada.nextDouble();
        if (valorTransferencia <= 0) {
            System.out.println("Valor inválido! Tente novamente.");
        } else if (valorTransferencia > c1.getSaldo()) {
            System.out.println("Saldo insuficiente para transferência. Seu saldo é: R$" + c1.getSaldo());
            System.out.println("Encerrando o processo...");
            System.exit(0); 
        }
    } while (valorTransferencia <= 0);

   
    c1.transferir(valorTransferencia, c2);
}


        
        System.out.println("\n--- SALDOS FINAIS ---");
        System.out.println("Usuário: " + c1.getUsuario().getNome());
        System.out.println("Saldo: R$ " + c1.getSaldo());

        System.out.println("Usuário: " + c2.getUsuario().getNome());
        System.out.println("Saldo: R$ " + c2.getSaldo());
    }
}
