package mvc;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Vector;

public class TableModel extends AbstractTableModel {
    /**
     *
     */
    private static final long serialVersionUID = 3588820044312603136L;
    public Vector cache; // will hold String[] objects . . .
    public int colCount;
    public String[] headers;
    private Connection db;
    public Statement statement;

    public TableModel() {
        //super();
        cache = new Vector();
    }

    //@Override
    public String getColumnName(int i) {
        return headers[i];
    }

    public int getColumnCount() {
        return colCount;
    }

    public int getRowCount() {
        return cache.size();
    }

    public Object getValueAt(int row, int col) {
        return ((String[]) cache.elementAt(row))[col];
    }

    public void setHostURL(String url) {
        closeDB();
        initDB(url);
        setQuery("SELECT * FROM help_topic limit 35");
    }

    void setQuery(String q) {
        cache = new Vector();
        try {
            ResultSet rs = statement.executeQuery(q);
            ResultSetMetaData meta = rs.getMetaData();
            colCount = meta.getColumnCount();

            // Now we must rebuild the headers array with the new column names
            headers = new String[colCount];
            for (int h = 1; h <= colCount; h++) {
                headers[h - 1] = meta.getColumnName(h);
            }

            // and file the cache with the records from our query. This would
            // not be
            // practical if we were expecting a few million records in response
            // to our
            // query, but we aren't, so we can do this.
            while (rs.next()) {
                String[] record = new String[colCount];
                for (int i = 0; i < colCount; i++) {
                    record[i] = rs.getString(i + 1);
                }
                // noinspection unchecked
                cache.addElement(record);
                // System.out.println(record.toString());
            }
            //fireTableChanged(null); // notify everyone that we have a new table.
        } catch (Exception e) {
            cache = new Vector(); // blank it out and keep going.
            e.printStackTrace();
        }
    }

    void initDB(String url) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            db = DriverManager.getConnection(url);
            statement = db.createStatement();
        } catch (Exception e) {
            System.out.println("Could not initialize the database.");
            e.printStackTrace();
        }
    }

    void closeDB() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (db != null) {
                db.close();
            }
        } catch (Exception e) {
            System.out.println("Could not close the current connection.");
            e.printStackTrace();
        }
    }

}
