/**
 * Classe concreta que representa a Imagem das Letras
 */
package com.gleydson.jword.modelo;

import java.util.Random;

import com.gleydson.jword.visualizacao.VisualizacaoDoJogo;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * @author gleydson
 *
 */
public class ImagemLetras {
	private char nome;
	private int x; 
	private int y; 
	private int velocidadeX;
	private int velocidadeY;
	private Bitmap bmp;
	private int larguraImg;
	private int alturaImg;
	private VisualizacaoDoJogo visualizacao;

	public ImagemLetras(char nomeDaLetra, VisualizacaoDoJogo visualizacao, Bitmap bmp) {
		this.nome = nomeDaLetra;
		this.bmp = bmp;
		this.visualizacao = visualizacao;
		this.larguraImg = bmp.getWidth();
		this.alturaImg = bmp.getHeight();
		Random randon = new Random();
		x = randon.nextInt(visualizacao.getWidth() - larguraImg);
		y = randon.nextInt(visualizacao.getHeight() - alturaImg);
		velocidadeX = randon.nextInt(10) - 5;
		velocidadeY = randon.nextInt(10) - 5;
	}

	private void update() {

		if (x > visualizacao.getWidth() - larguraImg - velocidadeX
				|| x + velocidadeX < 0) {

			velocidadeX = -velocidadeX;

		}
		x = x + velocidadeX;

		if (y > visualizacao.getHeight() - alturaImg - velocidadeY
				|| y + velocidadeY < 0) {

			velocidadeY = -velocidadeY;

		}

		y = y + velocidadeY;

	}

	public void onDraw(Canvas canvas) {
		update();
		canvas.drawBitmap(bmp, x, y, null);

	}
	// Verifica se a imagem foi clicada
	public boolean isClicou(float x2, float y2) {
		return x2 > x && x2 < x + larguraImg && y2 > y && y2 < y + alturaImg;
	}
	
	public char getNome(){
		return this.nome;
	}

}
