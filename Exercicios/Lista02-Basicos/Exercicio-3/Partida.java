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

        String[] tabs = tabFormatter(equipe1, equipe2);

        StringBuilder str = new StringBuilder();

        str.append(tabs[2]).append("1Q\t2Q\t3Q\t4Q\t");
        for (int i = 1; i <= qntProrrogacao; i++)
            str.append("PR").append(i).append("\t");
        str.append("FINAL\n");

        str.append(equipe1).append(tabs[0]);
        for (int x : pontuacaoEquipe1)
            str.append(x).append("\t");
        str.append(somarPontuacao(pontuacaoEquipe1)).append("\n");

        str.append(equipe2).append(tabs[1]);
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

    private String[] tabFormatter(String str1, String str2) {
        String[] tabs = {"", "", ""};
        int limiteDeQuebra = 8;

        int qntTabs1 = str1.length() / limiteDeQuebra + 1;
        int qntTabs2 = str2.length() / limiteDeQuebra + 1;
        int tabsEntre;

        if (qntTabs1 < qntTabs2) {
            tabs[1] = "\t";
            tabsEntre = (qntTabs2 - qntTabs1) + 1;
            for (int i = 0; i < tabsEntre; i++) {
                tabs[0] += "\t";
            }
            tabs[2] = tabs[0] + "\t";
        }
        else {
            tabs[0] = "\t";
            tabsEntre = (qntTabs1 - qntTabs2) + 1;
            for (int i = 0; i < tabsEntre; i++) {
                tabs[1] += "\t";
            }
            tabs[2] = tabs[1] + "\t";
        }

        return tabs;
    }
}
