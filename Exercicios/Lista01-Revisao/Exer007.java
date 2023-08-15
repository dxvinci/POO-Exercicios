/*
Data: 15/08/2023

07 - Um algoritmo para multiplicação rápida por 11 de números de 2 dígitos funciona assim: para multiplicar 81 x 11,
some os dígitos do número (8 + 1 = 9) e insira o resultado entre os dígitos (891). Se a soma der maior que 9,
incremente o dígito da esquerda (vai-um): 56 x 11 = 616. Escreva um programa que efetue multiplicações por 11
usando este algoritmo.
 */

import java.util.Scanner;

public class Exer007 {

    public static int multiplicarPor11(int x) {
        if (x > 100 || x < 10)
            return -1;

        int primeiroDigito = x / 10;
        int segundoDigito = x % 10;
        int soma = primeiroDigito + segundoDigito;

        if (soma > 9) {
            soma = soma % 10;
            primeiroDigito++;
        }

        String result = primeiroDigito + "" + soma + "" + segundoDigito;

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;

        do {
            System.out.println("Digite um número de 2 digitos para multiplicá-lo por 11: ");
            x = sc.nextInt();
            System.out.println(multiplicarPor11(x));
        }   while (x != -1);
    }
}
