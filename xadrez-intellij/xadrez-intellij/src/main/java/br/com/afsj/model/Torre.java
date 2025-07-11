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
public class Torre extends Peca{

    @Override
    public boolean movimentoOK(int x, int y) {
        // como ele se movimenta
        if (posX == -1 && posY == -1) {
            return true;
        }
        
        for (int i = 0; i < 8; i++) {
            if ((x == posX+i && x == posX-i) || (y == posY+i && y == posY-i)) {
                return true;
            }
        }
        
        return false;
    }
    
    
    
}
