package br.edu.insper.desagil.aps5.insee;

import java.util.HashMap;
import java.util.Map;

public class Data extends Referencia {
    private int ano;
    private int mes;
    private int dia;
    private static final Map<Integer, Integer> limites = new HashMap<>();

    static {
        limites.put(1, 31);
        limites.put(2, 28); // Considerando apenas anos comuns
        limites.put(3, 31);
        limites.put(4, 30);
        limites.put(5, 31);
        limites.put(6, 30);
        limites.put(7, 31);
        limites.put(8, 31);
        limites.put(9, 30);
        limites.put(10, 31);
        limites.put(11, 30);
        limites.put(12, 31);
    }

    public Data(int ano, int mes, int dia) {
        this.ano = Math.max(1970, ano);
        this.mes = Math.min(12, Math.max(1, mes));
        this.dia = Math.min(limites.get(this.mes), Math.max(1, dia));
    }

    @Override
    public int comoInteiro() {
        int totalDias = 0;

        // Adicionando os anos completos desde 1970
        for (int i = 1970; i < ano; i++) {
            totalDias += 365;
        }

        // Adicionando os meses completos do ano corrente
        for (int i = 1; i < mes; i++) {
            totalDias += limites.get(i);
        }

        // Adicionando os dias do mês atual
        totalDias += dia - 1;

        return totalDias;
    }
}