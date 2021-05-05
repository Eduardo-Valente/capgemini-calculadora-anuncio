package aplicacao;

import java.util.Scanner;

public class calculadora {

	public static final int VISUALIZACOES_ANUNCIO_NAO_COMPARTILHADO_A_CADA_UM_REAL = 30;
	
	public static final int VISUALIZACOES = 100;
	public static final int CLIQUES_ANUNCIO = 12;
	
	public static final int ACESSOS_ANUNCIO = 20;
	public static final int COMPARTILHAMENTOS_ANUNCIO = 3;
	public static final int NUMERO_POS_SEQUENCIA = 5;
	
	public static final int VISUALIZACOES_ANUNCIO_COMPARTILHADO = 40;
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int dinheiroInvestido = 0;
	int qtdVisualizacoesAnuncioNaoCompartilhado = 0;
	int qtdCliquesAnuncio = 0;
	int qtdCompartilhamentoRedeSocial = 0;
	int qtdVisualizacoesAnuncioCompartilhado = 0;
	int totalVisualizacoes = 0;
	
	
	System.out.print("Por favor informe a quantia inteira de dinheiro investida: ");
	dinheiroInvestido = sc.nextInt();
	
	qtdVisualizacoesAnuncioNaoCompartilhado = calculaQuantidadeVisualizacoesDoAnuncioNaoCompartilhado(dinheiroInvestido); 
	
	qtdCliquesAnuncio = calculaQuantidadeCliquesNoAnuncio(qtdVisualizacoesAnuncioNaoCompartilhado);
	
	qtdCompartilhamentoRedeSocial = calculaQuantidadeCompartilhamentosEmSequenciaNaRedeSocial(
									calculaQuantidadeCompartilhamentosNaRedeSocial(qtdCliquesAnuncio) );
	
	qtdVisualizacoesAnuncioCompartilhado = calculaQuantidadeVisualizacoesDoAnuncioCompartilhado(qtdCompartilhamentoRedeSocial);
	
	totalVisualizacoes = qtdVisualizacoesAnuncioNaoCompartilhado + qtdVisualizacoesAnuncioCompartilhado;
	
	System.out.printf("%d pessoas visualizaram o anúncio no total.\n", totalVisualizacoes);
	
	sc.close();
	
	}

	public static int calculaQuantidadeVisualizacoesDoAnuncioNaoCompartilhado(int dinheiroInvestido)
	{
		if(dinheiroInvestido < 1)
		{
			System.out.println("Por favor, insira um valor inteiro maior do que zero.");
			System.exit(1);
		}
		    
		return VISUALIZACOES_ANUNCIO_NAO_COMPARTILHADO_A_CADA_UM_REAL * dinheiroInvestido;
		    
	}
	
	public static int calculaQuantidadeCliquesNoAnuncio(int qtdVisualizacoesAnuncioNaoCompartilhado)
	{
		int vezesDozePessoasClicaram = 0;
		
		if(qtdVisualizacoesAnuncioNaoCompartilhado >= VISUALIZACOES)
		{
			vezesDozePessoasClicaram = qtdVisualizacoesAnuncioNaoCompartilhado / VISUALIZACOES;
			return vezesDozePessoasClicaram * CLIQUES_ANUNCIO; 
		}
		else {
			return 0;
		}
	}
	
	private static int calculaQuantidadeCompartilhamentosNaRedeSocial(int qtdCliquesAnuncio)
	{
		int vezesTresPessoasCompartilharam = 0;
		
		if(qtdCliquesAnuncio >= ACESSOS_ANUNCIO)
		{
			vezesTresPessoasCompartilharam = qtdCliquesAnuncio / ACESSOS_ANUNCIO;
			return vezesTresPessoasCompartilharam * COMPARTILHAMENTOS_ANUNCIO;
		}
		else {
			return 0;
		}
	}	
	
	/**
	 * Este método calcula o número máximo de compartilhamentos na rede social considerando a sequência adotada.
	 * 
	 * @param totalCompartilhamentos O total de compartilhamentos na rede social desconsiderando a sequência. 
	 * @return o número máximo de compartilhamentos observada a sequência.
	 */
	
	public static int calculaQuantidadeCompartilhamentosEmSequenciaNaRedeSocial(int totalCompartilhamentos)
	{
		
		int totalCompartilhamentosComSequencia = 0;
		
		for(int i = 1; i <= totalCompartilhamentos; i++)
		{
			if(i % NUMERO_POS_SEQUENCIA == 0)
			{
				continue;
			}
			
			++totalCompartilhamentosComSequencia;
		}
		
		return totalCompartilhamentosComSequencia;
	}
	
	public static int calculaQuantidadeVisualizacoesDoAnuncioCompartilhado(int qtdCompartilhamentoRedeSocial)
	{
		return qtdCompartilhamentoRedeSocial * VISUALIZACOES_ANUNCIO_COMPARTILHADO;
	}
}
