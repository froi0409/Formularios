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
public class InstruccionEliminarUsuario extends Instruccion {
    private String usuario;

    /**
     * Permite eliminar un usuario del sistema
     * @param listaUsuarios Lista de los usuarios que hay en el sistema
     * @param listaFormularios Lista de los formularios que hay en el sistema
     * @param userOnline Usuario loggeado en el sistema
     * @return Código índigo de respuesta del servidor al cliente
     */
    @Override
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        if(usuario.equals(userOnline)) {
            return generarCodigoRespuesta("Conflicto en Eliminacion", "No se puede eliminar a un usuario que actualmente esté con le sesion iniciada");
        }
        String codigo = "", descripcion;
        boolean comprobador = false;
        int cont = 0;
        for(Usuario element : listaUsuarios) {
            if(element.getUsuario().equals(usuario)) {
                listaUsuarios.remove(element);
                comprobador = true;
                break;
            }
        }
        
        if(comprobador) {
            ArrayList<Formulario> delete = new ArrayList<>();
            for(Formulario form : listaFormularios) {
                if(form.getUsuarioCreacion().equals(usuario)) {
                    delete.add(form);
                }
            }
            for(Formulario form : delete) {
                listaFormularios.remove(form);
            }
            descripcion = "Se ha eliminado del sistema al usuario " + usuario;
        } else {
            descripcion = "El usuario " + usuario + " no existe en el sistema";
        }
        return generarCodigoRespuesta("Eliminacion de Usuario", descripcion);
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
}
