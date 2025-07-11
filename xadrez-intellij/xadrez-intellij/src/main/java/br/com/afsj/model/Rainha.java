/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.afsj.model;

/**
 *
 * @author Aluno
 */
public class Rainha extends Peca {
    @Override
	public boolean movimentoOK(int x, int y) {
		
    	if (posX == -1 && posY == -1) {
			posX = x;
			posY = y;
			return true;
		}
		
    	/*
    	if ( ( (x == posX+2 || x == posX-2) && (y == posY-1 || y == posY+1) ) ||
			 ( (x == posX+1 || x == posX-1) && (y == posY-2 || y == posY+2) ) ) {
			posY = y;
			posX = x;
			return true ;
		}*/
    	
    	int sinalX, sinalY;
    	if (x>posX)
    		sinalX=-1;
    	else if (x<posX)
    		sinalX=1;
    	else
    		return false;
    	
    	if (y > posY)
    		sinalY=-1;
    	else if (y < posY)
    		sinalY=1;
    	else
    		return false;
    	
    	int aX = x;
    	int aY = y;
    
    	boolean caminhoLivre= true;
    	
    	do{
    		
    		aX=aX+sinalX;
    		aY=aY+sinalY;
    		
    		if (aX==posX && aY==posY)
    			return caminhoLivre;
    		
    		if (Tabuleiro.listaBrancas.pecaPosicao(aX, aY)!=null){
                    System.out.printf("Há peças brancas - x=%d, y=%d\n", aX, aY);
                    caminhoLivre=false;
                }
                
                if (Tabuleiro.listaPretas.pecaPosicao(aX, aY)!=null){
                    System.out.printf("Há peças pretas - x=%d, y=%d\n", aX, aY);
                    caminhoLivre=false;
                }
    	} while ((aX >0 && aX<8) && (aY >0 && aY <8));
        return false;
    
    }
    
}
