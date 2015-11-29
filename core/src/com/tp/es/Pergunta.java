package com.tp.es;

public class Pergunta {

    public String perg;
    public String[] respostas;
    public int correta;
    public int numAlternativas;

    public Pergunta(String p, String[] r, int c, int n)
    {
        perg = p;
        respostas = r;
        correta = c;
        numAlternativas = n;
    }
}
