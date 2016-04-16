package mvc.old;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.spi.JsonProvider;
import javax.json.stream.JsonParser;
import javax.swing.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import mvc.Model;

import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;

public class Controller_old implements ActionListener, Serializable {
	public Model model;

	public String readJson() {
		String result = "";
		try {
			URL url = new URL("https://api.hh.ru/vacancies");
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) result += line;
			rd.close();
		} catch (Exception e1) {e1.printStackTrace();}
		return result;
	}
	
	public void processJson() {
		//
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		try {
			ObjectOutputStream oos;
			ObjectInputStream ois;
				
			if (e.getActionCommand().equalsIgnoreCase("Save")) {
				oos = new ObjectOutputStream(new FileOutputStream(model.treeLeft.getClass().getName() + ".txt"));
				oos.writeObject(model.treeLeft);
				oos = new ObjectOutputStream(new FileOutputStream(model.treeRight.getClass().getName() + ".txt"));
				oos.writeObject(model.treeRight);
				//System.err.println("Save");
			}
			if (e.getActionCommand().equalsIgnoreCase("Load")) {
				ois = new ObjectInputStream(new FileInputStream(model.treeRight.getClass().getName() + ".txt"));
				JTree tree = (JTree) ois.readObject();
				model.treeLeft.setModel(tree.getModel());
				/*
				 * ois = new ObjectInputStream(new
				 * FileInputStream("med.Clinic.txt")); Clinic cl = (Clinic)
				 * ois.readObject(); view.getContentPane().add(cl);
				 * view.repaint();
				 */
			}
			if (e.getActionCommand().equalsIgnoreCase("Button1")) {
				//model.setTable("help_topic");
				//System.out.println(readJson());
				getJson2();
			}
		} 
		catch (Exception ex) {ex.printStackTrace();}
	}
	
	public void getGson(String json) throws IOException {
		Gson gson = new Gson();
		java.lang.reflect.Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
		Collection<String> ints2 = gson.fromJson(json, collectionType);
	}
	public void getJson() throws IOException {
		URL url = new URL("https://api.hh.ru/vacancies");
		  try (InputStream is = url.openStream();
		       JsonParser parser = Json.createParser(is)) {
		      while (parser.hasNext()) {
		          javax.json.stream.JsonParser.Event e1 = parser.next();
		          if (e1 == javax.json.stream.JsonParser.Event.KEY_NAME) {
		              switch (parser.getString()) {
		                  case "iems":
		                      parser.next();
		                    System.out.print(parser.getString());
		                    System.out.print("=: ");
		                    break;
		                  case "name":
		                    parser.next();
		                    System.out.print(parser.getString());
		                    System.out.print(": ");
		                    break;
		                  case "from":
			                    parser.next();
			                    System.out.print(parser.getString());
			                    System.out.print("$: ");
		                case "url":
		                    parser.next();
		                    System.out.println(parser.getString());
		                    System.out.println("---------");
		                    break;
		             }
		         }
		     }
		  }
	}

	public void getJson2() throws IOException {
		URL url = new URL("https://api.hh.ru/vacancies");
		InputStream is = url.openStream();
		JsonReader rdr = Json.createReader(is);
		JsonObject obj = rdr.readObject();
		JsonArray results = obj.getJsonArray("items");
		for (JsonObject result : results.getValuesAs(JsonObject.class)) {
			//System.out.println(result.getJsonObject("snippet").getString("salary"));
			// System.out.println(result.getString("area", "name"));
			System.out.println(result.toString());
		}
	}

	MouseListener listener = new MouseAdapter() {
		public void mousePressed(MouseEvent me) {
			JComponent comp = (JComponent) me.getSource();
			TransferHandler handler = comp.getTransferHandler();
			handler.exportAsDrag(comp, me, TransferHandler.COPY);
		}
	};
	
}
