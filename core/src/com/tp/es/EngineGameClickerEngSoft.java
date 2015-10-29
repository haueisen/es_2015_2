import java.util.ArrayList;


public class EngineGameClickerEngSoft {

	public int nivel;
	public double pontuacaoTotal;
	public double tempPontuacaoClick;
	public double tempSomaPontos;
	//esta variavel sempre guarda valores positivos (nas funcoes de atualizacao que ela sera atualizada para negativo)
	public double tempSubtraiPontos;
	public double tempSaldoTotal;
	public ArrayList<Obj> ListaObjetos;
	public ArrayList<Perguntas> ListaPerguntas;
	
	private void AtualizaTotal(double valorTempSaldoTotal){
		
		double somaPontos = 0;
		somaPontos = this.tempSaldoTotal;
		//zera o temporario
		this.tempSaldoTotal = 0;
		this.pontuacaoTotal = this.pontuacaoTotal + somaPontos;
	return;
	}
	
	
	public void AtualizaTempClick(double atualizaTempClick){
		
		this.tempPontuacaoClick = this.tempPontuacaoClick + atualizaTempClick;
	return;
	}
	
	
	public void AtualizaTempTotal(double tempPontuacaoClick, double tempSomaPontos, double tempSubstraiPontos){
		
		double tempTotalCalculado = 0;
		tempTotalCalculado = this.tempPontuacaoClick + this.tempSomaPontos + (-1) * this.tempSubtraiPontos;
		//zera valores temporarios
		this.tempPontuacaoClick = 0;
		this.tempSomaPontos = 0;
		this.tempSubtraiPontos = 0;
		
		AtualizaTotal(tempTotalCalculado);
	
	return;	
	}
	
	public void atualizaNivel(){
	
		this.nivel = this.nivel + 1;
		
	return;
	}
	
	//este metodo recebe um valor que representa o clic do jogador, com sua contribuicao do seu valor de click
	public void MouseClicklEvent(double contribuicaoClickJogador){
		
		double tempContribuicaoClickJogador = 0;
		tempContribuicaoClickJogador = contribuicaoClickJogador;
		this.tempPontuacaoClick = this.tempPontuacaoClick + tempContribuicaoClickJogador;
		
	return;
	}
	
	//este metodo e complexo
	//sera desenvolvido quando as perguntas estiverem prontas
	public int ChamaPergunta(int valorPergunta){
		
		int booleano;
		booleano = valorPergunta;
	
	return booleano;
	}
	
	public void ImprimeNivelJogador(){
		
		System.out.println(this.nivel);
		
	return;
	}
	
	public void ImprimeSaldoTotal(){
		
		System.out.println(this.pontuacaoTotal);
		
	return;
	}
	
	//////// Funcoes Get e Set ////////
	
	//Funcoes Get
	
	public double GetPontuacaoTotal(){
		
		double getPontuacaoTotal = 0;
		getPontuacaoTotal = this.pontuacaoTotal;
		
	return getPontuacaoTotal;
	}
	
	public double GetSomaPontos(){
		
		double getSomaPontos = 0;
		getSomaPontos = this.tempSomaPontos;
		
	return getSomaPontos;
	}
	
	public double GetSubtraiPontos(){
		
		double getSubtraiPontos = 0;
		getSubtraiPontos = this.tempSubtraiPontos;
		
	return getSubtraiPontos;
	}
	
	public double GetSaldoTotal(){
		
		double getSaldoTotal = 0;
		getSaldoTotal = this.tempSaldoTotal;
		
	return getSaldoTotal;
	}
			
	//Funcoes Set
	
	
	public void setParametrosIniciais(){
		
		this.nivel = 1;
		
		
	return;
	}	
	
	public void SetPontuacaoTotal(double setarValor){
		
		this.pontuacaoTotal = setarValor;
	
	return;
	}
	
	
}
