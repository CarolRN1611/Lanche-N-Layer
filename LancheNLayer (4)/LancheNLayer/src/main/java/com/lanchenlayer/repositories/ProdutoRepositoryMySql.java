package com.lanchenlayer.repositories;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.interfaces.IProdutoRepository;

import java.util.ArrayList;

public class ProdutoRepositoryMySql  implements IProdutoRepository {
    @Override
    public void adicionar(Produto produto) {

    }
    @Override
    private Produto filtrarProduto(int id){
    }

    @Override
    public void atualizar(Produto produto, int index) {

    }

    @Override
    public void remover(int id) {

    }

    @Override
    public Produto buscarPorId(int id) {
        return null;
    }

    @Override
    public ArrayList<Produto> buscarTodos() {
        return null;
    }
}
