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
public class Formulario {
    private String identificador;
    private String titulo;
    private String nombre;
    private String tema;
    private String usuarioCreacion;
    private String fechaCreacion;
    private ArrayList<Componente> listaComponentes;

    public Formulario(String identificador, String titulo, String nombre, String tema, String usuarioCreacion, String fechaCreacion) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.nombre = nombre;
        this.tema = tema;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.listaComponentes = new ArrayList<>();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Componente> getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(ArrayList<Componente> listaComponentes) {
        this.listaComponentes = listaComponentes;
    }
    
}
