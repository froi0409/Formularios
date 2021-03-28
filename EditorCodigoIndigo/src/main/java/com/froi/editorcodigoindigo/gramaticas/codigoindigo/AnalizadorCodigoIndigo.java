/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.editorcodigoindigo.gramaticas.codigoindigo;

import com.froi.editorcodigoindigo.analizadorrespuesta.ParserRespuestas;
import com.froi.editorcodigoindigo.analizadorrespuesta.RespuestasLexer;
import com.froi.editorcodigoindigo.entidades.Advertencia;
import com.froi.editorcodigoindigo.servidor.Canal;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author froi-pc
 */
public class AnalizadorCodigoIndigo {
    
    private String entrada;
    private ArrayList<Advertencia> listaErrores;
    private ArrayList<String> listaRespuestas;
    
    public AnalizadorCodigoIndigo(String entrada) {
        this.entrada = entrada;
        listaErrores = new ArrayList<>();
        this.listaRespuestas = new ArrayList<>();
    }
    
    /**
     * Método que nos sirve para enviar el codigo índigo al servidor y recibir la respuesta del mismo
     * @param salida JTextArea en el que se imprimirá la salida del análisis de la respuesta
     */
    public void analizar(JTextArea salida) {
        salida.setText("");
        salida.append("----------Enviando Solicitudes al servidor----------" + "\n");
        Canal canal = new Canal();
        String respuesta = canal.repuesta(entrada);
        
        StringReader reader = new StringReader(respuesta);
        RespuestasLexer respuestasLexer = new RespuestasLexer(reader);
        ParserRespuestas parserRespuestas = new ParserRespuestas(respuestasLexer, listaRespuestas, listaErrores);
        try {
            parserRespuestas.parse();
            salida.append("----------Conexión con el servidor establecida----------" + "\n" );
            for(String element : listaRespuestas) {
                salida.append(element + "\n\n");
            }
        } catch (Exception e) {
            salida.append("\n\n......Ha ocurrido un error al leer la respuesta del servidor: " + e.getMessage() + "......");
        }
    }
    
}
