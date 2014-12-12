/**
 * 
 */
package com.gleydson.jword.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.gleydson.jword.exception.JWordException;

/**
 * @author gleydson
 *
 */
public class GerenciadorDeArquivoController {
	private Scanner leitor = null;

	public Scanner abrirArquivo(String nivel) throws JWordException {
		try {
			leitor = new Scanner(new File("data/data/com.gleydson.jword/"+ nivel));
			return leitor;
		} catch (FileNotFoundException exc) {
			StringBuffer mensagem = new StringBuffer(
					"Não foi possível encontrar o arquivo");
			mensagem.append("\nMotivo: " + exc.getMessage());
			throw new JWordException(mensagem.toString());
		}
	}
	
	public void finalizaLeitor(Scanner leitor) {
		if (leitor != null) {
			leitor.close();
		}
	}
}
