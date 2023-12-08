public class Filme {
    private String nomeFilme;
    private boolean legendado;
    private int anoLancamento;

    public Filme(String nomeFilme, boolean legendado, int anoLancamento) {
        this.nomeFilme = nomeFilme;
        this.legendado = legendado;
        this.anoLancamento = anoLancamento;
    }

    public String dadosFilme() {
        return "Nome do filme: " + this.nomeFilme + "\n" +
               "Legendado: " + this.legendado + "\n" +
               "Ano de lançamento: " + this.anoLancamento;
    }

}
