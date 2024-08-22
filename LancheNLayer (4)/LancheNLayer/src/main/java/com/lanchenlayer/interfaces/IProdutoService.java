package com.lanchenlayer.interfaces;

import com.lanchenlayer.entities.Produto;

public interface IProdutoService {
    public boolean salvarImagem(Produto produto);
    public boolean removerImagem(Produto produto);
    public boolean atualizarImagem(Produto produto, String caminhoImagem);
}
