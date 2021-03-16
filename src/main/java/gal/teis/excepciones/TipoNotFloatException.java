/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones;

/**
 *
 * @author Esther Ferreiro
 */
public class TipoNotFloatException extends Exception {

    public TipoNotFloatException() {
        super ("O valor introducido non se corresponde cun número de tipo" +
                " float que se caracteriza por ser un real entre "+
                Float.MIN_VALUE+" y "+Float.MAX_VALUE);  
    }
    
}
