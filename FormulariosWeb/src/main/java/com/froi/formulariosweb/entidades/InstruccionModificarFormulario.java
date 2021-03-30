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
        if(userOnline.equals("")) {
            return generarCodigoRespuesta("Conflicto en Modificaion de Formulario", "Para realizar una modificacion, primero inicie sesión en el sistema");
        }
        String descripcion;
        boolean comprobante = false;
        for(Formulario element: listaFormularios) {
            if(element.getIdentificador().equals(id) && element.getUsuarioCreacion().equals(userOnline)) {
                if(nombre != null) {
                    for(Formulario formularios: listaFormularios) {
                        if(formularios.getNombre().equals(nombre)) {
                            return generarCodigoRespuesta("Modificaicion de Formulario", "No se ha podido modificar el formulario, porque ya éxiste en el sistema un formulario con nombre " + nombre);
                        }
                    }
                    element.setNombre(nombre);
                }
                if(titulo != null) {
                    element.setTitulo(titulo);
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
            descripcion = "No se ha realizado ninguna modificacion, porque uste no posee un formulario con el id: " + id;
        }
        return generarCodigoRespuesta("Modificacion de Formulario", descripcion);
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
