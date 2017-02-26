/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderers;

import java.awt.Component;
import evoting.model.TblPoliticalParty;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Administrator
 */
public class PoliticalPartyComboBoxRenderer extends DefaultListCellRenderer{
    
    @Override
    public Component getListCellRendererComponent(
    JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof TblPoliticalParty){
            TblPoliticalParty b = (TblPoliticalParty)value;
            setText(b.getFldTitle());
        }
        return this;
    }
}
