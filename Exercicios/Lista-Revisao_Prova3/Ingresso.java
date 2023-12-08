public class Ingresso {
    protected Sessao sessao;
    protected double valorDaVenda;

    public Ingresso(Sessao sessao, double valorDaVenda) {
        this.sessao = sessao;
        this.valorDaVenda = valorDaVenda;
    }

    public double precoIngresso() {
        return this.valorDaVenda;
    }

    public String dadosIngresso() {
        return "Sessão: " + this.sessao.dadosSessao() + "\nValor da venda: " + this.valorDaVenda;
    }
}
