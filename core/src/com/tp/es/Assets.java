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

    public static Sprite botaoNext;
    public static Sprite botaoNextPressionado;
    public static Sprite botaoNextDesativado;

    public static Sprite botaoObj;
    public static Sprite botaoObjPressionado;
    public static Sprite botaoObjDesativado;

    public static Sprite botaoTitulo;
    public static Sprite botaoTituloPressionado;
    public static Sprite botaoTituloDesativado;

    public static Sprite botaoTop;
    public static Sprite botaoTopPressionado;
    public static Sprite botaoTopDesativado;

    public static FileHandle bitmapFont18File;
    public static FileHandle bitmapFont18Image;

    public static FileHandle bitmapFont24File;
    public static FileHandle bitmapFont24Image;

    public static FileHandle bitmapFont32File;
    public static FileHandle bitmapFont32Image;

    public static Sprite loadSprite(String file) {
        Texture tex =  new Texture(Gdx.files.internal(file));
        return new Sprite(tex);
    }

    public static void load() {

        botao = loadSprite("button.png");
        botaoPressionado = loadSprite("button_down.png");
        botaoDesativado = loadSprite("button_disabled.png");

        botaoNext = loadSprite("button_prox.png");
        botaoNextPressionado = loadSprite("button_prox_down.png");
        botaoNextDesativado = loadSprite("button_prox_disabled.png");

        botaoObj = loadSprite("button_obj.png");
        botaoObjPressionado = loadSprite("button_obj_down.png");
        botaoObjDesativado = loadSprite("button_obj_disabled.png");

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

        bitmapFont18File = Gdx.files.internal("Arial18.fnt");
        bitmapFont18Image =Gdx.files.internal("Arial18_00.png");

        bitmapFont24File = Gdx.files.internal("Arial24.fnt");
        bitmapFont24Image =Gdx.files.internal("Arial24_00.png");

        bitmapFont32File = Gdx.files.internal("Arial32.fnt");
        bitmapFont32Image =Gdx.files.internal("Arial32_00.png");

    }
}
