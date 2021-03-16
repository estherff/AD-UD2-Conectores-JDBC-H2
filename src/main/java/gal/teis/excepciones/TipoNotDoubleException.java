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
public class TipoNotDoubleException extends Exception {

    public TipoNotDoubleException() {
        super ("O valor introducido non se corresponde cun número de tipo" +
                " double que se caracteriza por ser un real entre "+
                Double.MIN_VALUE+" y "+Double.MAX_VALUE);  
    }
    
}
