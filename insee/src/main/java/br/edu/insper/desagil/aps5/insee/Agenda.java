package br.edu.insper.desagil.aps5.insee;


import java.util.ArrayList;
import java.util.List;



public class Agenda {
    private final List<Evento> eventos = new ArrayList<>();

    public void adiciona(Evento evento) {
        if (evento.valido()) {
            eventos.add(evento);
        } else {
            throw new IllegalArgumentException("Evento inválido!");
        }
    }

    public List<Evento> getEventos() {  // ADICIONADO O MÉTODO GETTER
        return eventos;
    }
}
