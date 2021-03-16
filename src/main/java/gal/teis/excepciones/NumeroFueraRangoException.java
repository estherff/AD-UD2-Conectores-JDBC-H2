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
public class NumeroFueraRangoException extends Exception {

    public NumeroFueraRangoException(int i_rango, int f_rango) {
        super ("Nº fuera de rango, debe introducir un nº entero >= "+
                i_rango+" y <= "+f_rango);
    }
    
}
