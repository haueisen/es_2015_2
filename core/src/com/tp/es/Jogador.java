package com.tp.es;

public class Jogador {
	
	public static double ClickValueJogador = 1;
	public static String nomeJogador;
	public static float dinheiro;
	public static int nivel = 0;
	public static float LCpS = 0;
	
	//Funcao click jogador
	public static double ClickEvent(){

		return ClickValueJogador;
	}
		
	//Funcao que Atualiza o valor do click do jogador
	//Vai ser chamada sempre que o jogador subir de nivel
	public static void RefreshClickValue(double pesoClickAdicionado){
	
		ClickValueJogador = ClickValueJogador + pesoClickAdicionado;
		
	return;	
	}
	

	

}
