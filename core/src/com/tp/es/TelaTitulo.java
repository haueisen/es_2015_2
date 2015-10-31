package com.tp.es;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javafx.scene.Camera;

/**
 * Created by Flavio Haueisen on 10/31/15.
 */
public class TelaTitulo extends ScreenAdapter  {


    private int estado = 0;

    private static final int MAINMENU = 0;
    private static final int CREDITS = 0;

    private boolean botaoNovoJogoPressionado = false;
    private boolean botaoContinuaJogoPressionado = false;

    private boolean clicou = false;
    private boolean clicando = false;

    private OrthographicCamera camera;
    private Viewport viewport;
    private Vector2 clique;

    private GameClass jogo;

    private Botao botaoNovoJogo;
    private Botao botaoContinuaJogo;
    private Botao botaoCreditos;

    public TelaTitulo(GameClass tp)
    {
        this.jogo = tp;

        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);

        clique = new Vector2(-1,-1);

        botaoNovoJogo = new Botao(Assets.botao,Assets.botaoPressionado,Assets.botaoDesativado,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,210,70,true);
        botaoContinuaJogo = new Botao(Assets.botao,Assets.botaoPressionado,Assets.botaoDesativado,Gdx.graphics.getWidth()/2,(int) (Gdx.graphics.getHeight()/2 - 1.05f*botaoNovoJogo.getAltura()),210,70,false);

        botaoNovoJogo.setTexto("Novo Jogo");
        botaoContinuaJogo.setTexto("Continuar");

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {

                if (pointer == 0) {
                    clique.set(x, Gdx.graphics.getHeight() - y);
                    clicando = true;
                    clicou = false;
                }
                return true;
            }

            @Override
            public boolean touchUp(int x, int y, int pointer, int button) {

                if (pointer == 0) {
                    clique.set(x, Gdx.graphics.getHeight() - y);
                    clicando = false;
                    clicou = true;
                }
                return true;
            }
        });

    }

    public void update(float deltaTime){

        //----input-------------------
        if(!clicando && !clicou)
        {
            clique.set(-1,-1);
        }
        clicou = false;
        //---------------------------
        botaoNovoJogo.verificaCliqueBotao(clique);
        botaoContinuaJogo.verificaCliqueBotao(clique);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        jogo.batch.begin();
        Assets.tela1Ref.draw(jogo.batch);

        botaoNovoJogo.draw(jogo.batch);
        botaoContinuaJogo.draw(jogo.batch);

        jogo.batch.end();
    }

}
