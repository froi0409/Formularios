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
        String codigo = "", descripcion;
        boolean comprobador = false;
        System.out.println("se ejecuta");
        for(Formulario element : listaFormularios) {
            if(element.getIdentificador().equals(idFormulario)) {
                listaFormularios.remove(element);
                comprobador = true;
                break;
            }
        }
        System.out.println("hola");
        if(comprobador) {
            descripcion = "Se ha eliminado el formulario " + idFormulario + " con éxito";
        } else {
            descripcion = "No se ha podido eliminar el formulario " + idFormulario + " porque no éxiste ningún formulario con ese id";
        }
        codigo += "<!ini_respuesta:\"INSTRUCCIONES\">\n" +
                  "{ \"INSTRUCCION_EJECUTADA\" : [{\n";
        codigo += "\"TIPO\" : \"Eliminación de Formulario\",\n";
        codigo += "\"DETALLES\" : \"" + descripcion + "\"\n";
        codigo += "}\n" +
                  "]\n" +
                  "}\n" +
                  "<!fin_respuesta>\n";
        return generarCodigoRespuesta("Eliminacion de Formulario", descripcion);
    }
    
    public String getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(String idFormulario) {
        this.idFormulario = idFormulario;
    }
    
    
}
