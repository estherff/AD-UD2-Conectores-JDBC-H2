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
public class TipoNotLongException extends Exception {

    public TipoNotLongException() {
        super ("O valor introducido non se corresponde cun número de tipo" +
                " long que se caracteriza por ser un enteiro entre "+
                Long.MIN_VALUE+" y "+Long.MAX_VALUE);  
    }
    
}
