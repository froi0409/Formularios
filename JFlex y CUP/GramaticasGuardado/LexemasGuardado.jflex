package com.froi.formulariosweb.analizadores.db;

import java_cup.runtime.*;
import static com.froi.formulariosweb.analizadores.db.ParserGuardadoSym.*;


%%

%public
%class GuardadoLexer
%cup
//%unicode
%line
%column

%{

%}

TerminacionLinea = [\r|\n|\r\n]
WS = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]

IDCOMPONENTE = "\""{WS}*"ID_COMPONENTE_" [0-9]+ {WS}* "\""
NOMBRECAMPON = "\""{WS}*"NOMBRE_CAMPO_" [0-9]+ {WS}* "\""
REGISTRON = "\""{WS}*"REGISTRO_" [0-9]+ {WS}* "\""
ALLCHARACTERS = [\42] ([\40-\41] | [\43-\255])* [\42]

%%

<YYINITIAL> {

    ","                                         { System.out.println("COMA: " + yytext()); return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }
    "{"                                         { System.out.println("LLAVE_A: " + yytext()); return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                                         { System.out.println("LLAVE_C: " + yytext()); return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    "("                                         { System.out.println("PARENT_A: " + yytext()); return new Symbol(PARENT_A, yyline+1, yycolumn+1, yytext()); }
    ")"                                         { System.out.println("PARENT_C: " + yytext()); return new Symbol(PARENT_C, yyline+1, yycolumn+1, yytext()); }
    ":"                                         { System.out.println("PUNTOS: " + yytext()); return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    "db.formularios"                            { System.out.println("DB_FORMULARIOS: " + yytext()); return new Symbol(DB_FORMULARIOS, yyline+1, yycolumn+1, yytext()); }
    "db.usuarios"                               { System.out.println("DB_USUARIOS: " + yytext()); return new Symbol(DB_USUARIOS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO"{WS}*"\""                 { System.out.println("USUARIO: " + yytext()); return new Symbol(USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"PASSWORD"{WS}*"\""                { System.out.println("PASSWORD: " + yytext()); return new Symbol(PASSWORD, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ID_FORMULARO"{WS}*"\""            { System.out.println("ID_FORMULARIO: " + yytext()); return new Symbol(ID_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TITULO"{WS}*"\""                  { System.out.println("TITULO: " + yytext()); return new Symbol(TITULO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE"{WS}*"\""                  { System.out.println("NOMBRE: " + yytext()); return new Symbol(NOMBRE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEMA"{WS}*"\""                    { System.out.println("TEMA: " + yytext()); return new Symbol(TEMA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_CREACION"{WS}*"\""        { System.out.println("USUARIOCREACION: " + yytext()); return new Symbol(USUARIO_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FECHA_CREACION"{WS}*"\""          { System.out.println("FECHACREACION: " + yytext()); return new Symbol(FECHA_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ESTRUCTURA"{WS}*"\""              { System.out.println("ESTRUCTURA: " + yytext()); return new Symbol(ESTRUCTURA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DATOS_RECOPILADOS"{WS}*"\""       { System.out.println("DATOSRECOPILADOS: " + yytext()); return new Symbol(DATOS_RECOPILADOS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ID"{WS}*"\""                      { System.out.println("ID: " + yytext()); return new Symbol(ID, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE_CAMPO"{WS}*"\""            { System.out.println("NOMBRECAMPO: " + yytext()); return new Symbol(NOMBRE_CAMPO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FORMULARIO"{WS}*"\""              { System.out.println("FORMULARIO: " + yytext()); return new Symbol(FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CLASE"{WS}*"\""                   { System.out.println("CLASE: " + yytext()); return new Symbol(CLASE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INDICE"{WS}*"\""                  { System.out.println("INDICE: " + yytext()); return new Symbol(INDICE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEXTO_VISIBLE"{WS}*"\""           { System.out.println("TEXTOVISIBLE: " + yytext()); return new Symbol(TEXTO_VISIBLE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ALINEACION"{WS}*"\""              { System.out.println("ALINEACION: " + yytext()); return new Symbol(ALINEACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"REQUERIDO"{WS}*"\""               { System.out.println("REQUERIDO: " + yytext()); return new Symbol(REQUERIDO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"OPCIONES"{WS}*"\""                { System.out.println("OPCIONES: " + yytext()); return new Symbol(OPCIONES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FILAS"{WS}*"\""                   { System.out.println("FILAS: " + yytext()); return new Symbol(FILAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COLUMNAS"{WS}*"\""                { System.out.println("COLUMNAS: " + yytext()); return new Symbol(COLUMNAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"URL"{WS}*"\""                     { System.out.println("URL: " + yytext()); return new Symbol(URL, yyline+1, yycolumn+1, yytext()); }
    {IDCOMPONENTE}                              { System.out.println("IDCOMPONENTE: " + yytext()); return new Symbol(ID_COMPONENTE_N, yyline+1, yycolumn+1, yytext()); }
    {NOMBRECAMPON}                              { System.out.println("NOMBRECAMPON: " + yytext()); return new Symbol(NOMBRE_CAMPO_N, yyline+1, yycolumn+1, yytext()); }
    {REGISTRON}                                 { System.out.println("REGISTRON: " + yytext()); return new Symbol(REGISTRO_N, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}                             { System.out.println("ALLCHAR: " + yytext()); return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }
    
    {Ignore}                                    {/* Ignorar */}
}

[^] {
    System.out.println("Errores : " + yytext());
}