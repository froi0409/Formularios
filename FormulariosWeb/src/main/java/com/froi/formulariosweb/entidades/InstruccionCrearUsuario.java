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
public class InstruccionCrearUsuario extends Instruccion {
    private String usuario;
    private String password;
    private String fechaCreacion;
    
    public InstruccionCrearUsuario () {
        this.usuario = "";
        this.password = "";
        Calendar c2 = new GregorianCalendar();
        
        String dia = Integer.toString(c2.get(Calendar.DATE));
        String mes = Integer.toString(c2.get(Calendar.MONTH) + 1);
        String año = Integer.toString(c2.get(Calendar.YEAR));
        
        this.fechaCreacion = año + "-" + mes + "-" + dia;    
    }

    @Override
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        String codigo = "";
        String descripcion = "Se ha ingresado al usuario: " + usuario + ", con contraseña: " + password + ", con fecha de registro: " + fechaCreacion;
        boolean aceptacion = true;
        //Verificamos si el usuario ya existe en el sistema
        for(Usuario element: listaUsuarios) {
            if(usuario.equals(element.getUsuario())) {
                descripcion = "El usuario: " + usuario + " ya existe, intente con otro nombre de usuario";
                aceptacion = false;
                break;
            }
        }
        
        
        //Creamos el codigo del usuario que será aceptado
        if(aceptacion) {
            listaUsuarios.add(new Usuario(usuario, password, fechaCreacion));
        }
        
        //CODIGO DE PRUEBAS
        codigo += "<!ini_respuesta:\"INSTRUCCIONES\">\n" +
                  "{ \"INSTRUCCION_EJECUTADA\" : [{\n";
        codigo += "\"TIPO\" : \"Creacion de Usuario\",\n";
        codigo += "\"DETALLES\" : \"" + descripcion + "\"\n";
        codigo += "}\n" +
                  "]\n" +
                  "}\n" +
                  "<!fin_respuesta>\n";
        return generarCodigoRespuesta("Creacion de Usuario", descripcion);
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion.replace(" ","").replace("\n","").replace("\t","");
    }
    
}
