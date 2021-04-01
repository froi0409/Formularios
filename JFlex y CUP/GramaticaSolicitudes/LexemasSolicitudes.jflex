package com.froi.formulariosweb.analizadores.codigoindigo;

import java_cup.runtime.*;
import java.util.ArrayList;
import com.froi.formulariosweb.entidades.Advertencia;
import static com.froi.formulariosweb.analizadores.codigoindigo.ParserSolicitudesSym.*;
%%

%public
%class SolicitudesLexer
%cup
%unicode
%line
%column

//Codigo añadido
%{
    private ArrayList<Advertencia> listaErrores;
    private String cadenaLexica = "";

    public SolicitudesLexer(java.io.Reader in, ArrayList<Advertencia> listaErrores) {
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

//Definición de expresiones regulares específicas
INISOLICITUDES = [iI][nN][iI][_][sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS]
FINSOLICITUDES = [fF][iI][nN][_][sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS]
INISOLICITUD =  [iI][nN][iI][_][sS][oO][lL][iI][cC][iI][tT][uU][dD]
FINSOLICITUD = [fF][iI][nN][_][sS][oO][lL][iI][cC][iI][tT][uU][dD]
TEMA = ("Dark" | "White")
ALFANUMERIC = [\"](([a-zA-Z] | [0-9])+)[\"]
IDENTIFICA = [\"] ("$" | "_" | "-") ( [a-zA-Z] | [0-9] | "$" | "_" | "-")* [\"]
NUMERO = [\"][1-9][0-9]*[\"]

AÑO = [2-9][0-9][0-9][0-9]
MESESA = ( 0?[1-9] | [1][0-9] | [2][0-9] | [3][0-1] )
MESESB = ( 0?[1-9] | [1][0-9] | [2][0-9] | [3][0] )
MESESC = ( 0?[1-9] | [1][0-9] | [2][0-8] )
COMPLEMENTOA = ( (0?1)|(0?3)|(0?5)|(0?7)|(0?8)|(10)|(12) ) [-] {MESESA}
COMPLEMENTOB = ( (0?4)|(0?6)|(0?9)|(11) ) [-] {MESESB}
COMPLEMENTOC = (0?2) [-] {MESESC}
FECHA = [\"] {AÑO} [-] ( {COMPLEMENTOA} | {COMPLEMENTOB} | {COMPLEMENTOC} ) [\"] 

//ALLCHARACTERS = [\"]  [^"\"" "|"]+ [\"]
ALLCHARACTERS = [\42] ([\0-\41] | [\43-\173] | [\175-\255] | [^"\"" "|"] | ("\’" | "\'"))* [\42]
//ALLCHARACTERS = \" [\40]*  ([\41] | [\43-\176]) ([\40-\41] | [\43-\176])*  [\40]* \"
ALLCHARACTERSNOSPACE = [\"]  [^' ' "\"" "|"]+ [\"]
NOCOMILLAS =([^\"])*
OPTIONS = [\"] ([a-zA-Z0-9] | {WS} | [^"\"" "|"])+ ("|" ([a-zA-Z0-9] | {WS} | [^"\"" "|"])+)+ [\"]

CONSULTA = [\"]{WS}* "CONSULTA"{WS}* "-"{WS}* [0-9]+{WS}*  [\"]
IDENTIFCONSULTA = ("$" | "_" | "-") ( [a-zA-Z] | [0-9] | "$" | "_" | "-")*
CAMPOS = [\[]  ([^"\"" "|" "[" "]"] | {WS})* [\]]
CADENACONSULTA = ("\’" | "\'") ([^ "\"" "|"] | [ \t\f])* ("\’" | "\'")
NUMEROCONSULTA = (-)? [0-9]+ ( ['.'] [0-9]+ ) ?

%%

<YYINITIAL> {

    //Signos fundamentales
    "<"                     { agregarError(yyline+1,yycolumn+1); return new Symbol(MENOR_QUE, yyline+1, yycolumn+1, yytext()); }
    ">"                     { agregarError(yyline+1,yycolumn+1); return new Symbol(MAYOR_QUE, yyline+1, yycolumn+1, yytext()); }
    "="                     { agregarError(yyline+1,yycolumn+1); return new Symbol(IGUAL, yyline+1, yycolumn+1, yytext()); }
    "!"                     { agregarError(yyline+1,yycolumn+1); return new Symbol(EXCLAMACION, yyline+1, yycolumn+1, yytext()); }
    ":"                     { agregarError(yyline+1,yycolumn+1); return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    "["                     { agregarError(yyline+1,yycolumn+1); return new Symbol(CORCHETE_A, yyline+1, yycolumn+1, yytext()); }
    "]"                     { agregarError(yyline+1,yycolumn+1); return new Symbol(CORCHETE_C, yyline+1, yycolumn+1, yytext()); }
    "{"                     { agregarError(yyline+1,yycolumn+1); return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                     { agregarError(yyline+1,yycolumn+1); return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    ","                     { agregarError(yyline+1,yycolumn+1); return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }
    //"->"                    { return new Symbol(FLECHA, yyline+1, yycolumn+1, yytext()); }
    //"\""                    { return new Symbol(COMILLAS, yyline+1, yycolumn+1, yytext()); }

    //Instrucciones
    {INISOLICITUDES}        { agregarError(yyline+1,yycolumn+1); return new Symbol(INI_SOLICITUDES, yyline+1, yycolumn+1, yytext()); }
    {FINSOLICITUDES}        { agregarError(yyline+1,yycolumn+1); return new Symbol(FIN_SOLICITUDES, yyline+1, yycolumn+1, yytext()); }
    {INISOLICITUD}          { agregarError(yyline+1,yycolumn+1); return new Symbol(INI_SOLICITUD, yyline+1, yycolumn+1, yytext()); }
    {FINSOLICITUD}          { agregarError(yyline+1,yycolumn+1); return new Symbol(FIN_SOLICITUD, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CREAR_USUARIO"{WS}*"\""         { agregarError(yyline+1,yycolumn+1); return new Symbol(CREAR_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CREDENCIALES_USUARIO"{WS}*"\""  { agregarError(yyline+1,yycolumn+1); return new Symbol(CREDENCIALES_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO"{WS}*"\""               { agregarError(yyline+1,yycolumn+1); return new Symbol(USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"PASSWORD"{WS}*"\""              { agregarError(yyline+1,yycolumn+1); return new Symbol(PASSWORD, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"MODIFICAR_USUARIO"{WS}*"\""     { agregarError(yyline+1,yycolumn+1); return new Symbol(MODIFICAR_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_ANTIGUO"{WS}*"\""       { agregarError(yyline+1,yycolumn+1); return new Symbol(USUARIO_ANTIGUO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_NUEVO"{WS}*"\""         { agregarError(yyline+1,yycolumn+1); return new Symbol(USUARIO_NUEVO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NUEVO_PASSWORD"{WS}*"\""        { agregarError(yyline+1,yycolumn+1); return new Symbol(NUEVO_PASSWORD, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FECHA_MODIFICACION"{WS}*"\""    { agregarError(yyline+1,yycolumn+1); return new Symbol(FECHA_MODIFICACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ELIMINAR_USUARIO"{WS}*"\""      { agregarError(yyline+1,yycolumn+1); return new Symbol(ELIMINAR_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CREDENCIALES_USUARIO"{WS}*"\""  { agregarError(yyline+1,yycolumn+1); return new Symbol(CREDENCIALES_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"LOGIN_USUARIO"{WS}*"\""         { agregarError(yyline+1,yycolumn+1); return new Symbol(LOGIN_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NUEVO_FORMULARIO"{WS}*"\""      { agregarError(yyline+1,yycolumn+1); return new Symbol(NUEVO_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ID"{WS}*"\""                    { agregarError(yyline+1,yycolumn+1); return new Symbol(ID, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TITULO"{WS}*"\""                { agregarError(yyline+1,yycolumn+1); return new Symbol(TITULO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE"{WS}*"\""                { agregarError(yyline+1,yycolumn+1); return new Symbol(NOMBRE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEMA"{WS}*"\""                  { agregarError(yyline+1,yycolumn+1); return new Symbol(TEMA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_CREACION"{WS}*"\""      { agregarError(yyline+1,yycolumn+1); return new Symbol(USUARIO_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FECHA_CREACION"{WS}*"\""        { agregarError(yyline+1,yycolumn+1); return new Symbol(FECHA_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ELIMINAR_FORMULARIO"{WS}*"\""   { agregarError(yyline+1,yycolumn+1); return new Symbol(ELIMINAR_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"MODIFICAR_FORMULARIO"{WS}*"\""  { agregarError(yyline+1,yycolumn+1); return new Symbol(MODIFICAR_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"PARAMETROS_FORMULARIO"{WS}*"\"" { agregarError(yyline+1,yycolumn+1); return new Symbol(PARAMETROS_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"AGREGAR_COMPONENTE"{WS}*"\""    { agregarError(yyline+1,yycolumn+1); return new Symbol(AGREGAR_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"PARAMETROS_COMPONENTE"{WS}*"\"" { agregarError(yyline+1,yycolumn+1); return new Symbol(PARAMETROS_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE_CAMPO"{WS}*"\""          { agregarError(yyline+1,yycolumn+1); return new Symbol(NOMBRE_CAMPO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FORMULARIO"{WS}*"\""            { agregarError(yyline+1,yycolumn+1); return new Symbol(FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CLASE"{WS}*"\""                 { agregarError(yyline+1,yycolumn+1); return new Symbol(CLASE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INDICE"{WS}*"\""                { agregarError(yyline+1,yycolumn+1); return new Symbol(INDICE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEXTO_VISIBLE"{WS}*"\""         { agregarError(yyline+1,yycolumn+1); return new Symbol(TEXTO_VISIBLE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ALINEACION"{WS}*"\""            { agregarError(yyline+1,yycolumn+1); return new Symbol(ALINEACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"REQUERIDO"{WS}*"\""             { agregarError(yyline+1,yycolumn+1); return new Symbol(REQUERIDO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"OPCIONES"{WS}*"\""              { agregarError(yyline+1,yycolumn+1); return new Symbol(OPCIONES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FILAS"{WS}*"\""                 { agregarError(yyline+1,yycolumn+1); return new Symbol(FILAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COLUMNAS"{WS}*"\""              { agregarError(yyline+1,yycolumn+1); return new Symbol(COLUMNAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"URL"{WS}*"\""                   { agregarError(yyline+1,yycolumn+1); return new Symbol(URL, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ELIMINAR_COMPONENTE"{WS}*"\""   { agregarError(yyline+1,yycolumn+1); return new Symbol(ELIMINAR_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"MODIFICAR_COMPONENTE"{WS}*"\""  { agregarError(yyline+1,yycolumn+1); return new Symbol(MODIFICAR_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CONSULTAR_DATOS"{WS}*"\""       { agregarError(yyline+1,yycolumn+1); return new Symbol(CONSULTAR_DATOS, yyline+1, yycolumn+1, yytext()); }
    //Componentes Solicitados
    "\""{WS}*"CAMPO_TEXTO"{WS}*"\""           { agregarError(yyline+1,yycolumn+1); return new Symbol(CAMPO_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"AREA_TEXTO"{WS}*"\""            { agregarError(yyline+1,yycolumn+1); return new Symbol(AREA_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CHECKBOX"{WS}*"\""              { agregarError(yyline+1,yycolumn+1); return new Symbol(CHECKBOX, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"RADIO"{WS}*"\""                 { agregarError(yyline+1,yycolumn+1); return new Symbol(RADIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FICHERO"{WS}*"\""               { agregarError(yyline+1,yycolumn+1); return new Symbol(FICHERO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IMAGEN"{WS}*"\""                { agregarError(yyline+1,yycolumn+1); return new Symbol(IMAGEN, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COMBO"{WS}*"\""                 { agregarError(yyline+1,yycolumn+1); return new Symbol(COMBO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"BOTON"{WS}*"\""                 { agregarError(yyline+1,yycolumn+1); return new Symbol(BOTON, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"SI"{WS}*"\""                    { agregarError(yyline+1,yycolumn+1); return new Symbol(SI, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NO"{WS}*"\""                    { agregarError(yyline+1,yycolumn+1); return new Symbol(NO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CENTRO"{WS}*"\""                { agregarError(yyline+1,yycolumn+1); return new Symbol(CENTRO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IZQUIERDA"{WS}*"\""             { agregarError(yyline+1,yycolumn+1); return new Symbol(IZQUIERDA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DERECHA"{WS}*"\""               { agregarError(yyline+1,yycolumn+1); return new Symbol(DERECHA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"JUSTIFICAR"{WS}*"\""            { agregarError(yyline+1,yycolumn+1); return new Symbol(JUSTIFICAR, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"SI"{WS}*"\""                    { agregarError(yyline+1,yycolumn+1); return new Symbol(SI, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NO"{WS}*"\""                    { agregarError(yyline+1,yycolumn+1); return new Symbol(NO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"Dark"{WS}*"\""                  { agregarError(yyline+1,yycolumn+1); return new Symbol(DARK, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"White"{WS}*"\""                 { agregarError(yyline+1,yycolumn+1); return new Symbol(WHITE, yyline+1, yycolumn+1, yytext()); }
    //Lenguaje de reportería
    "\""{WS}*"CONSULTAS"{WS}*"\""             { agregarError(yyline+1,yycolumn+1); return new Symbol(CONSULTAS, yyline+1, yycolumn+1, yytext()); }
    /*"SELECT"                                    { return new Symbol(SELECT, yyline+1, yycolumn+1, yytext()); }
    "TO"                                        { return new Symbol(TO, yyline+1, yycolumn+1, yytext()); }
    "FORM"                                      { return new Symbol(FROM, yyline+1, yycolumn+1, yytext()); }
    "WHERE"                                     { return new Symbol(WHERE, yyline+1, yycolumn+1, yytext()); }
    "AND"                                       { return new Symbol(AND, yyline+1, yycolumn+1, yytext()); }
    "OR"                                        { return new Symbol(OR, yyline+1, yycolumn+1, yytext()); }
    "NOT"                                       { return new Symbol(NOT, yyline+1, yycolumn+1, yytext()); }
    {NUMEROCONSULTA}                            { System.out.println("NUMEROCONSULTA: " + yytext()); return new Symbol(NUMERO_CONSULTA, yyline+1, yycolumn+1, yytext()); }
    //{IDENTIFCONSULTA}                           { System.out.println("IDENTIFCONSULTA: " + yytext()); return new Symbol(IDENTIFCONSULTA, yyline+1, yycolumn+1, yytext()); }
    {CADENACONSULTA}                            { System.out.println("CADENA en: " + yyline + " , " + yycolumn + " - " + yytext()); return new Symbol(CADENA_CONSULTA, yyline+1, yycolumn+1, yytext()); }
    */
    //Cadenas Fundamentales
    {IDENTIFICA}            { agregarError(yyline+1,yycolumn+1); return new Symbol(IDENTIFICADOR, yyline+1, yycolumn+1, yytext()); }
    {NUMERO}                { agregarError(yyline+1,yycolumn+1); return new Symbol(NUMERO, yyline+1, yycolumn+1, yytext()); }
    {FECHA}                 { agregarError(yyline+1,yycolumn+1); return new Symbol(FECHA, yyline+1, yycolumn+1, yytext()); }
    {CONSULTA}              { agregarError(yyline+1,yycolumn+1); return new Symbol(CONSULTA, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERSNOSPACE}  { agregarError(yyline+1,yycolumn+1); return new Symbol(ALLCHARACTERSNOSPACE, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}         { agregarError(yyline+1,yycolumn+1); return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }
    {OPTIONS}               { agregarError(yyline+1,yycolumn+1); return new Symbol(OPTIONS, yyline+1, yycolumn+1, yytext()); }
    /*
    */
    {Ignore}                { agregarError(yyline+1,yycolumn+1); /* IGNORAR */}
    //{CAMPO}                                     { System.out.println("CAMPO en: " + yyline + " , " + yycolumn + " - " + yytext());return new Symbol(CAMPO, yyline+1, yycolumn+1, yytext()); }
    //{CAMPOS}                                    { System.out.println("CAMPOS: " + yytext()); return new Symbol(CAMPOS, yyline+1, yycolumn+1, yytext()); }
}

[^] {
    System.out.println("Error en linea: " + yyline+1 + " - Columna: " + yycolumn+1 + ". La expresión: " + yytext() + " no forma parte del lenguaje");
    cadenaLexica += yytext();
}
