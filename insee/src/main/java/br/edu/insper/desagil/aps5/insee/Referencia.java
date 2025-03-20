package br.edu.insper.desagil.aps5.insee;



public class Referencia {
    protected String observacao = "";

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int comoInteiro() {
        throw new UnsupportedOperationException("Método deve ser implementado pelas subclasses");
    }
}
