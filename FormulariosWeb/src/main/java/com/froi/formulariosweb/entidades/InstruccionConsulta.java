/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.entidades;

import com.froi.formulariosweb.entidadesfundamentales.Condicion;
import com.froi.formulariosweb.entidadesfundamentales.Formulario;
import com.froi.formulariosweb.entidadesfundamentales.Usuario;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class InstruccionConsulta extends Instruccion {
    private String idFormulario;
    private ArrayList<String>  listaCampos;
    private ArrayList<Condicion> listaCondiciones;
    
    public InstruccionConsulta() {
        this.listaCampos = new ArrayList<>();
        this.listaCondiciones = new ArrayList<>();
    }
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        return "si funciona";
    }
    public String getIdFormlario() {
        return idFormulario;
    }

    public void setIdFormulario(String idFormulario) {
        this.idFormulario = idFormulario;
    }

    public ArrayList<String> getListaCampos() {
        return listaCampos;
    }

    public void setListaCampos(ArrayList<String> listaCampos) {
        this.listaCampos = listaCampos;
    }

    public ArrayList<Condicion> getListaCondiciones() {
        return listaCondiciones;
    }

    public void setListaCondiciones(ArrayList<Condicion> listaCondiciones) {
        this.listaCondiciones = listaCondiciones;
    }
    
}
