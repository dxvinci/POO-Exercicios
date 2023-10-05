import java.time.LocalDate;
import java.util.LinkedList;

public class Convidado extends Frequentador {
    private LinkedList<Convite> convites;

    public Convidado(String name) {
        super(name);
        convites = new LinkedList<>();
    }

    public void receberConvite(Convite convite) {
        convites.add(convite);
    }

    @Override
    public void registrarVisita() {
        LocalDate hoje = LocalDate.now();
        if (validarConvite(hoje))
            super.registrarVisita();
    }

    private boolean validarConvite(LocalDate data) {
        boolean resposta;

        if (convites.isEmpty()) {
            System.out.println("Convite inválido: Convidado não possui convites");
            return false;
        }

        Convite convite = convites.getLast();

        if (!convite.getData().equals(data)) {
            System.out.println("Convite inválido: Data não correspondente");
            resposta = false;
        }
        else if (convite.getSocio().visitouClubeEm(data) && !convite.getSocio().isPresenteNoClube()) {
            System.out.println("Convite inválido: Sócio não está presente no clube");
            resposta = false;
        }
        else
            resposta = true;

        return resposta;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\n" +
                "Nome: " + this.name + "\n" +
                "Tipo: Convidado\n";
    }

}
