package mvc;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.swing.table.AbstractTableModel;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.util.Vector;

public class TableModel extends AbstractTableModel {
	public Vector cache; // will hold String[] objects . . .
	public int colCount;
	public String[] headers;
	private Connection db;
	public Statement statement;

	public TableModel() {
		// super();
		cache = new Vector();
	}

	// @Override
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

	public void setTable(String arg) {
		cache = new Vector();
		try {
			String text = URLEncoder.encode(arg, "UTF-8");
			URL url = new URL ("https://api.hh.ru/vacancies?"
			//URL url = new URL ("http://localhost:8080/NovaPoshtaJAVA/vacancies?"
					//+ "use_recommendations=false&"
					+ "text=" + text + "&"
					//+ "L_neighbours=true&"
					//+ "search_field=name&"
					//+ "search_field=company_name&"
					//+ "search_field=description&"
					//+ "search_debug=false&"
					//+ "items_on_page=30&"
					+ "area=2&"
					//+ "area=3&"
					//+ "area=104&"
					//+ "area=22&area=102&"
					//+ "L_disable_clusters_narrowing=false&"
					//+ "enable_snippets=true&"
					//+ "no_magic=false&"
					//+ "only_with_salary=true&"
					//+ "L_site=XHH&"
					//+ "clusters=true&"
					+ "salary=110000&"
					+ "exclude_archived=true&"
					//+ "L_lenient=true&"
					//+ "L_priority_sort=metallic&"
					//+ "currency_code=RUR&"
					+ "exclude_closed=true&"
					//+ "page=0&"
					+ "order_by=salary_desc&"
					+ "search_period=");
			InputStream is = url.openStream();
			JsonReader rdr = Json.createReader(is);
			JsonObject obj = rdr.readObject();
			JsonArray arr = obj.getJsonArray("items");
			
			colCount = 6;
			headers = new String[colCount];
			headers[0] = "date";
			headers[1] = "employer";
			headers[2] = "city";
			headers[3] = "work";
			headers[4] = "salary";
			headers[5] = "snippet";
			
			for (JsonObject result : arr.getValuesAs(JsonObject.class) ) {
				String[] record = new String[colCount];
				record[0] = (""+result.get("published_at")).substring(1, 11);
				record[1] = ""+result.getJsonObject("employer").get("name");
				record[2] = ""+result.getJsonObject("area").get("name");
				record[3] = ""+result.get("name");
				record[4] = ""+result.get("salary");
				record[5] = ""+result.getJsonObject("snippet").get("responsibility");
				try {
					if ((""+result.get("salary")).toString().length()>4) {
						record[4] = ""+result.getJsonObject("salary").get("from");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}			
				cache.addElement(record);
			}	

		} catch (Exception e) {
			cache = new Vector(); // blank it out and keep going.
			e.printStackTrace();
		}
	}

}
