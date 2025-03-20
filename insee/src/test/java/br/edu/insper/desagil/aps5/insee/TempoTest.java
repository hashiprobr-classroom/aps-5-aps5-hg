package br.edu.insper.desagil.aps5.insee;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TempoTest {

    @Test
    void constroi() {
        Tempo tempo = new Tempo(0, 0);
        assertEquals(0, tempo.comoInteiro());
    }

    @Test
    void naoAtualizaMenor() {
        Tempo tempo = new Tempo(-1, -1);
        assertEquals(0, tempo.comoInteiro());
    }

    @Test
    void atualizaMaior() {
        Tempo tempo = new Tempo(24, 60);
        assertEquals(1439, tempo.comoInteiro()); // 23:59 é o limite
    }

    @Test
    void comoZero() {
        Tempo tempo = new Tempo(0, 0);
        assertEquals(0, tempo.comoInteiro());
    }

    @Test
    void comoAgora() {
        Tempo tempo = new Tempo(15, 30);
        assertEquals(930, tempo.comoInteiro());
    }
}
