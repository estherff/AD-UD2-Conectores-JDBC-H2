/*
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package gal.teis.libreriadam;

import gal.teis.excepciones.*;
import java.util.Scanner;

/**
 * @author Amalia Falcon Conten distintos métodos estáticos que validan o tipo
 * de datos que se lee mediante Scanner
 */
public class ControlData {

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetros
     *
     * @param sc Tipo Scanner
     * @return Tipo byte - valor de tipo byte introducido por teclado
     */
    public static byte lerByte(Scanner sc) {
        byte valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextByte()) {
                valor = sc.nextByte();
                repetir = false;
            } else {
                System.out.println("\tERRO: debe introducir un valor numérico. "
                        + "\n\t\tVolva a introducir un número: \n");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla que unha cadea poida convertirse en byte e se non ocorre lánzase
     * unha instrucción propia
     *
     * @param cadea Tipo String - cadea orixinal que debe poder transformarse en
     * byte
     * @return Tipo byte, resultado de converter a cadea nun valor de tipo byte
     * @throws gal.teis.excepciones.TipoNotByteException
     */
    public static byte lerByte(String cadea) throws TipoNotByteException {
        byte valor = 0;

        try {

            valor = Byte.valueOf(cadea);

        } catch (NumberFormatException e) {

            throw new TipoNotByteException();
        }
        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return valor Tipo short, valor de tipo short introducido por teclado
     */
    public static short lerShort(Scanner sc) {
        short valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextShort()) {
                valor = sc.nextShort();
                repetir = false;
            } else {
                System.out.println("\tERRO: debe introducir un valor numérico. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla que unha cadea poida convertirse en short e se non ocorre
     * lánzase unha instrucción propia
     *
     * @param cadea Tipo String - cadea orixinal que debe poder transformarse en
     * short
     * @return valor Tipo short resultado de converter a cadea en un valor de
     * tipo short
     * @throws gal.teis.excepciones.TipoNotShortException
     */
    public static short lerShort(String cadea) throws TipoNotShortException {
        short valor = 0;

        try {

            valor = Short.valueOf(cadea);

        } catch (NumberFormatException e) {

            throw new TipoNotShortException();
        }
        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo int - valor de tipo int introducido por teclado
     */
    public static int lerInt(Scanner sc) {
        int valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                repetir = false;
            } else {
                System.out.println("\tERRO: debe introducir un valor numérico. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla que unha cadea poida convertirse en long e se non ocorre lánzase
     * unha instrucción propia
     *
     * @param cadea Tipo String - cadea orixinal que debe poder transformarse en
     * long
     * @return valor Tipo long resultado de converter a cadea en un valor de
     * tipo long
     * @throws gal.teis.excepciones.TipoNotIntException
     */
    public static int lerInt(String cadea) throws TipoNotIntException {
        int valor = 0;

        try {

            valor = Integer.valueOf(cadea);

        } catch (NumberFormatException e) {

            throw new TipoNotIntException();
        }
        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo long - valor de tipo long introducido por teclado
     */
    public static long lerLong(Scanner sc) {
        long valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextLong()) {
                valor = sc.nextLong();
                repetir = false;
            } else {
                System.out.println("\tERRO: debe introducir un valor numérico. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla que unha cadea poida convertirse en long e se non ocorre lánzase
     * unha instrucción propia
     *
     * @param cadea Tipo String - cadea orixinal que debe poder transformarse en
     * long
     * @return valor Tipo long resultado de converter a cadea en un valor de
     * tipo long
     * @throws gal.teis.excepciones.TipoNotLongException
     */
    public static long lerLong(String cadea) throws TipoNotLongException {
        long valor = 0;

        try {

            valor = Long.valueOf(cadea);

        } catch (NumberFormatException e) {

            throw new TipoNotLongException();
        }
        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo float - valor de tipo float introducido por teclado
     */
    public static float lerFloat(Scanner sc) {
        float valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextFloat()) {
                valor = sc.nextFloat();
                repetir = false;
            } else {
                System.out.println("\tERRO: debe introducir un valor decimal. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla que unha cadea poida convertirse en float e se non ocorre
     * lánzase unha instrucción propia
     *
     * @param cadea Tipo String - cadea orixinal que debe poder transformarse en
     * float
     * @return valor Tipo float resultado de converter a cadea en un valor de
     * tipo float
     * @throws gal.teis.excepciones.TipoNotFloatException
     */
    public static float lerFloat(String cadea) throws TipoNotFloatException {
        float valor = 0;

        try {

            valor = Float.valueOf(cadea);

        } catch (NumberFormatException e) {

            throw new TipoNotFloatException();
        }
        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo double - valor de tipo double introducido por teclado
     */
    public static double lerDouble(Scanner sc) {
        double valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                repetir = false;
            } else {
                System.out.println("\tERRO: debe introducir un valor decimal. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla que unha cadea poida convertirse en double e se non ocorre
     * lánzase unha instrucción propia
     *
     * @param cadea Tipo String - cadea orixinal que debe poder transformarse en
     * double
     * @return valor Tipo double resultado de converter a cadea en un valor de
     * tipo double
     * @throws gal.teis.excepciones.TipoNotDoubleException
     */
    public static double lerDouble(String cadea) throws TipoNotDoubleException {
        double valor = 0;

        try {

            valor = Double.valueOf(cadea);

        } catch (NumberFormatException e) {

            throw new TipoNotDoubleException();
        }
        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo boolean - valor de tipo boolean introducido por teclado
     */
    public static boolean lerBoolean(Scanner sc) {
        boolean valor = false;
        boolean repetir = true;

        do {
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                repetir = false;
            } else {
                System.out.println("\tERRO: debe introducir un valor booleano. "
                        + "\n\t\tVolva a introducir un booleano: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla que unha cadea poida convertirse en boolean e se non ocorre
     * lánzase unha instrucción propia
     *
     * @param cadea Tipo String - cadea orixinal que debe poder transformarse en
     * boolean
     * @return valor Tipo boolean resultado de converter a cadea en un valor de
     * tipo boolean
     * @throws gal.teis.excepciones.TipoNotBooleanException
     */
    public static boolean lerBoolean(String cadea) throws TipoNotBooleanException {
        boolean valor = false;

        try {

            valor = Boolean.valueOf(cadea);

        } catch (NumberFormatException e) {

            throw new TipoNotBooleanException();
        }
        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo String - valor de tipo String introducido por teclado
     */
    public static String lerString(Scanner sc) {
        String resultado = null;

        do {
            resultado = sc.nextLine();
        } while (resultado.isEmpty());

        return resultado;
    }

    /**
     * Controla que un String non estea valeiro e se o está lanza unha excepción
     * propia
     *
     * @param cadea String a controlar
     * @throws gal.teis.excepciones.TipoNotStringException
     */
    public static void lerString(String cadea) throws TipoNotStringException {

        if (cadea.isEmpty()) {
            throw new TipoNotStringException();
        }

    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo char - valor de tipo char introducido por teclado
     */
    public static char lerChar(Scanner sc) {
        String resultado = null;

        do {
            resultado = sc.nextLine();

        } while (resultado.isEmpty());

        return resultado.charAt(0);
    }

    /**
     * Controla que un String sexa un caracter e se non o é lanza unha excepción
     * propia
     *
     * @param cadea caracter primero da cadea
     * @return char o caracter equivalente a cadea
     * @throws gal.teis.excepciones.TipoNotCharException
     */
    public static char lerChar(String cadea) throws TipoNotCharException {

        if (cadea.isEmpty()) {
            throw new TipoNotCharException();
        }
        return cadea.charAt(0);
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo char - valor de la pimera letra que se introduce por teclado
     */
    public static char lerLetra(Scanner sc) {
        char caracter = '\0';

        do {
            caracter = (sc.nextLine()).charAt(0);
        } while (!Character.isLetter(caracter));

        return caracter;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo String - valor de tipo String introducido por teclado
     */
    public static String lerNome(Scanner sc) {
        String nome = null;
        boolean repetir = true;

        do {
            nome = sc.nextLine();
            if (nome.isEmpty() || !nome.toUpperCase().matches("[A-ZÁÉÍÓÚÜÑ\\-\\s]*")) {
                System.out.println("\tERRO: debe introducir algún nome válido "
                        + "\n\t\tVolva a introducir: ");
            } else {
                repetir = false;
            }
        } while (repetir);

        return nome;
    }

    /**
     * Controla que unha cadea conteña só letras
     *
     * @param cadea String a controlar
     * @throws gal.teis.excepciones.TipoNotNomeException
     */
    public static void lerNome(String cadea) throws TipoNotNomeException {

        if (!(cadea.isEmpty() || !cadea.toUpperCase().matches("[A-ZÁÉÍÓÚÜÑ\\-\\s]*"))) {
            throw new TipoNotNomeException();
        }
    }
}
