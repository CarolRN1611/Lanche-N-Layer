package com.lanchenlayer.interfaces;

import com.lanchenlayer.entities.Produto;

import java.util.ArrayList;

public interface IProdutoRepository {
    public void adicionar(Produto produto);
    private Produto filtrarProduto(int id);
    public void atualizar(Produto produto,int index);
    public void remover(int id);
    public Produto buscarPorId(int id);
    public ArrayList<Produto> buscarTodos();
}
