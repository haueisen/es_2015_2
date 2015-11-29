package com.tp.es;


public class Perguntas {

    //static objetos pergunta
    public static Pergunta[] pG;
    public static Pergunta[] pF;
    public static Pergunta[] pE;
    public static Pergunta[] pD;
    public static Pergunta[] pC;
    public static Pergunta[] pB;
    public static Pergunta[] pA;

    private static int nG,nF,nE,nD,nC,nB,nA;


    public static void initArrays()
    {
        pG = new Pergunta[1];
        String[] rG = {"Estabelecer e manter a integridade de todos\n" +
                "os produtos de trabalho de um processo ou projeto e\n" +
                "disponibilizá-los a todos os envolvidos.\n",

                "Gerenciar os requisitos do produto e dos componentes\n" +
                "do produto do projeto e identificar inconsistências\n" +
                "entre os requisitos, os planos do projeto e os\n" +
                "produtos de trabalho do projeto.\n",

                "Gerenciar a aquisição de produtos que satisfaçam às\n" +
                "necessidades expressas pelo adquirente. \n",

                "Estabelecer e manter planos que definem as atividades,\n" +
                "recursos e responsabilidades do projeto, bem como prover\n" +
                "informações sobre o andamento do projeto que permitam a \n" +
                "realização de correções quando houver desvios\n" +
                "significativos no desempenho do projeto. \n",

                "Assegurar que os produtos de trabalho e a execução dos \n" +
                "processos estejam em conformidade com os planos, \n" +
                "procedimentos e padrões estabelecidos. \n"};

        pG[0] = new Pergunta("Considere o MR-MPS-SW (agosto de 2012) e o nível de\n" +
                "maturidade G (parcialmente gerenciado) que é composto também pelo\n" +
                "processo Gerência de Projetos. Nesse contexto, o propósito do \n" +
                "processo Gerência de Projetos é:\n",rG,4,5);

        pF = new Pergunta[1];
        String[] rF = {"Gerência da Conformidade, cujo propósito é \n" +
                "assegurar que os produtos de trabalho e a execução \n" +
                "dos processos estejam em conformidade com os planos, \n" +
                "procedimentos e padrões estabelecidos.\n",

                "Gerência de Reutilização, cujo propósito é gerenciar \n" +
                "o ciclo de vida dos ativos reutilizáveis.\n",

                "Desenvolvimento de Requisitos, cujo propósito é definir \n" +
                "os requisitos do cliente, do produto e dos componentes do\n" +
                "produto.\n",

                "Projeto e Construção do Produto, cujo propósito é \n" +
                "projetar, desenvolver e implementar soluções para \n" +
                "atender aos requisitos.\n",

                "Gerência de Configuração, cujo propósito é estabelecer \n" +
                "e manter a integridade de todos os produtos de trabalho \n" +
                "de um processo ou projeto e disponibilizá-los\n" +
                "a todos os envolvidos\n"};
        pF[0] = new Pergunta("No MPS.BR o nível de maturidade F (Gerenciado) \n" +
                "é composto pelos processos do nível de maturidade anterior (G) \n" +
                "acrescidos dos processos Aquisição, Garantia da Qualidade, \n" +
                "Gerência de Portfólio de Projetos, Medição e:\n",rF,5,5);

        pE = new Pergunta[1];
        String[] rE = {"Certo\n",
                "Errado\n"};
        pE[0] = new Pergunta("O nível E do MPS.BR contempla um processo \n" +
                "que resulta no registro dos dados de utilização dos \n" +
                "ativos reutilizáveis.\n",rE,1,2);

        pD = new Pergunta[1];
        String[] rD = {"Aquisição, gerência de configuração e medição.\n",

                "Desenvolvimento de requisitos, validação e integração \n" +
                "do produto.\n",

                "Gerência de requisitos, gerência de projetos e garantia\n" +
                "da qualidade.\n",

                "Gerência de decisões, gerência de riscos e desenvolvimento \n" +
                "para reutilização.\n",

                "Gerência de recursos humanos, gerência de reutilização e\n" +
                "definição do processo organizacional.\n"};

        pD[0] = new Pergunta("Os níveis de maturidade do modelo MPS\n" +
                "(Melhoria de Processo de Software) estabelecem patamares \n" +
                "de evolução dos processos e representam estágios de melhoria \n" +
                "para a implementação de processos em uma organização. \n" +
                "Possui 7 níveis de maturidade, sendo um deles o\n" +
                "nível D - largamente definido. São alguns processos do nível D:\n",rD,2,5);

        pC = new Pergunta[1];
        String[] rC = {"Certo\n",
                "Errado\n"};
        pC[0] = new Pergunta("O nível de maturidade C - nível definido - do MPS.BR,\n" +
                "além de conter todos os processos dos níveis anteriores, \n" +
                "engloba também os processos desenvolvimento para reutilização, \n" +
                "gerência de decisões e gerência de riscos.\n",rC,1,2);

        pB = new Pergunta[1];
        String[] rB = {" Em Otimização, todos os processos dos níveis de \n" +
                "maturidade anteriores (G ao C) foram cumpridos. Este nível\n" +
                "não possui processos específicos.\n",

                "Gerenciado Quantitativamente, o processo de Gerência de \n" +
                "Projetos sofre sua segunda evolução, sendo acrescentados \n" +
                "novos resultados para atender aos objetivos de gerenciamento \n" +
                "quantitativo. Este nível não possui processos específicos.\n",

                "Parcialmente Definido, todos os processos dos níveis de \n" +
                "maturidade anteriores (G ao C) foram cumpridos e são \n" +
                "acrescidos os processos Avaliação e Melhoria do Processo \n" +
                "Organizacional, Definição do Processo Organizacional, \n" +
                "Gerência de Recursos Humanos e Gerência de Reutilização.\n",

                "Em Otimização, o processo Gerência de Projetos sofre sua \n" +
                "primeira evolução, retratando seu novo propósito: gerenciar \n" +
                "o projeto com base no processo definido para o projeto e \n" +
                "nos planos integrados.\n",

                "Gerenciado Quantitativamente, todos os processos dos \n" +
                "níveis de maturidade anteriores (F ao C) foram cumpridos \n" +
                "e são acrescidos os processos Avaliação e Melhoria do \n" +
                "Processo Organizacional, Definição do Processo Organizacional,\n" +
                "Gerência de Recursos Humanos e Gerência de Reutilização.\n"};


        pB[0] = new Pergunta("Considere que uma organização tenha implantado \n" +
                "o Modelo de Referência MPS para Software (MR-MPS-SW) e tenha \n" +
                "atingido o nível de maturidade B. Neste nível, denominado:\n",rB,2,5);


        pA = new Pergunta[1];
        String[] rA = {"Em Otimização\n",
                "Gerenciado\n",
                "Parcialmente Gerenciado\n",
                "Definido\n",
                "Parcialmente Definido\n"};
        pA[0] = new Pergunta("O programa de Melhoria de Processos do \n" +
            "   Software Brasileiro (MPS.BR) tem sete níveis de maturidade, \n" +
                "que estabelecem patamares de evolução de processos. \n" +
                "O nível de maior maturidade é o:\n",rA,1,5);

    }

    //metodo sorteia pergunta, param nivel
    public static Pergunta sorteiaPergunta(int nivel)
    {
        switch (nivel)
        {
            case 0://-
                return pG[0];
            case 1://G
                return pF[0];
            case 2://F
                return pE[0];
            case 3://E
                return pD[0];
            case 4://D
                return pC[0];
            case 5://C
                return pB[0];
            case 6://B
                return pA[0];
            default://A
                //nao ha perguntas pra quem ja esta no nivel A
                return null;

        }
    }

}
