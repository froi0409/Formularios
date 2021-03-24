package com.froi.formulariosweb.analizadores.db;

import static com.froi.formulariosweb.analizadores.db.ParserGuardadoSym.*;
import java_cup.runtime.*;

%%
%public
%class GuardadoLexer
%cup
//%unicode
%line
%column

TerminacionLinea = [\r|\n|\r\n]
WS = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]

IDCOMPONENTE = "\""{WS}*"ID_COMPONENTE_" [0-9]+ {WS}* "\""
NOMBRECAMPON = "\""{WS}*"NOMBRE_CAMPO_" [0-9]+ {WS}* "\""
REGISTRON = "\""{WS}*"REGISTRO_" [0-9]+ {WS}* "\""
ALLCHARACTERS = [\42] ([\40-\41] | [\43-\255])* [\42]

%%

<YYINITIAL> {

    ","                                         { return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }
    "{"                                         { return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                                         { return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    "("                                         { return new Symbol(PARENT_A, yyline+1, yycolumn+1, yytext()); }
    ")"                                         { return new Symbol(PARENT_C, yyline+1, yycolumn+1, yytext()); }
    ":"                                         { return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    "db.formularios"                            { return new Symbol(DB_FORMULARIOS, yyline+1, yycolumn+1, yytext()); }
    "db.usuarios"                               { System.out.println("dbusuarios: " + yytext()); return new Symbol(DB_USUARIOS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO"{WS}*"\""                 { return new Symbol(USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"PASSWORD"{WS}*"\""                { return new Symbol(PASSWORD, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ID_FORMULARO"{WS}*"\""            { return new Symbol(ID_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TITULO"{WS}*"\""                  { return new Symbol(TITULO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE"{WS}*"\""                  { return new Symbol(NOMBRE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEMA"{WS}*"\""                    { return new Symbol(TEMA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_CREACION"{WS}*"\""        { return new Symbol(USUARIO_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FECHA_CREACION"{WS}*"\""          { return new Symbol(FECHA_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ESTRUCTURA"{WS}*"\""              { return new Symbol(ESTRUCTURA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DATOS_RECOPILADOS"{WS}*"\""       { return new Symbol(DATOS_RECOPILADOS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ID"{WS}*"\""                      { return new Symbol(ID, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE_CAMPO"{WS}*"\""            { return new Symbol(NOMBRE_CAMPO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FORMULARIO"{WS}*"\""              { return new Symbol(FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CLASE"{WS}*"\""                   { return new Symbol(CLASE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INDICE"{WS}*"\""                  { return new Symbol(INDICE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEXTO_VISIBLE"{WS}*"\""           { return new Symbol(TEXTO_VISIBLE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ALINEACION"{WS}*"\""              { return new Symbol(ALINEACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"REQUERIDO"{WS}*"\""               { return new Symbol(REQUERIDO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"OPCIONES"{WS}*"\""                { return new Symbol(OPCIONES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FILAS"{WS}*"\""                   { return new Symbol(FILAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COLUMNAS"{WS}*"\""                { return new Symbol(COLUMNAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"URL"{WS}*"\""                     { return new Symbol(URL, yyline+1, yycolumn+1, yytext()); }
    /*"\""{WS}*"CAMPO_TEXTO"{WS}*"\""             { return new Symbol(CAMPO_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"AREA_TEXTO"{WS}*"\""              { return new Symbol(AREA_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CHECKBOX"{WS}*"\""                { return new Symbol(CHECKBOX, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"RADIO"{WS}*"\""                   { return new Symbol(RADIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FICHERO"{WS}*"\""                 { return new Symbol(FICHERO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IMAGEN"{WS}*"\""                  { return new Symbol(IMAGEN, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COMBO"{WS}*"\""                   { return new Symbol(COMBO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"BOTON"{WS}*"\""                   { return new Symbol(BOTON, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"SI"{WS}*"\""                      { return new Symbol(SI, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NO"{WS}*"\""                      { return new Symbol(NO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CENTRO"{WS}*"\""                  { return new Symbol(CENTRO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IZQUIERDA"{WS}*"\""               { return new Symbol(IZQUIERDA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DERECHA"{WS}*"\""                 { return new Symbol(DERECHA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"JUSTIFICAR"{WS}*"\""              { return new Symbol(JUSTIFICAR, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"Dark"{WS}*"\""                    { return new Symbol(DARK, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"White"{WS}*"\""                   { return new Symbol(WHITE, yyline+1, yycolumn+1, yytext()); }
    */
    {IDCOMPONENTE}                              { return new Symbol(ID_COMPONENTE_N, yyline+1, yycolumn+1, yytext()); }
    {NOMBRECAMPON}                              { return new Symbol(NOMBRE_CAMPO_N, yyline+1, yycolumn+1, yytext()); }
    {REGISTRON}                                 { return new Symbol(REGISTRO_N, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}                             { System.out.println("ALLCHAR: " + yytext()); return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }
    
    {Ignore}                                    {/* Ignorar */}
}

[^] {
    System.out.println("Error: " + yytext());
}