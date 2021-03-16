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
package gal.teis.libreriadam;

import gal.teis.excepciones.ValidacionException;

/**
 *
 * @author Esther Ferreiro
 */
public class ValidacionData {

    public static void validarNIF(String nif) throws ValidacionException {
        boolean bad = false;

        if (nif.length() != 9) {

            throw new ValidacionException("NIF", "Error: longitud incorrecta (9 caractares)\n");

        } else if (!nif.substring(0, 8).matches("[0-9]*")) {

            throw new ValidacionException("NIF", "Error: los primeros 8 digitos tienen que ser números\n");
            
        } else if (!nif.substring(8).matches("[aA-zZ]")) {

            throw new ValidacionException("NIF", "Error: el 9 digito tiene que ser una letra\n");
            
        }

    }
}
