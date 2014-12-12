/**
 * 
 */
package com.gleydson.jword.exception;

/**
 * @author gleydson
 *
 */
public class JWordException extends Exception{
	
	public JWordException() {
		super("Causa do erro : Desconhecida");
	}

	public JWordException(String mensagem) {
		super(mensagem);
	}
}
