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
public class TipoNotCharException extends Exception {

    public TipoNotCharException() {
        super ("Error. Debe introducir un carácter");  
    }
    
}
