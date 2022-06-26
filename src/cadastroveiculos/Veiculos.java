/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroveiculos;

/**
 *
 * @author charlistonrodrigo
 */


public class Veiculos {
    int codigo;
    String placa;
    String marca;
    String modelo;
    int ano_fab;
    int ano_mod;
    double valor;
    Veiculos prox;
    
    public Veiculos(int codigo,String placa, String marca,String modelo,int ano_fab, int ano_mod ,double valor){
    
         this.ano_fab = ano_fab;
         this.ano_mod = ano_mod;
         this.codigo = codigo;
         this.modelo = modelo;
         this.placa = placa;
         this.marca = marca;
         this.valor = valor;
    }
    public Veiculos(){   
    }
}