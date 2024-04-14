/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import classes.Casa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorxf
 */
public class SerializadorCSVCasa {
    public String toCSV(List<Casa> casas) {
    String csv = "ID;Tipo;Quartos;Banheiros;Area;Preco;\n";
    for (Casa casa : casas) {
        csv += casa.getId() + ";"
            + casa.getTipo() + ";"  
            + casa.getQuartos() + ";"
            + casa.getBanheiros() + ";"
            + casa.getArea() + ";"
            + casa.getPreco() + ";\n";
    }
    return csv;
}
    public List<Casa> fromCSV(String data) {
        List<Casa> casas = new ArrayList<>();
    
        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Casa casa = new Casa();
                casa.setId(partes[0]);
                casa.setTipo(partes[1]);
                casa.setQuartos(Integer.parseInt(partes[2]));
                casa.setBanheiros(Integer.parseInt(partes[3]));
                casa.setArea(Double.parseDouble(partes[4]));
                casa.setPreco(Double.parseDouble(partes[5]));
                casas.add(casa);
             }
        }
        return casas;
    }
}
