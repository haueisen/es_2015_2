package com.tp.es;

public class Objetos {

    // Constantes que representam os níveis do MPS-BR
    private static final int NIVEL_A = 7;
    private static final int NIVEL_B = 6;
    private static final int NIVEL_C = 5;
    private static final int NIVEL_D = 4;
    private static final int NIVEL_E = 3;
    private static final int NIVEL_F = 2;
    private static final int NIVEL_G = 1;

    // Objetos que representam os cargos ocupados na empresa
    public static Obj desenvolvedor;
    public static Obj gerenteProjetos;
    public static Obj gerenteRequisitos;
    public static Obj gerenteQualidade;
    public static Obj gerenteComercial;
    public static Obj gerenteConfiguracao;
    public static Obj gerenteProducao;
    public static Obj diretorProjetos;

    // Objetos que representam as atualizações dos funcionários
    public static Obj posMedicao;
    public static Obj posGerenciaProjetos;
    public static Obj posGerenciaReutilizacao;
    public static Obj posGerenciaProcessos;
    public static Obj posRecursosHumanos;
    public static Obj posGerenciaDesenvolvimentoRequisitos;
    public static Obj MBAIntegracaoProdutos;
    public static Obj MBAProjetoConstrucaoProdutos;
    public static Obj PosValidacao;
    public static Obj mestradoProfissionalVerificação;
    public static Obj MBADesenvolvimentoReutilizacao;
    public static Obj MBAGerenciaDecisoes;
    public static Obj MBAGerenciaRisco;
    public static Obj posGerenciaQualitativaProcessos;
    public static Obj MBAInovocao;


    //Construtor padrão
    public Objetos() {
    }

    //Inicializa os objetos usados no jogo
    public static void intArraysObj(){
        int id = 0;

        //inicializador dos funcionários
        /*0*/desenvolvedor = new Obj(id++, "Desenvolvedor", NIVEL_G, 15, 0.1);
        /*1*/gerenteProjetos = new Obj(id++, "Gerente de Projetos", NIVEL_G, 100, 0.5);
        /*2*/gerenteRequisitos = new Obj(id++, "Gerente de Requisitos", NIVEL_G, 500, 4.0);
        /*3*/gerenteQualidade = new Obj(id++, "Gerente de Qualidade", NIVEL_F, 300, 10.0);
        /*4*/gerenteComercial = new Obj(id++, "Gerente Comercial", NIVEL_F, 10000, 40.0);
        /*5*/gerenteConfiguracao = new Obj(id++, "Gerente de Configuração", NIVEL_F, 40000, 100.0);
        /*6*/gerenteProducao = new Obj(id++, "Gerente de Produção", NIVEL_E,200000, 400.0);
        /*7*/diretorProjetos = new Obj(id++, "Diretor de projetos",NIVEL_B,1667000,6666.0);
        //inicializador das atualizações
        /*0*/posMedicao = new Obj(id++,"Pós-Graduação em Medição", NIVEL_F,30000,8.0);
        /*1*/posGerenciaProjetos = new Obj(id++,"Pós-Graduação em Gerencia de Projetos", NIVEL_F,1000,0.8);
        /*2*/posGerenciaReutilizacao = new Obj(id++,"Pós-Graduação em Gerencia de Reutilização", NIVEL_E,400000,130.0);
        /*3*/posGerenciaProcessos = new Obj(id++,"Pós-Graduação em Gerencia de Processos", NIVEL_E,2000000,500.0);
        /*4*/posRecursosHumanos = new Obj(id++,"Pós-Graduação em Gerencia de Recursos Humanos", NIVEL_E,100000,50);
        /*5*/posGerenciaDesenvolvimentoRequisitos = new Obj(id++,"Pós-Graduação em Desenvolvimentos de Requisitos", NIVEL_D,5000,5.0);
        /*6*/MBAIntegracaoProdutos = new Obj(id++,"MBA em Integração de Produtos", NIVEL_D,300000,20);
        /*7*/MBAProjetoConstrucaoProdutos = new Obj(id++,"MBA em Projeto e Construção de Produtos ", NIVEL_D,10000,1);
        /*8*/PosValidacao = new Obj(id++,"Pós-Graduação em Validação", NIVEL_D,500000,1);
        /*9*/mestradoProfissionalVerificação = new Obj(id++,"Mestrado Profissional em Verificação", NIVEL_D,5000000,4.5);
        /*10*/MBADesenvolvimentoReutilizacao = new Obj(id++,"MBA em Desenvolvimento de Reutilização", NIVEL_C,4000000,200);
        /*11*/MBAGerenciaDecisoes = new Obj(id++,"MBA Grdauação em Gerencia de Decisões", NIVEL_C,50000,8);
        /*12*/MBAGerenciaRisco = new Obj(id++,"MBA Graduação em Gerencia de Riscos", NIVEL_C,20000000,800);
        /*13*/posGerenciaQualitativaProcessos = new Obj(id++,"Pós-Graduação em Gerencia Qualitativa de Processos", NIVEL_B,16667000,8332);
        /*14*/MBAInovocao = new Obj(id++,"MBA em Inovação", NIVEL_A,166667000,13332);

    }


}