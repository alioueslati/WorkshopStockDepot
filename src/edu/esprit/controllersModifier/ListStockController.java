/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.controllersModifier;

import edu.esprit.dao.StockDAO;
import edu.esprit.entities.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author OUESLATI
 */
public class ListStockController extends AbstractTableModel{
    
    String[] headers = {"ID", "TYPE", "QT", "QT_DEPOT"};
    List<Stock> listStock = new ArrayList<Stock>();
    
    public ListStockController()
    {
        StockDAO stockDAO = new StockDAO();
        listStock = stockDAO.DisplayAllStocks();
    }

    public int getRowCount() {
        
      return listStock.size();
      
    }

    public int getColumnCount() {
        
       return headers.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listStock.get(rowIndex).getNumero_stock();
            case 1:
                return listStock.get(rowIndex).getType_vet_stock();
            case 2:
                return listStock.get(rowIndex).getNombre_articles();
            case 3:
                return listStock.get(rowIndex).getDepot().getId_dep();
            default:
                return null;
                
        }
        
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
    
}
