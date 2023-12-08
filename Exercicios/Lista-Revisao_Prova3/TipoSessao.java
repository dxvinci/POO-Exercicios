public enum TipoSessao {
    DIURNO(0.0),
    NOTURNO(0.2),
    FINAL_DE_SEMANA(0.15);

    private final double Acrescimo;

    TipoSessao(double Acrescimo) {
        this.Acrescimo = Acrescimo;
    }

    public double getAcrescimo() {
        return this.Acrescimo;
    }

}
