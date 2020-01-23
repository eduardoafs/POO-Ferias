package tads.poo.banco;

import tads.poo.banco.exceptions.BancoException;
import tads.poo.banco.exceptions.SaldoInsuficienteException;
import tads.poo.banco.exceptions.ValorInvalidoException;

public class Main {
    public static void main(String[] args) throws BancoException {

        IConta conta1 = new ContaBancaria();
        IConta conta2 = new ContaBancaria();

        try {
            conta1.deposito(200.0);
            conta2.deposito(100.0);
        } catch (ValorInvalidoException e) {
            System.out.println("Deposito não foi realizado, pois o valor passado foi negativo.");
            System.out.println("Valor passado: "+e.getValor());
            System.out.println("Saldo da conta: " +e.getSaldo());
        }

        try {
            conta1.saque(250.);
        } catch (BancoException e){
            System.out.println("Saque não foi realizado");
            if (e instanceof ValorInvalidoException)
                System.out.println("Valor invalido");
            else if (e instanceof SaldoInsuficienteException)
                System.out.println("Saldo insuficiente");
        }

        //conta1.transferencia(conta2, 150.0);
        System.out.println(conta1.saldo()); // deve ser 50
        System.out.println(conta2.saldo()); // deve ser 250
/*
        conta1.transferencia(conta2, 150.0); // essa operação não é possível
        System.out.println(conta1.saldo()); // deve permanecer 50

        conta2.transferencia(conta1, 100.0);
        System.out.println(conta1.saldo()); // deve ser 150
        System.out.println(conta2.saldo()); // deve ser 150

        conta2.transferencia(conta1, -100.0);
        System.out.println(conta1.saldo()); // deve ser 150
        System.out.println(conta2.saldo()); // deve ser 150

        //conta1.saque(50.0);
        System.out.println(conta1.saldo()); // deve ser 100

         */
    }
}
