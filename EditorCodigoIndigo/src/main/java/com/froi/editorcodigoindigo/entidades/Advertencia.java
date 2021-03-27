/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.editorcodigoindigo.entidades;

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
        this.descripcion = descripcion;
    }
    
    public String toString(){
        if(tipo.equals("Sintáctico") || tipo.equals("Léxico")) {
            return "Cerca del Lexema: " + lexema + ".  fila: " + linea + "    Columna: " + columna + "    Tipo: " + tipo + ".  Descripcion: " + descripcion;
        } else if(tipo.equals("Elemento Faltante")) {
            return "Advertencia: Hace falta el parámetro " + descripcion + " en el bloque que inicia en la fila " + linea + " y columna " + columna;
        } else if(tipo.equals("Clase Invalida")) {
            return "Advertencia: " + descripcion + ". Conflicto en el bloque que inicia en la fila " + linea + " y columna " + columna;
        } else if(tipo.equals("Elemento Repetido")) {
            return "Advertencia: Se ha repetido el parametro " + descripcion + ". Conflicto en el bloque que inicia en la fila " + linea + " y columna " + columna;
        } else {
            return "Advertencia: " + descripcion;
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
        this.descripcion = descripcion;
    }
    
}
