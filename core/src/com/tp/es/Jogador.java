
public class Jogador {
	
	public double ClickValueJogador = 0;
	public String nomeJogador;

	
	//Fun��o click jogador
	public double ClickEvent(){
			
		double ClickEventValue;
		ClickEventValue = this.ClickValueJogador;
			
	return ClickEventValue;
	}
		
	//Fun��o que Atualiza o valor do click do jogador
	//Vai ser chamada sempre que o jogador subir de n�vel
	public void RefreshClickValue(double pesoClickAdicionado){
	
		this.ClickValueJogador = this.ClickValueJogador + pesoClickAdicionado;
		
	return;	
	}
	
	//Fun��es Get
	public String GetName(){
		
		String NomeJogador = this.nomeJogador;
	
	return NomeJogador;
	}
	
	//Fun��es Set
	public void SetName(String NovoNomeJogador){
		
		this.nomeJogador = NovoNomeJogador;
	
	return;
	}
	

}
