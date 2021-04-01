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
public class InstruccionEliminarFormulario extends Instruccion {
    private String idFormulario;

    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        if(userOnline.equals("")) {
            return generarCodigoRespuesta("Conflicto en Eliminacion de Formulario", "Para realizar una eliminacion, primero inicie sesión en el sistema");
        }
        
        String codigo = "", descripcion;
        boolean comprobador = false;
        for(Formulario element : listaFormularios) {
            if(element.getIdentificador().equals(idFormulario) && element.getUsuarioCreacion().equals(userOnline)) {
                listaFormularios.remove(element);
                comprobador = true;
                break;
            }
        }
        if(comprobador) {
            descripcion = "Se ha eliminado el formulario " + idFormulario + " con éxito";
        } else {
            descripcion = "No se ha podido eliminar el formulario " + idFormulario + " porque usted no posee ningún formulario con ese id";
        }
        return generarCodigoRespuesta("Eliminacion de Formulario", descripcion);
    }
    
    public String getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(String idFormulario) {
        this.idFormulario = idFormulario;
    }
    
    
}
