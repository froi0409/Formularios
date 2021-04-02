/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.analizadores.importacion;

import com.froi.formulariosweb.analizadores.codigoindigo.AnalizadorEntrada;
import com.froi.formulariosweb.entidades.Advertencia;
import com.froi.formulariosweb.entidades.Instruccion;
import com.froi.formulariosweb.entidadesfundamentales.Componente;
import com.froi.formulariosweb.entidadesfundamentales.Formulario;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author froi-pc
 */
public class AnalizadorEntradaImportacion {
    private ArrayList<Advertencia> listaErrores;
    private ArrayList<Formulario> listaFormularios;
    private String entrada;
    private String userOnline;
    
    public AnalizadorEntradaImportacion(String entrada, String userOnline) {
        this.entrada = entrada;
        this.listaFormularios = new ArrayList<>();
        this.listaErrores = new ArrayList<>();
        this.userOnline = userOnline;
    }
    
    public String analizar() {
        if(userOnline.equals("")) {
            Instruccion instruccion = new Instruccion();
            String codigoConflicto = "<!ini_respuestas>\n";
            codigoConflicto += instruccion.generarCodigoRespuesta("Importacion de Formulario", "Para importar un formulario, primero inicie sesión");
            codigoConflicto += "<!fin_respuestas>";
            return codigoConflicto;
        }
        String codigo = "";
        StringReader reader = new StringReader(entrada);
        ImportacionLexer importacionLexer = new ImportacionLexer(reader);
        ParserImportacion parserImportacion = new ParserImportacion(importacionLexer, listaFormularios, listaErrores);
        try {
            parserImportacion.parse();
            codigo += "<!ini_respuestas>\n";
            if(listaErrores.isEmpty()) {
                AnalizadorEntrada analizadorExistencias = new AnalizadorEntrada(null, null);
                analizadorExistencias.analisisDatosExistentes();
                ArrayList<Formulario> formulariosExistentes = analizadorExistencias.getListaFormularios();
                //Analizamos los formularios que han sido cargados en la importacion
                System.out.println("Cantidad de formularios detectados: " + listaFormularios.size());
                System.out.println("Cantidad de formularios en el sistema: " + formulariosExistentes.size());
                for(Formulario formulario : listaFormularios) {
                    boolean comprobador = true;
                    formulario.setUsuarioCreacion(userOnline);
                    Instruccion instruccion = new Instruccion();
                    for(Formulario formularioAuxiliar : formulariosExistentes) {
                        if(formulario.getIdentificador().equals(formularioAuxiliar.getIdentificador())) {
                            codigo += instruccion.generarCodigoRespuesta("Importacion de Formulario", "Ya existe un formulario con id " + formulario.getIdentificador());
                            comprobador = false;
                            break;
                        } else if(formulario.getNombre().equals(formularioAuxiliar.getNombre())) {
                            codigo += instruccion.generarCodigoRespuesta("Importacion de Formulario", "Ya existe un formulario con el nombre: " + formulario.getNombre());
                            comprobador = false;
                            break;
                        }
                    }
                    ArrayList<String> ids = new ArrayList<>();
                    //Almacenamos los id de los componentes que posee, para verificar que no haya alguno repetido
                    for(Componente componente : formulario.getListaComponentes()) {
                        ids.add(componente.getId());
                    }
                    Set<String> datosSinDuplicar = new HashSet<String>(ids);
                    String descripcion = "No se puede generar el formulario, porque ";
                    for(String datoRevisado : datosSinDuplicar) {
                        int repeticion = Collections.frequency(ids, datoRevisado);
                        if(repeticion > 1) {
                            descripcion += "El id " + datoRevisado + " se repite " + repeticion + " veces. ";
                            comprobador = false;
                        }
                    }
                    if(comprobador) {
                        System.out.println("CANTIDAD DE COMPONENTES: " + formulario.getListaComponentes().size());
                        formulariosExistentes.add(formulario);
                        codigo += instruccion.generarCodigoRespuesta("Importacion de Formulario ", "El formulario " + formulario.getIdentificador() + " ha sido importado con éxito");
                    } else {
                        codigo += instruccion.generarCodigoRespuesta("Importacion de Formulario", descripcion);
                    }
                }
                analizadorExistencias.guardarFormularios();
            } else {
                for(Advertencia element: listaErrores) {
                    codigo += "<!ini_respuesta:\"ERROR_DETECTADO\">\n" +
                              "{ \"DESCRIPCION_ERROR\" : [{\n";
                    codigo += "\"DESCRIPCION\" : \"" + element + "\"\n";
                    codigo += "}\n" +
                              "]\n" +
                              "}\n" +
                              "<!fin_respuesta>\n";
                }
            }
            codigo += "<!fin_respuestas>\n";
        } catch (Exception e) {
            System.out.println("Error AnalizadorEntradaImportacion: " + e.getMessage());
        }
        return codigo;
    }
    
}
