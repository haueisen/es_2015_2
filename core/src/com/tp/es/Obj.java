package com.tp.es;

public class Obj {

	public String nomeObjeto;
	public double ClickValueObj = 0;
	public double Penalidade = 0;
	public int nivel = 0;
	public int ID;
	public double trabalho = 100;
	public double custo;
	public boolean atualizacaoFeita = false;

	//Construtor dos funcionários
	public Obj(int id,String nome, int nivel, double custo, double clicksPorSegundo){
		this.ID = id;
		this.nomeObjeto = nome;
		this.nivel = nivel;
		this.custo = custo;
		this.ClickValueObj = clicksPorSegundo;
	}

	//Construtor para as atulizações dos funcionários
	public Obj(int id,String nome, int nivel){
		this.ID = id;
		this.nomeObjeto = nome;
		this.nivel = nivel;
	}

	//Funcao que Atualiza o valor do click do Objeto
	//Vai ser chamada sempre que algum elemento/acao afetar Positivamente o peso do Click do Obj
	public void DefineClickValue(double pesoClickAdicionado){

		this.ClickValueObj= this.ClickValueObj + pesoClickAdicionado;

		return;
	}

	//Funcao que Atualiza o valor do click do Objeto
	//Vai ser chamada sempre que algum elemento/acao afetar Negativamente o peso do Click do Obj
	public void DefinePenalidade(double pesoPenalidadeClickAdicionado){

		this.Penalidade = this.Penalidade  + pesoPenalidadeClickAdicionado;

		return;
	}

	//Atualiza o trabalho de acordo com algum fator de atualizacao (varia de 0% a 100%)00
	public void AtualizaTrabalho(double fatorDeAtualizacao){

		this.trabalho = fatorDeAtualizacao;

		return;
	}
}