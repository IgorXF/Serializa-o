/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciador;

import files.SerializadorCSVAnimal;
import classes.Animal;
import files.FilePersistence;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorxf
 */
public class GerenciaAnimal {
    private List<Animal> animais;

    public GerenciaAnimal() {
        this.animais = new ArrayList<>();
    }

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
        System.out.println("Animal adicionado com sucesso!");
    }

    public boolean removerAnimal(String cod) {
        for (Animal animal : animais) {
            if (animal.getCod().equals(cod)) {
                animais.remove(animal);
                System.out.println("Animal removido com sucesso!");
                return true;
            }
        }
        System.out.println("Animal não encontrado!");
        return false;
    }

    public Animal buscarAnimal(String cod) {
        for (Animal animal : animais) {
            if (animal.getCod().equals(cod)) {
                return animal;
            }
        }
        return null;
    }
    
    public void salvarAnimal(Animal animal){
        adicionarAnimal(animal);
        System.out.println("Animal salvo com sucesso!");
    }
        
    
    public void atualizarAnimal(String codAntigo, Animal animalNovo) {
        Animal animalExistente = buscarAnimal(codAntigo);
        
        if (animalExistente != null) {
            int indice = animais.indexOf(animalExistente);
            animais.set(indice, animalNovo);
            System.out.println("Animal atualizado com sucesso.");
        } else {
            System.out.println("Animal com o nome " + codAntigo + " não encontrado.");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Animal animal : animais) {
            saida.append(animal.toString()).append("\n");
        }
        return saida.toString();
    }
    
    public void salvarNoArquivo(String caminhoDoArquivo) throws IOException{
        SerializadorCSVAnimal serializadorCSV = new SerializadorCSVAnimal();
        String csvData = serializadorCSV.toCSV(this.animais);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(csvData, caminhoDoArquivo);
        System.out.println("Animais salvos com sucesso em " + caminhoDoArquivo);

    }

    // Novo: Carrega a lista de objetos de um arquivo CSV
    public void carregarDoArquivo(String caminhoDoArquivo) throws FileNotFoundException {
        FilePersistence filePersistence = new FilePersistence();
        String csvData = filePersistence.loadFromFile(caminhoDoArquivo);
        
        SerializadorCSVAnimal desserializadorCSV = new SerializadorCSVAnimal();
        this.animais = desserializadorCSV.fromCSV(csvData);
        System.out.println("Animais carregados com sucesso de " + caminhoDoArquivo);

    }  
}
