package com.froi.formulariosweb.analizadores.db;

import java_cup.runtime.*;
import static com.froi.formulariosweb.analizadores.db.ParserGuardadoSym.*;


%%

%public
%class GuardadoLexer
%cup
%unicode
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
ALLCHARACTERS = [\42] ([\40-\41] | [\43-\255] | [^"\""])* [\42]

%%

<YYINITIAL> {

    ","                                         { return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }
    "{"                                         { return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                                         { return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    "("                                         { return new Symbol(PARENT_A, yyline+1, yycolumn+1, yytext()); }
    ")"                                         { return new Symbol(PARENT_C, yyline+1, yycolumn+1, yytext()); }
    ":"                                         { return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    "db.formularios"                            { return new Symbol(DB_FORMULARIOS, yyline+1, yycolumn+1, yytext()); }
    "db.usuarios"                               { return new Symbol(DB_USUARIOS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO"{WS}*"\""                 { return new Symbol(USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"PASSWORD"{WS}*"\""                { return new Symbol(PASSWORD, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ID_FORMULARIO"{WS}*"\""           { return new Symbol(ID_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
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
    {IDCOMPONENTE}                              { return new Symbol(ID_COMPONENTE_N, yyline+1, yycolumn+1, yytext()); }
    {NOMBRECAMPON}                              { return new Symbol(NOMBRE_CAMPO_N, yyline+1, yycolumn+1, yytext()); }
    {REGISTRON}                                 { return new Symbol(REGISTRO_N, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}                             { return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }
    
    {Ignore}                                    {/* Ignorar */}
}

[^] {
    System.out.println("Errores : " + yytext());
}