/**
 * 
 */
package com.gleydson.jword.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import com.gleydson.jword.exception.JWordException;
import com.gleydson.jword.modelo.Imagem;


/**
 * @author gleydson
 *
 */
public class GerenciadorDeArquivo {
	private Scanner ler;

	public void abrirArquivo(String arquivo) throws JWordException {
		try {
			ler = new Scanner(new File("data/data/com.gleydson.jword/"+ arquivo));
		} catch (FileNotFoundException exc) {
			StringBuffer mensagem = new StringBuffer(
					"Não foi possível encontrar o arquivo");
			mensagem.append("\nMotivo: " + exc.getMessage());
			throw new JWordException(mensagem.toString());
		}
	}

	public Imagem lerArquivo() throws JWordException {
		Imagem imagem = new Imagem();
		Imagem imagemTemp;
		String linhaArquivo;
		try {
			linhaArquivo = ler.nextLine();
			while (ler.hasNext()) {
				linhaArquivo = ler.nextLine();
				try {
					imagemTemp = new Imagem(linhaArquivo);
				} catch (Exception exc) {
					throw new JWordException("Erro ao ler a linha do arquivo");
				}
				imagem.adicionaImagem(imagemTemp);
			}
			ler.close();
			return imagem;
		} catch (NoSuchElementException exc) {
			throw new JWordException("arquivo sem conteï¿½do");
		} catch (IllegalStateException exc) {
			throw new JWordException("Erro na leitura do arquivo");
		} catch (ArrayIndexOutOfBoundsException exc) {
			throw new JWordException("Vetor menor que arquivo");
		}

	}

	public void finalizaArquivo() {
		if (ler != null) {
			ler.close();
		}
	}
}
