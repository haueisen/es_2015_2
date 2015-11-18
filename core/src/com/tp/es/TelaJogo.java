package com.tp.es;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Preferences;
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

    private Botao botaoSalvar;
    private Botao botaoConselho;
    private Botao botaoAvaliacao;
    private Array<Botao> botoesCompra;
    private Botao computador;

    private BitmapFont font;
    private String nomeJogador;
    private int quantidadeDinheiro;
    private String nivelMaturidadeTexto;
    private float progressoLinhasCodigo;
    private float totalLinhasCodigo;

    private String conselhoTexto =  "Texto aleatorio para testar Texto \n" +
                                    "aleatorio para testar Texto aleatorio \n" +
                                    "para testar Texto aleatorio para testar\n" +
                                    "Texto aleatorio para testar Texto \n" +
                                    "aleatorio para testar Texto aleatorio \n" +
                                    "para testar Texto aleatorio para testar \n" +
                                    "Texto aleatorio para testar";

    private String avaliacaoTexto = "Perg? aleatorio para testar Perg? \n" +
                                    "aleatorio para testar Perg? aleatorio \n" +
                                    "para testar Perg? aleatorio para testar\n" +
                                    "Perg? aleatorio para testar Perg? \n" +
                                    "aleatorio para testar Perg? aleatorio \n" +
                                    "para testar Perg? aleatorio para testar \n" +
                                    "Perg? aleatorio para testar";

    private String statsTexto = "Info aleatorio para testar Info \n" +
                                "aleatorio para testar Info aleatorio \n" +
                                "para testar Info aleatorio para testar\n" +
                                "Info aleatorio para testar Info \n" +
                                "aleatorio para testar Info aleatorio \n" +
                                "para testar Info aleatorio para testar \n" +
                                "Info aleatorio para testar";

    private String textoMeio;
    private int contadorTemporario;

    private Preferences prefs;

    public TelaJogo(GameClass tp)
    {
        prefs = Gdx.app.getPreferences("JogoSalvo");
        this.jogo = tp;

        font = new BitmapFont(Assets.bitmapFontFile,Assets.bitmapFontImage,false);
        font.setColor(0,0,0,1);

        botaoSalvar = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.125),(int)(Gdx.graphics.getHeight()*0.93f),160,40,true);
        botaoConselho = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.4f),(int)(Gdx.graphics.getHeight()*0.93f),160,40,true);
        botaoAvaliacao = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.60f),(int)(Gdx.graphics.getHeight()*0.93f),160,40,true);

        computador = new Botao(Assets.pc,Assets.pcPressionado,Assets.pc,(int)(Gdx.graphics.getWidth()*0.125f),(int)(Gdx.graphics.getHeight()*0.5f),125,125,true);

        botaoSalvar.setTexto("Salvar");
        botaoConselho.setTexto("Conselho");
        botaoAvaliacao.setTexto("Avaliacao");
        computador.setTexto("");

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
        nomeJogador = prefs.getString("nome", "Jogador");
        if(prefs.getBoolean("carregaSalvo",false))//
        {
            contadorTemporario = prefs.getInteger("contador", 0);
            quantidadeDinheiro = prefs.getInteger("dinheiro", 0);
            nivelMaturidadeTexto = prefs.getString("maturidade", "-");
            progressoLinhasCodigo = prefs.getFloat("progressoLinhas", 000);
            totalLinhasCodigo = prefs.getFloat("totalLinhas", 100);
        }
        else {
            contadorTemporario = 0;
            quantidadeDinheiro = 0;
            nivelMaturidadeTexto = "-";
            progressoLinhasCodigo = 000;
            totalLinhasCodigo = 100;
        }

        textoMeio = statsTexto;
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
        }
        progressoLinhasCodigo = contadorTemporario;

        if(botaoSalvar.verificaCliqueBotao(clique))
        {
            prefs.putBoolean("existeSalvo", true);
            prefs.putInteger("contador", contadorTemporario);
            prefs.putString("nome", nomeJogador);
            prefs.putInteger("dinheiro", quantidadeDinheiro);
            prefs.putString("maturidade", nivelMaturidadeTexto);
            prefs.putFloat("progressoLinhas", progressoLinhasCodigo);
            prefs.putFloat("totalLinhas", totalLinhasCodigo);
            prefs.flush();
        }
        if(botaoConselho.verificaCliqueBotao(clique) && clicou)
        {
            if(textoMeio.equals(conselhoTexto))
                textoMeio = statsTexto;
            else
                textoMeio = conselhoTexto;
        }
        if(botaoAvaliacao.verificaCliqueBotao(clique) && clicou)
        {
            if(textoMeio.equals(avaliacaoTexto))
                textoMeio = statsTexto;
            else
                textoMeio = avaliacaoTexto;
        }

        clicou = false;
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        jogo.batch.begin();

        Assets.frame.draw(jogo.batch);

        computador.draw(jogo.batch);

        botaoSalvar.draw(jogo.batch);
        botaoConselho.draw(jogo.batch);
        botaoAvaliacao.draw(jogo.batch);

        font.draw(jogo.batch,String.valueOf(progressoLinhasCodigo)+"/"+String.valueOf(totalLinhasCodigo),Gdx.graphics.getWidth()*0.06f,Gdx.graphics.getHeight()*0.75f);
        font.draw(jogo.batch,nomeJogador, Gdx.graphics.getWidth()*0.8f,Gdx.graphics.getHeight()*0.95f);
        font.draw(jogo.batch, "$ "+String.valueOf(quantidadeDinheiro),Gdx.graphics.getWidth()*0.8f,Gdx.graphics.getHeight()*0.82f);
        font.draw(jogo.batch,"Maturidade: "+nivelMaturidadeTexto,Gdx.graphics.getWidth()*0.8f,Gdx.graphics.getHeight()*0.69f);
        font.draw(jogo.batch,textoMeio,Gdx.graphics.getWidth()*0.3f,Gdx.graphics.getHeight()*0.69f);

        jogo.batch.end();
    }
}
