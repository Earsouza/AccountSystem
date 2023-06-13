package org.example;

import org.example.entities.Account;
import org.example.exceptions.DomainExceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner s = new Scanner(System.in);
            System.out.println("Informe os dados da conta");
            System.out.print("Numero:");
            int number = s.nextInt();
            System.out.print("Titular:");
            s.nextLine();
            String holder = s.nextLine();
            System.out.print("Saldo inicial: ");
            double balance = s.nextDouble();
            System.out.print("Limite saque:");
            double withdrawLimit = s.nextDouble();

            Account acc = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.println("Informe uma quantia para sacar: ");
            double amount = s.nextDouble();
        try{
            acc.withDraw(amount);
            System.out.printf("Novo saldo: %.2f", acc.getBalance());
        }
        catch(DomainExceptions e){
            System.out.println(e.getMessage());
        }

        s.close();
    }
}