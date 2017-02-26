/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderers;

import java.awt.Component;
import evoting.model.TblCandidate;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
/**
 *
 * @author Panagiotis
 */
public class CandidateCompoBoxRenderer extends DefaultListCellRenderer{
    
    @Override
    public Component getListCellRendererComponent(
    JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof TblCandidate){
            TblCandidate b = (TblCandidate)value;
            setText(b.getFldName()+"  "+b.getFldName());
        }
        return this;
    }
}