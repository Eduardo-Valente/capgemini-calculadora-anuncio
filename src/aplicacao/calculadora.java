package aplicacao;

import java.util.Scanner;

public class calculadora {

	public static final int TRINTA_VISUALIZACOES_ANUNCIO_NAO_COMPARTILHADO = 30;
	
	public static final int CEM_VISUALIZACOES = 100;
	public static final int DOZE_CLIQUES_ANUNCIO = 12;
	
	public static final int VINTE_ACESSOS = 20;
	public static final int TRES_COMPARTILHAMENTOS_ANUNCIO = 3;
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int dinheiroInvestido = 0;
	int qtdVisualizacoesAnuncio = 0;
	int qtdCliquesAnuncio = 0;
	int qtdCompartilhamentoRedeSocial = 0;
	
	System.out.print("Por favor informe a quantia inteira de dinheiro investida: ");
	dinheiroInvestido = sc.nextInt();
	
	qtdVisualizacoesAnuncio = calculaQuantidadeVisualizacoesDoAnuncioNaoCompartilhado(dinheiroInvestido); 
	
	System.out.printf("O anúncio não compartilhado foi visto %d vezes.\n", qtdVisualizacoesAnuncio);
	
	qtdCliquesAnuncio = calculaQuantidadeCliquesNoAnuncio(qtdVisualizacoesAnuncio);
	
	System.out.printf("O anúncio foi clicado %d vezes.\n", qtdCliquesAnuncio);
	
	qtdCompartilhamentoRedeSocial = calculaQuantidadeCompartilhamentoRedeSocial(qtdCliquesAnuncio);
	
	System.out.printf("O anúncio foi compartilhado %d vezes.\n", qtdCompartilhamentoRedeSocial);
	
	sc.close();
	
	}

	public static int calculaQuantidadeVisualizacoesDoAnuncioNaoCompartilhado(int dinheiroInvestido)
	{
		if(dinheiroInvestido < 1)
		{
			System.out.println("Por favor, insira um valor inteiro maior do que zero.");
			System.exit(1);
		}
		    
		return TRINTA_VISUALIZACOES_ANUNCIO_NAO_COMPARTILHADO * dinheiroInvestido;
		    
	}
	
	public static int calculaQuantidadeCliquesNoAnuncio(int qtdVisualizacoesAnuncio)
	{
		int vezesDozePessoasClicaram = 0;
		
		if(qtdVisualizacoesAnuncio >= CEM_VISUALIZACOES)
		{
			vezesDozePessoasClicaram = qtdVisualizacoesAnuncio / CEM_VISUALIZACOES;
			return vezesDozePessoasClicaram * DOZE_CLIQUES_ANUNCIO; 
		}
		else {
			return 0;
		}
	}
	
	public static int calculaQuantidadeCompartilhamentoRedeSocial(int qtdCliquesAnuncio)
	{
		int vezesTresPessoasCompartilharam = 0;
		
		if(qtdCliquesAnuncio >= VINTE_ACESSOS)
		{
			vezesTresPessoasCompartilharam = qtdCliquesAnuncio / VINTE_ACESSOS;
			return vezesTresPessoasCompartilharam * TRES_COMPARTILHAMENTOS_ANUNCIO; 
		}
		else {
			return 0;
		}
	}
}
