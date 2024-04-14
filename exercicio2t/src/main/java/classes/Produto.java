/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Objects;

/**
 *
 * @author igorxf
 */
public class Produto {
    private String cod;
    private String nome;
    private double custo;
    private double preco;
    private String cor;

    // Construtor da classe
    public Produto(String cod, String nome, double custo, double preco, String cor) {
        this.cod = cod;
        this.nome = nome;
        this.custo = custo;
        this.preco = preco;
        this.cor = cor;
    }
    
    public Produto() {
        this.cod = " " ;
        this.nome = " ";
        this.custo = 0.0;
        this.preco = 0.0;
        this.cor = " ";
    }


    // Métodos getters para acessar os valores dos campos
    public String getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public double getPreco() {
        return preco;
    }

    public String getCor() {
        return cor;
    }

    // Métodos setters para modificar os valores dos campos
    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cod);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.custo) ^ (Double.doubleToLongBits(this.custo) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.cor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (Double.doubleToLongBits(this.custo) != Double.doubleToLongBits(other.custo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.cor, other.cor);
    }

    @Override
    public String toString() {
        return "Produto{" + "cod=" + cod + ", nome=" + nome + ", custo=" + custo + ", preco=" + preco + ", cor=" + cor + '}';
    }
    
}
