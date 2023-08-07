import java.util.Scanner;

public class Exer002 {

    public static int[] preencherVetor(int x) {
        System.out.println("Preencha o vetor com " + x + " elementos");
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[x];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = sc.nextInt();
        }
        return vetor;
    }

    public static int[] novoVetor(int[] vetor) {
        int[] novoVetor = new int[(vetor.length + 1) / 2];
        int j = 0;
        int k = 1;

        for (int i = 0; i < novoVetor.length; i++) {
            if (k < vetor.length) {
                novoVetor[i] = vetor[j] + vetor[k];
            }
            else {
                novoVetor[i] = vetor[j] * 2;
            }
            j += 2;
            k += 2;
        }

        return novoVetor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a quantidade de elementos no vetor: ");
        int x = sc.nextInt();
        int[] vetor = new int[x];

        vetor = preencherVetor(x);

        int[] novoVetor = novoVetor(vetor);

        for (int element : novoVetor)
            System.out.printf("%s ", element);

    }
}
