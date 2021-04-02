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
    
    /**
     * Permite a un usuario iniciar sesión en el sistema (también se encarga de notificarlo a la aplicación cliente)
     * @param listaUsuarios Lista de los usuarios que hay en el sistema
     * @param listaFormularios Lista de los formularios que hay en el sistema
     * @param userOnline Usuario loggeado en el sistema
     * @return Código índigo de respuesta del servidor al cliente
     */
    @Override
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        String codigo = "";
        String descripcion;
        boolean comprobante = false;
        if(!userOnline.equals("")) {
            return generarCodigoRespuesta("Conflicto login usuario", "No pudes iniciar otra sesion, ya que actualmente se encuentra loggeado el usuario: " + userOnline);
        }
        for(Usuario element : listaUsuarios) {
            if(element.getUsuario().equals(usuario) && element.getPassword().equals(password)) {
                comprobante = true;
                break;
            }
        }
        
        if(comprobante) {
            descripcion = "El usuario " + usuario + " ha ingresado al sistema";
            String indigoCode = "";
            indigoCode += "<!ini_respuesta:\"LOGIN_DETECTED\">\n" +
                          "{ \"USUARIO_LOGIN\" : [{\n";
            indigoCode += "\"TIPO\" : \"Login Efectuado\",\n";
            indigoCode += "\"DETALLES\" : \"" + descripcion + "\",\n";
            indigoCode += "\"USER_LOGGED\" : \"" + usuario + "\"\n";
            indigoCode += "}\n" +
                          "]\n" +
                          "}\n" +
                          "<!fin_respuesta>\n";
            return indigoCode;
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
