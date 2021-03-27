package com.froi.editorcodigoindigo.gramaticas.respuestas;

import java_cup.runtime.*;
import static com.froi.editorcodigoindigo.gramaticas.respuestas.ParserRespuestasSym.*;

%%

%public
%class RespuestasLexer
%cup
%unicode
%line
%column

TerminacionLinea = [\r|\n|\r\n]
WS = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]

INIRESPUESTAS = [iI][nN][iI][_][rR][eE][sS][pP][uU][eE][sS][tT][aA][sS]
INIRESPUESTA = [iI][nN][iI][_][rR][eE][sS][pP][uU][eE][sS][tT][aA]
FINRESPUESTAS = [fF][iI][nN][_][rR][eE][sS][pP][uU][eE][sS][tT][aA][sS]
FINRESPUESTA = [fF][iI][nN][_][rR][eE][sS][pP][uU][eE][sS][tT][aA]
ALLCHARACTERS = [\42] ([\40-\41] | [\43-\255])* [\42]
%%
<YYINITIAL> {

    //Signos fundamentales
    "<"                     { return new Symbol(MENOR_QUE, yyline+1, yycolumn+1, yytext()); }
    ">"                     { return new Symbol(MAYOR_QUE, yyline+1, yycolumn+1, yytext()); }
    "!"                     { return new Symbol(EXCLAMACION, yyline+1, yycolumn+1, yytext()); }
    ":"                     { return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    "["                     { return new Symbol(CORCHETE_A, yyline+1, yycolumn+1, yytext()); }
    "]"                     { return new Symbol(CORCHETE_C, yyline+1, yycolumn+1, yytext()); }
    "{"                     { return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                     { return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    ","                     { return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }
    
    //Instrucciones
    "\""{WS}*"ERROR_DETECTADO"{WS}*"\""                 { return new Symbol(ERROR_DETECTADO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DESCRIPCION"{WS}*"\""                     { return new Symbol(DESCRIPCION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INSTRUCCION_EJECUTADA"{WS}*"\""           { return new Symbol(INSTRUCCION_EJECUTADA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INSTRUCCIONES"{WS}*"\""                   { return new Symbol(INSTRUCCIONES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TIPO"{WS}*"\""                            { return new Symbol(TIPO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DETALLES"{WS}*"\""                        { return new Symbol(DETALLES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DESCRIPCION_ERROR"{WS}*"\""               { return new Symbol(DESCRIPCION_ERROR, yyline+1, yycolumn+1, yytext()); }

    {INIRESPUESTA}          { return new Symbol(INI_RESPUESTA, yyline+1, yycolumn+1, yytext()); }
    {FINRESPUESTA}          { return new Symbol(FIN_RESPUESTA, yyline+1, yycolumn+1, yytext()); }
    {INIRESPUESTAS}         { return new Symbol(INI_RESPUESTAS, yyline+1, yycolumn+1, yytext()); }
    {FINRESPUESTAS}         { return new Symbol(FIN_RESPUESTAS, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}         { return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }

    {Ignore}                {/* Ignorar */}

}

[^] {



}