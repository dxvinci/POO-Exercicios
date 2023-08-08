import java.util.Scanner;

/*
Data 08/08/2023

Descrição:
04 - Elabore um programa que leia uma frase e mostre-a invertida na tela. Após mostrar a primeira frase, o programa
deve ler e imprimir outra, assim fazendo até que o usuário digite a palavra “fim”.
*/

public class Exer004 {

    public static String inverterString(String x){
        StringBuilder invertida = new StringBuilder();
        int j = x.length() - 1;
        for (int i = 0; i < x.length(); i++) {
            invertida.append(x.charAt(j));
            j--;
        }
        return String.valueOf(invertida);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;

        do {
            System.out.println("Escreva algo: ");
            s = sc.nextLine();
            System.out.println(inverterString(s));
        } while (!s.equalsIgnoreCase("fim"));

        sc.close();
    }
}
