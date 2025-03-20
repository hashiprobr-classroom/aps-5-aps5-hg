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
        limites.put(2, 28); // Fevereiro pode ser 29 se for ano bissexto
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
        this.mes = Math.max(1, Math.min(12, mes));
        this.dia = Math.max(1, Math.min(getDiasNoMes(this.ano, this.mes), dia));
    }

    private boolean ehBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    private int getDiasNoMes(int ano, int mes) {
        if (mes == 2 && ehBissexto(ano)) {
            return 29;
        }
        return limites.get(mes);
    }


    public int comoInteiro() {
        int totalDias = 0;

        // Contar os dias completos de anos anteriores
        for (int i = 1970; i < ano; i++) {
            totalDias += ehBissexto(i) ? 366 : 365;
        }

        // Contar os dias completos dos meses do ano atual
        for (int i = 1; i < mes; i++) {
            totalDias += getDiasNoMes(ano, i);
        }

        // Contar os dias do mês atual
        totalDias += dia;

        return totalDias - 1; // Ajuste para começar do dia 0 em 01/01/1970
    }
}