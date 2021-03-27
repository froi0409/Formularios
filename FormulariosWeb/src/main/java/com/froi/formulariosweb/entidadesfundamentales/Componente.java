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
public class Componente {
    private String id;
    private String nombreCampo;
    private String formulario;
    private String clase;
    private String textoVisible;
    private String alineacion;
    private String requerido;
    private String opciones;
    private int filas;
    private int columnas;
    private String url;

    public Componente(String id, String formulario, String clase, String textoVisible) {
        this.id = id;
        this.formulario = formulario;
        this.clase = clase;
        this.textoVisible = textoVisible;
        this.requerido = "NO";
        this.alineacion = "IZQUIERDA";
        if(clase.equals("AREA_TEXTO")) {
            this.filas = 3;
            this.columnas = 20;
            this.nombreCampo = "";
        } 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getTextoVisible() {
        return textoVisible;
    }

    public void setTextoVisible(String textoVisible) {
        this.textoVisible = textoVisible;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getRequerido() {
        return requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
