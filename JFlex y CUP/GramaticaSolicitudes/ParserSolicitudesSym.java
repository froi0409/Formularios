
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.froi.editorcodigoindigo.gramaticas.codigoindigo;

/** CUP generated class containing symbol constants. */
public class ParserSolicitudesSym {
  /* terminals */
  public static final int USUARIO_ANTIGUO = 45;
  public static final int COMILLAS = 7;
  public static final int IDENTIFICADOR = 16;
  public static final int FROM = 94;
  public static final int INI_SOLICITUD = 38;
  public static final int CONSULTAR_DATOS = 76;
  public static final int DARK = 29;
  public static final int MENOR_IGUAL = 87;
  public static final int MENOR_QUE = 2;
  public static final int MODIFICAR_FORMULARIO = 59;
  public static final int EXCLAMACION = 5;
  public static final int CAMPO_TEXTO = 78;
  public static final int TITULO = 51;
  public static final int IZQUIERDA = 25;
  public static final int FIN_SOLICITUDES = 37;
  public static final int CHECKBOX = 80;
  public static final int SI = 22;
  public static final int USUARIO_NUEVO = 55;
  public static final int FECHA_MODIFICACION = 47;
  public static final int USUARIO_CREACION = 54;
  public static final int CONTRASEÑA = 17;
  public static final int DIFERENTE = 88;
  public static final int TEMA = 53;
  public static final int ELIMINAR_COMPONENTE = 74;
  public static final int CENTRO = 24;
  public static final int WHITE = 30;
  public static final int PASSWORD = 43;
  public static final int NUMERO = 21;
  public static final int OPCIONES = 70;
  public static final int MAYOR_QUE = 3;
  public static final int CAMPO = 33;
  public static final int MODIFICAR_USUARIO = 44;
  public static final int NOT = 93;
  public static final int CORCHETE_C = 9;
  public static final int CORCHETE_A = 8;
  public static final int GUION = 13;
  public static final int FICHERO = 82;
  public static final int ELIMINAR_USUARIO = 48;
  public static final int TEXTO_VISIBLE = 67;
  public static final int CREAR_USUARIO = 40;
  public static final int FLECHA = 86;
  public static final int FILAS = 71;
  public static final int NUEVO_PASSWORD = 46;
  public static final int AREA_TEXTO = 79;
  public static final int LLAVE_C = 15;
  public static final int LLAVE_A = 14;
  public static final int FORMULARIO = 64;
  public static final int NUMERO_CONSULTA = 34;
  public static final int SELECT = 96;
  public static final int ELIMINAR_FORMULARIO = 57;
  public static final int COMA = 10;
  public static final int IGUAL = 4;
  public static final int FECHA = 18;
  public static final int CLASE = 65;
  public static final int CAMPOS = 32;
  public static final int NOMBRE = 52;
  public static final int NOMBRE_CAMPO = 63;
  public static final int CONSULTA = 97;
  public static final int NUEVO_FORMULARIO = 49;
  public static final int COLUMNAS = 72;
  public static final int LOGIN_USUARIO = 58;
  public static final int FIN_SOLICITUD = 39;
  public static final int PUNTOS = 6;
  public static final int USUARIO = 42;
  public static final int CONSULTAS = 77;
  public static final int CADENA_CONSULTA = 35;
  public static final int IDENTIFCONSULTA = 31;
  public static final int URL = 73;
  public static final int PARAMETROS_COMPONENTE = 62;
  public static final int EOF = 0;
  public static final int WHERE = 95;
  public static final int IMAGEN = 83;
  public static final int MODIFICAR_COMPONENTE = 75;
  public static final int OR = 90;
  public static final int INI_SOLICITUDES = 36;
  public static final int error = 1;
  public static final int BOTON = 85;
  public static final int CREDENCIALES_USUARIO = 41;
  public static final int JUSTIFICAR = 27;
  public static final int ID = 50;
  public static final int DERECHA = 26;
  public static final int ALLCHARACTERS = 19;
  public static final int RADIO = 81;
  public static final int FECHA_CREACION = 56;
  public static final int REQUERIDO = 69;
  public static final int PARAMETROS_FORMULARIO = 60;
  public static final int ALLCHARACTERSNOSPACE = 20;
  public static final int DOLAR = 11;
  public static final int COMBO = 84;
  public static final int INDICE = 66;
  public static final int ALINEACION = 68;
  public static final int OPTIONS = 28;
  public static final int NO = 23;
  public static final int AND = 92;
  public static final int GUION_BAJO = 12;
  public static final int TO = 91;
  public static final int MAYOR_IGUAL = 89;
  public static final int AGREGAR_COMPONENTE = 61;
  public static final String[] terminalNames = new String[] {
  "EOF",
  "error",
  "MENOR_QUE",
  "MAYOR_QUE",
  "IGUAL",
  "EXCLAMACION",
  "PUNTOS",
  "COMILLAS",
  "CORCHETE_A",
  "CORCHETE_C",
  "COMA",
  "DOLAR",
  "GUION_BAJO",
  "GUION",
  "LLAVE_A",
  "LLAVE_C",
  "IDENTIFICADOR",
  "CONTRASEÑA",
  "FECHA",
  "ALLCHARACTERS",
  "ALLCHARACTERSNOSPACE",
  "NUMERO",
  "SI",
  "NO",
  "CENTRO",
  "IZQUIERDA",
  "DERECHA",
  "JUSTIFICAR",
  "OPTIONS",
  "DARK",
  "WHITE",
  "IDENTIFCONSULTA",
  "CAMPOS",
  "CAMPO",
  "NUMERO_CONSULTA",
  "CADENA_CONSULTA",
  "INI_SOLICITUDES",
  "FIN_SOLICITUDES",
  "INI_SOLICITUD",
  "FIN_SOLICITUD",
  "CREAR_USUARIO",
  "CREDENCIALES_USUARIO",
  "USUARIO",
  "PASSWORD",
  "MODIFICAR_USUARIO",
  "USUARIO_ANTIGUO",
  "NUEVO_PASSWORD",
  "FECHA_MODIFICACION",
  "ELIMINAR_USUARIO",
  "NUEVO_FORMULARIO",
  "ID",
  "TITULO",
  "NOMBRE",
  "TEMA",
  "USUARIO_CREACION",
  "USUARIO_NUEVO",
  "FECHA_CREACION",
  "ELIMINAR_FORMULARIO",
  "LOGIN_USUARIO",
  "MODIFICAR_FORMULARIO",
  "PARAMETROS_FORMULARIO",
  "AGREGAR_COMPONENTE",
  "PARAMETROS_COMPONENTE",
  "NOMBRE_CAMPO",
  "FORMULARIO",
  "CLASE",
  "INDICE",
  "TEXTO_VISIBLE",
  "ALINEACION",
  "REQUERIDO",
  "OPCIONES",
  "FILAS",
  "COLUMNAS",
  "URL",
  "ELIMINAR_COMPONENTE",
  "MODIFICAR_COMPONENTE",
  "CONSULTAR_DATOS",
  "CONSULTAS",
  "CAMPO_TEXTO",
  "AREA_TEXTO",
  "CHECKBOX",
  "RADIO",
  "FICHERO",
  "IMAGEN",
  "COMBO",
  "BOTON",
  "FLECHA",
  "MENOR_IGUAL",
  "DIFERENTE",
  "MAYOR_IGUAL",
  "OR",
  "TO",
  "AND",
  "NOT",
  "FROM",
  "WHERE",
  "SELECT",
  "CONSULTA"
  };
}

