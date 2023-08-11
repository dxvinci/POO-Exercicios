import java.util.Scanner;

public class Exer003 {

    public static void imprimirRetangulo(int x, int y) {
        if (x != y && x > 0 && y > 0) {
            imprimirLinhaCheia(x);
            for (int i = 0; i < y; i++) {
                imprimirLinhaVazia(x);
            }
            imprimirLinhaCheia(x);
        }
    }

    private static void imprimirLinhaVazia(int x) {
        StringBuilder linha = new StringBuilder();
        linha.append("X");
        for (int i = 1; i < x - 1; i++) {
            linha.append(" ");
        }
        linha.append("X");
        System.out.println(linha);
    }

    private static void imprimirLinhaCheia(int x) {
        StringBuilder linha = new StringBuilder();
        for (int i = 0; i < x; i++) {
            linha.append("X");
        }
        System.out.println(linha);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int altura, largura;

        System.out.println("Digite respectivamente a altura e largura do retângulo: ");
        altura = sc.nextInt();
        largura = sc.nextInt();
        imprimirRetangulo(altura, largura);
    }
}
