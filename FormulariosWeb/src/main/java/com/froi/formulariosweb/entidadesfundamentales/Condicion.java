/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.entidadesfundamentales;

import java.util.ArrayList;

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
    
    /**
     * Sirve para obtener la lista de las posiciones de los componentes que cumplen la condición especificada
     * @param componente Componente a analizar
     * @return Lista que contiene la posición de los componentes que cumplen la condición
     */
    public ArrayList<Integer> getListaValidacion(Componente componente) {
        ArrayList<Integer> listaValida = new ArrayList<>();
        int cont = 0;
        for(String dato : componente.getDatosRecopilados()) {
            boolean aceptador;
            //Ejecutamos la condicion
            if(isNumber(valorCondicion)) {
                switch(operadorRelacional) {
                    case "=":
                        aceptador = Double.parseDouble(dato) == Double.parseDouble(valorCondicion);
                        break;
                    case "<":
                        aceptador = Double.parseDouble(dato) < Double.parseDouble(valorCondicion);
                        break;
                    case ">":
                        aceptador = Double.parseDouble(dato) > Double.parseDouble(valorCondicion);
                        break;
                    case "<=":
                        aceptador = Double.parseDouble(dato) <= Double.parseDouble(valorCondicion);
                        break;
                    case ">=":
                        aceptador = Double.parseDouble(dato) >= Double.parseDouble(valorCondicion);
                        break;
                    case "<>":
                        aceptador = Double.parseDouble(dato) != Double.parseDouble(valorCondicion);
                        break;
                    default:
                        aceptador = false;
                        break;
                }
            } else {
                String cadena = valorCondicion.replace("'", "").replace("’", "");
                switch(operadorRelacional) {
                    case "=":
                        aceptador = cadena.equals(dato);
                        break;
                    case "<>":
                        aceptador = !cadena.equals(dato);
                        break;
                    default:
                        aceptador = false;
                        break;
                }
            }
            
            if(not) {
                aceptador = !aceptador;
            }
            
            if(aceptador){
                listaValida.add(cont);
            }
            
            cont++;
        }
        return listaValida;
    }
    
    /**
     * Método que nos ayuda a comprobar si una cadena es un numero
     * @param cadena cadena consultada
     * @return true si la cadena es un número, false si no lo es
     */
    private boolean isNumber(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String toString() {
        return operadorLogico + " " + not + " " + campo + " " + operadorRelacional + " " + valorCondicion;
    }

    public String getOperadorLogico() {
        return operadorLogico;
    }

    public void setOperadorLogico(String operadorLogico) {
        this.operadorLogico = operadorLogico;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getOperadorRelacional() {
        return operadorRelacional;
    }

    public void setOperadorRelacional(String operadorRelacional) {
        this.operadorRelacional = operadorRelacional;
    }

    public String getValorCondicion() {
        return valorCondicion;
    }

    public void setValorCondicion(String valorCondicion) {
        this.valorCondicion = valorCondicion;
    }

    public String getTipoValorCondicion() {
        return tipoValorCondicion;
    }

    public void setTipoValorCondicion(String tipoValorCondicion) {
        this.tipoValorCondicion = tipoValorCondicion;
    }
    
}
