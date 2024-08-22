package com.lanchenlayer.applications;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.interfaces.IProdutoApplication;
import com.lanchenlayer.interfaces.IProdutoRepository;
import com.lanchenlayer.interfaces.IProdutoService;
import com.lanchenlayer.repositories.ProdutoRepository;
import com.lanchenlayer.services.ProdutoService;

import java.util.ArrayList;

public class ProdutoApplication implements IProdutoApplication {
    private IProdutoRepository produtoRepository;
    private IProdutoService produtoService;

    public ProdutoApplication(IProdutoRepository produtoRepository, IProdutoService produtoService) {
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