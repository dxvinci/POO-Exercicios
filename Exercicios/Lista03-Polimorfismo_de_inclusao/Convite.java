import java.time.LocalDate;

public class Convite {
    private LocalDate data;
    private Socio socio;

    public Convite (LocalDate data, Socio socio) {
        this.data = data;
        this.socio = socio;
    }

    public LocalDate getData() {
        return this.data;
    }

    public Socio getSocio() {
        return this.socio;
    }
}
