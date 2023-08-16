/*
Data: 15/08/2023

08 - Escreva um método que verifique se uma data é válida, a partir de um dado recebido do usuário no formato
DD/MM/AAAA. Se a data for inválida, informe ao usuário onde está o erro.
 */

import java.util.Scanner;

public class Exer008 {

    public static boolean verificaData (String data) {
        boolean verificador = true;

        String[] dataSplitted = data.split("/");
        int dia = Integer.parseInt(dataSplitted[0]);
        int mes = Integer.parseInt(dataSplitted[1]);
        int ano = Integer.parseInt(dataSplitted[2]);

        if (ano < 1) {
            System.out.println("Ano inválido");
            verificador = false;
        }
        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido");
            verificador = false;
        }
        if (dia < 1 || dia > 31) {
            System.out.println("Dia inválido");
            verificador = false;
        }

        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) {
            System.out.println("Dia inválido para mês " + mes);
            verificador = false;
        }

        if (mes == 2 && dia > 28 && !verificaBissexto(ano)) {
            System.out.println("Dia inválido para mês de fevereiro em ano não bissexto");
            verificador = false;
        }

        if (mes == 2 && dia > 29 && verificaBissexto(ano)) {
            System.out.println("Dia inválido para mês de fevereiro");
            verificador = false;
        }

        return verificador;
    }

    public static boolean verificaBissexto(int ano) {
        return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data;

        do {
            System.out.println("Digite uma data pra verificar se é válida: ");
            data = sc.nextLine();
            System.out.println(verificaData(data));
        } while (!data.equalsIgnoreCase("fim"));

    }
}
