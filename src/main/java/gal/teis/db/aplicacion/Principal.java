/*
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS for A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package gal.teis.db.aplicacion;

import gal.teis.conexion.ConexionSingleton;
import gal.teis.db.clases.Libro;
import gal.teis.excepciones.OperacionBaseDatosException;
import gal.teis.excepciones.NumeroFueraRangoException;
import gal.teis.libreriadam.ControlData;
import gal.teis.libreriadam.Menu;
import gal.teis.db.operaciones.OperacionesBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Esther Ferreiro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    //Variable que representa la entrada de datos estándar
    static Scanner sc;

    static ArrayList<Libro> losLibros = new ArrayList<Libro>();

    public static void main(String[] args) {
        //Para finalizar el menú 
        boolean finalizar = false;
        //creo una instancia de la clase Scanner para la introdución de datos por teclado
        sc = new Scanner(System.in);
        //Donde se almacena la cadena resultado de la operación de base de datos
        String resultado = "";
        //Para almacenar campos de la base de datos para distintas operaciones.
        String titulo = "", autor = "";
        double precio = 0.0;
        //Cadena de conexión
        String cadenaConexion = "jdbc:h2:.\\data\\biblioteca";

        //Establece la conexión con una base de datos SQLite.
        //No es necesario cerrar la conexión al usar try con recursos
        try (Connection miConexion = ConexionSingleton.getConnection(cadenaConexion, "admin", "admin");
                Statement elStatement = miConexion.createStatement()) {
            do {
                switch (pintarMenu()) {
                    case 1://CRAER BASE DE DATOS
                        
                        try {
                        OperacionesBD.crearBD(miConexion);
                        System.out.println("La tabla LIBROS se ha creado con éxito");
                    } catch (OperacionBaseDatosException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                    case 2://ALTAS EN LA TABLA LIBROS
                        String otro = "S";
                        do {

                            System.out.println("Introduce el TÍTULO del libro");
                            titulo = ControlData.lerString(sc);

                            System.out.println("Introduce el AUTOR/A del libro");
                            autor = ControlData.lerString(sc);

                            System.out.println("Introduce el PRECIO del libro");
                            precio = ControlData.lerDouble(sc);
                            /*El campo ID no se introduce ya que se calcula de 
                            forma automatica, según se ha indicado en la orden 
                            SQL en el momento de la creación de la tabla LIBROS 
                            (PRIMARY KEY AUTO_INCREMENT)*/

                            Libro unLibro = new Libro(titulo, autor, precio);
                            losLibros.add(unLibro);
                            System.out.println("¿Desea dar de ALTA otro libro (S/N)?");
                            otro = ControlData.lerNome(sc).toUpperCase();
                        } while (otro.equals("S"));
                        
                        try {
                            miConexion.setAutoCommit(false);
                            for (Libro auxLibro : losLibros) {
                                //Realizar el alta del libro
                                resultado = OperacionesBD.altaLibros(miConexion, auxLibro.getTitulo(), auxLibro.getAutor(), auxLibro.getPrecio());
                            }
                            miConexion.commit();
                            miConexion.setAutoCommit(true);

                        } catch (OperacionBaseDatosException ex) {
                            try{
                            miConexion.rollback();
                            }catch (SQLException e){
                               System.out.println(e.getMessage());
                            }
                            //Se lanza esta excepción desde el método crearBD()
                            System.out.println(ex.getMessage());
                        }
                        break;

                    case 3://BAJAS
                        System.out.println("Introduce el TÍTULO del libro");
                        titulo = ControlData.lerString(sc);
                        try {
                            resultado = OperacionesBD.bajaLibrosPorTitulo(miConexion, titulo);
                            /*Este mensaje solo se muestra si no se produce una 
                            excepción en el método bajaLibrosPorTitulo()*/
                            System.out.println(resultado);
                        } catch (OperacionBaseDatosException ex) {
                            //Se lanza esta excepción desde el método crearBD()
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 4://CONSULTAS
                        /*Se muestar un menú para buscar en la tabla LIBROS por diferentes campos*/
                        switch (pintarSubMenuConsultas()) {
                            case 1: //Buscar por TITULO del libro
                                //Pedir los datos
                                System.out.println("Introduce el titulo del libro");
                                titulo = ControlData.lerString(sc);

                                try {
                                    resultado = OperacionesBD.consultaLibroPorTitulo(miConexion, titulo);
                                } catch (OperacionBaseDatosException ex) {
                                    System.out.println(ex.getMessage());
                                }

                                System.out.println(resultado);

                                break;

                            case 2: //Buscar por ID del libro
                                //Pedir los datos
                                System.out.println("Introduce el id del libro");
                                int id = ControlData.lerInt(sc);
                                try {
                                    resultado = OperacionesBD.consultaLibroPorId(miConexion, id);
                                } catch (OperacionBaseDatosException ex) {
                                    System.out.println(ex.getMessage());
                                }

                                System.out.println(resultado);

                                break;
                            case 3: //Buscar libros por AUTOR
                                //Pedir los datos
                                System.out.println("Introduce el autor del libro");
                                autor = ControlData.lerString(sc);
                                try {
                                    resultado = OperacionesBD.consultaLibroPorAutor(miConexion, autor);
                                } catch (OperacionBaseDatosException ex) {
                                    System.out.println(ex.getMessage());
                                }

                                System.out.println(resultado);

                                break;
                            case 4: //Buscar libros por PRECIO
                                //Pedir los datos
                                System.out.println("Introduce el PRECIO del libro");
                                precio = ControlData.lerDouble(sc);
                                try {
                                    resultado = OperacionesBD.consultaLibroPorPrecio(miConexion, precio);
                                } catch (OperacionBaseDatosException ex) {
                                    System.out.println(ex.getMessage());
                                }

                                System.out.println(resultado);

                                break;
                            case 5: {
                                try {
                                    //Ver todos los libros de la tabla LIBROS
                                    resultado = OperacionesBD.consultaTodoLosLibros(miConexion);
                                } catch (OperacionBaseDatosException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }
                            System.out.println(" " + resultado);

                            break;

                        }
                        break;

                    case 5:
                        System.out.println("Hasta luego!!!");
                        finalizar = true;
                }
            } while (!finalizar);

        } catch (SQLException e) {
            System.out.println("Se ha producido una excepcion " + e.getMessage()
                    + " El programa se cerrará. /n Consulte con el responsable");
        } finally {//Cerrar conexión y flujo de entrada estándar

            sc.close();
        }

    }

    /**
     * Dibuja un menú en la consola a partir con unas opciones determinadas
     */
    static byte pintarMenu() {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones;
        misOpciones = new ArrayList<String>() {
            {
                add("CREAR BASE DE DATOS");
                add("ALTAS");
                add("BAJAS");
                add("CONSULTAS");
                add("FINALIZAR");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*************************GESTION DE BIBLIOTECA*************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (NumeroFueraRangoException e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }

    static byte pintarSubMenuConsultas() {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones;
        misOpciones = new ArrayList<String>() {
            {
                add("Ver Libro por TITULO");
                add("Ver Libro por ID");
                add("Ver Libros por AUTOR");
                add("Ver Libros por PRECIO");
                add("Ver todos los libros");
                add("Finalizar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*********************BÚSQUEDAS EN BIBLIOTECA*******************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (NumeroFueraRangoException e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }

}
