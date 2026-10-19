package org.example;

public class Registro {

    private Integer id;
    private double temperatura;
    private double umidade;
    private double pressao;
    private double altitude;
    private double luminosidade;
    private double velocidadeDoVento;
    private int direcaoDoVento;
    private int intensidadeWifi;

    public Registro(double temperatura, double umidade, double pressao, double altitude, double luminosidade, double velocidadeDoVento, int direcaoDoVento, int intensidadeWifi) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
        this.altitude = altitude;
        this.luminosidade = luminosidade;
        this.velocidadeDoVento = velocidadeDoVento;
        this.direcaoDoVento = direcaoDoVento;
        this.intensidadeWifi = intensidadeWifi;
    }



}
