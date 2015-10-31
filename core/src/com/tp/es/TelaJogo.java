package com.tp.es;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Flavio Haueisen on 10/31/15.
 */
public class TelaJogo extends ScreenAdapter {

    private boolean clicou = false;
    private boolean clicando = false;
    private Vector2 clique;

    private GameClass jogo;

    private Botao botaoConselho;
    private Botao botaoAvaliacao;
    private Array<Botao> botoesCompra;
    private Botao computador;

    private BitmapFont font;
    private String nomeJogador;
    private String quantidadeDinheiroTexto;
    private String nivelMaturidadeTexto;
    private String progressoLinhasCodigo;

    private int contadorTemporario;

    public TelaJogo(GameClass tp)
    {
        this.jogo = tp;

        font = new BitmapFont(Assets.bitmapFontFile,Assets.bitmapFontImage,false);

        nomeJogador = "Jogador";
        quantidadeDinheiroTexto = "$";
        nivelMaturidadeTexto = "-";
        progressoLinhasCodigo = "000/100";

        botaoConselho = new Botao(Assets.botao,Assets.botaoPressionado,Assets.botaoDesativado,(int)(Gdx.graphics.getWidth()*0.36f),(int)(Gdx.graphics.getHeight()*0.95f),160,40,true);
        botaoAvaliacao = new Botao(Assets.botao,Assets.botaoPressionado,Assets.botaoDesativado,(int)(Gdx.graphics.getWidth()*0.60f),(int)(Gdx.graphics.getHeight()*0.95f),160,40,true);
        computador = new Botao(Assets.botao,Assets.botaoPressionado,Assets.botaoDesativado,(int)(Gdx.graphics.getWidth()*0.13f),(int)(Gdx.graphics.getHeight()*0.5f),125,125,true);


        botaoConselho.setTexto("Conselho");
        botaoAvaliacao.setTexto("Avaliacao");
        computador.setTexto("PC");

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

        clique = new Vector2(-1,-1);

        contadorTemporario = 0;
    }

    void update(float deltatime)
    {
        //----input-------------------
        if (!clicando && !clicou) {
            clique.set(-1, -1);
        }
        //---------------------------
       if(computador.verificaCliqueBotao(clique) && clicou)
       {
           contadorTemporario = contadorTemporario + 1;
           if(contadorTemporario < 10)
                progressoLinhasCodigo = "00"+contadorTemporario+"/100";
           else if(contadorTemporario < 100)
               progressoLinhasCodigo = "0"+contadorTemporario+"/100";
           else if(contadorTemporario == 10)
               progressoLinhasCodigo = "100/100";
           else {
               contadorTemporario = 0;
               progressoLinhasCodigo = "100/100";
           }
       }

        botaoConselho.verificaCliqueBotao(clique);
        botaoAvaliacao.verificaCliqueBotao(clique);

        clicou = false;
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        jogo.batch.begin();

        //Assets.tela2Ref.draw(jogo.batch);

        computador.draw(jogo.batch);

        botaoConselho.draw(jogo.batch);
        botaoAvaliacao.draw(jogo.batch);

        font.draw(jogo.batch,progressoLinhasCodigo,Gdx.graphics.getWidth()*0.06f,Gdx.graphics.getHeight()*0.75f);
        font.draw(jogo.batch,nomeJogador,Gdx.graphics.getWidth()*0.75f,Gdx.graphics.getHeight()*0.98f);
        font.draw(jogo.batch,quantidadeDinheiroTexto,Gdx.graphics.getWidth()*0.75f,Gdx.graphics.getHeight()*0.89f);
        font.draw(jogo.batch,nivelMaturidadeTexto,Gdx.graphics.getWidth()*0.75f,Gdx.graphics.getHeight()*0.80f);

        jogo.batch.end();
    }
}
