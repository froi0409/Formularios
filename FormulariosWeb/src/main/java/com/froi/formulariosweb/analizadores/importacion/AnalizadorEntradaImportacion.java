/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.analizadores.importacion;

import com.froi.formulariosweb.analizadores.codigoindigo.AnalizadorEntrada;
import com.froi.formulariosweb.entidades.Advertencia;
import com.froi.formulariosweb.entidades.Instruccion;
import com.froi.formulariosweb.entidadesfundamentales.Formulario;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class AnalizadorEntradaImportacion {
    private ArrayList<Advertencia> listaErrores;
    private ArrayList<Formulario> listaFormularios;
    private String entrada;
    
    public AnalizadorEntradaImportacion(String entrada) {
        this.entrada = entrada;
        this.listaFormularios = new ArrayList<>();
        this.listaErrores = new ArrayList<>();
    }
    
    public String analizar() {
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
                    if(comprobador) {
                        formulariosExistentes.add(formulario);
                        codigo += instruccion.generarCodigoRespuesta("Importacion de Formulario ", "El formulario " + formulario.getIdentificador() + " ha sido importado con éxito");
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
