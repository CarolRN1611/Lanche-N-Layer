package com.lanchenlayer.services;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.interfaces.IProdutoService;

public class ProdutoServiceDropbox implements IProdutoService {
    @Override
    public boolean salvarImagem(Produto produto) {
        return false;
    }

    @Override
    public boolean removerImagem(Produto produto) {
        return false;
    }

    @Override
    public boolean atualizarImagem(Produto produto, String caminhoImagem) {
        return false;
    }
}
