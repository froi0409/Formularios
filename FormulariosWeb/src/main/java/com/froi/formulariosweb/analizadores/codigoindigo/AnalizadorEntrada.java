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
    private String userOnline;
    
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
        this.rutaUsuarios = "Recursos/dbUsuarios.txt";
        this.rutaFormularios = "Recursos/dbFormularios.txt";
    }
    
    /**
     * Método que sirve para analizar el código índigo que el cliente enviará desde la aplicación cliente
     * @return Código índigo que contiene el formato de respuestas que el cliente analizará
     */
    public String codificar() {
        String codigo = "";

        analisisDatosExistentes(); //Verificamos los datos almacenados
        
        StringReader reader = new StringReader(entrada);
        SolicitudesLexer lexer = new SolicitudesLexer(reader);
        ParserSolicitudes parser = new ParserSolicitudes(lexer, listaErrores, listaInstrucciones);
        try {
            parser.parse();
            
            if(listaErrores.isEmpty()) {
                codigo += "<!ini_respuestas>\n";
                for(Instruccion element : listaInstrucciones) {
                    codigo += element.analizar(listaUsuarios, listaFormularios, userOnline);
                }
                codigo += "<!fin_respuestas>";
                guardarUsuarios();
                guardarFormularios();
            } else {
                System.out.println("\n\n\nERRORES: ");
                for(Advertencia element: listaErrores) {
                    System.out.println(element);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error CI: " + e.getMessage());
        }
        return codigo;
    }
    
    /**
     * Sirve para analizar los datos que hay guardados en el sistema
     */
    public void analisisDatosExistentes() {
        File dbUsuarios = new File(rutaUsuarios);
        File dbFormularios = new File(rutaFormularios);
        if(dbUsuarios.exists()) {
            try {
                //Leemos el archivo dbUsuarios
                String lectura, userCode = "";
                FileReader fr = new FileReader(dbUsuarios);
                BufferedReader readerArch = new BufferedReader(fr);
                System.out.println("\n\n");
                while((lectura = readerArch.readLine()) != null) {
                    userCode += lectura + "\n";
                }
                readerArch.close();
                
                //Inicializamos los analizadores
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
            try {
                String lectura, userCode = "";
                FileReader fr = new FileReader(dbFormularios);
                BufferedReader readerArch = new BufferedReader(fr);
                System.out.println("\n\n");
                while((lectura = readerArch.readLine()) != null) {
                    userCode += lectura + "\n";
                }
                readerArch.close();
                
                //Inicializamos los analizadores
                StringReader readerGuardado = new StringReader(userCode);
                GuardadoLexer lexerGuardado = new GuardadoLexer(readerGuardado);
                ParserGuardado parserGuardado = new ParserGuardado(lexerGuardado, listaUsuarios, listaFormularios);
                
                parserGuardado.parse();
                
            } catch (Exception e) {
                System.out.println("Error en la lectura del archivo dbFormularios: " + e.getMessage());
            }
                
        } else {
            System.out.println("No existe archivo que contenga los formlarios");
        }
    }
    
    /**
     * Guarda a todos los ususarios encontrados
     */
    public void guardarUsuarios() {
        String codigo = "";
        int contador = 0;
        codigo += "db.usuarios (\n";

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
    
    /**
     * Guarda todos los formularios encontrados
     */
    public void guardarFormularios() {
        String codigo = "";
        int contador = 0, datosRecopilados = 0;
        codigo += "db.formularios (\n";
        for(Formulario element : listaFormularios) {
            if(contador > 0) {
                codigo += ",\n";
            }
            codigo += "{\n";
            codigo += "\"ID_FORMULARIO\" : \"" + element.getIdentificador() + "\",\n";
            codigo += "\"TITULO\" : \"" + element.getTitulo() + "\",\n";
            codigo += "\"NOMBRE\" : \"" + element.getNombre() + "\",\n";
            codigo += "\"TEMA\" : \"" + element.getTema() + "\",\n";
            codigo += "\"USUARIO_CREACION\" : \"" + element.getUsuarioCreacion() + "\",\n";
            codigo += "\"FECHA_CREACION\" : \"" + element.getFechaCreacion() + "\"";
            if(!element.getListaComponentes().isEmpty()) {
                codigo += ",\n";
                codigo += "\"ESTRUCTURA\" : (\n";              
                int indice = 1;
                for(Componente elem : element.getListaComponentes()) {
                    if(indice > 1) {
                        codigo += ",\n";
                    }
                    codigo += "{\n";
                    codigo += "\"ID_COMPONENTE_" + indice + "\" : \"" + elem.getId() + "\",\n";
                    codigo += "\"INDICE\" : \"" + indice + "\",\n";
                    codigo += "\"FORMULARIO\" : \"" + elem.getFormulario() + "\",\n";
                    codigo += "\"CLASE\" : \"" + elem.getClase() + "\",\n";
                    codigo += "\"TEXTO_VISIBLE\" : \"" + elem.getTextoVisible() + "\",\n";
                    codigo += "\"REQUERIDO\" : \"" + elem.getRequerido() + "\",\n";
                    codigo += "\"ALINEACION\" : \"" + elem.getAlineacion() + "\",\n";
                    if (elem.getClase().equals("AREA_TEXTO")) {
                        codigo += "\"FILAS\" : \"" + elem.getFilas() + "\",\n";
                        codigo += "\"COLUMNAS\" : \"" + elem.getColumnas() + "\",\n";
                    } else if (elem.getClase().equals("CHECKBOX") || elem.getClase().equals("RADIO") || elem.getClase().equals("COMBO")) {
                        codigo += "\"OPCIONES\" : \"" + elem.getOpciones() + "\",\n";
                    } else if(elem.getClase().equals("IMAGEN")) {
                        codigo += "\"URL\" : \"" + elem.getUrl() + "\",\n";
                    }
                    if (elem.getNombreCampo() != null) {
                        codigo += "\"NOMBRE_CAMPO\" : \"" + elem.getNombreCampo() + "\",\n";
                    }
                    int registros = 0;
                    for(String dato : elem.getDatosRecopilados()) {
                        registros++;
                        codigo += "\"REGISTRO_" + registros + "\" : \"" + dato + "\",\n";
                    }
                    codigo += "}\n";
                    indice++;
                }
                codigo += ")\n";
            }
            if(datosRecopilados > 0) {
                
            }
            codigo += "\n}\n";
            contador++;
        }
        codigo += ")";
        try {
            FileWriter fw = new FileWriter(new File(rutaFormularios));
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(codigo);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error en la ruta del archivo de usuarios: " + e.getMessage());
        }
    }

    /**
     * Obtiene a los usuarios que han sido encontrados en el sistema
     * @return lista de usuarios que hay en el sistema
     */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Obtiene los formularios que han sido encontrados en el sistema
     * @return lista de formularios que hay en el sistema
     */
    public ArrayList<Formulario> getListaFormularios() {
        return listaFormularios;
    }
    
    
    
}
