/**
 * 
 */
package com.gleydson.jword.negocio;

import com.gleydson.jword.exception.JWordException;
import com.gleydson.jword.modelo.Imagem;

/**
 * @author gleydson
 *
 */
public class Jogo {
	private int acertos;
	private int erros;
	private boolean venceu;
	private boolean perdeu;
	private String imagem;
	private String nomeImagem;
	private String palavraEscolhida;
	private Level level;

	public void iniciarJogo(int level) throws JWordException {
		Imagem img = null;
		this.level = new Level();
		img = this.level.iniciarLevel(level);// Retorna uma Imagem sorteada
		this.nomeImagem = img.getNome();
		this.nomeImagem = this.nomeImagem.toUpperCase();
		this.imagem = img.getImagem();
	}

	public boolean verificaLetra(char letra) {
		char[] vetorPalavras = new char[nomeImagem.length()];
		boolean temp = false;
		char LetraAux;
		vetorPalavras = this.nomeImagem.toCharArray();
		for (int i = 0; i < this.nomeImagem.length(); i++) {
			LetraAux = nomeImagem.charAt(i);
			if (LetraAux == letra) {
				temp = setAcertos();
			}

		}
		return temp;
	}

	public boolean jogoAcabou() {
		if ((this.erros == 5) || (this.acertos == this.nomeImagem.length())) {
			this.venceu = false;this.perdeu = true;
			return false; // Retorna False por causa da Thread setRodando
		} else {
			this.venceu = true;this.perdeu = false;
			return true;
		}
	}

	private boolean setAcertos() {
		this.acertos++;
		return true;
	}

	public int getErros() {
		return this.erros;
	}

	public void setErros(int erro) {
		this.erros = erro;
	}

	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}

	public int getAcertos() {
		return this.acertos;
	}

	public String getImagem() {
		return this.imagem;
	}

	public boolean isVenceu() {
		return venceu;
	}

	public boolean isPerdeu() {
		return perdeu;
	}

	public String getPalavraEscolhida() {
		return this.palavraEscolhida;
	}

	public void temLetra(char letra) {
		if (!verificaLetra(letra)) {
			this.erros++;
		}
	}
}
