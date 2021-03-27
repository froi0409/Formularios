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

    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
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
            for(int i = 0; i < listaFormularios.size(); i++) {
                if(listaFormularios.get(i).getUsuarioCreacion().equals(usuario)) {
                    listaFormularios.remove(i);
                }
            }
            descripcion = "Se ha eliminado del sistema al usuario " + usuario;
        } else {
            descripcion = "El usuario " + usuario + " no existe en el sistema";
        }
        codigo += "<!ini_respuesta:\"INSTRUCCIONES\">\n" +
                  "{ \"INSTRUCCION_EJECUTADA\" : [{\n";
        codigo += "\"TIPO\" : \"Eliminar Usuario\",\n";
        codigo += "\"DETALLES\" : \"" + descripcion + "\"\n";
        codigo += "}\n" +
                  "]\n" +
                  "}\n" +
                  "<!fin_respuesta>\n";
        return codigo;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
}
