package com.lanchenlayer.services;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.interfaces.IProdutoService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ProdutoService implements IProdutoService {
    private String caminhoDestino = "C:\\Users\\aluno\\Downloads\\LancheNLayer (4)\\LancheNLayer\\src\\main\\resources\\images\\";

    public static String getFileExtension(String filePath) {
        String fileName = new File(filePath).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "No extension" : fileName.substring(dotIndex + 1);
    }

    public boolean salvarImagem(Produto produto) {
        Path pathOrigem = Paths.get(produto.getImagem());
        String extensao = getFileExtension(produto.getImagem());
        Path pathDestino = Paths.get(String.format("%s%d.%s", caminhoDestino, produto.getId(), extensao));
        produto.setImagem(pathDestino.toString());

        if (Files.exists(pathOrigem)) {
            try {
                Files.copy(pathOrigem, pathDestino, StandardCopyOption.REPLACE_EXISTING);
                produto.setImagem(pathDestino.toString());  // Atualiza o caminho completo da imagem
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
            if (Files.exists(pathImagem)) {
                Files.delete(pathImagem);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizarImagem(Produto produto, String caminhoImagem) {

        if (!removerImagem(produto)) {
            return false;
        }


        Path pathOrigem = Paths.get(caminhoImagem);
        String extensao = getFileExtension(caminhoImagem);
        Path pathDestino = Paths.get(String.format("%s%d.%s", caminhoDestino, produto.getId(), extensao));

        try {
            if (Files.exists(pathOrigem)) {
                Files.copy(pathOrigem, pathDestino, StandardCopyOption.REPLACE_EXISTING);
                produto.setImagem(pathDestino.toString());
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
