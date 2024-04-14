/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciador;

import classes.Carro;
import file.FilePersistence;
import file.SerializadorCSVCarro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorxf
 */
public class GerenciaCarros {
    private List<Carro> carros;

    public GerenciaCarros() {
        this.carros = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    public boolean removerCarro(String id) {
        for (Carro carro : carros) {
            if (carro.getId().equalsIgnoreCase(id)) {
                carros.remove(carro);
                return true;
            }
        }
        return false;
    }

    public Carro buscarCarro(String id) {
        for (Carro carro : carros) {
            if (carro.getId().equalsIgnoreCase(id)) {
                System.out.println("Carro Encontrado");
                return carro;
            }
        }
        System.out.println("nao existe esse carro!");
        return null;
    }
    
    public void salvarCarro(Carro carro){
        adicionarCarro(carro);
        System.out.println("Carro salvo com sucesso!");
    }
    
    public void atualizarCarro(String idAntigo, Carro carroNovo) {
        Carro carroExistente = buscarCarro(idAntigo);
        
        if (carroExistente != null) {
            int indice = carros.indexOf(carroExistente);
            carros.set(indice, carroNovo);
            System.out.println("Carro atualizado com sucesso.");
        } else {
            System.out.println("Carro com o nome " + idAntigo + " não encontrado.");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Carro carro : carros) {
            saida.append(carro.toString()).append("\n");
        }
        return saida.toString();
    }
    
    public void salvarNoArquivo(String caminhoDoArquivo) throws IOException{
        SerializadorCSVCarro serializadorCSV = new SerializadorCSVCarro();
        String csvData = serializadorCSV.toCSV(this.carros);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(csvData, caminhoDoArquivo);
        System.out.println("Carros salvos com sucesso em " + caminhoDoArquivo);

    }

    // Novo: Carrega a lista de objetos de um arquivo CSV
    public void carregarDoArquivo(String caminhoDoArquivo) throws FileNotFoundException {
        FilePersistence filePersistence = new FilePersistence();
        String csvData = filePersistence.loadFromFile(caminhoDoArquivo);
        
        SerializadorCSVCarro desserializadorCSV = new SerializadorCSVCarro();
        this.carros = desserializadorCSV.fromCSV(csvData);
        System.out.println("Carros carregados com sucesso de " + caminhoDoArquivo);

    }  
}
