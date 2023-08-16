/*
Data: 15/08/2023

09 - Sabendo que 1º de janeiro de 2024 será uma segunda feira, escreva um método que receba uma data e diga em
qual dia da semana esta data acontecerá em 2024. Escreva um programa principal para testar seu método.
 */

import java.util.Scanner;

public class Exer009 {

    public static String diaDaSemanaEm2024(String data) {
        if (!Exer008.verificaData(data))
            return "Data inválida";

        int diasCorridos = getDiasCorridos(data);

        return diaDaSemana(diasCorridos);
    }

    private static int getDiasCorridos(String data) {
        String[] dataSplitted = data.split("/");
        int dia = Integer.parseInt(dataSplitted[0]);
        int mes = Integer.parseInt(dataSplitted[1]);
        int ano = Integer.parseInt(dataSplitted[2]);

        int diasCorridos = dia;

        for (int i = 1; i < mes; i++) {
            diasCorridos += diasNoMes(i, ano);
        }

        return diasCorridos;
    }

    private static String diaDaSemana(int diasCorridos) {
        int n = diasCorridos % 7;
        switch (n) {
            case 0 -> {
                return "Domingo";
            }
            case 1 -> {
                return "Segunda-feira";
            }
            case 2 -> {
                return "Terça-feira";
            }
            case 3 -> {
                return "Quarta-feira";
            }
            case 4 -> {
                return "Quinta-feira";
            }
            case 5 -> {
                return "Sexta-feira";
            }
            case 6 -> {
                return "Sábado";
            }
            default -> {
                return "Erro";
            }
        }
    }

    private static int diasNoMes(int mes, int ano) {
        if (mes == 2 && Exer008.verificaBissexto(ano))
            return 29;
        else if (mes == 2)
            return 28;
        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
            return 30;
        else
            return 31;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data;

        do {
            System.out.println("Digite uma data pra verificar o dia da semana em 2024: ");
            data = sc.nextLine();
            System.out.println(diaDaSemanaEm2024(data));
        } while (!data.equalsIgnoreCase("fim"));
    }
}
