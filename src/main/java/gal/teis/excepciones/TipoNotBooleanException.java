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
public class TipoNotBooleanException extends Exception {

    public TipoNotBooleanException() {
        super ("O valor introducido non se corresponde cun número de tipo" +
                " boolean que se caracteriza permitir só os valores true e false ");  
    }
    
}
