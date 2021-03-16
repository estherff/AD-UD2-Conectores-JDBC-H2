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
public class ValidacionException extends Exception {

    public ValidacionException(String tipoValidacion, String causa) {
        
        super ("Error de validación en "+tipoValidacion+" debido a "+causa);
    }
    
}
