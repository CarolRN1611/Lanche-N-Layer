package com.lanchenlayer.repositories;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.interfaces.IProdutoRepository;

import java.util.ArrayList;

public class ProdutoRepository implements IProdutoRepository {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }
     private Produto filtrarProduto(int id){
        return produtos.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public void atualizar(Produto produto,int index){
        Produto produtoEmDb = filtrarProduto(index);

       produtoEmDb.setDescricao(produto.getDescricao());
       produtoEmDb.setImagem(produto.getImagem());
       produtoEmDb.setValor(produto.getValor());
    }

    public void remover(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public Produto buscarPorId(int id) {
        Produto produtoInDb = filtrarProduto(int id);

        return produtoInDb;
    }

    public ArrayList<Produto> buscarTodos() {
        return produtos;
    }
}
