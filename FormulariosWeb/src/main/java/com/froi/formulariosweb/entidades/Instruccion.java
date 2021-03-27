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
public class Instruccion {
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        return null;
    }
    
    public String generarCodigoRespuesta(String tipoRespuesta, String descripcion) {
        String indigoCode = "";
        indigoCode += "<!ini_respuesta:\"INSTRUCCIONES\">\n" +
                      "{ \"INSTRUCCION_EJECUTADA\" : [{\n";
        indigoCode += "\"TIPO\" : \"" + tipoRespuesta + "\",\n";
        indigoCode += "\"DETALLES\" : \"" + descripcion + "\"\n";
        indigoCode += "}\n" +
                      "]\n" +
                      "}\n" +
                      "<!fin_respuesta>\n";
        return indigoCode;
    }
}
