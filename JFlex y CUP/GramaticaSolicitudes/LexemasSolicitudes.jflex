package com.froi.editorcodigoindigo.gramaticas.codigoindigo;

import java_cup.runtime.*;
import static com.froi.editorcodigoindigo.gramaticas.codigoindigo.ParserSolicitudesSym.*;
%%

%public
%class SolicitudesLexer
%cup
%unicode
%line
%column

//Codigo añadido
%{


%}

//Definición de expresiones regulares específicas
INISOLICITUDES = [iI][nN][iI][_][sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS]
FINSOLICITUDES = [fF][iI][nN][_][sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS]
INISOLICITUD =  [iI][nN][iI][_][sS][oO][lL][iI][cC][iI][tT][uU][dD]
FINSOLICITUD = [fF][iI][nN][_][sS][oO][lL][iI][cC][iI][tT][uU][dD]
TEMA = ("Dark" | "White")
ALFANUMERIC = [\"](([a-zA-Z] | [0-9])+)[\"]
IDENTIFICA = [\"] ("$" | "_" | "-") ( [a-zA-Z] | [0-9] | "$" | "_" | "-")* [\"]
NUMERO = [\"][0-9]+[\"]

AÑO = [2-9][0-9][0-9][0-9]
MESESA = ( 0?[1-9] | [1][0-9] | [2][0-9] | [3][0-1] )
MESESB = ( 0?[1-9] | [1][0-9] | [2][0-9] | [3][0] )
MESESC = ( 0?[1-9] | [1][0-9] | [2][0-8] )
COMPLEMENTOA = ( (0?1)|(0?3)|(0?5)|(0?7)|(0?8)|(10)|(12) ) [-] {MESESA}
COMPLEMENTOB = ( (0?4)|(0?6)|(0?9)|(11) ) [-] {MESESB}
COMPLEMENTOC = (0?2) [-] {MESESC}
FECHA = [\"] {AÑO} [-] ( {COMPLEMENTOA} | {COMPLEMENTOB} | {COMPLEMENTOC} ) [\"] 

ALLCHARACTERS = [\"]  [^"\"" "|"]+ [\"]
ALLCHARACTERSNOSPACE = [\"]  [^' ' "\"" "|"]+ [\"]
NOCOMILLAS =([^\"])*
OPTIONS = [\"] ([a-zA-Z0-9] | {Ignore})+ ("|" ([a-zA-Z0-9] | {Ignore}})+)* [\"]

CONSULTA = [\"] "CONSULTA-" [0-100]  [\"]
CADENA = ['] [^"'" "\""] [']

TerminacionLinea = [\r|\n|\r\n]
WS = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]
%%

<YYINITIAL> {
    //Signos fundamentales
    "<"                     { return new Symbol(MENOR_QUE, yyline+1, yycolumn+1, yytext()); }
    ">"                     { return new Symbol(MAYOR_QUE, yyline+1, yycolumn+1, yytext()); }
    "<>"                    { return new Symbol(DIFERENTE, yyline+1, yycolumn+1, yytext()); }
    "<="                    { return new Symbol(MENOR_IGUAL, yyline+1, yycolumn+1, yytext()); }
    ">="                    { return new Symbil(MAYOR_IGUAL, yyline+1, yycolumn+1, yytext()); }
    "="                     { return new Symbol(IGUAL, yyline+1, yycolumn+1, yytext()); }
    "!"                     { return new Symbol(EXCLAMACION, yyline+1, yycolumn+1, yytext()); }
    ":"                     { return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    "["                     { return new Symbol(CORCHETE_A, yyline+1, yycolumn+1, yytext()); }
    "]"                     { return new Symbol(CORCHETE_C, yyline+1, yycolumn+1, yytext()); }
    "{"                     { return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                     { return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    ","                     { return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }
    "->"                    { return new Symbol(FLECHA, yyline+1, yycolumn+1, yytext()); }

    //Instrucciones
    {INISOLICITUDES}        { return new Symbol(INI_SOLICITUDES, yyline+1, yycolumn+1, yytext()); }
    {FINSOLICITUDES}        { return new Symbol(FIN_SOLICITUDES, yyline+1, yycolumn+1, yytext()); }
    {INISOLICITUD}          { return new Symbol(INI_SOLICITUD, yyline+1, yycolumn+1, yytext()); }
    {FINSOLICITUD}          { return new Symbol(FIN_SOLICITUD, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CREAR_USUARIO"{WS}*"\""         { return new Symbol(CREAR_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CREDENCIALES_USUARIO"{WS}*"\""  { return new Symbol(CREDENCIALES_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO"{WS}*"\""               { return new Symbol(USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"PASSWORD"{WS}*"\""              { return new Symbol(PASSWORD, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"MODIFICAR_USUARIO"{WS}*"\""     { return new Symbol(MODIFICAR_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_ANTIGUO"{WS}*"\""       { return new Symbol(USUARIO_ANTIGUO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_NUEVO"{WS}*"\""         { return new Symbol(USUARIO_NUEVO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NUEVO_PASSWORD"{WS}*"\""        { return new Symbol(NUEVO_PASSWORD, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FECHA_MODIFICACION"{WS}*"\""    { return new Symbol(FECHA_MODIFICACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ELIMINAR_USUARIO"{WS}*"\""      { return new Symbol(ELIMINAR_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CREDENCIALES_USUARIO"{WS}*"\""  { return new Symbol(CREDENCIALES_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"LOGIN_USUARIO"{WS}*"\""         { return new Symbol(LOGIN_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NUEVO_FORMULARIO"{WS}*"\""      { return new Symbol(NUEVO_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ID"{WS}*"\""                    { return new Symbol(ID, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TITULO"{WS}*"\""                { return new Symbol(TITULO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE"{WS}*"\""                { return new Symbol(NOMBRE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEMA"{WS}*"\""                  { return new Symbol(TEMA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_CREACION"{WS}*"\""      { return new Symbol(USUARIO_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FECHA_CREACION"{WS}*"\""        { return new Symbol(FECHA_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ELIMINAR_FORMULARIO"{WS}*"\""   { return new Symbol(ELIMINAR_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"MODIFICAR_FORMULARIO"{WS}*"\""  { return new Symbol(MODIFICAR_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"PARAMETROS_FORMULARIO"{WS}*"\"" { return new Symbol(PARAMETROS_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"AGREGAR_COMPONENT"{WS}*"E\""    { return new Symbol(AGREGAR_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"PARAMETROS_COMPONENTE"{WS}*"\"" { return new Symbol(PARAMETROS_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE_CAMPO"{WS}*"\""          { return new Symbol(NOMBRE_CAMPO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FORMULARIO"{WS}*"\""            { return new Symbol(FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CLASE"{WS}*"\""                 { return new Symbol(CLASE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INDICE"{WS}*"\""                { return new Symbol(INDICE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEXTO_VISIBLE"{WS}*"\""         { return new Symbol(TEXTO_VISIBLE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ALINEACION"{WS}*"\""            { return new Symbol(ALINEACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"REQUERIDO"{WS}*"\""             { return new Symbol(REQUERIDO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"OPCIONES"{WS}*"\""              { return new Symbol(OPCIONES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FILAS"{WS}*"\""                 { return new Symbol(FILAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COLUMNAS"{WS}*"\""              { return new Symbol(COLUMNAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"URL"{WS}*"\""                   { return new Symbol(URL, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ELIMINAR_COMPONENTE"{WS}*"\""   { return new Symbol(ELIMINAR_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"MODIFICAR_COMPONENTE"{WS}*"\""  { return new Symbol(MODIFICAR_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CONSULTAR_DATOS"{WS}*"\""       { return new Symbol(CONSULTAR_DATOS, yyline+1, yycolumn+1, yytext()); }
    //Componentes Solicitados
    "\""{WS}*"CAMPO_TEXTO"{WS}*"\""           { return new Symbol(CAMPO_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"AREA_TEXTO"{WS}*"\""            { return new Symbol(AREA_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CHECKBOX"{WS}*"\""              { return new Symbol(CHECKBOX, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"RADIO"{WS}*"\""                 { return new Symbol(RADIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FICHERO"{WS}*"\""               { return new Symbol(FICHERO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IMAGEN"{WS}*"\""                { return new Symbol(IMAGEN, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COMBO"{WS}*"\""                 { return new Symbol(COMBO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"BOTON"{WS}*"\""                 { return new Symbol(BOTON, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"SI"{WS}*"\""                    { return new Symbol(SI, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NO"{WS}*"\""                    { return new Symbol(NO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CENTRO"{WS}*"\""                { return new Symbol(CENTRO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IZQUIERDA"{WS}*"\""             { return new Symbol(IZQUIERDA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DERECHA"{WS}*"\""               { return new Symbol(DERECHA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"JUSTIFICAR"{WS}*"\""            { return new Symbol(JUSTIFICAR, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"SI"{WS}*"\""                    { return new Symbol(SI, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NO"{WS}*"\""                    { return new Symbol(NO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"Dark"{WS}*"\""                  { return new Symbol(DARK, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"White"{WS}*"\""                 { return new Symbol(WHITE, yyline+1, yycolumn+1, yytext()); }
    //Lenguaje de reportería
    "SELECT"                                    { return new Symbol(SELECT, yyline+1, yycolumn+1, yytext()); }
    "TO"                                        { return new Symbol(TO, yyline+1, yycolumn+1, yytext()); }
    "FROM"                                      { return new Symbol(FROM, yyline+1, yycolumn+1, yytext()); }
    "WHERE"                                     { return new Symbol(WHERE, yyline+1, yycolumn+1, yytext()); }
    "AND"                                       { return new Symbol(AND, yyline+1, yycolumn+1, yytext()); }
    "OR"                                        { return new Symbol(OR, yyline+1, yycolumn+1, yytext()); }
    "NOT"                                       { return new Symbol(NOT, yyline+1, yycolumn+1, yytext()); }


    //Cadenas Fundamentales
    {IDENTIFICA}            { return new Symbol(IDENTIFICADOR, yyline+1, yycolumn+1, yytext()); }
    {NUMERO}                { return new Symbol(NUMERO, yyline+1, yycolumn+1, yytext()); }
    {FECHA}                 { return new Symbol(FECHA, yyline+1, yycolumn+1, yytext()); }
    {CONSULTA}              { return new Symbol(CONSULTA, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERSNOSPACE}  { return new Symbol(ALLCHARACTERSNOSPACE, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}         { return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }
    {OPTIONS}               { return new Symbol(OPTIONS, yyline+1, yycolumn+1, yytext()); }
    {CADENA}                { return new Symbol(CADENA, yyline+1, yycolumn+1, yytext()); }
    {Ignore}                {/* IGNORAR */}
}

[^] {
    System.out.println("Error en linea: " + yyline+1 + " - Columna: " + yycolumn+1 + ". La expresión: " + yytext() + " no forma parte del lenguaje");
}
