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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author froi-pc
 */
public class AnalizadorCodigoIndigo {
    
    private ArrayList<Advertencia> listaErrores;
    private ArrayList<String> listaRespuestas;
    private Canal canal;
    private String userOnline = "";
    
    public AnalizadorCodigoIndigo() {
        listaErrores = new ArrayList<>();
        this.listaRespuestas = new ArrayList<>();
        this.canal = new Canal();
    }
    
    /**
     * Método que nos sirve para enviar el codigo índigo al servidor y recibir la respuesta del mismo
     * @param entrada Código que se enviará al servidor para ser analizado
     * @param salida JTextArea en el que se imprimirá la salida del análisis de la respuesta
     * @param tablaReportes JTable donde se visualizan los reportes
     * @param listaTablas ArrayList<DefaultTableModel> que contendrá las diferentes tablas que se obtengan de las consultas
     */
    public void analizar(String entrada, JTextArea salida, JTable tablaReportes, ArrayList<DefaultTableModel> listaTablas) {
        listaErrores.clear();
        listaRespuestas.clear();
        salida.setText("");
        salida.append("----------Enviando Solicitudes al servidor----------" + "\n");
        String respuesta = canal.repuesta(entrada, userOnline);
        
        StringReader reader = new StringReader(respuesta);
        RespuestasLexer respuestasLexer = new RespuestasLexer(reader);
        ParserRespuestas parserRespuestas = new ParserRespuestas(respuestasLexer, listaRespuestas, listaErrores, listaTablas, this);
        try {
            parserRespuestas.parse();
            salida.append("----------Conexión con el servidor establecida----------" + "\n" );
            for(String element : listaRespuestas) {
                salida.append(element + "\n\n");
            }
            System.out.println("USUARIO LOGGEADO: " + userOnline);
        } catch (Exception e) {
            salida.append("\n\n......Ha ocurrido un error al leer la respuesta del servidor: " + e.getMessage() + "......");
        }
    }

    public String getUserOnline() {
        return userOnline;
    }

    public void setUserOnline(String userOnline) {
        this.userOnline = userOnline;
    }
    
    
    
}
