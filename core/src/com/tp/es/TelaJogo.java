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
    private String ajudaTexto;

    private String ajudaTextoG =  "Requisitos para o próximo nível: \n" +
                                    "-Desenvolvedor   (Dev) \n" +
                                    "-Gerente de projetos   (G.Proj.) \n" +
                                    "-Gerente de Requisitos   (G.Req.)";

    private String ajudaTextoF =  "Requisitos para o próximo nível: \n" +
                                    "-Gerente Comercial   (G.Com.)\n" +
                                    "-Gerente de Configuração   (G.Conf.)\n" +
                                    "-Pós graduação em Gerenciamento \n" +
                                    "de Projetos (PG.GProj)\n" +
                                    "-Gerente de Qualidade   (G.Qual.) \n" +
                                    "-Pós graduação em medição (PG.Medicao)";

    private String ajudaTextoE =  "Requisitos para o próximo nível: \n" +
                                    "-Pos graduação em gerência de processos  (PG.GProc)\n" +
                                    "-Gerente de produção   (G.Prod.)\n" +
                                    "-Pós graduação em gerência de Recursos Humanos  (PG.RH) \n" +
                                    "-Pós graduação em gerência de reutilização  (PG.GReut)";

    private String ajudaTextoD =  "Requisitos para o próximo nível: \n" +
                                    "-Pós Graduação em desenvolvimento \n" +
                                    "de requisitos  (PG.GDReq)\n" +
                                    "-MBA em Integração de produtos  (MBA.IProd)\n" +
                                    "-MBA em Projeto e construção de produtos  (MBA.PCPrd) \n" +
                                    "-Pós Graduação em Validação  (PG.Valid)\n" +
                                    "-Mestrado Profissional em Verificação  (Me.Verif)";

    private String ajudaTextoC =  "Requisitos para o próximo nível: \n" +
                                    "-MBA em desenvolvimento de Reutilização  (MBA.DReut)\n" +
                                    "-Pós Graduação em gerência de Decisões  (MBA.GD)\n" +
                                    "-Pós Graduação em gerência de Riscos  (MBA.GRisco)";

    private String ajudaTextoB =  "Requisitos para o próximo nível: \n" +
                                    "-Diretor de Projetos   (D.Proj.)\n" +
                                    "-Pós Graduação em Gerência \n" +
                                    "Qualitativa de processos  (PG.GQP)";

    private String ajudaTextoA =  "Requisitos para o próximo nível: \n" +
                                    "-MBA em Inovação  (MBA.I)";

    private String avaliacaoTexto = "Parabéns você atingiu o nível máximo\n de maturidade.\n";

    private String statsTexto1 = "Linhas de Código p/segundo (LCpS): ";
    private String statsTexto2 = "Desenvolvedores (Dev): ";
    private String statsTexto3 = "Gerente de Projeto (G.Proj.):  ";
    private String statsTexto4 = "Gerente de Requisitos (G.Req.): ";
    private String statsTexto5 = "Gerente de Qualidade (G.Qual.): ";
    private String statsTexto6 = "Gerente Comercial (G.Com.):  ";
    private String statsTexto7 = "Gerente de Configuração (G.Conf.): ";
    private String statsTexto8 = "Gerente de Produção (G.Prod.): ";

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

    private double tempoFeedBack = 2;
    private double tempoEspera = 60;

    private double timerFeedback = 0;
    private double timerEspera = 0;

    private boolean emEspera = false;

    private Preferences prefs;

    private int[] numObjetos;
    private int[] numAtualizacoes;

    private int pagina = 1;
    private int totalPaginas = 6;
    private Botao botaoProx;
    private Botao botaoAnt;

    private Botao botaodesenvolvedor;
    private Botao botaogerenteProjetos;
    private Botao botaogerenteRequisitos;
    private Botao botaogerenteQualidade;
    private Botao botaogerenteComercial;
    private Botao botaogerenteConfiguracao;
    private Botao botaogerenteProducao;
    private Botao botaodiretorProjetos;

    private Botao botaoposMedicao;
    private Botao botaoposGerenciaProjetos;
    private Botao botaoposGerenciaReutilizacao;
    private Botao botaoposGerenciaProcessos;
    private Botao botaoposRecursosHumanos;
    private Botao botaoposGerenciaDesenvolvimentoRequisitos;
    private Botao botaoMBAIntegracaoProdutos;
    private Botao botaoMBAProjetoConstrucaoProdutos;
    private Botao botaoPosValidacao;
    private Botao botaomestradoProfissionalVerificação;
    private Botao botaoMBADesenvolvimentoReutilizacao;
    private Botao botaoMBAGerenciaDecisoes;
    private Botao botaoMBAGerenciaRisco;
    private Botao botaoposGerenciaQualitativaProcessos;
    private Botao botaoMBAInovocao;

    public TelaJogo(GameClass tp)
    {

        Perguntas.initArrays();
        Objetos.intArraysObj();

        numObjetos = new int[8];
        for(int i = 0; i < 8; i++)
        {
            numObjetos[i] = 0;
        }
        numAtualizacoes = new int[15];
        for(int i = 0; i < 15; i++)
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
            Jogador.LCpS = prefs.getFloat("lcps", 0);
            numObjetos[0] = prefs.getInteger("obj0", 0);
            numObjetos[1] = prefs.getInteger("obj1", 0);
            numObjetos[2] = prefs.getInteger("obj2", 0);
            numObjetos[3] = prefs.getInteger("obj3", 0);
            numObjetos[4] = prefs.getInteger("obj4", 0);
            numObjetos[5] = prefs.getInteger("obj5", 0);
            numObjetos[6] = prefs.getInteger("obj6", 0);
            numObjetos[7] = prefs.getInteger("obj7", 0);
            numAtualizacoes[0] = prefs.getInteger("up0", 0);
            numAtualizacoes[1] = prefs.getInteger("up1", 0);
            numAtualizacoes[2] = prefs.getInteger("up2", 0);
            numAtualizacoes[3] = prefs.getInteger("up3", 0);
            numAtualizacoes[4] = prefs.getInteger("up4", 0);
            numAtualizacoes[5] = prefs.getInteger("up5", 0);
            numAtualizacoes[6] = prefs.getInteger("up6", 0);
            numAtualizacoes[7] = prefs.getInteger("up7", 0);
            numAtualizacoes[8] = prefs.getInteger("up8", 0);
            numAtualizacoes[9] = prefs.getInteger("up9", 0);
            numAtualizacoes[10] = prefs.getInteger("up10", 0);
            numAtualizacoes[11] = prefs.getInteger("up11", 0);
            numAtualizacoes[12] = prefs.getInteger("up12", 0);
            numAtualizacoes[13] = prefs.getInteger("up13", 0);
            numAtualizacoes[14] = prefs.getInteger("up14", 0);
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
        //cosntrucoes
        botaodesenvolvedor = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);
        botaogerenteProjetos= new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75,280,70,true);
        botaogerenteRequisitos = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*2,280,70,true);
        botaogerenteQualidade = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*3,280,70,true);

        botaogerenteComercial = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);
        botaogerenteConfiguracao = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75,280,70,true);
        botaogerenteProducao  = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*2,280,70,true);
        botaodiretorProjetos  = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*3,280,70,true);

        //atualizacoes
        botaoposMedicao = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);
        botaoposGerenciaProjetos = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75,280,70,true);
        botaoposGerenciaReutilizacao = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*2,280,70,true);
        botaoposGerenciaProcessos = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*3,280,70,true);

        botaoposRecursosHumanos = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);
        botaoposGerenciaDesenvolvimentoRequisitos = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75,280,70,true);
        botaoMBAIntegracaoProdutos = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*2,280,70,true);
        botaoMBAProjetoConstrucaoProdutos = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*3,280,70,true);

        botaoPosValidacao = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);
        botaomestradoProfissionalVerificação = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75,280,70,true);
        botaoMBADesenvolvimentoReutilizacao  = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*2,280,70,true);
        botaoMBAGerenciaDecisoes  = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*3,280,70,true);

        botaoMBAGerenciaRisco = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f),280,70,true);
        botaoposGerenciaQualitativaProcessos = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75,280,70,true);
        botaoMBAInovocao = new Botao(Assets.botaoObj,Assets.botaoObjPressionado,Assets.botaoObjDesativado,(int)(Gdx.graphics.getWidth()*0.873f),(int)(Gdx.graphics.getHeight()*0.465f)-75*2,280,70,true);

        //construcoes
        botaodesenvolvedor.setTexto                         ("Dev          $15");
        botaogerenteProjetos.setTexto                       ("G.Proj.     $100");
        botaogerenteRequisitos.setTexto                     ("G.Req.      $500");
        botaogerenteQualidade.setTexto                      ("G.Qual.      $3K");
        botaogerenteComercial.setTexto                      ("G.Com.      $10K");
        botaogerenteConfiguracao.setTexto                   ("G.Conf.     $40K");
        botaogerenteProducao.setTexto                       ("G.Prod.    $200K");
        botaodiretorProjetos.setTexto                       ("D.Proj.  $1,667M");
        //atualizacoes
        botaoposMedicao.setTexto                            ("PG.Medicao  $30K");
        botaoposGerenciaProjetos.setTexto                   ("PG.GProj     $1K");
        botaoposGerenciaReutilizacao.setTexto               ("PG.GReut   $400K");
        botaoposGerenciaProcessos.setTexto                  ("PG.GProc     $2M");
        botaoposRecursosHumanos.setTexto                    ("PG.RH      $100k");
        botaoposGerenciaDesenvolvimentoRequisitos.setTexto  ("PG.GDReq     $5K");
        botaoMBAIntegracaoProdutos.setTexto                 ("MBA.IProd  $300K");
        botaoMBAProjetoConstrucaoProdutos.setTexto          ("MBA.PCPrd  $10K");
        botaoPosValidacao.setTexto                          ("PG.Valid   $500K");
        botaomestradoProfissionalVerificação.setTexto       ("Me.Verif     $5M");
        botaoMBADesenvolvimentoReutilizacao.setTexto        ("MBA.DReut    $4M");
        botaoMBAGerenciaDecisoes.setTexto                   ("MBA.GD      $50K");
        botaoMBAGerenciaRisco.setTexto                      ("MBA.GRisco $20M");
        botaoposGerenciaQualitativaProcessos.setTexto       ("PG.GQP $16,667M");
        botaoMBAInovocao.setTexto                           ("MBA.I $166,667M");

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

                prefs.putInteger("obj0", numObjetos[0]);
                prefs.putInteger("obj1", numObjetos[1]);
                prefs.putInteger("obj2", numObjetos[2]);
                prefs.putInteger("obj3", numObjetos[3]);
                prefs.putInteger("obj4", numObjetos[4]);
                prefs.putInteger("obj5",numObjetos[5]);
                prefs.putInteger("obj6",numObjetos[6]);
                prefs.putInteger("obj7",numObjetos[7]);
                prefs.putInteger("up0",numAtualizacoes[0]);
                prefs.putInteger("up1",numAtualizacoes[1]);
                prefs.putInteger("up2",numAtualizacoes[2]);
                prefs.putInteger("up3",numAtualizacoes[3]);
                prefs.putInteger("up4",numAtualizacoes[4]);
                prefs.putInteger("up5",numAtualizacoes[0]);
                prefs.putInteger("up6",numAtualizacoes[1]);
                prefs.putInteger("up7",numAtualizacoes[2]);
                prefs.putInteger("up8",numAtualizacoes[3]);
                prefs.putInteger("up9",numAtualizacoes[4]);
                prefs.putInteger("up10",numAtualizacoes[0]);
                prefs.putInteger("up11",numAtualizacoes[1]);
                prefs.putInteger("up12",numAtualizacoes[2]);
                prefs.putInteger("up13",numAtualizacoes[3]);
                prefs.putInteger("up14",numAtualizacoes[4]);
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

            //G
            botaodesenvolvedor.ativo = false;
            botaogerenteProjetos.ativo = false;
            botaogerenteRequisitos.ativo = false;
            //F
            botaogerenteQualidade.ativo = false;
            botaogerenteComercial.ativo = false;
            botaogerenteConfiguracao.ativo = false;
            //E
            botaogerenteProducao.ativo = false;
            //B
            botaodiretorProjetos.ativo = false;

            //atualizacoes
            //F
            botaoposMedicao.ativo = false;
            botaoposGerenciaProjetos.ativo = false;
            //E
            botaoposGerenciaReutilizacao.ativo = false;
            botaoposGerenciaProcessos.ativo = false;
            botaoposRecursosHumanos.ativo = false;
            //D
            botaoposGerenciaDesenvolvimentoRequisitos.ativo = false;
            botaoMBAIntegracaoProdutos.ativo = false;
            botaoMBAProjetoConstrucaoProdutos.ativo = false;
            botaoPosValidacao.ativo = false;
            botaomestradoProfissionalVerificação.ativo = false;
            //C
            botaoMBADesenvolvimentoReutilizacao.ativo = false;
            botaoMBAGerenciaDecisoes.ativo = false;
            botaoMBAGerenciaRisco.ativo = false;
            //B
            botaoposGerenciaQualitativaProcessos.ativo = false;
            //A
            botaoMBAInovocao.ativo = false;

            switch (Jogador.nivel)
            {
                case 6:
                    //A
                    if(Jogador.dinheiro > Objetos.MBAInovocao.custo && numObjetos[7] > 0 && !Objetos.MBAInovocao.atualizacaoFeita)
                        botaoMBAInovocao.ativo = true;
                case 5:
                    //B
                    if(Jogador.dinheiro > Objetos.diretorProjetos.custo)
                        botaodiretorProjetos.ativo = true;

                    if(Jogador.dinheiro > Objetos.posGerenciaQualitativaProcessos.custo && numObjetos[7] > 0 && !Objetos.posGerenciaQualitativaProcessos.atualizacaoFeita)
                        botaoposGerenciaQualitativaProcessos.ativo = true;
                case 4:
                    //C
                    if(Jogador.dinheiro > Objetos.MBADesenvolvimentoReutilizacao.custo && numObjetos[5] > 0 && !Objetos.MBADesenvolvimentoReutilizacao.atualizacaoFeita)
                        botaoMBADesenvolvimentoReutilizacao.ativo = true;
                    if(Jogador.dinheiro > Objetos.MBAGerenciaDecisoes.custo && numObjetos[2] > 0 && !Objetos.MBAGerenciaDecisoes.atualizacaoFeita)
                        botaoMBAGerenciaDecisoes.ativo = true;
                    if(Jogador.dinheiro > Objetos.MBAGerenciaRisco.custo && numObjetos[6] > 0 && !Objetos.MBAGerenciaRisco.atualizacaoFeita)
                        botaoMBAGerenciaRisco.ativo = true;
                case 3:
                    //D
                    if(Jogador.dinheiro > Objetos.posGerenciaDesenvolvimentoRequisitos.custo && numObjetos[2] > 0 && !Objetos.posGerenciaDesenvolvimentoRequisitos.atualizacaoFeita)
                        botaoposGerenciaDesenvolvimentoRequisitos.ativo = true;
                    if(Jogador.dinheiro > Objetos.MBAIntegracaoProdutos.custo && numObjetos[3] > 0 && !Objetos.MBAIntegracaoProdutos.atualizacaoFeita)
                        botaoMBAIntegracaoProdutos.ativo = true;
                    if(Jogador.dinheiro > Objetos.MBAProjetoConstrucaoProdutos.custo && numObjetos[1] > 0 && !Objetos.MBAProjetoConstrucaoProdutos.atualizacaoFeita)
                        botaoMBAProjetoConstrucaoProdutos.ativo = true;
                    if(Jogador.dinheiro > Objetos.PosValidacao.custo && numObjetos[0] > 0 && !Objetos.PosValidacao.atualizacaoFeita)
                        botaoPosValidacao.ativo = true;
                    if(Jogador.dinheiro > Objetos.mestradoProfissionalVerificação.custo && numObjetos[0] > 0 && !Objetos.mestradoProfissionalVerificação.atualizacaoFeita)
                        botaomestradoProfissionalVerificação.ativo = true;
                case 2:
                    //E
                    if(Jogador.dinheiro > Objetos.gerenteProducao.custo)
                        botaogerenteProducao.ativo = true;

                    if(Jogador.dinheiro > Objetos.posGerenciaReutilizacao.custo && numObjetos[5] > 0 && !Objetos.posGerenciaReutilizacao.atualizacaoFeita)
                        botaoposGerenciaReutilizacao.ativo = true;
                    if(Jogador.dinheiro > Objetos.posGerenciaProcessos.custo && numObjetos[6] > 0 && !Objetos.posGerenciaProcessos.atualizacaoFeita)
                        botaoposGerenciaProcessos.ativo = true;
                    if(Jogador.dinheiro > Objetos.posRecursosHumanos.custo && numObjetos[4] > 0 && !Objetos.posRecursosHumanos.atualizacaoFeita)
                        botaoposRecursosHumanos.ativo = true;
                case 1:
                    //F
                    if(Jogador.dinheiro > Objetos.gerenteQualidade.custo)
                        botaogerenteQualidade.ativo = true;
                    if(Jogador.dinheiro > Objetos.gerenteComercial.custo)
                        botaogerenteComercial.ativo = true;
                    if(Jogador.dinheiro > Objetos.gerenteConfiguracao.custo)
                        botaogerenteConfiguracao.ativo = true;

                    if(Jogador.dinheiro > Objetos.posMedicao.custo && numObjetos[3] > 0 && !Objetos.posMedicao.atualizacaoFeita)
                        botaoposMedicao.ativo = true;
                    if(Jogador.dinheiro > Objetos.posGerenciaProjetos.custo && numObjetos[1] > 0 && !Objetos.posGerenciaProjetos.atualizacaoFeita)
                        botaoposGerenciaProjetos.ativo = true;
                case 0:
                    //G
                    if(Jogador.dinheiro > Objetos.desenvolvedor.custo)
                        botaodesenvolvedor.ativo = true;
                    if(Jogador.dinheiro > Objetos.gerenteProjetos.custo)
                        botaogerenteProjetos.ativo = true;
                    if(Jogador.dinheiro > Objetos.gerenteRequisitos.custo)
                        botaogerenteRequisitos.ativo = true;

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
            //construcoes
            if(pagina == 1) {
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
                if (botaogerenteRequisitos.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.gerenteRequisitos.custo;
                    numObjetos[2]++;
                    Jogador.LCpS += Objetos.gerenteRequisitos.ClickValueObj;
                }
                if (botaogerenteQualidade.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.gerenteQualidade.custo;
                    numObjetos[3]++;
                    Jogador.LCpS += Objetos.gerenteQualidade.ClickValueObj;
                }
            }
            else if(pagina == 2) {
                if (botaogerenteComercial.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.gerenteComercial.custo;
                    numObjetos[4]++;
                    Jogador.LCpS += Objetos.gerenteComercial.ClickValueObj;
                }
                if (botaogerenteConfiguracao.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.gerenteConfiguracao.custo;
                    numObjetos[5]++;
                    Jogador.LCpS += Objetos.gerenteConfiguracao.ClickValueObj;
                }
                if (botaogerenteProducao.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.gerenteProducao.custo;
                    numObjetos[6]++;
                    Jogador.LCpS += Objetos.gerenteProducao.ClickValueObj;
                }
                if (botaodiretorProjetos.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.gerenteProjetos.custo;
                    numObjetos[7]++;
                    Jogador.LCpS += Objetos.gerenteProjetos.ClickValueObj;
                }
            }
            //atualizacoes
            else if(pagina == 3) {
                if (botaoposMedicao.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.posMedicao.custo;
                    numAtualizacoes[0]++;
                    Objetos.posMedicao.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.posMedicao.ClickValueObj;
                }
                if (botaoposGerenciaProjetos.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.posGerenciaProjetos.custo;
                    numAtualizacoes[1]++;
                    Objetos.posGerenciaProjetos.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.posGerenciaProjetos.ClickValueObj;
                }
                if (botaoposGerenciaReutilizacao.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.posGerenciaReutilizacao.custo;
                    numAtualizacoes[2]++;
                    Objetos.posGerenciaReutilizacao.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.posGerenciaReutilizacao.ClickValueObj;
                }
                if (botaoposGerenciaProcessos.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.posGerenciaProcessos.custo;
                    numAtualizacoes[3]++;
                    Objetos.posGerenciaProcessos.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.posGerenciaProcessos.ClickValueObj;
                }
            }
            else if(pagina == 4) {
                if (botaoposRecursosHumanos.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.posRecursosHumanos.custo;
                    numAtualizacoes[4]++;
                    Objetos.posRecursosHumanos.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.posRecursosHumanos.ClickValueObj;
                }
                if (botaoposGerenciaDesenvolvimentoRequisitos.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.posGerenciaDesenvolvimentoRequisitos.custo;
                    numAtualizacoes[5]++;
                    Objetos.posGerenciaDesenvolvimentoRequisitos.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.posGerenciaDesenvolvimentoRequisitos.ClickValueObj;
                }
                if (botaoMBAIntegracaoProdutos.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.MBAIntegracaoProdutos.custo;
                    numAtualizacoes[6]++;
                    Objetos.MBAIntegracaoProdutos.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.MBAIntegracaoProdutos.ClickValueObj;
                }
                if (botaoMBAProjetoConstrucaoProdutos.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.MBAProjetoConstrucaoProdutos.custo;
                    numAtualizacoes[7]++;
                    Objetos.MBAProjetoConstrucaoProdutos.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.MBAProjetoConstrucaoProdutos.ClickValueObj;
                }
            }
            else if(pagina == 5) {
                if (botaoPosValidacao.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.PosValidacao.custo;
                    numAtualizacoes[8]++;
                    Objetos.PosValidacao.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.PosValidacao.ClickValueObj;
                }
                if (botaomestradoProfissionalVerificação.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.mestradoProfissionalVerificação.custo;
                    numAtualizacoes[9]++;
                    Objetos.mestradoProfissionalVerificação.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.mestradoProfissionalVerificação.ClickValueObj;
                }
                if (botaoMBADesenvolvimentoReutilizacao.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.MBADesenvolvimentoReutilizacao.custo;
                    numAtualizacoes[10]++;
                    Objetos.MBADesenvolvimentoReutilizacao.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.MBADesenvolvimentoReutilizacao.ClickValueObj;
                }
                if (botaoMBAGerenciaDecisoes.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.MBAGerenciaDecisoes.custo;
                    numAtualizacoes[11]++;
                    Objetos.MBAGerenciaDecisoes.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.MBAGerenciaDecisoes.ClickValueObj;
                }
            }
            else if(pagina == 6) {
                if (botaoMBAGerenciaRisco.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.MBAGerenciaRisco.custo;
                    numAtualizacoes[12]++;
                    Objetos.MBAGerenciaRisco.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.MBAGerenciaRisco.ClickValueObj;
                }
                if (botaoposGerenciaQualitativaProcessos.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.posGerenciaQualitativaProcessos.custo;
                    numAtualizacoes[13]++;
                    Objetos.posGerenciaQualitativaProcessos.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.posGerenciaQualitativaProcessos.ClickValueObj;
                }
                if (botaoMBAInovocao.verificaCliqueBotao(clique) && clicou) {
                    Jogador.dinheiro -= Objetos.MBAInovocao.custo;
                    numAtualizacoes[14]++;
                    Objetos.MBAInovocao.atualizacaoFeita = true;
                    Jogador.LCpS += Objetos.MBAInovocao.ClickValueObj;
                }
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

        //ajuda texto
        botaoAvaliacao.ativo = false;
        switch (Jogador.nivel) {

            case 7:
                ajudaTexto = "Ao infinito e além!!!";
                break;
            case 6:
                ajudaTexto = ajudaTextoA;
                if(numAtualizacoes[14] > 0)
                    botaoAvaliacao.ativo = true;
                break;
            case 5:
                ajudaTexto = ajudaTextoB;
                if(numObjetos[7] > 0 && numAtualizacoes[13] > 0)
                    botaoAvaliacao.ativo = true;
                break;
            case 4:
                ajudaTexto = ajudaTextoC;
                if(numAtualizacoes[10] > 0 && numAtualizacoes[11] > 0 && numAtualizacoes[12] > 0)
                    botaoAvaliacao.ativo = true;
                break;
            case 3:
                ajudaTexto = ajudaTextoD;
                if(numAtualizacoes[9] > 0 && numAtualizacoes[8] > 0 && numAtualizacoes[7] > 0
                        && numAtualizacoes[6] > 0 && numAtualizacoes[5] > 0)
                    botaoAvaliacao.ativo = true;
                break;
            case 2:
                ajudaTexto = ajudaTextoE;
                if(numObjetos[6] > 0 && numAtualizacoes[2] > 0 && numAtualizacoes[3] > 0 && numAtualizacoes[4] > 0)
                    botaoAvaliacao.ativo = true;
                break;
            case 1:
                ajudaTexto = ajudaTextoF;
                if(numObjetos[3] > 0 && numObjetos[4] > 0 && numObjetos[5] > 0 && numAtualizacoes[0] > 0 && numAtualizacoes[1] > 0)
                    botaoAvaliacao.ativo = true;
                break;
            case 0:
                ajudaTexto = ajudaTextoG;
                if(numObjetos[0] > 0 && numObjetos[1] > 0 && numObjetos[2] > 0)
                    botaoAvaliacao.ativo = true;
                break;
        }

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
            botaogerenteRequisitos.draw(jogo.batch);
            botaogerenteQualidade.draw(jogo.batch);
        }
        else if (pagina == 2)
        {
            font32.draw(jogo.batch, "Construções", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.57f);
            botaogerenteComercial.draw(jogo.batch);
            botaogerenteConfiguracao.draw(jogo.batch);
            botaogerenteProducao.draw(jogo.batch);
            botaodiretorProjetos.draw(jogo.batch);
        }
        else if (pagina == 3)
        {
            font32.draw(jogo.batch, "Atualizações", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.57f);
            botaoposMedicao.draw(jogo.batch);
            botaoposGerenciaProjetos.draw(jogo.batch);
            botaoposGerenciaReutilizacao.draw(jogo.batch);
            botaoposGerenciaProcessos.draw(jogo.batch);
        }
        else if (pagina == 4)
        {
            font32.draw(jogo.batch, "Atualizações", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.57f);
            botaoposRecursosHumanos.draw(jogo.batch);
            botaoposGerenciaDesenvolvimentoRequisitos.draw(jogo.batch);
            botaoMBAIntegracaoProdutos.draw(jogo.batch);
            botaoMBAProjetoConstrucaoProdutos.draw(jogo.batch);
        }
        else if (pagina == 5)
        {
            font32.draw(jogo.batch, "Atualizações", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.57f);
            botaoPosValidacao.draw(jogo.batch);
            botaomestradoProfissionalVerificação.draw(jogo.batch);
            botaoMBADesenvolvimentoReutilizacao.draw(jogo.batch);
            botaoMBAGerenciaDecisoes.draw(jogo.batch);
        }
        else if (pagina == 6)
        {
            font32.draw(jogo.batch, "Atualizações", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.57f);
            botaoMBAGerenciaRisco.draw(jogo.batch);
            botaoposGerenciaQualitativaProcessos.draw(jogo.batch);
            botaoMBAInovocao.draw(jogo.batch);
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
                font24.draw(jogo.batch, ajudaTexto, Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.79f);
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
