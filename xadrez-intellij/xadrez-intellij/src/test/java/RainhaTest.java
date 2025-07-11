import br.com.afsj.model.*;
import br.com.afsj.view.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RainhaTest {
    Tabuleiro tabuleiro = new Tabuleiro();

    Rainha rb = Tabuleiro.rainhaBranca;
    IRainha irb = Tabuleiro.iRainhaBranca;

    Rainha rp = Tabuleiro.rainhaPreta;
    IRainha irp = Tabuleiro.iRainhaPreta;

    Peao pb = Tabuleiro.peaoBranco;
    IPeao ipb = Tabuleiro.iPeaoBranco;

    Torre tp = Tabuleiro.torrePreta;
    ITorre itp = Tabuleiro.iTorrePreta;

    Peao pp = Tabuleiro.peaoPreto;
    IPeao ipp = Tabuleiro.iPeaoPreto;

    Torre tb = Tabuleiro.torreBranca;
    ITorre itb = Tabuleiro.iTorreBranca;

    Cavalo cp = Tabuleiro.cavaloPreto;
    ICavalo icp = Tabuleiro.iCavaloPreto;

    Bispo bb1 = Tabuleiro.bispoBranco1;
    IBispo ibb1 = Tabuleiro.iBispoBranco1;

    @BeforeEach
    void iniciarTabuleiro() {
        // Reinicializa as peças do tabuleiro antes de cada teste
        Tabuleiro.rainhaBranca = new Rainha();
        Tabuleiro.iRainhaBranca = new IRainha(Tabuleiro.rainhaBranca);

        Tabuleiro.rainhaPreta = new Rainha();
        Tabuleiro.iRainhaPreta = new IRainha(Tabuleiro.rainhaPreta);

        Tabuleiro.cavaloPreto = new Cavalo();
        Tabuleiro.iCavaloPreto = new ICavalo(Tabuleiro.cavaloPreto);

        Tabuleiro.bispoBranco1 = new Bispo();
        Tabuleiro.iBispoBranco1 = new IBispo(Tabuleiro.bispoBranco1);

        Tabuleiro.torreBranca = new Torre();
        Tabuleiro.iTorreBranca = new ITorre(Tabuleiro.torreBranca);

        Tabuleiro.peaoBranco = new Peao();
        Tabuleiro.iPeaoBranco = new IPeao(Tabuleiro.peaoBranco);

        Tabuleiro.peaoPreto = new Peao();
        Tabuleiro.iPeaoPreto = new IPeao(Tabuleiro.peaoPreto);

        Tabuleiro.torrePreta = new Torre();
        Tabuleiro.iTorrePreta = new ITorre(Tabuleiro.torrePreta);

        tabuleiro = new Tabuleiro();
        tabuleiro.iniciar(new TradutorEspanhol());

        // Atualiza as variáveis locais do teste, pois por serem estáticas, elas influenciavam outros testes se não fossem reinicializadas
        rb = Tabuleiro.rainhaBranca;
        irb = Tabuleiro.iRainhaBranca;

        rp = Tabuleiro.rainhaPreta;
        irp = Tabuleiro.iRainhaPreta;

        pb = Tabuleiro.peaoBranco;
        ipb = Tabuleiro.iPeaoBranco;

        tp = Tabuleiro.torrePreta;
        itp = Tabuleiro.iTorrePreta;

        pp = Tabuleiro.peaoPreto;
        ipp = Tabuleiro.iPeaoPreto;

        tb = Tabuleiro.torreBranca;
        itb = Tabuleiro.iTorreBranca;

        cp = Tabuleiro.cavaloPreto;
        icp = Tabuleiro.iCavaloPreto;

        bb1 = Tabuleiro.bispoBranco1;
        ibb1 = Tabuleiro.iBispoBranco1;
    }

    @Test
    @DisplayName("Movimento Horizontal da Rainha Branca")
    void movimentoHorizontalRainhaBranca() {
        Tabuleiro.avaliarEventoPeca(rb, irb);

        Tabuleiro.avaliarEventoTabuleiro(7, 7);
        assertAll("Mover Rainha Branca para (7, 7)",
                () -> assertEquals(7, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Movimento Horizontal da Rainha Preta")
    void movimentoHorizontalRainhaPreta() {
        // Movimento para passar a vez para a rainha preta
        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(4, 6);

        Tabuleiro.avaliarEventoPeca(rp, irp);
        Tabuleiro.avaliarEventoTabuleiro(0, 0);
        assertAll("Mover Rainha Preta para (0, 0)",
                () -> assertEquals(0, rp.getPosX()),
                () -> assertEquals(0, rp.getPosY())
        );
    }

    @Test
    @DisplayName("Movimento Vertical da Rainha Branca")
    void movimentoVerticalRainhaBranca() {
        Tabuleiro.avaliarEventoPeca(rb, irb);

        Tabuleiro.avaliarEventoTabuleiro(3, 3);
        assertAll("Mover Rainha Branca para (3, 3)",
                () -> assertEquals(3, rb.getPosX()),
                () -> assertEquals(3, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Movimento Vertical da Rainha Preta")
    void movimentoVerticalRainhaPreta() {
        // Movimento para passar a vez para a rainha preta
        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(4, 6);

        Tabuleiro.avaliarEventoPeca(rp, irp);
        Tabuleiro.avaliarEventoTabuleiro(3, 2);
        assertAll("Mover Rainha Preta para (3, 2)",
                () -> assertEquals(3, rp.getPosX()),
                () -> assertEquals(2, rp.getPosY())
        );
    }

    @Test
    @DisplayName("Movimento Diagonal da Rainha Branca")
    void movimentoDiagonalRainhaBranca() {
        Tabuleiro.avaliarEventoPeca(rb, irb);

        Tabuleiro.avaliarEventoTabuleiro(5, 5);
        assertAll("Mover Rainha Branca para (5, 5)",
                () -> assertEquals(5, rb.getPosX()),
                () -> assertEquals(5, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Movimento Diagonal da Rainha Preta")
    void movimentoDiagonalRainhaPreta() {
        // Movimento para passar a vez para a rainha preta
        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(4, 6);

        Tabuleiro.avaliarEventoPeca(rp, irp);
        Tabuleiro.avaliarEventoTabuleiro(0, 3);
        assertAll("Mover Rainha Preta para (0, 3)",
                () -> assertEquals(0, rp.getPosX()),
                () -> assertEquals(3, rp.getPosY())
        );
    }

    @Test
    @DisplayName("Capturar peça Preta")
    void capturarPecaPreta() {
        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoPeca(cp, icp); // evento seleciona o cavalo preto para ser capturado

        // Verifica se a rainha branca ocupou a posição do cavalo preto, e se o cavalo preto foi removido do tabuleiro
        assertAll("Capturar cavalo preto em (2, 7)",
                () -> assertEquals(2, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY()),
                () -> assertEquals(-1, cp.getPosX()),
                () -> assertEquals(-1, cp.getPosY())
        );
    }

    @Test
    @DisplayName("Capturar peça Branca")
    void capturarPecaBranca() {
        // Movimento para passar a vez para a rainha preta
        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(4, 6);

        Tabuleiro.avaliarEventoPeca(rp, irp);
        Tabuleiro.avaliarEventoPeca(bb1, ibb1); // evento seleciona o bispo branco para ser capturado

        // Verifica se a rainha preta ocupou a posição do bispo branco, e se o bispo branco foi removido do tabuleiro
        assertAll("Capturar bispo branco em (4, 0)",
                () -> assertEquals(4, rp.getPosX()),
                () -> assertEquals(0, rp.getPosY()),
                () -> assertEquals(-1, bb1.getPosX()),
                () -> assertEquals(-1, bb1.getPosY())
        );
    }

    @Test
    @DisplayName("Capturar peça Amiga da Rainha Branca")
    void capturarPecaAmigaBranca() {
        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoPeca(pb, ipb); // evento seleciona o peão branco para ser capturado

        assertAll("Tentar capturar peão branco em (6, 4)",
                () -> assertEquals(3, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Capturar peça Amiga da Rainha Preta")
    void capturarPecaAmigaPreta() {
        // Movimento para passar a vez para a rainha preta
        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(4, 6);

        Tabuleiro.avaliarEventoPeca(rp, irp);
        Tabuleiro.avaliarEventoPeca(tp, itp); // evento seleciona a torre preta para ser capturada

        // Verifica se a rainha preta e a torre preta se mantiveram na posição inicial
        assertAll("Tentar capturar torre preta em (4, 1)",
                () -> assertEquals(3, rp.getPosX()),
                () -> assertEquals(0, rp.getPosY()),
                () -> assertEquals(4, tp.getPosX()),
                () -> assertEquals(1, tp.getPosY())
        );
    }

    @Test
    @DisplayName("Bloquear Movimento da Rainha Branca")
    void bloquearMovimentoRainhaBranca() {
        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoPeca(pp, ipp); // evento seleciona o peão preto para ser capturado

        // Verifica se a rainha branca e o peão preto se mantiveram na posição inicial
        assertAll("Tentar capturar peao preto em (7, 3)",
                () -> assertEquals(3, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY()),
                () -> assertEquals(7, pp.getPosX()),
                () -> assertEquals(3, pp.getPosY())
        );
    }

    @Test
    @DisplayName("Bloquear Movimento da Rainha Preta")
    void bloquearMovimentoRainhaPreta() {
        // Movimento para passar a vez para a rainha preta
        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(4, 6);

        Tabuleiro.avaliarEventoPeca(rp, irp);
        Tabuleiro.avaliarEventoPeca(tb, itb); // evento seleciona o bispo branco para ser capturado

        // Verifica se a rainha preta e o bispo branco 2 se mantiveram na posição inicial
        assertAll("Tentar capturar torre branca em (5, 2)",
                () -> assertEquals(3, rp.getPosX()),
                () -> assertEquals(0, rp.getPosY()),
                () -> assertEquals(5, tb.getPosX()),
                () -> assertEquals(2, tb.getPosY())
        );
    }
}