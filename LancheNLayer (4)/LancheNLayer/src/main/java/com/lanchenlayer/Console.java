package com.lanchenlayer;

import com.lanchenlayer.applications.ProdutoApplication;
import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.facade.ProdutoFacade;
import com.lanchenlayer.interfaces.IProdutoApplication;
import com.lanchenlayer.interfaces.IProdutoRepository;
import com.lanchenlayer.interfaces.IProdutoService;
import com.lanchenlayer.repositories.ProdutoRepository;
import com.lanchenlayer.services.ProdutoService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Console {
    public static void main(String[] args) {
        IProdutoRepository produtoRepository = new ProdutoRepository();
        IProdutoService produtoService = new ProdutoService();
        IProdutoApplication produtoApplication = new ProdutoApplication(produtoRepository, produtoService);
        ProdutoFacade produtoFacade = new ProdutoFacade(produtoApplication);

        produtoFacade.adicionar(new Produto(1, "Cachorro quente", 4.00f, "C:\\Users\\aluno\\imagens\\cachorroquente.jpg"));
        produtoFacade.adicionar(new Produto(2, "X-Salada", 5.00f, "C:\\Users\\aluno\\imagens\\xsalada.jpg"));

        ArrayList<Produto> produtos = produtoFacade.buscarTodos();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        System.out.println("Descrição");
        produtos.forEach(c -> {
            System.out.println(c.getDescricao());
        });

        while (!sair) {
            System.out.println("1-Cadastrar Produto");
            System.out.println("2-Fazer Venda");
            System.out.println("3-Remover imagem");
            System.out.println("4-Atualizar imagem");
            System.out.println("Qualquer outra tecla para sair");

            int resposta = scanner.nextInt();
            scanner.nextLine();

            if (resposta == 1) {
                System.out.println("Informe o nome do produto");
                String descricao = scanner.nextLine();

                System.out.println("Informe o caminho da imagem do produto");
                String imagem = scanner.nextLine();

                System.out.println("Informe o codigo do produto");
                int codigo = scanner.nextInt();

                System.out.println("Informe o preço do produto");
                float preco = scanner.nextFloat();
                scanner.nextLine();

                Produto p = new Produto(codigo, descricao, preco, imagem);
                produtoApplication.adicionar(p);
            } else if (resposta == 2) {
                float i;
                System.out.println("Informe o codigo do produto");
                int codigo = scanner.nextInt();

                System.out.println("Informe a quantidade do produto");
                int quantidade = scanner.nextInt();
                i = produtoApplication.vender(codigo, quantidade, produtos);

                if (i == -1) {
                    System.out.println("codigo não encontrado");
                } else {
                    System.out.println("o valor total é " + i);
                }

            } else if (resposta == 3) {
                System.out.println("Informe o codigo do produto");
                int codigo = scanner.nextInt();

                //Produto produtoImagem = produtoRepository.buscarPorId(codigo);
                Produto produtoImagem = produtos.get(codigo-1);
                System.out.println(produtoImagem);
                if (produtoImagem != null) {
                    boolean feito = produtoService.removerImagem(produtoImagem);

                    if (feito) {
                        System.out.println("Imagem removida com sucesso!");
                    } else {
                        System.out.println("Erro ao remover imagem.");
                    }
                } else {
                    System.out.println("Produto não encontrado.");
                }

            }else if (resposta == 4) {
                System.out.println("Informe o codigo do produto");
                int codigo = scanner.nextInt();

                Produto produtoImagem = produtoRepository.buscarPorId(codigo);

                System.out.println(produtoImagem);
                if (produtoImagem != null) {
                    System.out.println("Informe o novo caminho da imagem ");
                    String caminhoImagem = scanner.nextLine();
                    scanner.nextLine();

                    boolean feito = produtoService.atualizarImagem(produtoImagem ,caminhoImagem);

                    if (feito) {
                        System.out.println("Imagem atualizada com sucesso!");
                    } else {
                        System.out.println("Erro ao atualizar imagem.");
                    }
                } else {
                    System.out.println("Produto não encontrado.");
                }
                } else {
                sair = true;
            }
        }
    }
}