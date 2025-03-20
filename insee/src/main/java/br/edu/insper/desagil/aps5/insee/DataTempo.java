package br.edu.insper.desagil.aps5.insee;


public class DataTempo extends Referencia {
    private final Data data;
    private final Tempo tempo;

    public DataTempo(Data data, Tempo tempo) {
        this.data = data;
        this.tempo = tempo;
    }

    @Override
    public int comoInteiro() {
        return data.comoInteiro() * 1440 + tempo.comoInteiro();
    }
}

