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
public class ItemDePedidoTableModel extends AbstractTableModel {

    private ArrayList<ItemDePedido> itensDePedido;

    public ItemDePedidoTableModel(ArrayList<ItemDePedido> itens) {
        this.itensDePedido = itens;
    }
  

    @Override
    public int getRowCount() {
        return itensDePedido.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemDePedido item = itensDePedido.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getProduto().getDescricao();
            case 1:
                return item.getQtd();
            case 2:
                return item.getValorItem();
            default:
                return "";
        }

    }
    

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "PRODUTO";
            case 1:
                return "QUANTIDADE";
            case 2:
                return "VALOR ITEM";
            default:
                return "";
        }
    }

    public ItemDePedido getItem(int i) {
        return this.itensDePedido.get(i);
    }

    public void atualizaTabela() {
        fireTableDataChanged();
    }

}
