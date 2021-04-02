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
import java.util.Collections;

/**
 *
 * @author froi-pc
 */
public class InstruccionElliminarComponente extends Instruccion {
    private String idComponente;
    private String idFormulario;

    /**
     * Permite eliminar un componente de un formulario en específico
     * @param listaUsuarios Lista de los usuarios que hay en el sistema
     * @param listaFormularios Lista de los formularios que hay en el sistema
     * @param userOnline Usuario loggeado en el sistema
     * @return Código índigo de respuesta del servidor al cliente
     */
    @Override
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        if(userOnline.equals("")) {
            return generarCodigoRespuesta("Conflicto en Eliminacion de ]Componente", "Para realizar una eliminacion, primero inicie sesión en el sistema");
        }
        String codigo = "", descripcion;
        boolean comprobanteForm = false, comprobanteComp = false;
        for(Formulario element : listaFormularios) {
            if(element.getIdentificador().equals(idFormulario) && element.getUsuarioCreacion().equals(userOnline)) {
                comprobanteForm = true;
                for(Componente elem : element.getListaComponentes()) {
                    if(elem.getId().equals(idComponente)) {
                        element.getListaComponentes().remove(elem);
                        comprobanteComp = true;
                        break;
                    }
                }
                int cont = 1;
                //Establecemos los indices de los componentes
                Collections.sort(element.getListaComponentes());
                for(Componente compo : element.getListaComponentes()) {
                    compo.setIndice(cont);
                    cont++;
                }
                break;
            }
        }
        if(!comprobanteForm) {
            descripcion = "No se ha podido eliminar el componente " + idComponente + " porque usted no posee un fomulario: " + idFormulario;
        } else if(!comprobanteComp) {
            descripcion = "El componente " + idComponente + " no existe en eL formulario " + idFormulario;
        } else {
            descripcion = "Se ha eliminado el componente " + idComponente + " del formulario " + idFormulario;
        }
        return generarCodigoRespuesta("Eliminacion de Componente", descripcion);
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
