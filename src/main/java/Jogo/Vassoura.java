package Jogo;

import Telas.selecaoPersonagem;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Vassoura {

    int valorSelecaoP = selecaoPersonagem.getSelecaoP();
    private int x, y;
    private int dx, dy;
    private int altura, largura;
    private Image imagem;
    private boolean isVisivel;
    private List<Feitico> misseis;

    public Vassoura() {

        if (valorSelecaoP == 1) {
        	ImageIcon referenciaImg = new ImageIcon(getClass().getResource("/Images/ronVassoura.png"));
            imagem = referenciaImg.getImage();
            altura = imagem.getHeight(null);
            largura = imagem.getWidth(null);
            misseis = new ArrayList<Feitico>();
            this.x = 100;
            this.y = 100;
        } else if (valorSelecaoP == 2) {
        	ImageIcon referenciaImg = new ImageIcon(getClass().getResource("/Images/harryVassoura.png"));
            imagem = referenciaImg.getImage();
            altura = imagem.getHeight(null);
            largura = imagem.getWidth(null);
            misseis = new ArrayList<Feitico>();
            this.x = 100;
            this.y = 100;
        } else if (valorSelecaoP == 3) {
        	ImageIcon referenciaImg = new ImageIcon(getClass().getResource("/Images/hermioneVassoura.png"));
            imagem = referenciaImg.getImage();
            altura = imagem.getHeight(null);
            largura = imagem.getWidth(null);
            misseis = new ArrayList<Feitico>();
            this.x = 100;
            this.y = 100;
        }else{
        	ImageIcon referenciaImg = new ImageIcon(getClass().getResource("/Images/harryVassoura.png"));
            imagem = referenciaImg.getImage();
            altura = imagem.getHeight(null);
            largura = imagem.getWidth(null);
            misseis = new ArrayList<Feitico>();
            this.x = 100;
            this.y = 100;
        }
    }

    public void mover() {
        x += dx;
        y += dy;

        if (this.x < 1) {
            x = 1;
        }

        if (this.x > 590) {
            x = 462;
        }

        if (this.y < 1) {
            y = 1;
        }

        if (this.y > 590) {
            y = 340;
        }
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public List<Feitico> getMisseis() {
        return misseis;
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

    public void atirar() {
        this.misseis.add(new Feitico(x + largura, y + altura / 2));
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

    public void keyPressed(KeyEvent tecla) {

        int tecla_cod = tecla.getKeyCode();

        switch (tecla_cod) {

            case (KeyEvent.VK_SPACE):
                atirar();
                break;

            case (KeyEvent.VK_UP):
                dy = -1;
                break;

            case (KeyEvent.VK_DOWN):
                dy = +1;
                break;

            case (KeyEvent.VK_LEFT):
                dx = -1;
                break;

            case (KeyEvent.VK_RIGHT):
                dx = +1;
                break;
        }
    }

    public void keyReleased(KeyEvent tecla) {
        int tecla_cod = tecla.getKeyCode();

        switch (tecla_cod) {

            case (KeyEvent.VK_UP):
                dy = 0;
                break;

            case (KeyEvent.VK_DOWN):
                dy = 0;
                break;

            case (KeyEvent.VK_LEFT):
                dx = 0;
                break;

            case (KeyEvent.VK_RIGHT):
                dx = 0;
                break;
        }
    }

}
