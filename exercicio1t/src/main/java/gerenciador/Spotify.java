/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciador;

import classes.Musica;
import files.FilePersistence;
import files.SerializadorCSVMusica;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorxf
 */
public class Spotify {
    private List<Musica> musicas;

    public Spotify() {
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
         musicas.add(musica);
         System.out.println("Música adicionada");
    }

    public boolean removerMusica(String titulo) {
        for (Musica musica : musicas) {
            if (musica.getTitulo().equals(titulo)) {
                musicas.remove(musica);
                System.out.println("Musica removida com sucesso!");
                return true;
            }
         }
         System.out.println("Musica nao existe");
         return false;
    }

    public Musica buscarMusica(String titulo) {
        for (Musica musica : musicas) {
            if (musica.getTitulo().equals(titulo)) {
                System.out.println("Música encontrada com sucesso!");
                return musica;
            }
        }
        System.out.println("Não encontrada");
        return null;
    }

    public void salvarMusica(Musica musica) {
         this.musicas.add(musica);
        System.out.println("Música salva com sucesso");
    }

    public void atualizarMusica(String titulo, Musica musicaNova) {
        Musica musicaExistente = buscarMusica(titulo);
         if(musicaExistente != null) {
            int indice = musicas.indexOf(musicaExistente);
            musicas.set(indice, musicaNova);
            System.out.println("Música atualizada com sucesso.");
        } else {
            System.out.println("Música com o titulo " + titulo + " não encontrado.");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Musica produto : musicas) {
            saida.append(produto.toString()).append("\n");
        }
        return saida.toString();
    }
         
    public void salvarNoArquivo(String caminhoDoArquivo) throws IOException{
        SerializadorCSVMusica serializadorCSV = new SerializadorCSVMusica();
        String csvData = serializadorCSV.toCSV(this.musicas);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(csvData, caminhoDoArquivo);
        System.out.println("Músicas salvas com sucesso em " + caminhoDoArquivo);

    }

    // Novo: Carrega a lista de objetos de um arquivo CSV
    public void carregarDoArquivo(String caminhoDoArquivo) throws FileNotFoundException {
        FilePersistence filePersistence = new FilePersistence();
        String csvData = filePersistence.loadFromFile(caminhoDoArquivo);
        
        SerializadorCSVMusica desserializadorCVS = new SerializadorCSVMusica();
        this.musicas = desserializadorCVS.fromCSV(csvData);
        System.out.println("Músicas carregadas com sucesso de " + caminhoDoArquivo);

    }    

}
