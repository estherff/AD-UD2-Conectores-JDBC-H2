/*
 *  This program is free software: you can redistribute it and/or modify
    it under the terms OF the GNU General Public License as published by
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

import gal.teis.excepciones.NumeroFueraRangoException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Esther Ferreiro 
 * Imprime en pantalla un menú a partir dun ArrayList de
 * String que conten as opcións do menú. Permite facer un control de rango da
 * opción del menú que se introduce
 */
public class Menu {

    private ArrayList<String> opciones = new ArrayList<String>();
    private int numOpciones;

    public Menu(ArrayList opciones) {
        this.opciones = opciones;
        this.numOpciones = opciones.size();
    }

    /**
     * Imprime o menú na pantalla
     */
    public void printMenu() {
        for (int i = 1; i <= opciones.size(); i++) {
            System.out.println(i + ".- " + opciones.get(i - 1));
        }
    }

    /**
     * Comproba que o parámetro está dentro do rango de opcións coas que se 
     * creou o menú. Lanza unha excepción propia no caso de que o nº non estea 
     * dentro do rango das opcións posibles.
     *
     * @param op int - valor a analizar como pertencente ou non ao rango de
     * opcións do menú
     * @return boolean - true se está no rango e false en caso contrario
     */
    public void rango(byte op) throws NumeroFueraRangoException {
        boolean enrango = true;
        if (op < 1 || op > numOpciones) {
            enrango = false;
            throw new NumeroFueraRangoException(1,numOpciones);
        }
    }
    /**
     * Lee un n´º por teclado ata que se introduce un nº correcto para o
     * rango establecido polas opcións do menú
     * @param sc Scanner - Instancia de Scanner para ler 
     */
    public void rango(Scanner sc) {
        boolean enrango = true;
        byte op = ControlData.lerByte(sc);
        do {
            if (op < 1 || op > numOpciones) {
                enrango = false;
                System.out.println("\tERRO: debe introducir un valor dentro do rango de números posibles. "
                        + "\n\t\tVolva a introducir un número: \n");
            }
        } while (!enrango);
    }
}
