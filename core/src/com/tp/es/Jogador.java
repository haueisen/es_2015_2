
public class Jogador {
	
	public double ClickValueJogador = 0;
	public String nomeJogador;

	
	//Funcao click jogador
	public double ClickEvent(){
			
		double ClickEventValue;
		ClickEventValue = this.ClickValueJogador;
			
	return ClickEventValue;
	}
		
	//Funcao que Atualiza o valor do click do jogador
	//Vai ser chamada sempre que o jogador subir de nivel
	public void RefreshClickValue(double pesoClickAdicionado){
	
		this.ClickValueJogador = this.ClickValueJogador + pesoClickAdicionado;
		
	return;	
	}
	
	//Funcoes Get
	public String GetName(){
		
		String NomeJogador = this.nomeJogador;
	
	return NomeJogador;
	}
	
	//Funcoes Set
	public void SetName(String NovoNomeJogador){
		
		this.nomeJogador = NovoNomeJogador;
	
	return;
	}
	

}
