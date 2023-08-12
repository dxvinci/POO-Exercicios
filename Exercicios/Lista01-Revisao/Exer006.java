/*
Data: 11/08/2023

06 – Mensalmente, a organização de moradores do bairro faz um sorteio cujos bilhetes contêm números de 6 dígitos.
O sorteio é baseado nos dois primeiros números da loteria federal, sendo que o número vencedor no sorteio da
organização é formado pelos três primeiros dígitos do segundo prêmio e os três últimos dígitos do primeiro prêmio
da loteria federal. Por exemplo, se o primeiro prêmio fosse 34.582 e o segundo 54.098, o número vencedor seria
540.582. Escreva um programa que leia os prêmios da loteria federal e retorna o número vencedor da organização.
 */

import java.util.Scanner;

public class Exer006 {

    public static String gerarNumeroVencedor(int premio1, int premio2) {
        String primeiraParte = importarDigitos(String.valueOf(premio2), 0, 3);
        String segundaParte = importarDigitos(String.valueOf(premio1), 2, 5);

        return primeiraParte + segundaParte;
    }

    public static String importarDigitos(String valor, int inicio, int fim) {
        StringBuilder s = new StringBuilder();
        for (int i = inicio; i < fim; i++) {
            s.append(valor.charAt(i));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int premio1, premio2;
        System.out.println("Digite os valores do primeiro e segundo prêmio: ");
        premio1 = sc.nextInt();
        premio2 = sc.nextInt();

        String bilheteVencedor = gerarNumeroVencedor(premio1, premio2);
    }
}
