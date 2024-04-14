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
public class Musica {

    private String Titulo;
    private String Artista;
    private double Preco;
    private double Duracao;

    public Musica() {
        this.Titulo = " ";
        this.Artista = " ";
        this.Duracao = 0.0;
        this.Preco = 0.0;
    }
    
    public Musica (String Titulo, String Artista, double Preco, double Duracao) {
        this.Titulo = Titulo;
        this.Artista = Artista;
        this.Duracao = Duracao;
        this.Duracao = Duracao;
    }

    public void Copiar(Musica M1){
        this.Titulo = M1.getTitulo();
        this.Artista = M1.getArtista();
        this.Duracao = M1.getDuracao();
        this.Preco = M1.getPreco();
    }

    public void Imprimir(){
        System.out.println(this);
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public double getDuracao() {
        return Duracao;
    }

    public void setDuracao(double Duracao) {
        this.Duracao = Duracao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.Titulo);
        hash = 89 * hash + Objects.hashCode(this.Artista);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.Preco) ^ (Double.doubleToLongBits(this.Preco) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.Duracao) ^ (Double.doubleToLongBits(this.Duracao) >>> 32));
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
        final Musica other = (Musica) obj;
        if (Double.doubleToLongBits(this.Preco) != Double.doubleToLongBits(other.Preco)) {
            return false;
        }
        if (Double.doubleToLongBits(this.Duracao) != Double.doubleToLongBits(other.Duracao)) {
            return false;
        }
        if (!Objects.equals(this.Titulo, other.Titulo)) {
            return false;
        }
        return Objects.equals(this.Artista, other.Artista);
    }

    @Override
    public String toString() {
        return "Musica{" + "Titulo=" + Titulo + ", Artista=" + Artista + ", Preco=" + Preco + ", Duracao=" + Duracao + '}';
    }
    
    
}
