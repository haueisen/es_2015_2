
public class Obj {

	public String nomeObjeto;
	public double ClickValueObj = 0;
	public double Penalidade = 0;
	public static int StaticNumObj;
	public double trabalho = 100;
	//Fun��o que Atualiza o valor do click do Objeto
	//Vai ser chamada sempre que algum elemento/a��o afetar Positivamente o peso do Click do Obj
	public void DefineClickValue(double pesoClickAdicionado){
	
		this.ClickValueObj= this.ClickValueObj + pesoClickAdicionado;
		
	return;	
	}
	
	//Fun��o que Atualiza o valor do click do Objeto
	//Vai ser chamada sempre que algum elemento/a��o afetar Negativamente o peso do Click do Obj
	public void DefinePenalidade(double pesoPenalidadeClickAdicionado){
		
		this.Penalidade = this.Penalidade  + pesoPenalidadeClickAdicionado;
			
	return;	
	}
		
	//Atualiza o trabalho de acordo com algum fator de atualiza��o (varia de 0% a 100%)00
	public void AtualizaTrabalho(double fatorDeAtualiza��o){
		
		this.trabalho = fatorDeAtualiza��o;
		
	return;
	}
	
	//////// Fun��es Get e Set ////////s
	
	//Fun��es Get
	//Recupera o nome do Objeto
	public String GetName(){
		
		String NomeObjeto = this.nomeObjeto;
	
	return NomeObjeto;
	}
	
	//Fun��es Set
	//Seta o nome do Objeto
	public void SetName(String NovoNomeObjeto){
		
		this.nomeObjeto = NovoNomeObjeto;
	
	return;
	}
	

	
}
