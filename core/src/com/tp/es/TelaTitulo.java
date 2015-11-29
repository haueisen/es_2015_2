package com.tp.es;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

public class TelaTitulo extends ScreenAdapter  {


    private int estado = 0;

    private static final int MAINMENU = 0;
    private static final int CREDITS = 1;
    private static final int NAME_INPUT = 2;

    private boolean botaoNovoJogoPressionado = false;
    private boolean botaoContinuaJogoPressionado = false;

    private boolean clicou = false;
    private boolean clicando = false;

    private Vector2 clique;

    private GameClass jogo;

    private Botao botaoNovoJogo;
    private Botao botaoContinuaJogo;
    private Botao botaoCreditos;

    private BitmapFont font;
    private String creditosTexto;

    private NameInputListener listener;

    private boolean jogoSalvo = false;

    private Preferences prefs;

    public TelaTitulo(GameClass tp)
    {
        this.jogo = tp;

        clique = new Vector2(-1,-1);

        botaoNovoJogo = new Botao(Assets.botaoTitulo,Assets.botaoTituloPressionado,Assets.botaoTituloDesativado,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,210,70,true);
        botaoContinuaJogo = new Botao(Assets.botaoTitulo,Assets.botaoTituloPressionado,Assets.botaoTituloDesativado,Gdx.graphics.getWidth()/2,(int) (Gdx.graphics.getHeight()/2 - 1.05f*botaoNovoJogo.getAltura()),210,70,false);
        botaoCreditos = new Botao(Assets.botaoTitulo,Assets.botaoTituloPressionado,Assets.botaoTituloDesativado,Gdx.graphics.getWidth()/2,(int) (Gdx.graphics.getHeight()/2 - 2.1f*botaoContinuaJogo.getAltura()),210,70,true);

        botaoNovoJogo.setTexto("Novo Jogo");
        botaoContinuaJogo.setTexto("Continuar");
        botaoCreditos.setTexto("Creditos");

        //se existe arquivo de save, ativa botao continua

        listener = new NameInputListener();

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

        font = new BitmapFont(Assets.bitmapFont32File,Assets.bitmapFont32Image,false);
        font.setColor(0, 0, 0, 1);
        creditosTexto = "Daniel Pereira\nFlavio Haueisen\nHumberto Morais\nJean Freire\nLucas Castro\nThiago Sandi\nWeslei Vilela";

        prefs = Gdx.app.getPreferences("JogoSalvo");
        jogoSalvo = prefs.getBoolean("existeSalvo", false);


        botaoContinuaJogo.ativo = jogoSalvo;
    }

    public void update(float deltaTime){
        //----input-------------------
        if (!clicando && !clicou) {
            clique.set(-1, -1);
        }
        //---------------------------
        if(estado == MAINMENU) {

            if (botaoNovoJogo.verificaCliqueBotao(clique)) {
                estado = NAME_INPUT;
                listener.cancelado = false;
                Gdx.input.getTextInput(listener, "Qual o nome do jogador?", "Sem Nome","");

            } else if (botaoContinuaJogo.verificaCliqueBotao(clique)) {
                prefs.putBoolean("carregaSalvo",true);
                jogo.setScreen(new TelaJogo(jogo));
            }
        }
        else if(estado == NAME_INPUT)
        {
            if(listener.cancelado) {
                estado = MAINMENU;
            }
            else if(!listener.nome.isEmpty()){
                prefs.putBoolean("carregaSalvo", false);
                prefs.putString("nome", listener.nome);
                jogo.setScreen(new TelaJogo(jogo));
            }
        }
        if (botaoCreditos.verificaCliqueBotao(clique) && clicou) {
            estado = (estado + 1) % 2;
        }
        clicou = false;


    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        jogo.batch.begin();
        //Assets.tela1Ref.draw(jogo.batch);

        if(estado == MAINMENU || estado == NAME_INPUT) {
            font.draw(jogo.batch,"ClickSoft",220,Gdx.graphics.getHeight() - 50);
            botaoNovoJogo.draw(jogo.batch);
            botaoContinuaJogo.draw(jogo.batch);
        }
        else if(estado == CREDITS)
        {
            font.draw(jogo.batch, creditosTexto, 250, Gdx.graphics.getHeight() - 50);
        }
        botaoCreditos.draw(jogo.batch);

        jogo.batch.end();
    }

}
