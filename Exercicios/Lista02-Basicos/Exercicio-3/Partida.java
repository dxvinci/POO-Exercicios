import java.util.ArrayList;

public class Partida {

    private String equipe1;
    private String equipe2;
    private int periodoAtual;
    private ArrayList<Integer> pontuacaoEquipe1;
    private ArrayList<Integer> pontuacaoEquipe2;

    public Partida(String equipe1, String equipe2) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        periodoAtual = 0;
        pontuacaoEquipe1 = new ArrayList<>();
        pontuacaoEquipe2 = new ArrayList<>();
    }

    public void cadastrarPeriodo(int pontosEquipe1, int pontosEquipe2) {
        if (continua()) {
            pontuacaoEquipe1.add(periodoAtual, pontosEquipe1);
            pontuacaoEquipe2.add(periodoAtual, pontosEquipe2);
            periodoAtual++;
        }
    }

    public String imprimirPlacar() {
        int qntProrrogacao = periodoAtual - 4;
        String tabEquipe1;
        String tabEquipe2;

        if (equipe1.length() / 8 > 0)
            tabEquipe1 = "\t";
        else tabEquipe1 = "\t\t";

        if (equipe2.length() / 8 > 0)
            tabEquipe2 = "\t";
        else tabEquipe2 = "\t\t";

        StringBuilder str = new StringBuilder();

        str.append("\t\t\t1Q\t2Q\t3Q\t4Q\t");
        for (int i = 1; i <= qntProrrogacao; i++)
            str.append("PR").append(i).append("\t");
        str.append("FINAL\n");

        str.append(equipe1).append(tabEquipe1);
        for (int x : pontuacaoEquipe1)
            str.append(x).append("\t");
        str.append(somarPontuacao(pontuacaoEquipe1)).append("\n");

        str.append(equipe2).append(tabEquipe2);
        for (int x : pontuacaoEquipe2)
            str.append(x).append("\t");
        str.append(somarPontuacao(pontuacaoEquipe2)).append("\n");

        return str.toString();
    }

    public boolean continua() {
        return periodoAtual < 4 || somarPontuacao(pontuacaoEquipe1) == somarPontuacao(pontuacaoEquipe2);
    }

    public String equipeVencedora() {
        return (somarPontuacao(pontuacaoEquipe1) > somarPontuacao(pontuacaoEquipe2)) ? equipe1 : equipe2;
    }

    private int somarPontuacao(ArrayList<Integer> pontuacoes) {
        int soma = 0;
        for (int x : pontuacoes) {
            soma += x;
        }
        return soma;
    }

}
