
public class Jogador {
	
	public double ClickValueJogador = 0;
	public String nomeJogador;

	
	//Função click jogador
	public double ClickEvent(){
			
		double ClickEventValue;
		ClickEventValue = this.ClickValueJogador;
			
	return ClickEventValue;
	}
		
	//Função que Atualiza o valor do click do jogador
	//Vai ser chamada sempre que o jogador subir de nível
	public void RefreshClickValue(double pesoClickAdicionado){
	
		this.ClickValueJogador = this.ClickValueJogador + pesoClickAdicionado;
		
	return;	
	}
	
	//Funções Get
	public String GetName(){
		
		String NomeJogador = this.nomeJogador;
	
	return NomeJogador;
	}
	
	//Funções Set
	public void SetName(String NovoNomeJogador){
		
		this.nomeJogador = NovoNomeJogador;
	
	return;
	}
	

}
