package br.edu.insper.desagil.aps5.insee;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class AgendaTest {

    @Test
    void constroi() {
        Agenda agenda = new Agenda();
        assertTrue(agenda.getEventos().isEmpty());
    }

    @Test
    void adicionaValido() {
        Agenda agenda = new Agenda();
        Data dataInicio = new Data(2024, 9, 26);
        Data dataFim = new Data(2024, 9, 27);

        Tempo tempoInicio = new Tempo(10, 0);
        Tempo tempoFim = new Tempo(12, 0);

        DataTempo inicio = new DataTempo(dataInicio, tempoInicio);
        DataTempo fim = new DataTempo(dataFim, tempoFim);

        Evento evento = new Evento(inicio, fim);
        agenda.adiciona(evento);

        List<Evento> eventos = agenda.getEventos();
        assertEquals(1, eventos.size());
        assertEquals(evento, eventos.get(0));
    }

    @Test
    void adicionaInvalido() {
        Agenda agenda = new Agenda();
        Data dataInicio = new Data(2024, 9, 27);
        Data dataFim = new Data(2024, 9, 26);

        Tempo tempoInicio = new Tempo(10, 0);
        Tempo tempoFim = new Tempo(12, 0);

        DataTempo inicio = new DataTempo(dataInicio, tempoInicio);
        DataTempo fim = new DataTempo(dataFim, tempoFim);

        Evento evento = new Evento(inicio, fim); // Início depois do fim

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.adiciona(evento);
        });

        assertEquals("Evento inválido!", exception.getMessage());
    }
}
