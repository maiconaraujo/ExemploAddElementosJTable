/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author MAICON
 */
public class Pedido {
    private int codigo;
    private Cliente cliente;
    private double total;
    private ArrayList<ItemDePedido> itens = new ArrayList<>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<ItemDePedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemDePedido> itens) {
        this.itens = itens;
    }
    
    public double calcularTotal(){
        double total = 0;
        for(ItemDePedido item : itens){
            total = total + item.getValorItem();
        }
        
        return total;
    }
}
