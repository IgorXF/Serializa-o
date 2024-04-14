package files;

import classes.Animal;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author igorxf
 */
public class SerializadorCSVAnimal {
     public String toCSV(List<Animal> animais) {
        String csv = "Cod;Especie;Raça;Idade;Peso;\n";
        for (Animal animal : animais) {
            csv += animal.getCod() + ";" 
                +  animal.getEspecie() + ";"
                +  animal.getRaca() + ";"
                +  animal.getIdade() + ";"
                +  animal.getPeso() + ";\n";
        }
        return csv;
    }
    public List<Animal> fromCSV(String data) {
        List<Animal> animais = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        // Ignora o cabeçalho
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Animal animal = new Animal();
                animal.setCod(partes[0]);
                animal.setEspecie(partes[1]);
                animal.setRaca(partes[2]);
                animal.setIdade(Integer.parseInt(partes[3]));
                animal.setPeso(Double.parseDouble(partes[4]));
                
                //apos montar um produto, adiciono na lista
                animais.add(animal);
            }
        }
        return animais;
    }
}
