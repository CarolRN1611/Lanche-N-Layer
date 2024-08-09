package com.lanchenlayer.applications;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.repositories.ProdutoRepository;
import com.lanchenlayer.services.ProdutoService;

import java.util.ArrayList;

public class ProdutoApplication {
    private ProdutoRepository produtoRepository;
    private ProdutoService produtoService;

    public ProdutoApplication(ProdutoRepository produtoRepository, ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
    }

    public void adicionar(Produto produto) {
        this.produtoRepository.adicionar(produto);
        this.produtoService.salvarImagem(produto);
    }

    public void adicionarSoImagem(Produto produto) {
        this.produtoService.salvarImagem(produto);
    }

    public void remover(int id) {
        this.produtoRepository.remover(id);
    }

    public Produto buscarPorId(int id) {
        return this.produtoRepository.buscarPorId(id);
    }

    public ArrayList<Produto> buscarTodos() {
        return this.produtoRepository.buscarTodos();
    }

    public float vender(int cod,int quantidade,ArrayList<Produto> produto){
        float total;
        for (int i = 0; i < produto.size(); i++) {
            if(produto.get(i).getId() ==cod){
                total = produto.get(i).getValor() * quantidade;
                return total;
            }
        }
        return -1;
    }
}
