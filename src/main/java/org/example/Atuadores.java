package org.example;

import java.time.LocalDateTime;

public class Atuadores {

    private Integer id;
    private String nomeAtuador;
    private boolean statusAtual;
    private LocalDateTime ultimoComando;

    public Atuadores(String nomeAtuador, boolean statusAtual) {
        this.nomeAtuador = nomeAtuador;
        this.statusAtual = statusAtual;
        this.ultimoComando = LocalDateTime.now();
    }

    public String getNomeAtuador() {
        return nomeAtuador;
    }

    public boolean isStatusAtual() {
        return statusAtual;
    }

    public LocalDateTime getUltimoComando() {
        return ultimoComando;
    }



}
