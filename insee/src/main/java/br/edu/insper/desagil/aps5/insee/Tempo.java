package br.edu.insper.desagil.aps5.insee;


public class Tempo extends Referencia {
    private int hora = 0;
    private int minuto = 0;

    public Tempo(int hora, int minuto) {
        this.hora = Math.min(23, Math.max(0, hora));
        this.minuto = Math.min(59, Math.max(0, minuto));
    }

    @Override
    public int comoInteiro() {
        return (hora * 60) + minuto;
    }
}
