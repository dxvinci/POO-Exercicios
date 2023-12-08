import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Sessao {
    private static final double PRECO_BASE = 20.0;

    private Filme filme;
    private LocalDateTime horario;
    private TipoSessao tipoSessao;
    private double precoSessao;
    private int ingressosVendidos;
    private int capacidade;

    public Sessao(Filme filme, LocalDateTime diaEHorario, int capacidade) {
        this.filme = filme;
        this.horario = diaEHorario;
        this.tipoSessao = tipoDaSessao(diaEHorario);
        this.precoSessao = calcularPrecoSessao();
        this.ingressosVendidos = 0;
        this.capacidade = capacidade;
    }

    public String dadosSessao() {
        return "Filme: " + this.filme + "\n" +
               "Horário: " + this.horario + "\n" +
               "Preço da sessão: " + this.precoSessao + "\n" +
               "Ingressos vendidos: " + this.ingressosVendidos + "\n" +
               "Capacidade: " + this.capacidade;
    }

    private TipoSessao tipoDaSessao(LocalDateTime diaEHorario) {
        if (diaEHorario.getDayOfWeek() == DayOfWeek.SATURDAY || diaEHorario.getDayOfWeek() == DayOfWeek.SUNDAY)
            return TipoSessao.FINAL_DE_SEMANA;
        else if (diaEHorario.getHour() >= 17)
            return TipoSessao.NOTURNO;
        else
            return TipoSessao.DIURNO;
    }

    private double calcularPrecoSessao() {
        if (tipoSessao == TipoSessao.DIURNO)
            return PRECO_BASE;
        else if (tipoSessao == TipoSessao.NOTURNO)
            return PRECO_BASE * (1 + tipoSessao.getAcrescimo());
        else if (tipoSessao == TipoSessao.FINAL_DE_SEMANA) {
            double precoSessaoNoturno = PRECO_BASE * (1 + TipoSessao.NOTURNO.getAcrescimo());
            return precoSessaoNoturno * (1 + tipoSessao.getAcrescimo());
        }
        else
            return 0.0;
    }

    public double valorIngresso() {
        return this.precoSessao;
    }

    public double valorArrecadado() {
        return this.ingressosVendidos * this.precoSessao;
    }

    public boolean sessaoEstaLotada() {
        return this.ingressosVendidos == this.capacidade;
    }

}
