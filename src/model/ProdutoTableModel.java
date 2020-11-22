/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sala305b
 */
public class ProdutoTableModel extends AbstractTableModel {    

    private ArrayList<Produto> produtos;
    
    public ProdutoTableModel(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int getRowCount() {
        return this.produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = this.produtos.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return produto.getCodigo();
            case 1:
                return produto.getDescricao();
            case 2:
                return produto.getPreco();
            default:
                return null;
        }
    }   

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "CÓDIGO";
            case 1:
                return "DESCRIÇÃO";
            case 2:
                return "PREÇO";
            default:
                return "";
        }
    }
    
    public Produto getProduto(int indice){
        return this.produtos.get(indice);
    }
    
    public void removeVeiculo(int indice){
        this.produtos.remove(indice);
        
        fireTableDataChanged();
    }
    
    public void atualizarTabela(){
        fireTableDataChanged();
    }
    
    public void addListaNova(ArrayList<Produto> listaNova){
        this.produtos.clear();
        
        this.produtos.addAll(listaNova);
        fireTableDataChanged();
        
    }
    
}
