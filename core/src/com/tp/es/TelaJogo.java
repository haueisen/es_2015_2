package com.tp.es;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class TelaJogo extends ScreenAdapter {


    private int estado = 0;

    private static final int JOGANDO = 0;
    private static final int FEEDBACK = 1;

    private boolean clicou = false;
    private boolean clicando = false;
    private Vector2 clique;

    private GameClass jogo;

    private Botao botaoSalvar;
    private Botao botaoConselho;
    private Botao botaoAvaliacao;
    private Botao botaoStats;

    private Array<Botao> botoesCompra;
    private Botao computador;

    private BitmapFont font18;
    private BitmapFont font24;
    private BitmapFont font32;
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

    private String avaliacaoTexto = "Parabéns você atingiu o nível máximo\n de maturidade.\n";

    private String statsTexto = "Info aleatorio para testar Info \n" +
                                "aleatorio para testar Info aleatorio \n" +
                                "para testar Info aleatorio para testar\n" +
                                "Info aleatorio para testar Info \n" +
                                "aleatorio para testar Info aleatorio \n" +
                                "para testar Info aleatorio para testar \n" +
                                "Info aleatorio para testar";

    private String textoMeio;
    private boolean emAvaliacao = false;
    private boolean emAjuda = false;
    private boolean emStats = true;

    private Pergunta perg;

    private Botao botaoProxima;
    private Botao botaoAnterior;

    private Botao botaoConfirma;
    private boolean acerto = false;

    private int alternativa = 0;
    private int contadorTemporario;

    private double tempoFeedBack = 3;
    private double tempoEspera = 6;

    private double timerFeedback = 0;
    private double timerEspera = 0;

    private boolean emEspera = false;

    private Preferences prefs;

    public TelaJogo(GameClass tp)
    {
        prefs = Gdx.app.getPreferences("JogoSalvo");
        this.jogo = tp;

        font18 = new BitmapFont(Assets.bitmapFont18File,Assets.bitmapFont18Image,false);
        font18.setColor(0,0,0,1);

        font24 = new BitmapFont(Assets.bitmapFont24File,Assets.bitmapFont24Image,false);
        font24.setColor(0,0,0,1);

        font32 = new BitmapFont(Assets.bitmapFont32File,Assets.bitmapFont32Image,false);
        font32.setColor(0,0,0,1);

        botaoSalvar = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.125),(int)(Gdx.graphics.getHeight()*0.93f),160,40,true);
        botaoConselho = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.35f),(int)(Gdx.graphics.getHeight()*0.93f),160,40,true);
        botaoAvaliacao = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.65f),(int)(Gdx.graphics.getHeight()*0.93f),160,40,true);
        botaoStats = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.50f),(int)(Gdx.graphics.getHeight()*0.93f),160,40,true);

        botaoProxima = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.60f),(int)(Gdx.graphics.getHeight()*0.19f),160,40,true);
        botaoAnterior = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.40f),(int)(Gdx.graphics.getHeight()*0.19f),160,40,true);

        botaoConfirma = new Botao(Assets.botaoTop,Assets.botaoTopPressionado,Assets.botaoTopDesativado,(int)(Gdx.graphics.getWidth()*0.50f),(int)(Gdx.graphics.getHeight()*0.29f),160,40,true);


        computador = new Botao(Assets.pc,Assets.pcPressionado,Assets.pc,(int)(Gdx.graphics.getWidth()*0.125f),(int)(Gdx.graphics.getHeight()*0.5f),125,125,true);

        botaoSalvar.setTexto("Salvar");
        botaoConselho.setTexto("Ajuda");
        botaoAvaliacao.setTexto("Avaliação");
        botaoStats.setTexto("Info");
        computador.setTexto("");

        botaoProxima.setTexto("Próxima");
        botaoAnterior.setTexto("Anterior");
        botaoConfirma.setTexto("Confirma");


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


        switch(nivelMaturidadeTexto.charAt(0))
        {
            case '-':
                Jogador.nivel = 0;
                break;
            case 'G':
                Jogador.nivel = 1;
                break;
            case 'F':
                Jogador.nivel = 2;
                break;
            case 'E':
                Jogador.nivel = 3;
                break;
            case 'D':
                Jogador.nivel = 4;
                break;
            case 'C':
                Jogador.nivel = 5;
                break;
            case 'B':
                Jogador.nivel = 6;
                break;
            case 'A':
                Jogador.nivel = 7;
                break;

        }

        Perguntas.initArrays();
    }

    void update(float deltatime)
    {
        if(estado == JOGANDO) {
            //----input-------------------
            if (!clicando && !clicou) {
                clique.set(-1, -1);
            }
            //---------------------------
            if (computador.verificaCliqueBotao(clique) && clicou) {
                contadorTemporario = contadorTemporario + 1;
            }
            progressoLinhasCodigo = contadorTemporario;

            if (botaoSalvar.verificaCliqueBotao(clique)) {
                prefs.putBoolean("existeSalvo", true);
                prefs.putInteger("contador", contadorTemporario);
                prefs.putString("nome", nomeJogador);
                prefs.putInteger("dinheiro", quantidadeDinheiro);
                prefs.putString("maturidade", nivelMaturidadeTexto);
                prefs.putFloat("progressoLinhas", progressoLinhasCodigo);
                prefs.putFloat("totalLinhas", totalLinhasCodigo);
                prefs.flush();
            }

            if (botaoConselho.verificaCliqueBotao(clique) && clicou) {
                emAjuda = true;
                emStats = false;
                emAvaliacao = false;
            }
            if (botaoAvaliacao.verificaCliqueBotao(clique) && clicou) {
                emAjuda = false;
                emStats = false;
                emAvaliacao = true;

                perg = Perguntas.sorteiaPergunta(Jogador.nivel);
            }
            if (botaoStats.verificaCliqueBotao(clique) && clicou) {
                emAjuda = false;
                emStats = true;
                emAvaliacao = false;
            }


            if (emStats) {

            } else if (emAvaliacao) {
                if (botaoProxima.verificaCliqueBotao(clique) && clicou) {

                    if (alternativa < perg.numAlternativas - 1)
                        alternativa++;

                }
                if (botaoAnterior.verificaCliqueBotao(clique) && clicou) {
                    if (alternativa > 0)
                        alternativa--;
                }

                if (botaoConfirma.verificaCliqueBotao(clique) && clicou) {
                    if (alternativa == perg.correta - 1)//acerto
                    {
                        estado = FEEDBACK;
                        acerto = true;
                        Jogador.nivel++;
                        switch (Jogador.nivel) {
                            case 0:
                                nivelMaturidadeTexto = "-";
                                break;
                            case 1:
                                nivelMaturidadeTexto = "G";
                                break;
                            case 2:
                                nivelMaturidadeTexto = "F";
                                break;
                            case 3:
                                nivelMaturidadeTexto = "E";
                                break;
                            case 4:
                                nivelMaturidadeTexto = "D";
                                break;
                            case 5:
                                nivelMaturidadeTexto = "C";
                                break;
                            case 6:
                                nivelMaturidadeTexto = "B";
                                break;
                            case 7:
                                nivelMaturidadeTexto = "A";
                                break;
                        }

                    } else//erro
                    {
                        emEspera = true;
                        acerto = false;
                        estado = FEEDBACK;
                    }
                    alternativa = 0;
                    emAvaliacao = false;
                    emStats = true;
                }
            } else if (emAjuda) {

            }

            //atualizar stats com infos
            //atualizar objetos disponiveis
            //se nivel entao renderiza
            //senao nao redenriz e botao inativo
            //atualizar botoes dos objetos
            //fazer barra de rolagem
        }
        else if(estado == FEEDBACK)
        {
            timerFeedback += deltatime;
            if(timerFeedback > tempoFeedBack)
            {
                estado = JOGANDO;
                timerFeedback = 0;
            }
        }
        clicou = false;

        if(emEspera) {
            botaoConfirma.ativo = false;
            timerEspera += deltatime;
            if(timerEspera > tempoEspera)
            {
                emEspera = false;
                timerEspera = 0;
            }
        }
        else
            botaoConfirma.ativo = true;

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0.85f, 0.85f, 0.85f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        jogo.batch.begin();

        Assets.frame.draw(jogo.batch);

        computador.draw(jogo.batch);

        botaoSalvar.draw(jogo.batch);
        botaoConselho.draw(jogo.batch);
        botaoAvaliacao.draw(jogo.batch);
        botaoStats.draw(jogo.batch);

        font32.draw(jogo.batch,String.valueOf(progressoLinhasCodigo),Gdx.graphics.getWidth()* 0.06f, Gdx.graphics.getHeight()*0.65f);
        font32.draw(jogo.batch, nomeJogador, Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.95f);
        font32.draw(jogo.batch, "$ "+String.valueOf(quantidadeDinheiro),Gdx.graphics.getWidth()*0.8f,Gdx.graphics.getHeight()*0.82f);
        font32.draw(jogo.batch, "Maturidade: " + nivelMaturidadeTexto, Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.69f);

        if(estado == JOGANDO)
        {
            if (emStats)
                font32.draw(jogo.batch, textoMeio, Gdx.graphics.getWidth() * 0.3f, Gdx.graphics.getHeight() * 0.69f);
            else if (emAvaliacao) {
                if (Jogador.nivel < 7) {
                    font18.draw(jogo.batch, perg.perg, Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.79f);

                    font18.draw(jogo.batch, perg.respostas[alternativa], Gdx.graphics.getWidth() * 0.32f, Gdx.graphics.getHeight() * 0.55f);

                    botaoProxima.draw(jogo.batch);
                    botaoAnterior.draw(jogo.batch);
                    botaoConfirma.draw(jogo.batch);

                    font32.draw(jogo.batch, String.valueOf(alternativa+1)+"/"+String.valueOf(perg.numAlternativas), Gdx.graphics.getWidth() * 0.485f, Gdx.graphics.getHeight() * 0.205f);
                } else {
                    font32.draw(jogo.batch, avaliacaoTexto, Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.79f);
                }
            } else if (emAjuda) {

            }
        }
        else if(estado == FEEDBACK)
        {
            if(acerto)
                font32.draw(jogo.batch, "Resposta Correta!\nSubiu de nível!", Gdx.graphics.getWidth() * 0.35f, Gdx.graphics.getHeight() * 0.59f);
            else
                font32.draw(jogo.batch, "Resposta Errada!\nPrecisa estudar mais!", Gdx.graphics.getWidth() * 0.35f, Gdx.graphics.getHeight() * 0.59f);
        }

        jogo.batch.end();
    }
}
