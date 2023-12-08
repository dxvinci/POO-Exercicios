import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cinema {
    private Map<String, Cliente> clientes;
    private Map<Filme, List<Sessao>> sessoes;

    public Cinema(Map<String, Cliente> clientes, Map<Filme, List<Sessao>> sessoes) {
        this.clientes = new HashMap<>();
        this.sessoes = new HashMap<>();
    }

    public double totalArrecadado() {
        double total = 0;
        // TODO
        return total;
    }

    public String extratoCliente(String documento) {
        return clientes.get(documento).extrato();
    }

    public List<Sessao> sessoesLotadas(Filme filme) {
        List<Sessao> sessoesDoFilme = sessoes.get(filme);

        return sessoesDoFilme.stream()
                .filter(Sessao::sessaoEstaLotada)
                .toList();
    }
}
