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
public class TipoNotNomeException extends Exception {

    public TipoNotNomeException() {
        super ("Error. Só se adminten letras nos datos introducidos");  
    }
    
}
