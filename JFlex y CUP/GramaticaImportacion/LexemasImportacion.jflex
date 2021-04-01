

%%
%public
%class ImportacionLexer
%cup
%unicode
%line
%column

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

    "("                                         { return new Symbol(PARENT_A, yyline+1, yycolumn+1, yytext()); }
    ")"                                         { return new Symbol(PARENT_C, yyline+1, yycolumn+1, yytext()); }
    "{"                                         { return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                                         { return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    ":"                                         { return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    ","                                         { return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }

    "new.formulario"                            { return new Symbol(NEW_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ID_FORMULARIO"{WS}*"\""           { return new Symbol(ID_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TITULO"{WS}*"\""                  { return new Symbol(TITULO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE"{WS}*"\""                  { return new Symbol(NOMBRE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEMA"{WS}*"\""                    { return new Symbol(TEMA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FECHA_CREACION"{WS}*"\""          { return new Symbol(FECHA_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"USUARIO_CREACION"{WS}*"\""        { return new Symbol(USUARIO_CREACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ESTRUCTURA"{WS}*"\""              { return new Symbol(ESTRUCTURA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INDICE"{WS}*"\""                  { return new Symbol(INDICE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FORMULARIO"{WS}*"\""              { return new Symbol(FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CLASE"{WS}*"\""                   { return new Symbol(CLASE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"REQUERIDO"{WS}*"\""               { return new Symbol(REQUERIDO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"ALINEACION"{WS}*"\""              { return new Symbol(ALINEACION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NOMBRE_CAMPO"{WS}*"\""            { return new Symbol(NOMBRE_CAMPO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TEXTO_VISIBLE"{WS}*"\""           { return new Symbol(TEXTO_VISIBLE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"OPCIONES"{WS}*"\""                { return new Symbol(OPCIONES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FILAS"{WS}*"\""                   { return new Symbol(FILAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COLUMNAS"{WS}*"\""                { return new Symbol(COLUMNAS, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"URL"{WS}*"\""                     { return new Symbol(URL, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"Dark"{WS}*"\""                    { return new Symbol(DARK, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"White"{WS}*"\""                   { return new Symbol(WHITE, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"SI"{WS}*"\""                      { return new Symbol(SI, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"NO"{WS}*"\""                      { return new Symbol(NO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CENTRO"{WS}*"\""                  { return new Symbol(CENTRO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IZQUIERDA"{WS}*"\""               { return new Symbol(IZQUIERDA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DERECHA"{WS}*"\""                 { return new Symbol(DERECHA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"JUSTIFICAR"{WS}*"\""              { return new Symbol(JUSTIFICAR, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CAMPO_TEXTO"{WS}*"\""             { return new Symbol(CAMPO_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"AREA_TEXTO"{WS}*"\""              { return new Symbol(AREA_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"CHECKBOX"{WS}*"\""                { return new Symbol(CHECKBOX, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"RADIO"{WS}*"\""                   { return new Symbol(RADIO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"FICHERO"{WS}*"\""                 { return new Symbol(FICHERO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"IMAGEN"{WS}*"\""                  { return new Symbol(IMAGEN, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"COMBO"{WS}*"\""                   { return new Symbol(COMBO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"BOTON"{WS}*"\""                   { return new Symbol(BOTON, yyline+1, yycolumn+1, yytext()); }


    {IDCOMPONENTEN}                             { return new Symbol(ID_COMPONENTE_N, yyline+1, yycolumn+1, yytext()); }
    {IDENTIFICA}                                { return new Symbol(IDENTIFICADOR, yyline+1, yycolumn+1, yytext()); }
    {NUMERO}                                    { return new Symbol(NUMERO, yyline+1, yycolumn+1, yytext()); }
    {FECHA}                                     { return new Symbol(FECHA, yyline+1, yycolumn+1, yytext()); }
    {OPTIONS}                                   { return new Symbol(OPCIONES, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERSNOSPACE}                      { return new Symbol(ALLCHARACTERSNOSPACE, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}                             { return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }

    {Ignore}                                    {/*Ignorar*/}

}
[^] {

}    
