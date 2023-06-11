
package controller;
import java.util.ArrayList;

import model.Adocao;

public class ControleAdocao {

    private ArrayList<Adocao> listaAdocoes;

    public ControleAdocao() {
        listaAdocoes = new ArrayList<>();
    }

    public void cadastrarAdocao(Adocao adocao) {
        if (adocao == null) {
            throw new IllegalArgumentException("Adoção inválida. Informações faltando.");
        }
        listaAdocoes.add(adocao);
    }

    public ArrayList<Adocao> listarAdocoes() {
        return listaAdocoes;
    }

    public ArrayList<Adocao> buscarAdocoesPorUsuario(String nomeUsuario) {
        ArrayList<Adocao> adocoesUsuario = new ArrayList<>();
        for (Adocao adocao : listaAdocoes) {
            if (adocao.getUsuario().getNome().equals(nomeUsuario)) {
                adocoesUsuario.add(adocao);
            }
        }
        return adocoesUsuario;
    }

    public ArrayList<Adocao> buscarAdocoesPorCachorro(String nomeCachorro) {
        ArrayList<Adocao> adocoesCachorro = new ArrayList<>();
        for (Adocao adocao : listaAdocoes) {
            if (adocao.getCao().getNome().equals(nomeCachorro)) {
                adocoesCachorro.add(adocao);
            }
        }
        return adocoesCachorro;
    }

    public void removerAdocao(Adocao adocao) {
        if (!listaAdocoes.contains(adocao)) {
            throw new IllegalArgumentException("Adoção não encontrada na lista.");
        }
        listaAdocoes.remove(adocao);
    }
}