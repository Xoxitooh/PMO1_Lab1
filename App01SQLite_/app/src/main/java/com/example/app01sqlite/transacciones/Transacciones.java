package com.example.app01sqlite.transacciones;

public class Transacciones {

    // Tablas
    public static final String tablaPersona = "persona";
    // Campos
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edades = "edades";
    public static final String correos = "correos";
    public static final String direcciones = "direcciones";

    //Tablas - CREATE, DROP
    public static final String CreateTablePersona = "CREATE TABLE persona( id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT, edades INTEGER, correos TEXT, direcciones TEXT)";

    public static final String DropTablePersona = "DROP TABLE IF EXITS persona";

    //Creación del nombre de la base de datos
    public static final String NameDataBase = "DBCurso";


}
