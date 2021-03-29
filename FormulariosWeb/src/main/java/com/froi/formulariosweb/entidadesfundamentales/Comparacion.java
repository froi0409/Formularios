/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.entidadesfundamentales;

/**
 *
 * @author froi-pc
 */
public class Comparacion {
    private String operador;
    private String valor;

    public Comparacion(String operador, String valor) {
        this.operador = operador;
        this.valor = valor;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
