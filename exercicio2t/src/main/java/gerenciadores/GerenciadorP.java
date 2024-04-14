/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadores;

import classes.Produto;
import files.FilePersistence;
import files.SerializadorCSVProduto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorxf
 */
public class GerenciadorP {

    private List<Produto> produtos;

    public GerenciadorP() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
         System.out.println("Produto adicionado");
    }

    public boolean removerProduto(String cod) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(cod)) {
                System.out.println("Produto removido com sucesso!");
                return produtos.remove(produto);
            }
        }
        System.out.println("Produto nao existe");
        return false;
    }

    public Produto buscarProduto(String cod) {
        for (Produto produto : produtos) {
            if (produto.getCod().equalsIgnoreCase(cod)) {
                System.out.println("Produto encontrado com sucesso!");
                return produto;
            }
        }
        System.out.println("Produto nao encontrado");
        return null;
    }

    public void salvarProduto(Produto produto) {
        adicionarProduto(produto);
        System.out.println("Produto salvo com sucesso!");
    }

    public void atualizarProduto(String cod, Produto produtoNovo) {
        Produto produtoExistente = buscarProduto(cod);
        
        if (produtoExistente != null) {
            int indice = produtos.indexOf(produtoExistente);
            produtos.set(indice, produtoNovo);
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Produto com o nome " + cod + " não encontrado.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Produto produto : produtos) {
            sb.append(produto.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public void salvarNoArquivo(String caminhoDoArquivo) throws IOException {
        //Serializando XML
        SerializadorCSVProduto serializadorCSV = new SerializadorCSVProduto();
        String csvData = serializadorCSV.toCSV(this.produtos);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(csvData, caminhoDoArquivo);
        System.out.println("Produtos salvos com sucesso em " + caminhoDoArquivo);
    }

    public void carregarDoArquivo(String caminhoDoArquivo) throws FileNotFoundException {
        FilePersistence filePersistence = new FilePersistence();
        String jsonData = filePersistence.loadFromFile(caminhoDoArquivo);

        //Desserializando JSON
        SerializadorCSVProduto desserializadorJSON = new SerializadorCSVProduto();
        this.produtos = desserializadorJSON.fromCSV(jsonData);

        System.out.println("Produtos carregados com sucesso de " + caminhoDoArquivo);
    }

}
