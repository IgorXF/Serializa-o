/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

import classes.Musica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorxf
 */
public class SerializadorCSVMusica {
    public String toCSV(List<Musica> musicas) {
        String csv = "Titulo;Artista;Preco;Duracao;\n";
        for (Musica musica : musicas) {
            csv += musica.getTitulo() + ";" 
                +  musica.getArtista() + ";"
                +  musica.getPreco() + ";"
                +  musica.getDuracao() + ";\n";
        }
        return csv;
    }
    public List<Musica> fromCSV(String data) {
        List<Musica> musicas = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        // Ignora o cabeçalho
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Musica musica = new Musica();
                musica.setTitulo(partes[0]);
                musica.setArtista(partes[1]);
                musica.setPreco(Double.parseDouble(partes[2]));
                musica.setDuracao(Double.parseDouble(partes[3]));
                
                //apos montar um produto, adiciono na lista
                musicas.add(musica);
            }
        }
        return musicas;
    }

    
}
