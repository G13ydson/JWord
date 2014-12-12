/**
 * 
 */
package com.gleydson.jword.fachada;

import android.content.Context;

import com.gleydson.jword.exception.JWordException;
import com.gleydson.jword.negocio.Level;
import com.gleydson.jword.negocio.Jogo;
import com.gleydson.jword.visualizacao.VisualizacaoDoJogo;

/**
 * @author gleydson
 *
 */
public class Fachada {
	
	private Jogo jogo = new Jogo();
	private Level level = new Level();
	public void iniciarJogo(int nivel) throws JWordException {
		jogo.iniciarJogo(nivel);
	}

	public void iniciarDesafio(int level) throws JWordException {
		this.level.iniciarLevel(level);
	}

	public String carregarImagem() {
		return jogo.getImagem();
	}

	public void temLetra(char letra) {
		jogo.temLetra(letra);
	}

	public VisualizacaoDoJogo MostrarVisualizacao(Context context) {
		return new VisualizacaoDoJogo(context);
	}

	public boolean isGanhou() {
		return jogo.isVenceu();
	}

	public boolean isPerdeu() {
		return jogo.isPerdeu();
	}

	public void diminuitTempo() {

	}

	public void proximaImagem() {

	}

	public boolean jogoAcabou() {
		return jogo.jogoAcabou();
	}

	public int getErros() {
		return jogo.getErros();
	}

	public void setErros(int erro) {
		this.jogo.setErros(erro);
	}

	public int getAcertos() {
		return jogo.getAcertos();
	}

	public void setAcertos(int acertos) {
		this.jogo.setAcertos(acertos);
	}
}
