package br.com.afsj.model;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import br.com.afsj.control.Xadrez;
import br.com.afsj.view.*;

public class Tabuleiro {

	public static JFrame TELA;

	public static ArrayPecas listaBrancas;
	public static ArrayPecas listaPretas;

	protected static int corJogadorAtual;
	protected static Peca pecaMarcada;
	protected static IPeca iPecaMarcada;

	public static Rainha rainhaBranca = new Rainha();
	public static IRainha iRainhaBranca = new IRainha(rainhaBranca);

	public static Rainha rainhaPreta = new Rainha();
	public static IRainha iRainhaPreta = new IRainha(rainhaPreta);

	public static Cavalo cavaloPreto = new Cavalo();
	public static ICavalo iCavaloPreto = new ICavalo(cavaloPreto);

	public static Bispo bispoBranco1 = new Bispo();
	public static IBispo iBispoBranco1 = new IBispo(bispoBranco1);

	public static Torre torreBranca = new Torre();
	public static ITorre iTorreBranca = new ITorre(torreBranca);

	public static Peao peaoBranco = new Peao();
	public static IPeao iPeaoBranco = new IPeao(peaoBranco);

	public static Peao peaoPreto = new Peao();
	public static IPeao iPeaoPreto = new IPeao(peaoPreto);

	public static Torre torrePreta = new Torre();
	public static ITorre iTorrePreta = new ITorre(torrePreta);

