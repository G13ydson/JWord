/**
 * 
 */
package com.gleydson.jword.visualizacao;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gleydson.jword.R;
import com.gleydson.jword.exception.JWordException;
import com.gleydson.jword.fachada.Fachada;
import com.gleydson.jword.modelo.ImagemLetras;
import com.gleydson.jword.negocio.LoopDoJogo;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author gleydson
 *
 */
public class VisualizacaoDoJogo extends SurfaceView {
	private SurfaceHolder titular;
	private LoopDoJogo loop;
	private List<ImagemLetras> letras = new ArrayList<ImagemLetras>();
	private long ultimoClick;
	private Bitmap imagemSorteada;
	private Fachada fch;
	private Resources res = getResources();
	private Bitmap bitmap;
	private Rect dest;
	Paint paint = new Paint();
	
	

	public VisualizacaoDoJogo(Context context) {
		super(context);
		fch = new Fachada();
		loop = new LoopDoJogo(this);
		titular = getHolder(); //Método que acessa a superficie 
		
		titular.addCallback(new SurfaceHolder.Callback() { 
			//Responsável pelo controle da thread secundária de 
			//desenho, iniciando e parando a thread


			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub

			}

			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				try {
					bitmap = BitmapFactory.decodeResource(res, R.drawable.background);
					dest = new Rect(0, 0, getWidth(), getHeight());
					paint.setFilterBitmap(true);
					carregaImagemSorteada(); //
					criarLetras();
					loop.setRodando(true);
					loop.start();
				} catch (JWordException e) {
					System.out.println("ERRO");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("ERRO");
					e.printStackTrace();
				}

			}

			@Override
			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void criarLetras() {

		letras.add(criarLetra('A', R.drawable.letraa));
		letras.add(criarLetra('B', R.drawable.letrab));
		letras.add(criarLetra('C', R.drawable.letrac));
		letras.add(criarLetra('D', R.drawable.letrad));
		letras.add(criarLetra('E', R.drawable.letrae));
		letras.add(criarLetra('F', R.drawable.letraf));
		letras.add(criarLetra('G', R.drawable.letrag));
		letras.add(criarLetra('H', R.drawable.letrah));
		letras.add(criarLetra('I', R.drawable.letrai));
		letras.add(criarLetra('J', R.drawable.letraj));
		letras.add(criarLetra('K', R.drawable.letrak));
		letras.add(criarLetra('L', R.drawable.letral));
		letras.add(criarLetra('M', R.drawable.letram));
		letras.add(criarLetra('N', R.drawable.letran));
		letras.add(criarLetra('O', R.drawable.letrao));
		letras.add(criarLetra('P', R.drawable.letrap));
		letras.add(criarLetra('Q', R.drawable.letraq));
		letras.add(criarLetra('R', R.drawable.letrar));
		letras.add(criarLetra('S', R.drawable.letras));
		letras.add(criarLetra('T', R.drawable.letrat));
		letras.add(criarLetra('U', R.drawable.letrau));
		letras.add(criarLetra('V', R.drawable.letrav));
		letras.add(criarLetra('W', R.drawable.letraw));
		letras.add(criarLetra('X', R.drawable.letrax));
		letras.add(criarLetra('Y', R.drawable.letray));
		letras.add(criarLetra('Z', R.drawable.letraz));

	}

	/** Método para desenhar na tela*/
	public void onDraw(Canvas canvas) {
		canvas.drawBitmap(bitmap, null, dest, paint);
		//canvas.drawColor(Color.BLUE);
		for (ImagemLetras letra : letras) {
			letra.onDraw(canvas);
		}
		loop.setRodando(fch.jogoAcabou());
		mostrarPainel(canvas);
		mostrarPlacar(canvas);

	}

	public void carregaImagemSorteada() throws JWordException, IOException {
		fch.iniciarJogo(1);
		FileInputStream fis = new FileInputStream(
				"data/data/com.gleydson.jword/imagens/" + fch.carregarImagem());
		BufferedInputStream buf = new BufferedInputStream(fis);
		this.imagemSorteada = BitmapFactory.decodeStream(buf);
	}

	public void mostrarPainel(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.DKGRAY);
		canvas.drawRect(0, 0, 500, 100, paint);
		canvas.drawBitmap(this.imagemSorteada, 200, 5, null);
	}

	public void mostrarPlacar(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setStyle(Style.FILL);
		paint.setTextSize(18);
		canvas.drawText("ACERTOS :" + Integer.toString(fch.getAcertos()), 10,
				20, paint);
		paint.setColor(Color.RED);
		canvas.drawText("ERROS :" + Integer.toString(fch.getErros()), 10, 60,
				paint);
	}

	private ImagemLetras criarLetra(char nomeDaletra, int source) {
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), source);
		return new ImagemLetras(nomeDaletra, this, bmp);
	}

	public boolean onTouchEvent(MotionEvent event) {
		// Por algum motivo está dando dois cliques, dessa forma pega-se o tempo do ultimo clique e
		// não é clicado novamente.
		if (System.currentTimeMillis() - ultimoClick > 500) {
			ultimoClick = System.currentTimeMillis();		
				for (int i = letras.size() - 1; i >= 0; i--) {
					ImagemLetras letra = letras.get(i);
					if (letra.isClicou(event.getX(), event.getY())) {
						fch.temLetra(letra.getNome());
						break;
					}
				}
		}
		return false;
	}

}