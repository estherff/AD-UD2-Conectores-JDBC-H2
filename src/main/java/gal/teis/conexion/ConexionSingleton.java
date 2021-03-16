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
package gal.teis.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * Se crea el objeto de la conexión de la base de datos utilizando el patrón
 * Singleton con el objetivo de que solo pueda existir una instancia del mismo
 * en el proyecto Java.
 *
 * El patrón Singleton se construye con un constructor privado que es llamado
 * por un método publico y estático (getConexionSingleton) que analiza si ya
 * está creada una instancia de la clase, en cuyo caso la devuelve y si no está
 * creada, la crea. De esta forma, cada vez que se necesita abrir una conexión
 * de la base de datos se puede llamar al método getConexionSingleton con la
 * garantía de que no duplicará las conexiones y siempre nos devolverá la
 * conexión abierta o abrirá una nueva si es necesario.
 *
 * @author Esther Ferreiro
 */
public class ConexionSingleton {

    private final String cadenaConexion;
    private final Connection laConexion;

    private static ConexionSingleton laConexionSingelton;

    /**
     * Devuelve una conexión de la base de datos y garantiza que solo existirá
     * una instancia de la misma.
     *
     * @param cadenaConexion La cadena de conexión de la base de datos
     * @return una instancia de la conexión a una base de datos
     */
    public static Connection getConnection(String cadenaConexion)
            throws SQLException {
        if (Objects.isNull(laConexionSingelton)) {
            laConexionSingelton = new ConexionSingleton(cadenaConexion);
        }
        return laConexionSingelton.laConexion;
    }

    public static Connection getConnection(String cadenaConexion, String usuario, String pass)
            throws SQLException {
        if (Objects.isNull(laConexionSingelton)) {
            laConexionSingelton = new ConexionSingleton(cadenaConexion,usuario,pass);
        }
        return laConexionSingelton.laConexion;
    }

    /**
     * Constructor privado que es llamado por el método público y estático de la
     * clase para garantizar la existencia de una única instancia de la misma.
     *
     * @param url
     * @param baseDatos
     */
    private ConexionSingleton(String cadenaConexion) throws SQLException {
        this.cadenaConexion = cadenaConexion;
        this.laConexion = DriverManager.getConnection(cadenaConexion);
    }

    private ConexionSingleton(String cadenaConexion, String username, String password) throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", username);
        connectionProps.put("password", password);
        //connectionProps.put("serverTimezone", "UTC");

        this.cadenaConexion = cadenaConexion;
        this.laConexion = DriverManager.getConnection(cadenaConexion, connectionProps);
    }
}
