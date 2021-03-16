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
public class TipoNotIntException extends Exception {

    public TipoNotIntException() {
        super ("O valor introducido non se corresponde cun número de tipo" +
                " byte que se caracteriza por ser un enteiro entre "+
                Integer.MIN_VALUE+" y "+Integer.MAX_VALUE);  
    }
    
}
