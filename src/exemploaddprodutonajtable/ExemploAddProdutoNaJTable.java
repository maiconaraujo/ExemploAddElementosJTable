/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploaddprodutonajtable;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import view.FormularioPedido;

/**
 *
 * @author MAICON
 */
public class ExemploAddProdutoNaJTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        FormularioPedido form = new FormularioPedido();
        form.setVisible(true);
    }
    
}
