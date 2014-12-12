/**
 * 
 */
package com.gleydson.jword.negocio;

import android.graphics.Canvas;

import com.gleydson.jword.visualizacao.VisualizacaoDoJogo;

/**
 * @author gleydson
 *
 */
public class LoopDoJogo extends Thread {
	private VisualizacaoDoJogo visualizacao;
	private boolean rodando = false;

	public LoopDoJogo(VisualizacaoDoJogo visualizacao) {
		this.visualizacao = visualizacao;
	}

	public void setRodando(boolean rodando) {
		this.rodando = rodando;
	}

	@Override
	public void run() {

		while (rodando) {
			Canvas c = null;
			try {
				//retorna o objeto canvas para desenho na superficie
				c = visualizacao.getHolder().lockCanvas();
				visualizacao.onDraw(c);
				
			} finally {
				if (c != null) {
					visualizacao.getHolder().unlockCanvasAndPost(c);
				}
			}
		
		}

	}
}