	public void iniciar(Tradutor t) {
		listaBrancas = new ArrayPecas();
		listaPretas = new ArrayPecas();

		corJogadorAtual = Xadrez.corBRANCA;
		pecaMarcada = null;
		iPecaMarcada = null;
		ITabuleiro iTabuleiro = new ITabuleiro();

		TELA = new JFrame(t.traduzir("Xadrez"));

		rainhaBranca.setCor(Xadrez.corBRANCA);
		rainhaBranca.mover(3, 7);
		iRainhaBranca.setIconeBranco(new ImageIcon("imagens/Rainha-Brancas-Branco.png"));
		iRainhaBranca.setIconeMarrom(new ImageIcon("imagens/Rainha-Brancas-Marrom.png"));
		iRainhaBranca.mover(3, 7);
		TELA.getContentPane().add(iRainhaBranca.getImagem());
		listaBrancas.add(rainhaBranca);

		rainhaPreta.setCor(Xadrez.corPRETA);
		rainhaPreta.mover(3, 0);
		iRainhaPreta.setIconeBranco(new ImageIcon("imagens/Rainha-Pretas-Branco.png"));
		iRainhaPreta.setIconeMarrom(new ImageIcon("imagens/Rainha-Pretas-Marrom.png"));
		iRainhaPreta.mover(3, 0);
		TELA.getContentPane().add(iRainhaPreta.getImagem());
		listaPretas.add(rainhaPreta);

		cavaloPreto.setCor(Xadrez.corPRETA);
		cavaloPreto.mover(2, 7);
		iCavaloPreto.setIconeBranco(new ImageIcon("imagens/Cavalo-Pretas-Branco.png"));
		iCavaloPreto.setIconeMarrom(new ImageIcon("imagens/Cavalo-Pretas-Marrom.png"));
		iCavaloPreto.mover(2, 7);
		TELA.getContentPane().add(iCavaloPreto.getImagem());
		listaPretas.add(cavaloPreto);

		bispoBranco1.setCor(Xadrez.corBRANCA);
		bispoBranco1.mover(4, 0);
		iBispoBranco1.setIconeBranco(new ImageIcon("imagens/Bispo-Brancas-Branco.png"));
		iBispoBranco1.setIconeMarrom(new ImageIcon("imagens/Bispo-Brancas-Marrom.png"));
		iBispoBranco1.mover(4, 0);
		TELA.getContentPane().add(iBispoBranco1.getImagem());
		listaBrancas.add(bispoBranco1);

		peaoBranco.setCor(Xadrez.corBRANCA);
		peaoBranco.mover(6, 4);
		iPeaoBranco.setIconeBranco(new ImageIcon("imagens/Peao-Brancas-Branco.png"));
		iPeaoBranco.setIconeMarrom(new ImageIcon("imagens/Peao-Brancas-Marrom.png"));
		iPeaoBranco.mover(6, 4);
		TELA.getContentPane().add(iPeaoBranco.getImagem());
		listaBrancas.add(peaoBranco);

		torrePreta.setCor(Xadrez.corPRETA);
		torrePreta.mover(4, 1);
		iTorrePreta.setIconeBranco(new ImageIcon("imagens/Torre-Pretas-Branco.png"));
		iTorrePreta.setIconeMarrom(new ImageIcon("imagens/Torre-Pretas-Marrom.png"));
		iTorrePreta.mover(4, 1);
		TELA.getContentPane().add(iTorrePreta.getImagem());
		listaPretas.add(torrePreta);

		peaoPreto.setCor(Xadrez.corPRETA);
		peaoPreto.mover(7, 3);
		iPeaoPreto.setIconeBranco(new ImageIcon("imagens/Peao-Pretas-Branco.png"));
		iPeaoPreto.setIconeMarrom(new ImageIcon("imagens/Peao-Pretas-Marrom.png"));
		iPeaoPreto.mover(7, 3);
		TELA.getContentPane().add(iPeaoPreto.getImagem());
		listaPretas.add(peaoPreto);

		torreBranca.setCor(Xadrez.corBRANCA);
		torreBranca.mover(5, 2);
		iTorreBranca.setIconeBranco(new ImageIcon("imagens/Torre-Brancas-Branco.png"));
        iTorreBranca.setIconeMarrom(new ImageIcon("imagens/Torre-Brancas-Marrom.png"));
		iTorreBranca.mover(5, 2);
		TELA.getContentPane().add(iTorreBranca.getImagem());
		listaBrancas.add(torreBranca);

		TELA.getContentPane().add(iTabuleiro.getImagem());
		TELA.setSize(400, 400);
		TELA.setVisible(true);
		TELA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void avaliarEventoPeca(Peca p, IPeca ip) {
		if (p.getCor() == corJogadorAtual)
			marcarPeca(p, ip);
		else if (pecaMarcada != null)
			capturarPeca(p, ip);
	}

	public static void avaliarEventoTabuleiro(int x, int y) {
		if ( (pecaMarcada != null) && (x >= 0) && (x <= 7) && (y >=0) && (y <= 7) ) {
			moverPecaMarcada(x, y);
		}
	}

	public static void marcarPeca(Peca p, IPeca ip) {
		if (iPecaMarcada != null)
			iPecaMarcada.desmarcar();
		pecaMarcada = p;
		iPecaMarcada = ip;
		iPecaMarcada.marcar();
	}

	public static void capturarPeca(Peca p, IPeca ip) {
		if (pecaMarcada.capturar(p.getPosX(), p.getPosY())) {
			ip.remover();
			TELA.getContentPane().remove(ip.getImagem());
			iPecaMarcada.desmarcar();
			iPecaMarcada.mover(p.getPosX(), p.getPosY());
			p.remover();
			pecaMarcada = null;
			iPecaMarcada = null;
			if (corJogadorAtual == Xadrez.corBRANCA)
				corJogadorAtual = Xadrez.corPRETA;
			else
				corJogadorAtual = Xadrez.corBRANCA;
		}
	}

	public static void moverPecaMarcada(int x, int y) {
		if (pecaMarcada.mover(x, y)) {
			iPecaMarcada.desmarcar();
			iPecaMarcada.mover(x, y);
			pecaMarcada = null;
			iPecaMarcada = null;
			if (corJogadorAtual == Xadrez.corBRANCA)
				corJogadorAtual = Xadrez.corPRETA;
			else
				corJogadorAtual = Xadrez.corBRANCA;
		}
	}
}

