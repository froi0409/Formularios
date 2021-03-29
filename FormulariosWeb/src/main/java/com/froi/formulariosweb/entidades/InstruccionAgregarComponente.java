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

/**
 *
 * @author froi-pc
 */
public class InstruccionAgregarComponente extends Instruccion {
    private String id;
    private String nombreCampo;
    private String formulario;
    private String clase;
    private String textoVisible;
    private String alineacion;
    private String requerido;
    private String opciones;
    private String filas;
    private String columnas;
    private String url;

    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        String codigo = "";
        String descripcion = "";
        boolean comprobante = false;
        boolean comprobanteSecundario = true;
        boolean comprobanteTerciario = true;
        int cont = 0;
        for(Formulario element : listaFormularios) {
            if(element.getIdentificador().equals(formulario)) {
                comprobante = true;
                break;
            }
            cont++;
        }
        
        if(comprobante) {
            for(Componente elem: listaFormularios.get(cont).getListaComponentes()) {
                if(elem.getId().equals(id)){
                    comprobanteSecundario = false;
                    break;
                }
            }
            for(Componente elem: listaFormularios.get(cont).getListaComponentes()) {
                if(elem.getNombreCampo().equals(nombreCampo)) {
                    comprobanteTerciario = false;
                    break;
                }
            }
            if (comprobanteSecundario && comprobanteTerciario) {
                Componente compo = new Componente(id, formulario, clase, textoVisible);
                if (nombreCampo != null) {
                    compo.setNombreCampo(nombreCampo);
                } 
                if(alineacion != null) {
                    compo.setAlineacion(alineacion);
                }
                if(requerido != null) {
                    compo.setRequerido(requerido);
                }
                if(opciones != null) {
                    compo.setOpciones(opciones);
                }
                if(filas != null) {
                    compo.setFilas(Integer.parseInt(filas));
                }
                if(columnas != null) {
                    compo.setColumnas(Integer.parseInt(columnas));
                }
                if(url != null) {
                    compo.setUrl(url);
                }
                Formulario formUse = listaFormularios.get(cont);
                if(clase.equals("AREA_TEXTO") || clase.equals("CAMPO_TEXTO") || clase.equals("COMBO") || clase.equals("RADIO")) {
                    //Añadimos la cantidad de datos recopilados que ya han sido agregados en otros formularios
                    //Esto con el fin de que no afecte a los resultados en los reportes
                    for(Componente element : formUse.getListaComponentes()) {
                        if(element.getClase().equals("AREA_TEXTO") || element.getClase().equals("CAMPO_TEXTO") || element.getClase().equals("COMBO") || element.getClase().equals("RADIO")) {
                            for(int i = 0; i < element.getDatosRecopilados().size(); i++) {
                                compo.getDatosRecopilados().add("");
                            }
                            break;
                        }
                    }
                }
                formUse.getListaComponentes().add(compo);
                descripcion += "Se añadió al formulario " + formUse.getIdentificador() + " el componente " + clase;
            } else {
                descripcion += "No se pudo agregar el componente: ";
                if(!comprobanteSecundario) {
                    descripcion += "El identificador: " + id + " ya está asociado a otro componente en el formulario. ";
                }
                if(!comprobanteTerciario) {
                    descripcion += "El nombre de campo " + nombreCampo + " ya se encuentra asociado a otro componente del formulario. ";
            
                }
            }
            
        } else {
            descripcion += "No se pudo agregar componente " + id + ", debido a que no existe el formulario: " + formulario + " indicado";
        }
        return generarCodigoRespuesta("Agregar Componente", descripcion);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
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
