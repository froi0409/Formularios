/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.analizadores.codigoindigo;

import com.froi.formulariosweb.analizadores.db.GuardadoLexer;
import com.froi.formulariosweb.analizadores.db.ParserGuardado;
import com.froi.formulariosweb.entidades.Advertencia;
import com.froi.formulariosweb.entidades.Instruccion;
import com.froi.formulariosweb.entidadesfundamentales.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author froi-pc
 */
public class AnalizadorEntrada {
    private ArrayList<Advertencia> listaErrores;
    private ArrayList<Instruccion> listaInstrucciones;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Formulario> listaFormularios;
    private String entrada;
    private String rutaUsuarios;
    private String rutaFormularios;
    
    /**
     * Inicializa la clase, guarda la información necesaria para llevar a cabo el análisis
     * @param entrada Código índigo que se analizará
     */
    public AnalizadorEntrada(String entrada) {
        this.listaErrores = new ArrayList<>();
        this.listaInstrucciones = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaFormularios = new ArrayList<>();
        this.entrada = entrada;
        this.rutaUsuarios = "/home/froi-pc/Documentos/CUNOC/Quinto Semestre/Compiladores 1/Proyectos/Formularios/FormulariosWeb/src/main/java/Resources/dbUsuarios.txt";
        this.rutaFormularios = "/home/froi-pc/Documentos/CUNOC/Quinto Semestre/Compiladores 1/Proyectos/Formularios/FormulariosWeb/src/main/java/Resources/dbFormularios.txt";
    }
    
    /**
     * Método que sirve para analizar el código índigo que el cliente enviará desde la aplicación cliente
     * @return Código índigo que contiene el formato de respuestas que el cliente analizará
     */
    public String codificar() {
        String codigo = "";
        
        ArrayList<String> codigoUsuarios = new ArrayList<>();
        ArrayList<String> codigoFormularios = new ArrayList<>();
        analisisDatosExistentes(codigoUsuarios, codigoFormularios); //Verificamos los datos almacenados
        
        StringReader reader = new StringReader(entrada);
        SolicitudesLexer lexer = new SolicitudesLexer(reader);
        ParserSolicitudes parser = new ParserSolicitudes(lexer, listaErrores, listaInstrucciones);
        try {
            parser.parse();
            
            if(listaErrores.isEmpty()) {
                codigo += "<!ini_respuestas>\n";
                for(Instruccion element : listaInstrucciones) {
                    codigo += element.analizar(listaUsuarios, listaFormularios, codigoUsuarios, codigoFormularios);
                }
                codigo += "<!fin_respuestas>";
                guardarUsuarios(codigoUsuarios);
            }
            
        } catch (Exception e) {
            System.out.println("Error CI: " + e.getMessage());
        }
        return codigo;
    }
    
    private void analisisDatosExistentes(ArrayList<String> codigoUsuarios, ArrayList<String> codigoFormularios) {
        File dbUsuarios = new File(rutaUsuarios);
        File dbFormularios = new File(rutaFormularios);
        if(dbUsuarios.exists()) {
            try {
                String lectura, userCode = "";
                FileReader fr = new FileReader(dbUsuarios);
                BufferedReader reader = new BufferedReader(fr);
                System.out.println("\n\n");
                while((lectura = reader.readLine()) != null) {
                    userCode += lectura + "\n";
                }
                System.out.println("\n\n");
                System.out.println(userCode);
                StringReader readerGuardado = new StringReader(userCode);
                GuardadoLexer lexerGuardado = new GuardadoLexer(readerGuardado);
                ParserGuardado parserGuardado = new ParserGuardado(lexerGuardado, listaUsuarios, listaFormularios);
                
                parserGuardado.parse();
                
            } catch (Exception e) {
                System.out.println("Error en la lectura del archivo db de usuarios: " + e.getMessage());
            }

        } else {
            System.out.println("No existe archivo que contenga los usuarios");
        }
        
        if(dbFormularios.exists()) {
            System.out.println("SE HA ENCONTRADO EL ARCHIVO dbFormularios");
        } else {
            System.out.println("No existe archivo que contenga los formlarios");
        }
    }
    
    private void guardarUsuarios(ArrayList<String> codigoUsuarios) {
        String codigo = "";
        int contador = 0;
        codigo += "db.usuarios (\n";
        for(String element : codigoUsuarios) {
            if(contador > 0) {
                codigo += ",\n";
            }
            codigo += element;
            contador++;
        }
        for(Usuario element: listaUsuarios) {
            if(contador > 0) {
                codigo += ",\n";
            }
            codigo += "{\n" +
                      "\"USUARIO\" : \"" + element.getUsuario() + "\",\n" +
                      "\"PASSWORD\" : \"" + element.getPassword() + "\",\n" +
                      "\"FECHA_CREACION\" : \"" + element.getFechaCreacion() + "\"\n" +
                      "}\n";
            contador++;
        }
        codigo += ")";
        try {
            FileWriter fw = new FileWriter(new File(rutaUsuarios));
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(codigo);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error en la ruta del archivo de usuarios: " + e.getMessage());
        }
        
        
        
    }
    
}
