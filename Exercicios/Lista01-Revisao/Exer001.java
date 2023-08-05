import java.util.Scanner;

public class Exer001 {

    public static int[] preencherVetor() {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[6];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = sc.nextInt();
        }
        return vetor;
    }

    public static void inverterVetor(int[] vetor) {
        int tmp, j = vetor.length - 1;
        for (int i = 0; i < vetor.length / 2; i++) {
            tmp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = tmp;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println("Preencha o vetor com 6 elementos: ");
        int[] vetor = preencherVetor();
        inverterVetor(vetor);

        for (int x : vetor)
            System.out.println(x);

    }
}
