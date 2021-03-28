/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.entidades;

/**
 *
 * @author froi-pc
 */
public class Advertencia {
    
    private String tipo;
    private String lexema;
    private String linea = "";
    private String columna = "";
    private String descripcion;

    public Advertencia(String lexema, int linea, int columna, String tipo, String descripcion) {
        this.lexema = lexema;
        this.linea += linea;
        this.columna += columna;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    public Advertencia(String tipo, int linea, String descripcion) {
        this.tipo = tipo;
        this.linea += linea;
        this.descripcion = descripcion;
    }
    public Advertencia(String tipo, int linea, int columna, String descripcion) {
        this.tipo = tipo;
        this.linea += linea;
        this.columna += columna;
        this.descripcion = descripcion.replace("\"", "");
    }
    
    public String toString(){
        String mensaje;
        if(tipo.equals("Sintáctico") || tipo.equals("Léxico")) {
            mensaje = "Cerca del Lexema: " + lexema + ".  fila: " + linea + "    Columna: " + columna + "    Tipo: " + tipo + ".  Descripcion: " + descripcion;
            mensaje = mensaje.replace("\"", "");
            return mensaje;
        } else if(tipo.equals("Elemento Faltante")) {
            mensaje = "Advertencia: Hace falta el parámetro " + descripcion + " en el bloque que inicia en la fila " + linea + " y columna " + columna;
            mensaje = mensaje.replace("\"", "");
            return mensaje;
        } else if(tipo.equals("Clase Invalida")) {
            mensaje = "Advertencia: " + descripcion + ". Conflicto en el bloque que inicia en la fila " + linea + " y columna " + columna;
            mensaje = mensaje.replace("\"", "");
            return mensaje;
        } else if(tipo.equals("Elemento Repetido")) {
            mensaje = "Advertencia: Se ha repetido el parametro " + descripcion + ". Conflicto en el bloque que inicia en la fila " + linea + " y columna " + columna;
            mensaje = mensaje.replace("\"", "");
            return mensaje;
        } else {
            mensaje = "Advertencia: " + descripcion;
            mensaje = mensaje.replace("\"", "");
            return mensaje;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public String getLinea() {
        return linea;
    }

    public String getColumna() {
        return columna;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.replace("\"", "");
    }
    
}
