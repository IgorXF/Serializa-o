package files;

import classes.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose
 */
public class SerializadorCSVProduto {
    
    // Serializa = Salvar no formato texto
    //Serializa a lista de produtos para uma String no formato CSV
    public String toCSV(List<Produto> produtos) {
        String csv = "Cod;Nome;Custo;Preco;Cor;\n";
        for (Produto produto : produtos) {
        csv += produto.getCod() + ";" 
            + produto.getNome() + ";"
            + produto.getCusto() + ";"
            + produto.getPreco() + ";"
            + produto.getCor() + ";\n"; // Removi o ponto e vírgula aqui
        }
    return csv;
    }

    // Deserializa uma String no formato CSV para uma lista de produtos
    public List<Produto> fromCSV(String data) {
        List<Produto> produtos = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        // Ignora o cabeçalho
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Produto produto = new Produto();
                produto.setCod(partes[0]);
                produto.setNome(partes[1]);
                produto.setCusto(Double.parseDouble(partes[2]));
                produto.setPreco(Double.parseDouble(partes[3]));
                
                //apos montar um produto, adiciono na lista
                produtos.add(produto);
            }
        }
        return produtos;
    }
}
