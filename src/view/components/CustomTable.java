package view.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class CustomTable extends JTable {
    public CustomTable(String[] columnNames) {
        super(new DefaultTableModel(columnNames, 0));
        setRowHeight(35);
        setFillsViewportHeight(true);
        setGridColor(new Color(230, 230, 230)); // لون الحدود
        setFont(new Font("Arial", Font.PLAIN, 14));
        setSelectionBackground(new Color(52, 152, 219));
        setSelectionForeground(Color.WHITE);

        // Custom header design
        JTableHeader header = getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(new Color(41, 128, 185)); // أزرق داكن للرأس
        header.setForeground(Color.WHITE);
    }

    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) getModel();
    }

    public void addRow(Object[] rowData) {
        getTableModel().addRow(rowData);
    }
}
