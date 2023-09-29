import java.time.LocalDate;
import java.time.LocalTime;

public class Visita {
    private Frequentador frequentador;
    private LocalDate data;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;

    public Visita(Frequentador frequentador) {
        this.frequentador = frequentador;
        this.data = LocalDate.now();
        this.horaEntrada = LocalTime.now();
    }

    public void registrarSaida(){
        this.horaSaida = LocalTime.now();
    }

}
