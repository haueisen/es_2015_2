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

    private String statsTexto1 = "Linhas de Código p/segundo (LCpS): ";
    private String statsTexto2 ="Desenvolvedores (Dev): ";
    private String statsTexto3 ="Gerente de Projeto (G.Proj.):  ";
    private String statsTexto4 ="Gerente de Qualidade (G.Qual.): ";
    private String statsTexto5 ="Gerente Comercial (G.Com.):  ";
    private String statsTexto6 ="Gerente de Configuração (G.Conf.): ";
    private String statsTexto7 ="Gerente de RH (G.RH.): ";
    private String statsTexto8 ="Gerente de Produção (G.Prod.): ";

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

    private int[] numObjetos;
    private int[] numAtualizacoes;

    private int pagina = 1;
    private int totalPaginas = 4;
    private Botao botaoProx;
    private Botao botaoAnt;

    private Botao botaodesenvolvedor;
    private Botao botaogerenteProjetos;
    private Botao botaogerenteQualidade;
    private Botao botaogerenteComercial;
    private Botao botaogerenteConfiguracao;
    private Botao botaogerenteRH;
    private Botao botaogerenteProducao;

    private Botao botaoposGerenciaRequisitos;
    private Botao botaoposMedicao;
    private Botao botaoMBAProjetos;
    private Botao botaoposGerenciaReutilizacao;
    private Botao botaoposGerenciaProcessos;

    public TelaJogo(GameClass tp)
    {

        Perguntas.initArrays();
        Objetos.intArraysObj();

        numObjetos = new int[7];
        for(int i = 0; i < 7; i++)
        {
            numObjetos[i] = 0;
        }
        numAtualizacoes = new int[5];
        for(int i = 0; i < 5; i++)
        {
            numAtualizacoes[i] = 0;
        }

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
            Jogador.dinheiro = prefs.getFloat("dinheiro", 0);
            nivelMaturidadeTexto = prefs.getString("maturidade", "-");
            progressoLinhasCodigo = prefs.getFloat("progressoLinhas", 000);
            totalLinhasCodigo = prefs.getFloat("totalLinhas", 100);
            Jogador.LCpS = prefs.getFloat("lcps",0);
            numObjetos[0] = prefs.getInteger("obj0", 0);
            numObjetos[1] = prefs.getInteger("obj1", 0);
            numObjetos[2] = prefs.getInteger("obj2", 0);
            numObjetos[3] = prefs.getInteger("obj3", 0);
            numObjetos[4] = prefs.getInteger("obj4", 0);
            numObjetos[5] = prefs.getInteger("obj5", 0);
            numObjetos[6] = prefs.getInteger("obj6", 0);
            numAtualizacoes[0] = prefs.getInteger("up0", 0);
            numAtualizacoes[1] = prefs.getInteger("up1", 0);
            numAtualizacoes[2] = prefs.getInteger("up2", 0);
            numAtualizacoes[3] = prefs.getInteger("up3", 0);
            numAtualizacoes[4] = prefs.getInteger("up4", 0);
        }
        else {
            contadorTemporario = 0;
            quantidadeDinheiro = 0;
            nivelMaturidadeTexto = "-";
            progressoLinhasCodigo = 000;
            totalLinhasCodigo = 100;
        }

        //textoMeio = statsTexto;


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


        //botoes objetos e atualizacoes
        botaodesenvolvedor = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);
        botaogerenteProjetos = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75,280,70,true);
        botaogerenteQualidade = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*2,280,70,true);
        botaogerenteComercial = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*3,280,70,true);

        botaodesenvolvedor.setTexto   ("Dev        $15");
        botaogerenteProjetos.setTexto ("G.Proj.   $100");
        botaogerenteQualidade.setTexto("G.Qual.   $500");
        botaogerenteComercial.setTexto("G.Com.   $3000");

        botaogerenteConfiguracao = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);
        botaogerenteRH = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75,280,70,true);
        botaogerenteProducao = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*2,280,70,true);

        botaogerenteConfiguracao.setTexto("G.Conf.   $10000");
        botaogerenteRH.setTexto           ("G.RH.     $40000");
        botaogerenteProducao.setTexto     ("G.Prod.  $200000");

        botaoposGerenciaRequisitos= new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);
        botaoposMedicao= new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75,280,70,true);
        botaoMBAProjetos= new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*2,280,70,true);
        botaoposGerenciaReutilizacao= new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*3,280,70,true);

        botaoposGerenciaRequisitos.setTexto ("P.G. em G.Req.");
        botaoposMedicao.setTexto ("P.G. em Med.");
        botaoMBAProjetos.setTexto ("P.G. em Projetos.");
        botaoposGerenciaReutilizacao.setTexto ("P.G. em G.Reut.");

        botaoposGerenciaProcessos= new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);

        botaoposGerenciaProcessos.setTexto ("P.G. em G.Proc.");

        botaoProx = new Botao(Assets.botaoNext,Assets.botaoNextPressionado,Assets.botaoNextDesativado,(int)(Gdx.graphics.getWidth()*0.947f),(int)(Gdx.graphics.getHeight()*0.06f),90,40,true);
        botaoAnt = new Botao(Assets.botaoNext,Assets.botaoNextPressionado,Assets.botaoNextDesativado,(int)(Gdx.graphics.getWidth()*0.798f),(int)(Gdx.graphics.getHeight()*0.06f),90,40,true);
        botaoProx.setTexto(">");
        botaoAnt.setTexto("<");
    }

    void LCpSObjetos(float delta)
    {
        Jogador.dinheiro += Jogador.LCpS*delta;
        progressoLinhasCodigo += Jogador.LCpS*delta;

    }

    void update(float deltatime) {
        if (estado == JOGANDO) {
            //----input-------------------
            if (!clicando && !clicou) {
                clique.set(-1, -1);
            }
            //---------------------------
            if (computador.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro = Jogador.dinheiro + 1;
                progressoLinhasCodigo = progressoLinhasCodigo + 1;
            }
            //progressoLinhasCodigo = contadorTemporario;

            LCpSObjetos(deltatime);

            if (botaoSalvar.verificaCliqueBotao(clique)) {
                prefs.putBoolean("existeSalvo", true);
                prefs.putInteger("contador", contadorTemporario);
                prefs.putString("nome", nomeJogador);
                prefs.putFloat("dinheiro", Jogador.dinheiro);
                prefs.putString("maturidade", nivelMaturidadeTexto);
                prefs.putFloat("progressoLinhas", progressoLinhasCodigo);
                prefs.putFloat("totalLinhas", totalLinhasCodigo);
                prefs.putFloat("lcps", Jogador.LCpS);
                //AQUI COLOCAR QTAS DE CADA CONSTRUCAO E ATUALIZACAO
                prefs.putInteger("obj0",numObjetos[0]);
                prefs.putInteger("obj1",numObjetos[1]);
                prefs.putInteger("obj2",numObjetos[2]);
                prefs.putInteger("obj3",numObjetos[3]);
                prefs.putInteger("obj4",numObjetos[4]);
                prefs.putInteger("obj5",numObjetos[5]);
                prefs.putInteger("obj6",numObjetos[6]);
                prefs.putInteger("up0",numAtualizacoes[0]);
                prefs.putInteger("up1",numAtualizacoes[1]);
                prefs.putInteger("up2",numAtualizacoes[2]);
                prefs.putInteger("up3",numAtualizacoes[3]);
                prefs.putInteger("up4",numAtualizacoes[4]);
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
            //G
            botaodesenvolvedor.ativo = false;
            botaogerenteProjetos.ativo = false;
            //F
            botaogerenteQualidade.ativo = false;
            botaogerenteComercial.ativo = false;
            botaogerenteConfiguracao.ativo = false;
            //E
            botaogerenteRH.ativo = false;
            botaogerenteProducao.ativo = false;
            //G
            botaoposGerenciaRequisitos.ativo = false;
            botaoposGerenciaRequisitos.ativo = false;
            //F
            botaoposMedicao.ativo = false;
            botaoMBAProjetos.ativo = false;
            //E
            botaoposGerenciaReutilizacao.ativo = false;
            botaoposGerenciaProcessos.ativo = false;

            switch (Jogador.nivel)
            {

                case 2:
                    //E
                    if(Jogador.dinheiro > Objetos.gerenteRH.custo)
                        botaogerenteRH.ativo = false;
                    if(Jogador.dinheiro > Objetos.gerenteProducao.custo)
                        botaogerenteProducao.ativo = false;
                    //E
                    // colocar dependencias
                    botaoposGerenciaReutilizacao.ativo = false;
                    botaoposGerenciaProcessos.ativo = false;
                case 1:
                    //F
                    if(Jogador.dinheiro > Objetos.gerenteQualidade.custo)
                        botaogerenteQualidade.ativo = true;
                    if(Jogador.dinheiro > Objetos.gerenteComercial.custo)
                        botaogerenteComercial.ativo = true;
                    if(Jogador.dinheiro > Objetos.gerenteConfiguracao.custo)
                        botaogerenteConfiguracao.ativo = true;
                    //F
                    //colocar dependencias
                    botaoposMedicao.ativo = true;
                    botaoMBAProjetos.ativo = true;
                case 0:
                    //G
                    if(Jogador.dinheiro > Objetos.desenvolvedor.custo)
                        botaodesenvolvedor.ativo = true;
                    if(Jogador.dinheiro > Objetos.gerenteProjetos.custo)
                        botaogerenteProjetos.ativo = true;

                    //colocar dependencias
                    botaoposGerenciaRequisitos.ativo = true;
                    break;
                default:
                    break;
            }

            //atualizar botoes dos objetos
            if (botaoProx.verificaCliqueBotao(clique) && clicou) {

                if (pagina < totalPaginas)
                    pagina++;

            }
            if (botaoAnt.verificaCliqueBotao(clique) && clicou) {
                if (pagina > 1)
                    pagina--;
            }
            //mecanica compra
            if (botaodesenvolvedor.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.desenvolvedor.custo;
                numObjetos[0]++;
                Jogador.LCpS += Objetos.desenvolvedor.ClickValueObj;
            }
            if (botaogerenteProjetos.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.gerenteProjetos.custo;
                numObjetos[1]++;
                Jogador.LCpS += Objetos.gerenteProjetos.ClickValueObj;
            }
            if (botaogerenteQualidade.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.gerenteQualidade.custo;
                numObjetos[2]++;
                Jogador.LCpS += Objetos.gerenteQualidade.ClickValueObj;
            }
            if (botaogerenteComercial.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.gerenteComercial.custo;
                numObjetos[3]++;
                Jogador.LCpS += Objetos.gerenteComercial.ClickValueObj;
            }
            if (botaogerenteConfiguracao.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.gerenteConfiguracao.custo;
                numObjetos[4]++;
                Jogador.LCpS += Objetos.gerenteConfiguracao.ClickValueObj;
            }
            if (botaogerenteRH.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.gerenteRH.custo;
                numObjetos[5]++;
                Jogador.LCpS += Objetos.gerenteRH.ClickValueObj;
            }
            if (botaogerenteProducao.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.gerenteProducao.custo;
                numObjetos[6]++;
                Jogador.LCpS += Objetos.gerenteProducao.ClickValueObj;
            }
            if (botaoposGerenciaRequisitos.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.posGerenciaRequisitos.custo;
                numAtualizacoes[0]++;
            }
            if (botaoposMedicao.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.posMedicao.custo;
                numAtualizacoes[1]++;
            }
            if (botaoMBAProjetos.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.MBAProjetos.custo;
                numAtualizacoes[2]++;
            }
            if (botaoposGerenciaReutilizacao.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.posGerenciaReutilizacao.custo;
                numAtualizacoes[3]++;
            }
            if (botaoposGerenciaProcessos.verificaCliqueBotao(clique) && clicou) {
                Jogador.dinheiro -= Objetos.posGerenciaProcessos.custo;
                numAtualizacoes[4]++;
            }

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


        //perguntas
        if(emEspera) {
            botaoConfirma.ativo = false;
            timerEspera += deltatime;
            if (timerEspera > tempoEspera)
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

        String[] decimal = String.valueOf(progressoLinhasCodigo).split("\\.");

        if(decimal.length > 1)
            font32.draw(jogo.batch,decimal[0]+"."+decimal[1].charAt(0), Gdx.graphics.getWidth() * 0.06f, Gdx.graphics.getHeight() * 0.65f);
        else
            font32.draw(jogo.batch,decimal[0], Gdx.graphics.getWidth() * 0.06f, Gdx.graphics.getHeight() * 0.65f);
        font32.draw(jogo.batch, nomeJogador, Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.95f);
        font32.draw(jogo.batch, "$ " + String.valueOf((int)Jogador.dinheiro), Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.82f);
        font32.draw(jogo.batch, "Maturidade: " + nivelMaturidadeTexto, Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.69f);



        if (pagina == 1) {
            font32.draw(jogo.batch, "Construções", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.57f);
            botaodesenvolvedor.draw(jogo.batch);
            botaogerenteProjetos.draw(jogo.batch);
            botaogerenteQualidade.draw(jogo.batch);
            botaogerenteComercial.draw(jogo.batch);
        }
        else if (pagina == 2)
        {
            font32.draw(jogo.batch, "Construções", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.57f);
            botaogerenteConfiguracao.draw(jogo.batch);
            botaogerenteRH.draw(jogo.batch);
            botaogerenteProducao.draw(jogo.batch);
        }
        else if (pagina == 3)
        {
            font32.draw(jogo.batch, "Atualizações", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.57f);
            botaoposGerenciaRequisitos.draw(jogo.batch);
            botaoposMedicao.draw(jogo.batch);
            botaoMBAProjetos.draw(jogo.batch);
            botaoposGerenciaReutilizacao.draw(jogo.batch);
        }
        else if (pagina == 4)
        {
            font32.draw(jogo.batch, "Atualizações", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.57f);
            botaoposGerenciaProcessos.draw(jogo.batch);
        }
        botaoProx.draw(jogo.batch);
        botaoAnt.draw(jogo.batch);
        font32.draw(jogo.batch, String.valueOf(pagina) + "/" + String.valueOf(totalPaginas), Gdx.graphics.getWidth() * 0.855f, Gdx.graphics.getHeight() * 0.08f);

        if(estado == JOGANDO)
        {
            if (emStats) {
                String[] casadecimal = String.valueOf(Jogador.LCpS).split("\\.");
                if(casadecimal.length > 1)
                    font24.draw(jogo.batch, statsTexto1+casadecimal[0]+"."+casadecimal[1].charAt(0), Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.7f);
                else
                    font24.draw(jogo.batch, statsTexto1+String.valueOf(Jogador.LCpS), Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.7f);
                font24.draw(jogo.batch, statsTexto2+String.valueOf(numObjetos[0]), Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.65f);
                font24.draw(jogo.batch, statsTexto3+String.valueOf(numObjetos[1]), Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.6f);
                font24.draw(jogo.batch, statsTexto4+String.valueOf(numObjetos[2]), Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.55f);
                font24.draw(jogo.batch, statsTexto5+String.valueOf(numObjetos[3]), Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.5f);
                font24.draw(jogo.batch, statsTexto6+String.valueOf(numObjetos[4]), Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.45f);
                font24.draw(jogo.batch, statsTexto7+String.valueOf(numObjetos[5]), Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.4f);
                font24.draw(jogo.batch, statsTexto8+String.valueOf(numObjetos[6]), Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.35f);
            }
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
