package org.example;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Registro {

    private Integer id;
    private double temperatura;
    private double umidade;
    private double pressao;
    private double altitude;
    private double luminosidade;
    private double velocidadeDoVento;
    private Integer direcaoDoVento;
    private Integer intensidadeWifi;
    private Integer idDispositivo;
    private Timestamp timestamp;
    private LocalDateTime dataHora;


    public Registro(
            double temperatura,
            double umidade,
            double pressao,
            double altitude,
            double luminosidade,
            double velocidadeDoVento,
            Integer direcaoDoVento,
            Integer intensidadeWifi,
            Integer idDispositivo) {

        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
        this.altitude = altitude;
        this.luminosidade = luminosidade;
        this.velocidadeDoVento = velocidadeDoVento;
        this.direcaoDoVento = direcaoDoVento;
        this.intensidadeWifi = intensidadeWifi;
        this.idDispositivo = idDispositivo;


        this.dataHora = LocalDateTime.now();
        this.timestamp = Timestamp.valueOf(this.dataHora);
    }


    public Registro(
            Integer id,
            double temperatura,
            double umidade,
            double pressao,
            double altitude,
            double luminosidade,
            double velocidadeDoVento,
            Integer direcaoDoVento,
            Integer intensidadeWifi,
            Integer idDispositivo,
            Timestamp timestamp,
            LocalDateTime dataHora) {

        this.id = id;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
        this.altitude = altitude;
        this.luminosidade = luminosidade;
        this.velocidadeDoVento = velocidadeDoVento;
        this.direcaoDoVento = direcaoDoVento;
        this.intensidadeWifi = intensidadeWifi;
        this.idDispositivo = idDispositivo;
        this.timestamp = timestamp;
        this.dataHora = dataHora;
    }

    public Integer Id() {
        return id;
    }

    public double temperatura() {
        return temperatura;
    }

    public double umidade() {
        return umidade;
    }

    public double pressao() {
        return pressao;
    }

    public double altitude() {
        return altitude;
    }

    public double luminosidade() {
        return luminosidade;
    }

    public double velocidadeDoVento() {
        return velocidadeDoVento;
    }

    public Integer direcaoDoVento() {
        return direcaoDoVento;
    }

    public Integer intensidadeWifi() {
        return intensidadeWifi;
    }

    public Integer idDispositivo() {
        return idDispositivo;
    }

    public Timestamp timestamp() {
        return timestamp;
    }

    public LocalDateTime dataHora() {
        return dataHora;
    }
}