package com.lanchenlayer.services;

import com.lanchenlayer.entities.Produto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ProdutoService {
    private String caminhoDestino = "C:\\Users\\aluno\\LancheNLayer\\src\\main\\resources\\images\\";

    public static String getFileExtension(String filePath) {
        String fileName = new File(filePath).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "No extension" : fileName.substring(dotIndex + 1);
    }

    public boolean salvarImagem(Produto produto) {
        Path pathOrigem = Paths.get(produto.getImagem());
        String extensao = getFileExtension(produto.getImagem());
        Path pathDestino = Paths.get(String.format("%s%d.%s", caminhoDestino, produto.getId(), extensao));
        produto.setImagem(String.valueOf(pathDestino));

        if (Files.exists(pathOrigem)) {
            try {
                Files.copy(pathOrigem, pathDestino, StandardCopyOption.REPLACE_EXISTING);
                produto.setImagem(pathDestino.getFileName().toString());
                return true;
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }

        return false;
    }

    public boolean removerImagem(Produto produto) {
        Path pathImagem = Paths.get(caminhoDestino, String.format("%d.%s", produto.getId(), getFileExtension(produto.getImagem())));

        try {
            System.out.println("1");
            if (Files.exists(pathImagem)) {
                System.out.println("2");
                Files.delete(pathImagem);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("3");
            e.printStackTrace();
            return false;
        }
    }

public boolean atualizarImagem(Produto produto, int id) {

    if (!removerImagem(produto)) {
        return false;
    }

    Path pathOrigem = Paths.get(produto.getImagem());
    String extensao = ProdutoService.getFileExtension(produto.getImagem());
    Path pathDestino = Paths.get(String.format("%s%d.%s", caminhoDestino, id, extensao));

    try {
        if (Files.exists(pathOrigem)) {
            Files.copy(pathOrigem, pathDestino, StandardCopyOption.REPLACE_EXISTING);
            produto.setImagem(pathDestino.getFileName().toString());
            return true;
        } else {
            return false;
        }
    } catch (IOException ex) {
        ex.printStackTrace();
        return false;
    }
}
}

