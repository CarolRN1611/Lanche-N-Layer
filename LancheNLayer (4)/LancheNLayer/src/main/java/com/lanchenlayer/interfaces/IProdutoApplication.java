package com.lanchenlayer.interfaces;

import com.lanchenlayer.entities.Produto;

import java.util.ArrayList;

public interface IProdutoApplication {
    public void adicionar(Produto produto);
    public void adicionarSoImagem(Produto produto);
    public void remover(int id);
    public Produto buscarPorId(int id);
    public ArrayList<Produto> buscarTodos();
    public float vender(int cod,int quantidade,ArrayList<Produto> produto);
}
