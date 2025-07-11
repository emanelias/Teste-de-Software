package br.com.afsj.model;

public class Rei extends Peca {

	protected int ContadorMovimento = 0;
	/*
	private float raio(int x, int y, int w, int z) {

		return ((float) Math.sqrt(Math.pow(x - w, 2) + Math.pow(y - z, 2)));
	}
*/
	@Override
	public boolean movimentoOK(int x, int y) {
/*
		// movimento inicial
		if (posX == -1 && posY == -1) {
			return true;
		}

		// movimento 

		if (this == Tabuleiro.reiBranco) {
			if (raio(x, y, Tabuleiro.reiPreto.posX, Tabuleiro.reiPreto.posY) >= Math.sqrt(2)) {
				// movimento branco normal
				if ((x == posX || x == posX + 1 || x == posX - 1) && (y == posY || y == posY - 1 || y == posY + 1)
						&& (Tabuleiro.listaPretas.posicaoLivreAtaque(x, y) == true)) {
					return true;
				}
			
				//roque branco maior
				if (
						(Tabuleiro.reiBranco.ContadorMovimento < 2) && (Tabuleiro.torreBranca1.ContadorMovimento <2) 
					&& (x == posX - 2) && (y == posY) 
					&& (Tabuleiro.listaPretas.posicaoLivreAtaque(2, 7) == true) 
					&& (Tabuleiro.listaPretas.posicaoLivreAtaque(3, 7) == true)
					&& (Tabuleiro.listaBrancas.pecaPosicao(1, 7) == null) 
					&& (Tabuleiro.listaBrancas.pecaPosicao(2, 7) == null)
					&& (Tabuleiro.listaBrancas.pecaPosicao(3, 7) == null)
					&& (Tabuleiro.listaPretas.pecaPosicao(1, 7) == null) 
					&& (Tabuleiro.listaPretas.pecaPosicao(2, 7) == null)
					&& (Tabuleiro.listaPretas.pecaPosicao(3, 7) == null)
					) {
					
					Tabuleiro.torreBranca1.mover(1, 7);
					return true;
				}
				//roque branco menor
				if (
						(Tabuleiro.reiBranco.ContadorMovimento < 2) && (Tabuleiro.torreBranca2.ContadorMovimento <2) 
					&& (x == posX + 2) && (y == posY) 
					&& (Tabuleiro.listaPretas.posicaoLivreAtaque(5, 7) == true) 
					&& (Tabuleiro.listaPretas.posicaoLivreAtaque(6, 7) == true)
					&& (Tabuleiro.listaBrancas.pecaPosicao(5, 7) == null) 
					&& (Tabuleiro.listaBrancas.pecaPosicao(6, 7) == null)
					&& (Tabuleiro.listaPretas.pecaPosicao(5, 7) == null)
					&& (Tabuleiro.listaPretas.pecaPosicao(6, 7) == null)
					) {
					
					Tabuleiro.torreBranca1.mover(5, 7);
					return true;
				}
			}
		}

		if (this == Tabuleiro.reiPreto) {
			if (raio(x, y, Tabuleiro.reiBranco.posX, Tabuleiro.reiBranco.posY) >= Math.sqrt(2)) {
				if ((x == posX || x == posX + 1 || x == posX - 1) && (y == posY || y == posY - 1 || y == posY + 1)
						&& (Tabuleiro.listaBrancas.posicaoLivreAtaque(x, y) == true)) {
					return true;
				}
				//incluir roque preto aqui
				//roque preto maior
				if (
						(Tabuleiro.reiPreto.ContadorMovimento < 2) && (Tabuleiro.torrePreta1.ContadorMovimento <2) 
					&& (x == posX - 2) && (y == posY) 
					&& (Tabuleiro.listaBrancas.posicaoLivreAtaque(2, 0) == true) 
					&& (Tabuleiro.listaBrancas.posicaoLivreAtaque(3, 0) == true)
					&& (Tabuleiro.listaBrancas.pecaPosicao(1, 0) == null) 
					&& (Tabuleiro.listaBrancas.pecaPosicao(2, 0) == null)
					&& (Tabuleiro.listaBrancas.pecaPosicao(3, 0) == null)
					&& (Tabuleiro.listaPretas.pecaPosicao(1, 0) == null) 
					&& (Tabuleiro.listaPretas.pecaPosicao(2, 0) == null)
					&& (Tabuleiro.listaPretas.pecaPosicao(3, 0) == null)
					) {
					
					Tabuleiro.torreBranca1.mover(1, 0);
					return true;
				}
				//roque preto menor
				if (
						(Tabuleiro.reiPreto.ContadorMovimento < 2) && (Tabuleiro.torrePreta2.ContadorMovimento <2) 
					&& (x == posX + 2) && (y == posY) 
					&& (Tabuleiro.listaBrancas.posicaoLivreAtaque(5, 0) == true) 
					&& (Tabuleiro.listaBrancas.posicaoLivreAtaque(6, 0) == true)
					&& (Tabuleiro.listaBrancas.pecaPosicao(5, 0) == null) 
					&& (Tabuleiro.listaBrancas.pecaPosicao(6, 0) == null)
					&& (Tabuleiro.listaPretas.pecaPosicao(5, 0) == null)
					&& (Tabuleiro.listaPretas.pecaPosicao(6, 0) == null)
					) {
					
					Tabuleiro.torreBranca1.mover(5, 0);
					return true;
				}
			}
		}
		
		return false;
		*/
		return true;
	}
	
	@Override
	public boolean mover(int x, int y) {
		if ( this.movimentoOK(x,y) ) {
			posX = x;
			posY = y;
			this.ContadorMovimento = this.ContadorMovimento + 1;
			//System.out.println("contador REI " + this.ContadorMovimento);
			return true;
		}
		return false;
	}
}
