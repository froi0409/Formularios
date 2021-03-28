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
public class InstruccionLoginUsuario extends Instruccion {
    
    private String usuario;
    private String password;
    
    public InstruccionLoginUsuario() {
    }
    
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        String codigo = "";
        String descripcion;
        boolean comprobante = false;
        for(Usuario element : listaUsuarios) {
            if(element.getUsuario().equals(usuario) && element.getPassword().equals(password)) {
                comprobante = true;
            }
        }
        
        if(comprobante) {
            descripcion = "El usuario " + usuario + " ha ingresado al sistema";
            userOnline = usuario;
            System.out.println(userOnline);
        } else {
            descripcion = "Usuario o contraseña inválidos, revise sus credenciales";
        }
        
        return generarCodigoRespuesta("Login Usuario", descripcion);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
