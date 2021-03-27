/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.entidades;

import com.froi.formulariosweb.entidadesfundamentales.Condicion;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class InstruccionConsulta extends Instruccion {
    private String idFormlario;
    private ArrayList<String>  listaCampos;
    private ArrayList<Condicion> listaCondiciones;
    
    public InstruccionConsulta() {
        this.listaCampos = new ArrayList<>();
        this.listaCondiciones = new ArrayList<>();
    }
    
    public String getIdFormlario() {
        return idFormlario;
    }

    public void setIdFormlario(String idFormlario) {
        this.idFormlario = idFormlario;
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
