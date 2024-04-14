/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import classes.Carro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorxf
 */
public class SerializadorCSVCarro {
    public String toCSV(List<Carro> carros) {
    String csv = "ID;Marca;Modelo;Ano;Preco;\n";
    for (Carro carro : carros) {
        csv += carro.getId() + ";"
            + carro.getMarca() + ";"  
            + carro.getModelo() + ";"
            + carro.getAno() + ";"
            + carro.getPreco() + ";\n";
    }
    return csv;
}
    public List<Carro> fromCSV(String data) {
        List<Carro> carros = new ArrayList<>();
    
        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
        String[] partes = linhas[i].split(";");
        if (partes.length >= 4) {
            Carro carro = new Carro();
            carro.setId(partes[0]);
            carro.setMarca(partes[1]);
            carro.setModelo(partes[2]);
            carro.setAno(Integer.parseInt(partes[3]));
            carro.setPreco(Double.parseDouble(partes[4]));
            carros.add(carro);
        }
    }
    return carros;
}
}
