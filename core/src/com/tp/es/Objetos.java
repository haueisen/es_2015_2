package com.tp.es;

public class Objetos {

    // Constantes que representam os níveis do MPS-BR
    private static final int NIVEL_E = 3;
    private static final int NIVEL_F = 2;
    private static final int NIVEL_G = 1;

    // Objetos que representam os cargos ocupados na empresa
    public static Obj desenvolvedor;
    public static Obj gerenteProjetos;
    public static Obj gerenteQualidade;
    public static Obj gerenteComercial;
    public static Obj gerenteConfigutacao;
    public static Obj gerenteRH;
    public static Obj gerenteProducao;

    // Objetos que representam as atualizações dos funcionários
    public static Obj posGerenciaRequisitos;
    public static Obj posMedicao;
    public static Obj MBAProjetos;
    public static Obj posGerenciaReutilizacao;
    public static Obj posGerenciaProcessos;

    //Construtor padrão
    public Objetos() {
    }

    //Inicializa os objetos usados no jogo
    public static void intArraysObj(){
        int id = 0;

        //inicializador dos funcionários
        desenvolvedor = new Obj(id++, "Desenvolvedor", NIVEL_G, 15, 0.1);
        gerenteProjetos = new Obj(id++, "Gerente de Projetos", NIVEL_G, 100, 0.5);
        gerenteQualidade = new Obj(id++, "Gerente de Qualidade", NIVEL_F, 500, 4.0);
        gerenteComercial = new Obj(id++, "Gerente Comercial", NIVEL_F, 3000, 10.0);
        gerenteConfigutacao = new Obj(id++, "Gerente de Configuração", NIVEL_F, 10000, 40.0);
        gerenteRH = new Obj(id++, "Gerente de Recursos Humanos", NIVEL_E, 40000, 100.0);
        gerenteProducao = new Obj(id++, "Gerente de Produção", NIVEL_E,200000, 400.0);

        //inicializador das atualizações
        posGerenciaRequisitos = new Obj(id++,"Pós-Graduação em Gerencia de Requisitos", NIVEL_G);
        posMedicao = new Obj(id++, "Pós-Graduação em Medição", NIVEL_F);
        MBAProjetos = new Obj(id++, "MBA em Gerenciamento de Projetos",NIVEL_F);
        posGerenciaReutilizacao = new Obj(id++, "Pós-Graduação em Gerencia de Reutilização", NIVEL_E);
        posGerenciaProcessos = new Obj(id++, "Pós-Graduação em Gerencia de Processos", NIVEL_E);
    }

}