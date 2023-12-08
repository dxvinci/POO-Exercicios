import java.util.ArrayList;
import java.util.List;

public class Cliente {
    protected String nome;
    protected String documento;
    protected List<Ingresso> ingressos;

    public Cliente(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
        this.ingressos = new ArrayList<>();
    }

    public String extrato() {
        StringBuilder extrato = new StringBuilder("Extrato do cliente " + this.nome + ":\n");
        ingressos.stream()
                .map(ingresso -> ingresso.dadosIngresso())
                .forEach(dados -> extrato.append(dados));
        return extrato.toString();
    }

}