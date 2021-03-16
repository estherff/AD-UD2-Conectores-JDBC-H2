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
public class TipoNotShortException extends Exception {

    public TipoNotShortException() {
        super ("O valor introducido non se corresponde cun número de tipo" +
                " short que se caracteriza por ser un enteiro entre "+
                Short.MIN_VALUE+" y "+Short.MAX_VALUE);  
    }
    
}
