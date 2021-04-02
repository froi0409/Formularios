package com.froi.formulariosweb.analizadores.importacion;

import com.froi.formulariosweb.entidades.Advertencia;
import java.util.ArrayList;
import java_cup.runtime.*;
import static com.froi.formulariosweb.analizadores.importacion.ParserImportacionSym.*;

%%
%public
%class ImportacionLexer
%cup
%unicode
%line
%column
%{
    private ArrayList<Advertencia> listaErrores;
    private String cadenaLexica = "";

    public ImportacionLexer(java.io.Reader in, ArrayList<Advertencia> listaErrores) {
        this.zzReader = in;
        this.listaErrores = listaErrores;
    }
    public void agregarError(int linea, int columna) {
        if(cadenaLexica.length() > 0) {
            int column = columna - cadenaLexica.length();
            listaErrores.add(new Advertencia(cadenaLexica, linea, column, "Léxico", "Simbolo no reconocido por la gramática"));
            cadenaLexica = "";
        }
    }

%}
%eof{
    agregarError(yyline, yycolumn);
%eof}
TerminacionLinea = [\r|\n|\r\n]
WS = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]
IDCOMPONENTEN = "\""{WS}*"ID_COMPONENTE_" [0-9]+ {WS}* "\""
IDENTIFICA = [\"] ("$" | "_" | "-") ( [a-zA-Z] | [0-9] | "$" | "_" | "-")* [\"]
NUMERO = [\"][1-9][0-9]*[\"]
TEMA = ("Dark" | "White")
AÑO = [2-9][0-9][0-9][0-9]
MESESA = ( 0?[1-9] | [1][0-9] | [2][0-9] | [3][0-1] )
MESESB = ( 0?[1-9] | [1][0-9] | [2][0-9] | [3][0] )
MESESC = ( 0?[1-9] | [1][0-9] | [2][0-8] )
COMPLEMENTOA = ( (0?1)|(0?3)|(0?5)|(0?7)|(0?8)|(10)|(12) ) [-] {MESESA}
COMPLEMENTOB = ( (0?4)|(0?6)|(0?9)|(11) ) [-] {MESESB}
COMPLEMENTOC = (0?2) [-] {MESESC}
FECHA = [\"] {AÑO} [-] ( {COMPLEMENTOA} | {COMPLEMENTOB} | {COMPLEMENTOC} ) [\"] 
ALLCHARACTERS = [\42] ([\0-\41] | [\43-\173] | [\175-\255] | [^"\"" "|"] | ("\’" | "\'"))* [\42]
ALLCHARACTERSNOSPACE = [\"]  [^' ' "\"" "|"]+ [\"]
OPTIONS = [\"] ([a-zA-Z0-9] | {WS} | [^"\"" "|"])+ ("|" ([a-zA-Z0-9] | {WS} | [^"\"" "|"])+)+ [\"]

%%

<YYINITIAL> {

    "("                                         { agregarError(yyline+1,yycolumn+1); return new Symbol(PARENT_A, yyline+1, yycolumn+1, yytext()); }
    ")"                                         { agregarError(yyline+1,yycolumn+1); return new Symbol(PARENT_C, yyline+1, yycolumn+1, yytext()); }
    "{"                                         { agregarError(yyline+1,yycolumn+1); return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                                         { agregarError(yyline+1,yycolumn+1); return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    ":"                                         { agregarError(yyline+1,yycolumn+1); return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    ","                                         { agregarError(yyline+1,yycolumn+1); return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }

    "new.formulario"                            { agregarError(yyline+1,yycolumn+1); return new Symbol(NEW_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ID_FORMULARIO"{WS}*"\""           { agregarError(yyline+1,yycolumn+1); return new Symbol(ID_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TITULO"{WS}*"\""                  { agregarError(yyline+1,yycolumn+1); return new Symbol(TITULO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE"{WS}*"\""                  { agregarError(yyline+1,yycolumn+1); return new Symbol(NOMBRE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEMA"{WS}*"\""                    { agregarError(yyline+1,yycolumn+1); return new Symbol(TEMA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FECHA_CREACION"{WS}*"\""          { agregarError(yyline+1,yycolumn+1); return new Symbol(FECHA_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_CREACION"{WS}*"\""        { agregarError(yyline+1,yycolumn+1); return new Symbol(USUARIO_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ESTRUCTURA"{WS}*"\""              { agregarError(yyline+1,yycolumn+1); return new Symbol(ESTRUCTURA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INDICE"{WS}*"\""                  { agregarError(yyline+1,yycolumn+1); return new Symbol(INDICE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FORMULARIO"{WS}*"\""              { agregarError(yyline+1,yycolumn+1); return new Symbol(FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CLASE"{WS}*"\""                   { agregarError(yyline+1,yycolumn+1); return new Symbol(CLASE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"REQUERIDO"{WS}*"\""               { agregarError(yyline+1,yycolumn+1); return new Symbol(REQUERIDO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ALINEACION"{WS}*"\""              { agregarError(yyline+1,yycolumn+1); return new Symbol(ALINEACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE_CAMPO"{WS}*"\""            { agregarError(yyline+1,yycolumn+1); return new Symbol(NOMBRE_CAMPO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEXTO_VISIBLE"{WS}*"\""           { agregarError(yyline+1,yycolumn+1); return new Symbol(TEXTO_VISIBLE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"OPCIONES"{WS}*"\""                { agregarError(yyline+1,yycolumn+1); return new Symbol(OPCIONES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FILAS"{WS}*"\""                   { agregarError(yyline+1,yycolumn+1); return new Symbol(FILAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COLUMNAS"{WS}*"\""                { agregarError(yyline+1,yycolumn+1); return new Symbol(COLUMNAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"URL"{WS}*"\""                     { agregarError(yyline+1,yycolumn+1); return new Symbol(URL, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"Dark"{WS}*"\""                    { agregarError(yyline+1,yycolumn+1); return new Symbol(DARK, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"White"{WS}*"\""                   { agregarError(yyline+1,yycolumn+1); return new Symbol(WHITE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"SI"{WS}*"\""                      { agregarError(yyline+1,yycolumn+1); return new Symbol(SI, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NO"{WS}*"\""                      { agregarError(yyline+1,yycolumn+1); return new Symbol(NO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CENTRO"{WS}*"\""                  { agregarError(yyline+1,yycolumn+1); return new Symbol(CENTRO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IZQUIERDA"{WS}*"\""               { agregarError(yyline+1,yycolumn+1); return new Symbol(IZQUIERDA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DERECHA"{WS}*"\""                 { agregarError(yyline+1,yycolumn+1); return new Symbol(DERECHA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"JUSTIFICAR"{WS}*"\""              { agregarError(yyline+1,yycolumn+1); return new Symbol(JUSTIFICAR, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CAMPO_TEXTO"{WS}*"\""             { agregarError(yyline+1,yycolumn+1); return new Symbol(CAMPO_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"AREA_TEXTO"{WS}*"\""              { agregarError(yyline+1,yycolumn+1); return new Symbol(AREA_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CHECKBOX"{WS}*"\""                { agregarError(yyline+1,yycolumn+1); return new Symbol(CHECKBOX, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"RADIO"{WS}*"\""                   { agregarError(yyline+1,yycolumn+1); return new Symbol(RADIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FICHERO"{WS}*"\""                 { agregarError(yyline+1,yycolumn+1); return new Symbol(FICHERO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IMAGEN"{WS}*"\""                  { agregarError(yyline+1,yycolumn+1); return new Symbol(IMAGEN, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COMBO"{WS}*"\""                   { agregarError(yyline+1,yycolumn+1); return new Symbol(COMBO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"BOTON"{WS}*"\""                   { agregarError(yyline+1,yycolumn+1); return new Symbol(BOTON, yyline+1, yycolumn+1, yytext()); }


    {IDCOMPONENTEN}                             { agregarError(yyline+1,yycolumn+1); return new Symbol(ID_COMPONENTE_N, yyline+1, yycolumn+1, yytext()); }
    {IDENTIFICA}                                { agregarError(yyline+1,yycolumn+1); return new Symbol(IDENTIFICADOR, yyline+1, yycolumn+1, yytext()); }
    {NUMERO}                                    { agregarError(yyline+1,yycolumn+1); return new Symbol(NUMERO, yyline+1, yycolumn+1, yytext()); }
    {FECHA}                                     { agregarError(yyline+1,yycolumn+1); return new Symbol(FECHA, yyline+1, yycolumn+1, yytext()); }
    {OPTIONS}                                   { agregarError(yyline+1,yycolumn+1); return new Symbol(OPTIONS, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERSNOSPACE}                      { agregarError(yyline+1,yycolumn+1); return new Symbol(ALLCHARACTERSNOSPACE, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}                             { agregarError(yyline+1,yycolumn+1); return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }

    {Ignore}                                    { agregarError(yyline+1,yycolumn+1); /*Ignorar*/}

}
[^] {
    System.out.println("Error en linea: " + yyline+1 + " - Columna: " + yycolumn+1 + ". La expresión: " + yytext() + " no forma parte del lenguaje");
    cadenaLexica += yytext();
}
