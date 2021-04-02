/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.entidades;

import com.froi.formulariosweb.entidadesfundamentales.Componente;
import com.froi.formulariosweb.entidadesfundamentales.Condicion;
import com.froi.formulariosweb.entidadesfundamentales.Formulario;
import com.froi.formulariosweb.entidadesfundamentales.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author froi-pc
 */
public class InstruccionConsulta extends Instruccion {
    private String idFormulario;
    private ArrayList<String>  listaCampos;
    private ArrayList<Condicion> listaCondiciones;
    private ArrayList<Componente> camposMostrar;
    private ArrayList<Integer> posicionesDatosValidos;
    private Formulario formularioUtilizado;
    
    public InstruccionConsulta() {
        this.listaCampos = new ArrayList<>();
        this.listaCondiciones = new ArrayList<>();
        this.camposMostrar = new ArrayList<>();
        this.posicionesDatosValidos = new ArrayList<>();
    }
    
    /**
     * Permite realizar una consulta sobre un formulario en específico
     * @param listaUsuarios Lista de los usuarios que hay en el sistema
     * @param listaFormularios Lista de los formularios que hay en el sistema
     * @param userOnline Usuario loggeado en el sistema
     * @return Código índigo de respuesta del servidor al cliente
     */
    @Override
    public String analizar(ArrayList<Usuario> listaUsuarios, ArrayList<Formulario> listaFormularios, String userOnline) {
        
        if(userOnline.equals("")) {
            return generarCodigoRespuesta("Conflicto en Consulta", "Para realizar una consulta, primero inicie sesión en el sistema");
        }
        
        boolean comprobadorExistenciaForm = false, comprobadorExistenciaCampos = true, comprobadorCamposConInfo = true;
        String descripcionCamposInexistentes = "Los siguientes campos no existen: ", descripcionCamposSinInfo = "Los siguientes campos no almacenan informacion: ";
        for(Formulario formulario : listaFormularios) {
            //Verificamos si el formulario existe
            if((formulario.getIdentificador().equals(idFormulario) || formulario.getNombre().equals(idFormulario)) && formulario.getUsuarioCreacion().equals(userOnline)) {
                //Verificamos si el usuario no indicó campos a mostrar. Si no los indicó, mostramos todos los campos
                if(listaCampos.isEmpty()) {
                    for(Componente componente : formulario.getListaComponentes()) {
                        camposMostrar.add(componente);
                    }
                } else {
                    //Verificamos que los campos a mostrar existan en el formulario
                    for(String campo : listaCampos) {
                        boolean comprobadorCampo = false;
                        for(Componente componente : formulario.getListaComponentes()) {
                            //Comprobamos si el campo existe en el formulario
                            if(componente.getId().equals(campo) || componente.getNombreCampo().equals(campo)) {
                                camposMostrar.add(componente);
                                //Verificamos si el campo puede mostrar información
                                if(!componente.getClase().equals("AREA_TEXTO") && !componente.getClase().equals("CAMPO_TEXTO") && !componente.getClase().equals("RADIO") && !componente.getClase().equals("COMBO")) {
                                    comprobadorCamposConInfo = false;
                                    descripcionCamposSinInfo += componente.getId() + ". ";
                                }
                                comprobadorCampo = true;
                            }
                            
                        }
                        //Indicamos que hay campos inválidos
                        if(!comprobadorCampo) {
                            descripcionCamposInexistentes += " " + campo + ". ";
                            comprobadorExistenciaCampos = false;
                        }
                    }
                    //Verificamos que los campos especificados en las condiciones existan en el formulario
                    for(Condicion condicion : listaCondiciones) {
                        boolean comprobadorCampo = false;
                        for(Componente componente : formulario.getListaComponentes()) {
                            //Comprobamos si el campo de la condicion existe en el formulario
                            if(condicion.getCampo().equals(componente.getId()) || condicion.getCampo().equals(componente.getNombreCampo())) {
                                comprobadorCampo = true;
                                if(!componente.getClase().equals("AREA_TEXTO") && !componente.getClase().equals("CAMPO_TEXTO") && !componente.getClase().equals("RADIO") && !componente.getClase().equals("COMBO")) {
                                    comprobadorCamposConInfo = false;
                                    descripcionCamposSinInfo += componente.getId() + ". ";
                                }
                            }
                        }
                        if(!comprobadorCampo) {
                            descripcionCamposInexistentes += " " + condicion.getCampo() + ". ";
                            comprobadorExistenciaCampos = false;
                        }
                    }
                }
                //Si alguno de los campos especificados no existe en el formulario, se retona el mensaje que lo indica
                if(!comprobadorExistenciaCampos) {
                    if(!comprobadorCamposConInfo) {
                        descripcionCamposInexistentes += descripcionCamposSinInfo;
                    }
                    return generarCodigoRespuesta("Conflicto de Consulta", descripcionCamposInexistentes);
                }
                if(!comprobadorCamposConInfo) {
                    return generarCodigoRespuesta("Conflicto de Consulta", descripcionCamposSinInfo);
                }
                comprobadorExistenciaForm = true;
                formularioUtilizado = formulario;
                break;
            }
        }
        if(!comprobadorExistenciaForm) {
            String problema = "Usted no posee un formulario con el id o nombre: " + idFormulario;
            return generarCodigoRespuesta("Conflicto de Consulta", problema);
        }
        return generarCodigoConsulta();
    }
    
