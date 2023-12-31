package Jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Feitico {
	
	private int x,y;
	private int altura,largura;
	private Image imagem;
	private boolean isVisivel;
	
	private static final int LARGURA_TELA = 600;
	private static final int VELOCIDADE = 3;
	
	public Feitico(int x, int y){
		this.x = x;
		this.y = y;
		
		ImageIcon referenciaImg = new ImageIcon(getClass().getResource("/Images/TiroSimples.png"));
		imagem = referenciaImg.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		isVisivel = true;
	}
	
	
	public boolean isVisivel() {
		return isVisivel;
	}


	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public Image getImagem() {
		return imagem;
	}

	public void mover(){
		this.x += VELOCIDADE;
		if(this.x > LARGURA_TELA){
			isVisivel = false;
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}

}
