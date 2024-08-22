package com.lanchenlayer.repositories;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.interfaces.IProdutoRepository;

import java.util.ArrayList;

public class ProdutoRepository implements IProdutoRepository {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }
    public void atualizar(Produto produto,int index){
        produtos.set(index,produto);

    }

    public void remover(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public Produto buscarPorId(int id) {
        Produto produtoInDb = produtos.stream().filter(p -> p.getId() == id).findFirst().get();

        return produtoInDb;
    }

    public ArrayList<Produto> buscarTodos() {
        return produtos;
    }
}