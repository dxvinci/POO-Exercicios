import java.time.LocalDate;
import java.util.LinkedList;

public class Socio extends Frequentador {
    private static final int LIMITE_CONVITES_MENSAL = 4;
    private LinkedList<Convite> convites;

    public Socio(String name) {
        super(name);
        convites = new LinkedList<>();
    }

    public void gerarConvite(LocalDate data, Convidado convidado) {
        if (podeGerarConviteNoMes(data)) {
            Convite convite = new Convite(data, this);
            convites.add(convite);
            convidado.receberConvite(convite);
        }
    }

    public boolean isPresenteNoClube(LocalDate data) {
        for (Visita visita : visitas) {
            if (visita.getData().equals(data))
                return visita.getHoraSaida() == null;
        }
        return false;
    }

    private boolean podeGerarConviteNoMes (LocalDate data) {
        int mes = data.getMonthValue();
        int counter = 0;
        for (Convite convite : convites) {
            if (convite.getData().getMonthValue() == mes)
                counter++;
        }
        return counter < LIMITE_CONVITES_MENSAL;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\n" +
                "Nome: " + this.name + "\n" +
                "Tipo: Sócio\n";
    }
}
