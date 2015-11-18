package com.tp.es;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Flavio Haueisen on 10/31/15.
 */
public class Assets {

    public static Sprite tela1Ref;
    public static Sprite tela2Ref;

    public static Sprite frame;

    public static Sprite pc;
    public static Sprite pcPressionado;

    public static Sprite botao;
    public static Sprite botaoPressionado;
    public static Sprite botaoDesativado;

    public static Sprite botaoTitulo;
    public static Sprite botaoTituloPressionado;
    public static Sprite botaoTituloDesativado;

    public static Sprite botaoTop;
    public static Sprite botaoTopPressionado;
    public static Sprite botaoTopDesativado;

    public static FileHandle bitmapFontFile;
    public static FileHandle bitmapFontImage;

    public static Sprite loadSprite(String file) {
        Texture tex =  new Texture(Gdx.files.internal(file));
        return new Sprite(tex);
    }

    public static void load() {

        botao = loadSprite("button.png");
        botaoPressionado = loadSprite("button_down.png");
        botaoDesativado = loadSprite("button_disabled.png");

        botaoTitulo = loadSprite("button_title.png");
        botaoTituloPressionado = loadSprite("button_title_down.png");
        botaoTituloDesativado = loadSprite("button_title_disabled.png");

        botaoTop = loadSprite("button_top.png");
        botaoTopPressionado = loadSprite("button_top_down.png");
        botaoTopDesativado = loadSprite("button_top_disabled.png");

        pc = loadSprite("pc.png");
        pcPressionado = loadSprite("pc_down.png");

        tela1Ref = loadSprite("tela1_referencia.png");
        tela2Ref = loadSprite("tela2_referencia.png");

        frame = loadSprite("frame.png");

        bitmapFontFile = Gdx.files.internal("font.fnt");
        bitmapFontImage =Gdx.files.internal("font.png");
    }
}
