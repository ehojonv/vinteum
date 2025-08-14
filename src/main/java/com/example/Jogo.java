package com.example;

public class Jogo {

    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Jogador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
    }

    public Carta distribuirCartaParaJogador(Jogador jogador) {
        if (jogador.parou()) {
            return null;
        }

        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }

    public boolean acabou() {
        var osDoisPararam = jogador.parou() && computador.parou();

        return estourou(jogador) ||
                estourou(computador) ||
                osDoisPararam;
    }

    public String resultado() {
        if ((estourou(jogador) && estourou(computador)) || jogador.getPontos() == computador.getPontos()) {
            return "Empatou";
        }

        if (jogador.getPontos() > computador.getPontos() || (estourou(computador) && !estourou(jogador))) {
            return "Você ganhou";
        }

        return "Você perdeu otário";
    }

    private boolean estourou(Jogador jogador) {
        return jogador.getPontos() > 21;
    }

}
