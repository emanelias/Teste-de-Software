package br.com.afsj.model;

import javax.swing.JOptionPane;

import br.com.afsj.control.Xadrez;

public class Peao extends Peca {
	
	@Override
	public boolean movimentoOK(int x, int y) {
		if (posX == -1 && posY == -1) {
			return true;
		}
		
		// Fun��o para a primeira jogada: duas casas iniciais ou apenas uma.
		if (cor == Xadrez.corBRANCA && posY == 6) {
			if ( (x == posX) && ((y == posY-1)||(y == posY-2)) ) {
				return true ;
			}
		}
		
		// Fun��o para verificar se o pe�o chegou at� a �ltima posi��o da sua coluna.
		if (cor == Xadrez.corBRANCA && y == 0) {			
			if ( (x == posX) && (y == posY-1) ) {
				String opcao = JOptionPane.showInputDialog("Digte um valor: \n1 - Torre, \n2 - Cavalo, \n3 - Bispo, \n4 - Rainha");
				return true ;				
			}			
		}

		
		// Fun��o para o restante das jogadas: uma casa inicial.
		if (cor == Xadrez.corBRANCA) {
			if ( (x == posX) && (y == posY-1) ) {
				return true ;
			}
		}
			
		
		//Fun��o para a primeira jogada: duas casas iniciais ou apenas uma.
		if (cor == Xadrez.corPRETA && posY==1) {
			if ( (x == posX) && (y == posY+1) || y == posY+2 ) {
				return true ;
			}
		}

		// Fun��o para verificar se o pe�o chegou at� a �ltima posi��o da sua coluna.
				if (cor == Xadrez.corPRETA && y == 7) {					
					if ( (x == posX) && (y == posY+1) ) {						
						String opcao = JOptionPane.showInputDialog("Digte um valor: \n1 - Torre, \n2 - Cavalo, \n3 - Bispo, \n4 - Rainha");
						return true ;				
					}			
				}
				
		// Fun��o para o restante das jogadas: uma casa inicial.
		if (cor == Xadrez.corPRETA) {
			if ( (x == posX) && (y == posY+1) ) {
				return true ;
			}
		}
		
		

		return false;
	}
	
	@Override
	public boolean capturar(int x, int y) {

		//System.out.println(z);

		if (cor == Xadrez.corBRANCA) {
			if ( (x == posX-1 || x == posX+1) && (y == posY-1) ) {
				posX = x;
				posY = y;
				return true ;
			}
		}

		// Fun��o en passant.
		if (cor == Xadrez.corBRANCA && y == 3) {
			if ( (x == posX-1 || x == posX+1) && (y == posY) ) {
				posX = x;
				posY = y;				
				return true;
			}
		}		
		
		if (cor == Xadrez.corPRETA) {
			if ( (x == posX-1 || x == posX+1) && (y == posY+1) ) {
				posX = x;
				posY = y;
				return true ;
			}
		}
		
		// Fun��o en passant.
		if (cor == Xadrez.corPRETA && y == 4) {
			if ( (x == posX-1 || x == posX+1) && (y == posY) ) {
				posX = x;
				posY = y;				
				return true;
			}
		}		

		return false;		
	}
}
