public class Clube {
    private Frequentador[] frequentadores;
    private int quantFreq;

    public Clube(int n){
        if(n<=2) n=2;
        frequentadores = new Frequentador[n];
        quantFreq = 0;
    }

    public boolean addFrequentador(Frequentador novo){
        boolean resposta = true;
        if(quantFreq == frequentadores.length)
            resposta = false;
        else{
            for (int i = 0; i < quantFreq && resposta; i++) {
                if(frequentadores[i].equals(novo))
                        resposta = false;
            }
            if(resposta){
                frequentadores[quantFreq] = novo;
                quantFreq++;
            }
        }
        return resposta;        
    }
    
    public void registrarVisita(String idFreq){
        for (int i = 0; i < quantFreq; i++) {
            if(idFreq.equals(frequentadores[i].getID()))
                frequentadores[i].registrarVisita();
        }
    }

    public void registrarSaida(String idFreq){
        for (int i = 0; i < quantFreq; i++) {
            if(idFreq.equals(frequentadores[i].getID()))
                frequentadores[i].registrarSaida();
        }
    }

    public String relatorioVisitasData(Data dia){
        StringBuilder relat = new StringBuilder("Visitas em "+dia+"\n");
        for (int i = 0; i < quantFreq; i++) {
            if(frequentadores[i].visitouClubeEm(dia))
                relat.append(frequentadores[i]+"\n");
        }
        return relat.toString();
    }

    public String relatorioVisitasFreq(String idFreq){
        for (int i = 0; i < quantFreq; i++) {
            if(idFreq.equals(frequentadores[i].getID()))
                return frequentadores[i].relatorioVisitas();
        }
        return "Não existe este sócio";
    }
}