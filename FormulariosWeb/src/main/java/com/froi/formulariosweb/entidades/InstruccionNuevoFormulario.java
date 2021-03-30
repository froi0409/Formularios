/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.entidades;

import com.froi.formulariosweb.entidadesfundamentales.Formulario;
import com.froi.formulariosweb.entidadesfundamentales.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author froi-pc
 */
public class InstruccionNuevoFormulario extends Instruccion {
    
    private String id;
    private String titulo;
    private String nombre;
    private String tema;
    private String usuarioCreacion;
    private String fechaCreacion;
    
    public InstruccionNuevoFormulario() {
        Calendar c2 = new GregorianCalendar();
        
        String dia = Integer.toString(c2.get(Calendar.DATE));
        String mes = Integer.toString(c2.get(Calendar.MONTH) + 1);
        String año = Integer.toString(c2.get(Calendar.YEAR));
        
        this.fechaCreacion = año + "-" + mes + "-" + dia;   
    }
    
    /**
     * Analiza un nuevo formulario, para que el mismo pueda ser creado
     * @param listaUsuarios Lista de los usuarios que hay en el sistema
     * @param listaFormularios Lista de los formularios existentes en el sistema
     * @param userOnline Usuario que está loggeado en el servidor
     * @return Código índifo de respuesta del servidor
     */
    @Override
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        if(userOnline.equals("")) {
            return generarCodigoRespuesta("Conflicto en Creación de Formulario", "Para crear un nuevo formulario, primero inicie sesión en el sistema");
        }
        String codigo = "";
        String descripcion = "";
        boolean comprobante = true, comprobanteSecundario = true;
        for(Formulario element : listaFormularios) {
            if(element.getIdentificador().equals(id)) {
                comprobante = false;
                break;
            }
        }
        for(Formulario element : listaFormularios) {
            if(element.getNombre().equals(nombre)) {
                comprobanteSecundario = false;
            }
        }
        if(comprobante && comprobanteSecundario) {
            //Verificamos si hay un usuario específico para que se le sea asignado el formulario
            if(usuarioCreacion == null) {
                System.out.println(userOnline + " -> user");
                if(userOnline.equals("")) { //Verificamos si existe un usuraio conectado
                    descripcion = "No de pudo crear el formulario: " + id + ", porque no se especificó ningún usuario a ingresar, y no hay un usuario loggeado en el sistema";
                } else {
                    usuarioCreacion = userOnline;
                    listaFormularios.add(new Formulario(id, titulo, nombre, tema, usuarioCreacion, fechaCreacion));
                    descripcion = "Se ha creado el formulario: " + id;
                }
            } else {
                boolean comprobanteUsuario = false;
                for(Usuario element : listaUsuarios) {
                    if(element.getUsuario().equals(usuarioCreacion)) {
                        comprobanteUsuario = true;
                        break;
                    }
                }
                if(comprobanteUsuario) {
                    listaFormularios.add(new Formulario(id, titulo, nombre, tema, usuarioCreacion, fechaCreacion));
                    descripcion = "Se ha creado el formulario: " + id;
            
                } else {
                    descripcion = "No se ha podido crear el formulario " + id + " porque el usuario " + usuarioCreacion + " no existe en el sistema";
                }
            }
        } else {
            descripcion = "No se pudo crear el formulario: ";
            if(!comprobante) {
                descripcion += "El id: " + id + " ya se encuentra asociado a otro formulario del sistema. ";
            }
            if(!comprobanteSecundario) {
                descripcion += "El nombre " + nombre + " ya se encuentra asociado a otro formulario del sistema. ";
            }
            
        }
        return generarCodigoRespuesta("Nuevo Formulario", descripcion);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
