/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timekeeper.view;

import timekeeper.model.project.Project;

import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Toppy
 */
public class ProjectTableModel extends AbstractTableModel {

     private List <Project> pro;
     private static final String[] COLUMN_NAMES = {"Project Id", "Status", "Name", "Description"};
     public Class[] m_colTypes = { Integer.class, Boolean.class, String.class, String.class  };
     
     public ProjectTableModel(List<Project> pro)
     {
         super();
         this.pro = pro;
     }
    @Override
    public int getRowCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return pro.size();
    
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String getColumnName(int columnIndex)
    {   
        
         return COLUMN_NAMES[columnIndex];
        
    }
   

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Project pro1 = pro1 = pro.get(rowIndex);
        
        switch(columnIndex){
        case 0: return pro1.getProjectID();
        case 1: return "A";
        case 2: return pro1.getName();
        case 3 : return pro1.getDescription();
        }
        return new String();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   /* public void setValueAt(Object value,int row, int col)
    {
       Project pro1 = (Project) pro.get(row);
       switch(col)
       {
           case 0: pro1.setProjectID((Integer) value);
           break;
           case 1: pro1.setActiveFlag((Boolean) value);
           break;
           case 2: pro1.setName((String) value);
               break;
           case 3: pro1.setDescription((String) value);
               break;
       }
    }*/
    
}
