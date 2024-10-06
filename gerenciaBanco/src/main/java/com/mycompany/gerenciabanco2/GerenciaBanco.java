/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author Marcelo Mendes sw Souza RA: 3696038203
 */
public class GerenciaBanco {

    public static void exibirMenu() {
        System.out.println("\nMenu Bancário:");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Efetuar Deposito");
        System.out.println("3 - Efetuar Saque");
        System.out.println("4 - Exibir Dados Cliente");
        System.out.println("5 - Finalizar Atendimento");
        System.out.print("Escolha opção desejada: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coletando informações pessoais do usuário
        System.out.println("Bem-vindo ao Gerencia Banco!");
        System.out.println("");        
        System.out.println("Informe Dados solicitados para continuar");        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        DadosPessoais dadosPessoais = new DadosPessoais(nome, sobrenome, cpf);
        ContaBancaria conta = new ContaBancaria();

        int opcao;

        //Menu continuará sendo exibido até aplicação ser finalizada
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            
            switch (opcao) {
                case 1:
                    System.out.println("Saldo em Conta: R$" + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.print("Informe o valor que deseja depositar: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Informe o valor para saque: R$");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    dadosPessoais.exibirDados();
                    break;
                case 5:
                    System.out.println("Obrigado por utilizar nossos serviços! Até logo.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 5); // Interrompe a execução quando a opção 5 for escolhida

        scanner.close();
    }
}

// Classe Dados Cliente
class DadosPessoais {
    private String nome;
    private String sobrenome;
    private String cpf;

    // Construtor para a classe DadosPessoais
    public DadosPessoais(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    // Método Exibir Dados Clin
    public void exibirDados() {
        System.out.println("Dados do Cliente");
        System.out.println("Nome: " + nome.toUpperCase() + " " + sobrenome.toUpperCase());
        System.out.println("CPF: " + cpf);
    }
}

// Classe Operações Bancárias
class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0.00;
    }

    // Consultar Saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Realizar Depósito
    public void depositar(double valor) {
     
        try {
            if (valor > 0) {
              saldo += valor;
                System.out.println("Depósito realizado com sucesso!");
            } else {
                System.out.println("Valor inválido para depósito.");
                }
        }
        catch(Exception e) {
          System.out.println("Ocorreu erro ao tentar efetuar o depósito. Tente novamente mais tarde!");
        }        
        
    }

    // Método Realizar Saque
    public void sacar(double valor) {
        try {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente ou valor inválido.");
            }
        
         }
        catch(Exception e) {
          System.out.println("Ocorreu erro ao tentar efetuar o Saque. Tente novamente mais tarde!");
        }   
    }
}
