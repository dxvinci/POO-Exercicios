import java.util.Scanner;

public class App {

    public static Partida criarPartida() {
        Scanner sc = new Scanner(System.in);
        String equipe1, equipe2;

        System.out.println("Escreva os nomes das equipes: ");
        equipe1 = sc.nextLine();
        equipe2 = sc.nextLine();

        return new Partida(equipe1, equipe2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Partida partida = criarPartida();

        while (partida.continua()) {
            partida.cadastrarPeriodo(sc.nextInt(), sc.nextInt());
        }

        System.out.println(partida.imprimirPlacar());
        System.out.println(partida.equipeVencedora() + " \uD83C\uDFC6");
    }

}
