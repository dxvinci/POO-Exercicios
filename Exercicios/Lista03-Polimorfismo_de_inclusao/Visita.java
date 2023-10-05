import java.time.LocalDate;
import java.time.LocalTime;

public class Visita {
    private final Frequentador frequentador;
    private final LocalDate data;
    private final LocalTime horaEntrada;
    private LocalTime horaSaida;

    public Visita(Frequentador frequentador) {
        this.frequentador = frequentador;
        this.data = LocalDate.now();
        this.horaEntrada = LocalTime.now();
        this.horaSaida = null;
    }

    public LocalDate getData() {
        return this.data;
    }

    public LocalTime getHoraSaida() {
        return this.horaSaida;
    }

    public void registrarSaida() {
        this.horaSaida = LocalTime.now();
    }

    @Override
    public String toString() {
        return "Data: " + Clube.DATE_FORMAT.format(data) + "\n" +
                "Hora de entrada: " + Clube.TIME_FORMAT.format(horaEntrada) + "\n" +
                "Hora de saída: " + Clube.TIME_FORMAT.format(horaSaida) + "\n";
    }

}
