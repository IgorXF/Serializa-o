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
public class Animal {
    private String cod; 
    private String especie;
    private String raca;
    private int idade;
    private double peso;

    // Construtor da classe
    public Animal(String cod, String especie, String raca, int idade, double peso) {
        this.cod = cod;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
    }
    
    public Animal() {
        this.cod = "";
        this.especie = "";
        this.raca = "";
        this.idade = 0;
        this.peso = 0.0;
    }

    // Métodos getters para acessar os valores dos campos
    public String getCod() {
        return cod;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    // Métodos setters para modificar os valores dos campos
    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.cod);
        hash = 67 * hash + Objects.hashCode(this.especie);
        hash = 67 * hash + Objects.hashCode(this.raca);
        hash = 67 * hash + this.idade;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
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
        final Animal other = (Animal) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        if (!Objects.equals(this.especie, other.especie)) {
            return false;
        }
        return Objects.equals(this.raca, other.raca);
    }

    @Override
    public String toString() {
        return "Animal{" + "cod=" + cod + ", especie=" + especie + ", raca=" + raca + ", idade=" + idade + ", peso=" + peso + '}';
    }
    
    
}


