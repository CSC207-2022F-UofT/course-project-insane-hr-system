package presenter.view_model;

import java.util.Arrays;
import java.util.List;

public class Table {
    private String[] columnName;
    private Object[][] data;
    private Object[] reference;

    public Table(String[] columnName, Object[][] data, Object[] reference) {
        this.columnName = columnName;
        this.data = data;
        this.reference = reference;
    }

    public String[] getColumnName() {
        return columnName;
    }

    public void setColumnName(String[] columnName) {
        this.columnName = columnName;
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public Object[] getReference() {
        return reference;
    }

    public void setReference(Object[] reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Table{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
