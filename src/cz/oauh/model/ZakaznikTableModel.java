package cz.oauh.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ZakaznikTableModel extends AbstractTableModel {
    private final List<Zakaznik> data;
    public ZakaznikTableModel(List<Zakaznik> data) {
        this.data = data;
        this.fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return data.size();
    }
    @Override
    public int getColumnCount() {
        return 2;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakaznik zvolenyZakaznik = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return zvolenyZakaznik.getJmeno();
            case 1: return zvolenyZakaznik.getDatumNarozeni();
            default: throw new RuntimeException(
                    "Požadavek na neexistující číslo sloupce: "+columnIndex
                            +" - máme jen sloupce 0 a 1!");
        }
    }
}
