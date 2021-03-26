/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.entidades;

import com.froi.formulariosweb.entidadesfundamentales.Formulario;
import com.froi.formulariosweb.entidadesfundamentales.Usuario;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class InstruccionModificarFormulario extends Instruccion {
    private String id;
    private String titulo;
    private String nombre;
    private String tema;

    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        String descripcion;
        boolean comprobante = false;
        for(Formulario element: listaFormularios) {
            if(element.getIdentificador().equals(id)) {
                if(titulo != null) {
                    element.setTitulo(titulo);
                }
                if(nombre != null) {
                    element.setNombre(nombre);
                }
                if(tema != null) {
                    element.setTema(tema);
                }
                comprobante = true;
                break;
            }
        }
        if(comprobante) {
            descripcion = "En el formulario " + id + " se han cambiado los siguientes parametros: ";
            if(titulo != null) {
                descripcion += "Titulo: " + titulo + ". ";
            }
            if(nombre != null) {
                descripcion += "Nombre: " + nombre + ". ";
            }
            if(tema != null) {
                descripcion += "Tema: " + tema + ". ";
            }
        } else {
            descripcion = "No existe ningun formulario con el id: " + id;
        }
        return generarCodigoRespuesta("Modificacion de Usuario", descripcion);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
}
