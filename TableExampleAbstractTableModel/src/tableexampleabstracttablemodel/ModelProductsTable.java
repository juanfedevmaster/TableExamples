/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableexampleabstracttablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModelProductsTable extends AbstractTableModel {

    List<Product> products;
    String[] columnNames = {"Product Id","Product name", "Stock"};

    public ModelProductsTable(List<Product> products) {
        this.products = products;
    }
    
    public void AddProduct(Product product){
        this.products.add(product);
        this.fireTableDataChanged();
    }
    
    public void removeProduct(){
        this.products.removeLast();
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return this.products.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var product = this.products.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                product.getProductId();
            case 1 ->
                product.getName();
            case 2 ->
                product.getStock();
            default ->
                product;
        };
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }
     
}
