import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Frequentador {
    private static int idCount = 1;
    protected String id;
    protected String name;
    protected LinkedList<Visita> visitas;

    public Frequentador(String name) {
        this.id = String.valueOf(idCount++);
        this.name = name;
        this.visitas = new LinkedList<>();
    }

    /**
     * @return id
     */
    public String getID() {
        return this.id;
    }

    /**
     * Registra uma visita ao clube
     */
    public void registrarVisita() {
        visitas.add(new Visita(this));
    }

    /**
     * Registra uma saída do clube
     */
    public void registrarSaida() {
        visitas.getLast().registrarSaida();
    }

    /**
     * Verifica se o frequentador visitou o clube em um determinado dia
     * @param dia data a ser verificada
     * @return true se visitou, false se não
     */
    public boolean visitouClubeEm(LocalDate dia) {
        for (Visita visita : visitas) {
            if (visita.getData().equals(dia))
                return true;
        }
        return false;
    }

    /**
     * Retorna um relatório de todas as visitas feitas por um frequentador
     * @return String do relatório
     */
    public String relatorioVisitas() {
        StringBuilder relat = new StringBuilder("Visitas de " + this.name + "\n");
        for (Visita visita : visitas) {
            relat.append(visita).append("\n");
        }
        return relat.toString();
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\n" +
                "Nome: " + this.name + "\n";
    }

}
