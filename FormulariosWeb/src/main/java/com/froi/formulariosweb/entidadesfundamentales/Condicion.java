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
public class Condicion {
    private String operadorLogico;
    private boolean not;
    private String campo;
    private String operadorRelacional;
    private String valorCondicion;
    private String tipoValorCondicion;

    public Condicion(String operadorLogico, boolean not, String campo, String operadorRelacional, String valorCondicion) {
        this.operadorLogico = operadorLogico;
        this.not = not;
        this.campo = campo;
        this.operadorRelacional = operadorRelacional;
        this.valorCondicion = valorCondicion;
    }
    
    public String toString() {
        return operadorLogico + " " + not + " " + campo + " " + operadorRelacional + " " + valorCondicion;
    }
    
}
