/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.entidades;

import com.froi.formulariosweb.entidadesfundamentales.Componente;
import com.froi.formulariosweb.entidadesfundamentales.Formulario;
import com.froi.formulariosweb.entidadesfundamentales.Usuario;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class InstruccionElliminarComponente extends Instruccion {
    private String idComponente;
    private String idFormulario;

    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        String codigo = "", descripcion;
        boolean comprobanteForm = false, comprobanteComp = false;
        for(Formulario element : listaFormularios) {
            if(element.getIdentificador().equals(idFormulario)) {
                comprobanteForm = true;
                for(Componente elem : element.getListaComponentes()) {
                    if(elem.getId().equals(idComponente)) {
                        element.getListaComponentes().remove(elem);
                        comprobanteComp = true;
                        break;
                    }
                }
                break;
            }
        }
        if(!comprobanteForm) {
            descripcion = "No se ha podido eliminar el componente " + idComponente + " porque el formulario " + idFormulario + "  no existe en el sistema";
        } else if(!comprobanteComp) {
            descripcion = "El componente " + idComponente + " no existe en eL formulario " + idFormulario;
        } else {
            descripcion = "Se ha eliminado el componente " + idComponente + " del formulario " + idFormulario;
        }
        codigo += "<!ini_respuesta:\"INSTRUCCIONES\">\n" +
                  "{ \"INSTRUCCION_EJECUTADA\" : [{\n";
        codigo += "\"TIPO\" : \"Creacion de Usuario\",\n";
        codigo += "\"DETALLES\" : \"" + descripcion + "\"\n";
        codigo += "}\n" +
                  "]\n" +
                  "}\n" +
                  "<!fin_respuesta>\n";
        return codigo;
    }
    
    public String getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(String idComponente) {
        this.idComponente = idComponente;
    }

    public String getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(String idFormulario) {
        this.idFormulario = idFormulario;
    }
    
}
