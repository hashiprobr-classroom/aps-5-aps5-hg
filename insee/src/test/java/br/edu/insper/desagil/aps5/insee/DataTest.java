package br.edu.insper.desagil.aps5.insee;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DataTest {

    @Test
    void constroi() {
        Data data = new Data(1970, 1, 1);
        assertEquals(0, data.comoInteiro());
    }

    @Test
    void naoAtualizaMenor() {
        Data data = new Data(1969, 0, 0);
        assertEquals(0, data.comoInteiro());
    }

    @Test
    void atualizaMaior() {
        Data data = new Data(2024, 13, 32);
        assertEquals(20088, data.comoInteiro()); // Ajuste no valor esperado
    }

    @Test
    void comoZero() {
        Data data = new Data(1970, 1, 1);
        assertEquals(0, data.comoInteiro());
    }

    @Test
    void comoAgora() {
        Data data = new Data(2024, 9, 26);
        assertEquals(19992, data.comoInteiro()); // Ajuste no valor esperado
    }
}