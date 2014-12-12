/**
 * 
 */
package com.gleydson.jword.negocio;

import java.util.NoSuchElementException;

import com.gleydson.jword.exception.JWordException;
import com.gleydson.jword.modelo.Imagem;
import com.gleydson.jword.persistencia.GerenciadorDeArquivo;

/**
 * @author gleydson
 *
 */
public class Level {
private GerenciadorDeArquivo gerenciador;

	
	public Imagem iniciarLevel(int level) throws JWordException {
		Imagem imagem;
		gerenciador = new GerenciadorDeArquivo();
		gerenciador.abrirArquivo("NIVEL" + level + ".txt");
		try {
			imagem = gerenciador.lerArquivo();
			return imagem.sorteiaImagemLista();
			//return vetorImagens.sorteiaImagem();
		} catch (NoSuchElementException exc) {
			// Implementar o erro
		}
		return null;
	}
}
