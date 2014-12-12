/**
 * Classe concreta que representa uma imagem
 */
package com.gleydson.jword.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author gleydson
 *
 */
public class Imagem {
	private String nome;
	private String imagem;
	private List<Imagem> imagens = new ArrayList<Imagem>();
	
	public Imagem(String nome, String imagem) {
		this.nome = nome;
		this.imagem = imagem;
	}

	public Imagem(String arquivo) {
		StringTokenizer token = new StringTokenizer(arquivo, ";");
		this.nome = token.nextToken();
		this.imagem = token.nextToken();
	}

	public Imagem() {
		this.nome = "";
		this.imagem = "";
	}

	public String getNome() {
		return nome;
	}

	public String getImagem() {
		return imagem;
	}
	
	public void adicionaImagem(Imagem imagem){
		imagens.add(imagem);
	}
	
	public Imagem getImagem(int indice){
		return imagens.get(indice);
	}
	
	public Imagem sorteiaImagemLista(){
		System.out.println(imagens);
		Collections.shuffle(imagens);
		return imagens.get(2);
	}
	
	public int getTamanhoListaImagem(){
		return imagens.size();
	}
	
}
