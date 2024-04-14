/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciador;

import classes.Casa;
import file.FilePersistence;
import file.SerializadorCSVCasa;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorxf
 */
public class GerenciadorCasa {
    private List<Casa> casas;

    public GerenciadorCasa() {
        this.casas = new ArrayList<>();
    }

    public void adicionarCasa(Casa casa) {
        casas.add(casa);
    }

    public boolean removerCasa(String id) {
        for (Casa casa : casas) {
            if (casa.getId().equalsIgnoreCase(id)) {
                casas.remove(casa);
                return true;
            }
        }
        return false;
    }

    public Casa buscarCasa(String id) {
        for (Casa casa : casas) {
            if (casa.getId().equalsIgnoreCase(id)) {
                System.out.println("Casa Encontrada");
                return casa;
            }
        }
        System.out.println("nao existe essa casa!");
        return null;
    }
    
    public void salvarCasa(Casa casa){
        adicionarCasa(casa);
        System.out.println("Casa salva com sucesso!");
    }
    
    public void atualizarCasa(String idAntigo, Casa casaNova) {
        Casa casaExistente = buscarCasa(idAntigo);
        
        if (casaExistente != null) {
            int indice = casas.indexOf(casaExistente);
            casas.set(indice, casaNova);
            System.out.println("Casa atualizada com sucesso.");
        } else {
            System.out.println("Casa com o id: " + idAntigo + " não encontrada.");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Casa casa : casas) {
            saida.append(casa.toString()).append("\n");
        }
        return saida.toString();
    }
    
    public void salvarNoArquivo(String caminhoDoArquivo) throws IOException{
        SerializadorCSVCasa serializadorCSV = new SerializadorCSVCasa();
        String csvData = serializadorCSV.toCSV(this.casas);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(csvData, caminhoDoArquivo);
        System.out.println("Casas salvas com sucesso em " + caminhoDoArquivo);

    }

    // Novo: Carrega a lista de objetos de um arquivo CSV
    public void carregarDoArquivo(String caminhoDoArquivo) throws FileNotFoundException {
        FilePersistence filePersistence = new FilePersistence();
        String csvData = filePersistence.loadFromFile(caminhoDoArquivo);
        
        SerializadorCSVCasa desserializadorCSV = new SerializadorCSVCasa();
        this.casas = desserializadorCSV.fromCSV(csvData);
        System.out.println("Casas carregadas com sucesso de " + caminhoDoArquivo);

    }  
}
