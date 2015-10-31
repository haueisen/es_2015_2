package com.tp.es;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Flavio Haueisen on 10/31/15.
 */
public class Botao {

    public boolean ativo = false;
    private Sprite sprite;

    private Sprite normal;
    private Sprite pressionado;
    private Sprite desativado;

    private Vector2 centro;
    private Vector2 tamanho;

    private BitmapFont font;
    private String texto;
    private Vector2 textoPosicao;

    public Botao(Sprite sprite, Sprite sprite_down, Sprite sprite_disable, int x, int y, int w, int h, boolean ativo)
    {

        this.normal = sprite;
        this.pressionado = sprite_down;
        this.desativado = sprite_disable;

        if(ativo)
            this.sprite = new Sprite(this.normal);
        else
            this.sprite = new Sprite(this.desativado);

        this.centro =  new Vector2(x,y);
        this.tamanho =  new Vector2(w,h);

        this.sprite.setSize(tamanho.x, tamanho.y);
        this.sprite.setCenter(centro.x, centro.y);

        this.ativo = ativo;
        this.texto = "";
        this.textoPosicao = new Vector2();
        this.font = new BitmapFont(Assets.bitmapFontFile,Assets.bitmapFontImage,false);

    }

    boolean verificaCliqueBotao(Vector2 clique)
    {
        if(ativo) {
            if (sprite.getBoundingRectangle().contains(clique)) {
                sprite.setTexture(pressionado.getTexture());
                return true;
            } else {
                sprite.setTexture(normal.getTexture());
                return false;
            }
        }
        else
        {
            sprite.setTexture(desativado.getTexture());
            return false;
        }
    }

    int getAltura()
    {
       return (int) tamanho.y;
    }

    int getLargura()
    {
        return (int)tamanho.x;
    }

    void setLagura(int w)
    {
        tamanho.x = w;
        sprite.setSize(tamanho.x, tamanho.y);
    }

    void setAltura(int h)
    {
        tamanho.y = h;
        sprite.setSize(tamanho.x, tamanho.y);
    }

    void setPosicao(int x, int y)
    {
        centro.set(x,y);
        sprite.setCenter(centro.x, centro.y);
    }

    void setTexto(String str)
    {
        float x,y;

        texto = str;

        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font,texto);

        x = glyphLayout.width;
        y = glyphLayout.height;

        textoPosicao.x = centro.x - x / 2;
        textoPosicao.y = centro.y + y / 2;

    }

    void draw(SpriteBatch batch)
    {
        sprite.draw(batch);
        font.draw(batch,texto, textoPosicao.x, textoPosicao.y);
    }
}
