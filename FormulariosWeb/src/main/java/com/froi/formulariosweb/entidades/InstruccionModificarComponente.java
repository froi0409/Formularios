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
public class InstruccionModificarComponente extends Instruccion {
    private String idComponente;
    private String formulario;
    private int indice;
    private String nombreCampo;
    private String clase;
    private String textoVisible;
    private String alineacion;
    private String requerido;
    private String opciones;
    private String filas;
    private String columnas;
    private String url;

    public InstruccionModificarComponente(){
        this.indice = -1;
    }
    
    /**
     * Permite modificar un componente de un formulario en específico
     * @param listaUsuarios Lista de los usuarios que hay en el sistema
     * @param listaFormularios Lista de los formularios que hay en el sistema
     * @param userOnline Usuario loggeado en el sistema
     * @return Código índigo de respuesta del servidor al cliente
     */
    @Override
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        if(userOnline.equals("")) {
            return generarCodigoRespuesta("Conflicto en Agregar Componente", "Para agregar un componente a un formulario, primero inicie sesión en el sistema");
        }
        int cont = 0;
        boolean comprobadorFormulario = false, comprobanteComponente = false;
        String descripcion = "Para el componente " + idComponente + " del formulario " + formulario + ": ";
        for(Formulario form : listaFormularios) {
            if(form.getIdentificador().equals(formulario) && form.getUsuarioCreacion().equals(userOnline)) {
                Collections.sort(form.getListaComponentes());
                for(Componente componente : form.getListaComponentes()) { 
                    if(componente.getId().equals(idComponente)) {
                        if(indice != -1) {
                            descripcion += cambioIndice(form.getListaComponentes(), indice, componente.getIndice());
                        }
                        if(textoVisible != null) {
                            componente.setTextoVisible(textoVisible);
                            descripcion += "Se cambió el texto visible. ";
                        }
                        if(alineacion != null) {
                            componente.setAlineacion(alineacion);
                            descripcion += "Se cambió la alineación a " + alineacion + ". ";
                        }
                        if(requerido != null) {
                            componente.setRequerido(requerido);
                            descripcion += "El componente ahora " + requerido + " es requerido. ";
                        }
                        if(nombreCampo != null) {
                            boolean existeOtro = false;
                            for(Componente aux : form.getListaComponentes()) {
                                if(aux.getNombreCampo().equals(nombreCampo)) {
                                    existeOtro = true;
                                    break;
                                }
                            }
                            if(existeOtro) {
                                descripcion += "No se puede modificar el nombre del campo a " + nombreCampo + " porque ya existe otro componente con ese nombre. ";
                            } else {
                                componente.setNombreCampo(nombreCampo);
                                descripcion += "Se ha actualizado el nombre del campo a " + nombreCampo + ". ";
                            }
                        }
                        if(opciones != null) {
                            componente.setOpciones(opciones);
                            descripcion += "Se han modificado las opciones del componente. ";
                        }
                        if(filas != null) {
                            componente.setFilas(Integer.parseInt(filas));
                            descripcion += "Se han modificado las filas del componente. ";
                        }
                        if(columnas != null) {
                            componente.setColumnas(Integer.parseInt(columnas));
                            descripcion += "Se han modificado las columnas del componente. ";
                        }
                        if(url != null) {
                            componente.setUrl(url);
                            descripcion += "Se ha actualizado el url del componente. ";
                        }
                        comprobanteComponente = true;
                        break;
                    }
                }
                comprobadorFormulario = true;
                break;
            }
        }
        if(!comprobadorFormulario) {
            descripcion = "Usted no posee un formulario con identificador: " + formulario;
        } else if (!comprobanteComponente) {
            descripcion = "No existe ningún componente con el id " + idComponente + " en el formulario " + formulario;
        }
        return generarCodigoRespuesta("Modificacion de Componente", descripcion);
    }
    
    private String cambioIndice(ArrayList<Componente> listaComponentes, int indice, int indiceInicial) {
        if(indice > listaComponentes.size()) {
            return "El indice " + indice + " excede la cantidad de componentes del formulario. ";
        }
        if(indiceInicial < indice) {
            listaComponentes.get(indiceInicial-1).setIndice(indice);
            for(int i = indiceInicial; i < indice; i++) {
                listaComponentes.get(i).reducirIndice();
            }
            return "Se ha actualizado el indice de: " + indiceInicial + " a " + indice + ". ";
        } else if(indiceInicial > indice) {
            listaComponentes.get(indiceInicial-1).setIndice(indice);
            for(int i = indice-1; i < indiceInicial-2; i++) {
                listaComponentes.get(i).incrementarIndice();
            }
            return "Se ha actualizado el indice de: " + indiceInicial + " a " + indice + ". ";
        } else {
            return "El indice del componente ya es " + indice + ". ";
        }
        
    }
    
    public String getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(String idComponente) {
        this.idComponente = idComponente;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getTextoVisible() {
        return textoVisible;
    }

    public void setTextoVisible(String textoVisible) {
        this.textoVisible = textoVisible;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getRequerido() {
        return requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

    public String getFilas() {
        return filas;
    }

    public void setFilas(String filas) {
        this.filas = filas;
    }

    public String getColumnas() {
        return columnas;
    }

    public void setColumnas(String columnas) {
        this.columnas = columnas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
