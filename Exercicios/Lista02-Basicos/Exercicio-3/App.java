import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Partida partida = new Partida("Vasco", "Flamengo");

        while (partida.continua()) {
            partida.cadastrarPeriodo(sc.nextInt(), sc.nextInt());
        }

        System.out.println(partida.imprimirPlacar());
        System.out.println(partida.equipeVencedora() + " \uD83C\uDFC6");
    }

}
