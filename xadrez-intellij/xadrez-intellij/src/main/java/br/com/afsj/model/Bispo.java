package br.com.afsj.model;

public class Bispo extends Peca {
	@Override
	public boolean movimentoOK(int x, int y) {
		if (posX == -1 && posY == -1)
			return true;

		int sinalX, sinalY;

		if (x > posX)
			sinalX = -1;
		else if (x < posX)
			sinalX = 1;
		else
			return false;

		if (y > posY)
			sinalY = -1;
		else if (y < posY)
			sinalY = 1;
		else
			return false;

		int aX = x;
		int aY = y;
		boolean caminhoLivre = true;

		do {
			aX = aX + sinalX;
			aY = aY + sinalY;

			if (aX == posX && aY == posY)
				return caminhoLivre;

			if (Tabuleiro.listaBrancas.pecaPosicao(aX, aY) != null) {
				caminhoLivre = false;
			}
			if (Tabuleiro.listaPretas.pecaPosicao(aX, aY) != null) {
				caminhoLivre = false;
			}

		} while ((aX > 0 && aX < 8) && (aY > 0 && aY < 8));

		return false;
	}
}
