import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Clube {
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    private List<Frequentador> frequentadores;
    private int quantFreq;

    public Clube() {
        frequentadores = new LinkedList<>();
        quantFreq = 0;
    }

    /**
     * Retorna o frequentador com o id passado como parâmetro
     * @param id do frequentador
     * @return Frequentador
     */
    private Frequentador getFrequentadorPorId(String id) {
        for (int i = 0; i < quantFreq; i++) {
            if(id.equals(frequentadores.get(i).getID()))
                return frequentadores.get(i);
        }
        return null;
    }

    /**
     * Adiciona um frequentador na lista de frequentadores do clube
     * @param novo frequentador
     * @return true se foi possível adicionar à lista, false se não
     */
    public boolean addFrequentador(Frequentador novo) {
        boolean resposta = true;
        frequentadores.add(novo);
        System.out.println("Cadastro realizado com sucesso. ID: " + novo.getID());
        quantFreq++;
        return resposta;
    }

    /**
     * Registra a visita de um frequentador ao clube
     * @param idFreq id do frequentador
     */
    public void registrarVisita(String idFreq) {
        Frequentador frequentador = getFrequentadorPorId(idFreq);
        if (frequentador != null)
            frequentador.registrarVisita();
        else
            System.out.println("ID inválido");
    }

    /**
     * Registra a saída de um frequentador do clube
     * @param idFreq id do frequentador
     */
    public void registrarSaida(String idFreq) {
        Frequentador frequentador = getFrequentadorPorId(idFreq);
        if (frequentador != null)
            frequentador.registrarSaida();
        else
            System.out.println("ID inválido");
    }

    /**
     * Gera um convite para um convidado de um sócio
     * @param idSocio id do sócio
     * @param idConvidado id do convidado
     * @param data data do convite
     */
    public void gerarConvite(String idSocio, String idConvidado, String data) {
        LocalDate dataConvite = LocalDate.parse(data, DATE_FORMAT);
        System.out.println(dataConvite);
        Socio socio = (Socio) getFrequentadorPorId(idSocio);
        Convidado convidado = (Convidado) getFrequentadorPorId(idConvidado);

        if (socio == null)
            System.out.println("ID de Sócio inválido");
        else if (convidado == null)
            System.out.println("ID de Convidado inválido");
        else
            socio.gerarConvite(dataConvite, convidado);
    }

    /**
     * Retorna um relatório de todas as visitas feitas no clube em um dia específico
     * @param dia data LocalDate
     * @return String com o relatório
     */
    public String relatorioVisitasData(LocalDate dia) {
        StringBuilder relat = new StringBuilder("Visitas em " + DATE_FORMAT.format(dia) + "\n");
        for (int i = 0; i < quantFreq; i++) {
            if(frequentadores.get(i).visitouClubeEm(dia))
                relat.append(frequentadores.get(i)).append("\n");
        }
        return relat.toString();
    }

    /**
     * Retorna um relatório de todas as visitas feitas por um sócio
     * @param idFreq id do sócio
     * @return String com o relatório
     */
    public String relatorioVisitasFreq(String idFreq) {
        for (int i = 0; i < quantFreq; i++) {
            if(idFreq.equals(frequentadores.get(i).getID()))
                return frequentadores.get(i).relatorioVisitas();
        }
        return "Não existe este sócio";
    }
}