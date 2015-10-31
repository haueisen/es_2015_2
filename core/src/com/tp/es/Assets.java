package com.tp.es;

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

    public static Sprite botao;
    public static Sprite botaoPressionado;
    public static Sprite botaoDesativado;

    public static FileHandle bitmapFontFile;
    public static FileHandle bitmapFontImage;

    public static Sprite loadSprite(String file) {
        Texture tex =  new Texture(Gdx.files.internal(file));
        return new Sprite(tex);
    }

    public static void load() {

        botao = loadSprite("button_placeholder.png");
        botaoPressionado = loadSprite("button_placeholder_down.png");
        botaoDesativado = loadSprite("button_placeholder_disabled.png");
        tela1Ref = loadSprite("tela1_referencia.png");
        tela2Ref = loadSprite("tela2_referencia.png");

        bitmapFontFile = new FileHandle("font.fnt");
        bitmapFontImage = new FileHandle("font.png");
    }
}
