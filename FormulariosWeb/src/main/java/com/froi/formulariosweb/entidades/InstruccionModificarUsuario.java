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
public class InstruccionModificarUsuario extends Instruccion {
    private String usuarioAntiguo;
    private String usuarioNuevo;
    private String nuevoPassword;
    private String fechaModificacion;
    
    public InstruccionModificarUsuario() {
        Calendar c2 = new GregorianCalendar();
        
        String dia = Integer.toString(c2.get(Calendar.DATE));
        String mes = Integer.toString(c2.get(Calendar.MONTH) + 1);
        String año = Integer.toString(c2.get(Calendar.YEAR));
        
        this.fechaModificacion = año + "-" + mes + "-" + dia;   
    }

    @Override
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        String codigo = "", descripcion = "";
        boolean comprobante = false, comprobante2 = true;
        int cont = 0;
        //Comprobamos si el usuario antiguoexiste en el sistena
        for(Usuario element:listaUsuarios) {
            if(element.getUsuario().equals(usuarioAntiguo)) {
                comprobante = true;
                break;
            }
            cont++;
        }
        //Comprobamos si el nombre de usuario nuevo está disponible en el sistema
        for(Usuario element:listaUsuarios) {
            if(element.getUsuario().equals(usuarioNuevo)){
                comprobante2 = false;
            }
        }
        
        if(comprobante && comprobante2) {
            listaUsuarios.get(cont).setUsuario(usuarioNuevo);
            listaUsuarios.get(cont).setPassword(nuevoPassword);
            for(Formulario element : listaFormularios) {
                if(element.getUsuarioCreacion().equals(usuarioAntiguo)) {
                    element.setUsuarioCreacion(usuarioNuevo);
                }
            }
            descripcion = "se ha realizado el cambio de usuario " + usuarioAntiguo + " por " + usuarioNuevo;
            descripcion += ". Se ha actualizado la contraseña a " + nuevoPassword;

            if(fechaModificacion != null) {
                listaUsuarios.get(cont).setFechaCreacion(fechaModificacion);
            }
            descripcion += ". En la fecha " + fechaModificacion;
        } else {
            descripcion = "No se pudo realizar la modificación en el usuario " + usuarioAntiguo;
            if(!comprobante) {
                descripcion += ". El nombre de usuario " + usuarioAntiguo + " no existe en el sistema";
            }
            if(!comprobante2) {
                descripcion += ". El nombre de usuario " + usuarioNuevo + " ya existe en el sistema";
            }
        }
        return generarCodigoRespuesta("Modificacion de Usuario", descripcion);
    }
    
    public String getUsuarioAntiguo() {
        return usuarioAntiguo;
    }

    public void setUsuarioAntiguo(String usuarioAntiguo) {
        this.usuarioAntiguo = usuarioAntiguo;
    }

    public String getUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(String usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }

    public String getNuevoPassword() {
        return nuevoPassword;
    }

    public void setNuevoPassword(String nuevoPassword) {
        this.nuevoPassword = nuevoPassword;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion.replace(" ","").replace("\n","").replace("\t","");
    }
    
    
}