    /**
     * Geera el codigo indigo de respuesta que la consulta devolverá al cliente
     * @return Código índigo de respueta de la consulta
     */
    public String generarCodigoConsulta() {
        String codigoConsulta = "";
        codigoConsulta += "<!ini_respuesta: \"CONSULTA\">\n";
        codigoConsulta += "{ \"DATOS_CONSULTA\" : [\n";
        codigoConsulta += datosRecopilados();
        codigoConsulta += "]\n";
        codigoConsulta += "}\n";
        codigoConsulta += "<!fin_respuesta>\n";
        return codigoConsulta;
    }
    
    /**
     * Obtiene la parte del código de los datos recopilados que cumplen condiciones
     * @return Parte del código índigo de respuesta que contiene los datos recopilados que cumplen la condición establecida
     */
    private String datosRecopilados() {
        String datosVerificados = "";
        int cont = 0;
        setPosicionesValidas();
        for(Componente campoMostrar : camposMostrar) {
            if(campoMostrar.getClase().equals("AREA_TEXTO") || campoMostrar.getClase().equals("CAMPO_TEXTO") || campoMostrar.getClase().equals("COMBO") || campoMostrar.getClase().equals("RADIO")) {
                if(cont > 0) {
                    datosVerificados += ",\n";
                }
                datosVerificados += "{\n";
                datosVerificados += "\"CAMPO\" : \"" + campoMostrar.getNombreCampo() + "\"";
                /* AQUÍ DEBEMOS COLOCAR LOS DATOS A MOSTRAR */
                int contadorValidos = 0;
                for(String dato : campoMostrar.getDatosRecopilados()) {
                    if(posicionesDatosValidos.contains(contadorValidos)) {
                        datosVerificados += ",\n";
                        datosVerificados += "\"DATO\" : \"" + dato + "\"";
                    }
                    contadorValidos++;
                }
                datosVerificados += "\n}\n";
                cont++;
            }
        }
        return datosVerificados;
    }
    
    private void setPosicionesValidas() {
        ArrayList<Componente> listaComponentes = formularioUtilizado.getListaComponentes();
        if(listaCondiciones.isEmpty()) {
            for(Componente componente : listaComponentes) {
                //Establecemos las posiciones validas que tendrá la condición
                if(componente.getId().equals(camposMostrar.get(0).getId())) {
                    for(int i = 0; i < componente.getDatosRecopilados().size(); i++) {
                        posicionesDatosValidos.add(i);
                    }
                }
            }
        } else {
            ArrayList<Integer> listaAuxiliar = new ArrayList<>();
            for(int i = listaCondiciones.size()-1; i >= 0; i--) {
                for(Componente componente : listaComponentes) {
                    if(componente.getId().equals(listaCondiciones.get(i).getCampo()) || componente.getNombreCampo().equals(listaCondiciones.get(i).getCampo())) {
                        listaAuxiliar = listaCondiciones.get(i).getListaValidacion(componente);
                        for(Integer integer : listaAuxiliar) {
                            System.out.println(integer);
                        }
                    break;
                    }
                }
                if(listaCondiciones.get(i).getOperadorLogico() != null && listaCondiciones.get(i).getOperadorLogico().equals("AND")) {
                    posicionesDatosValidos = interseccion(posicionesDatosValidos, listaAuxiliar);
                } else if(listaCondiciones.get(i).getOperadorLogico() != null && listaCondiciones.get(i).getOperadorLogico().equals("OR")) {
                    posicionesDatosValidos = union(posicionesDatosValidos, listaAuxiliar);
                } else if(listaCondiciones.get(i).getOperadorLogico() == null) {
                    posicionesDatosValidos = (ArrayList<Integer>) listaAuxiliar.clone();
                }
            }
            /*
            for(Condicion condicion : listaCondiciones) {
                for(Componente componente : listaComponentes) {
                    if(componente.getId().equals(condicion.getCampo()) || componente.getNombreCampo().equals(condicion.getCampo())) {
                        listaAuxiliar = condicion.getListaValidacion(componente);
                    }
                    break;
                }
                if(condicion.getOperadorLogico() != null && condicion.getOperadorLogico().equals("AND")) {
                    System.out.println("filtro1AND");
                    posicionesDatosValidos = interseccion(posicionesDatosValidos, listaAuxiliar);
                } else if(condicion.getOperadorLogico() != null && condicion.getOperadorLogico().equals("OR")) {
                    System.out.println("filtro1OR");
                    posicionesDatosValidos = union(posicionesDatosValidos, listaAuxiliar);
                } else if(condicion.getOperadorLogico() == null) {
                    System.out.println("filtro1NULL");
                    posicionesDatosValidos = (ArrayList<Integer>) listaAuxiliar.clone();
                }
            }
            */
        }
    }
    
    /**
     * Método que sirve para ejecutar la condición "OR"
     * @param lista1 Lista Principal
     * @param lista2 Lista Auxiliar
     * @return  Unión de las listas
     */
    private ArrayList<Integer> union(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        //Set que nos sirve para encontrar la unión de las dos listas
        Set<Integer> setUnion = new HashSet<>();
        setUnion.addAll(lista1);
        setUnion.addAll(lista2);
        
        ArrayList<Integer> aux = new ArrayList<Integer>(setUnion);
        
        Set<Integer> setEliminacionRepetidos = new HashSet<Integer>(aux);
        aux.clear();
        aux.addAll(setEliminacionRepetidos);
        
        return aux;
    }
    
    /**
     * Método que sirve para ejecutar la condición "AND"
     * @param lista1 Lista Principal
     * @param lista2 Lista Auxiliar
     * @return Unión de las listas
     */
    private ArrayList<Integer> interseccion(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> aux = new ArrayList<>();
        for(Integer poscion : lista1) {
            if(lista2.contains(poscion)) {
                aux.add(poscion);
            }
        }
        return aux;
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
