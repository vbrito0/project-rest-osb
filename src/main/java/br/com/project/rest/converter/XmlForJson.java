package br.com.project.rest.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class XmlForJson {
	
public static void main(String[] args) throws JSONException {
		
		//--------------------------------------
		// (1) monta "cliente.xml" em uma string
		//--------------------------------------
				
		String xmlString = "<?xml version=\"1.0\"?>" + 
					"<clientes>" + 
						"<cliente>" +
							"<nome>Victor</nome>" + 
							"<idade>20</idade>" + 
						"</cliente>" + 
						"<cliente>" + 
							"<nome>Leonardo</nome>" + 
							"<idade>16</idade>" + 
						"</cliente>" + 
					"</clientes>";
		
		//--------------------------------------------------------------
		// (2) cria um JSONObject a partir do arquivo XML
		//     com o uso do método estático "toJSONObject" da classe XML
		//---------------------------------------------------------------
		
		JSONObject clientesJson = XML.toJSONObject(xmlString);
		
		//----------------------------------------------------------------
		// (3) gera e imprime a string JSON, com o uso do método toString() 
		//-----------------------------------------------------------------
		
		System.out.println(clientesJson.toString());
		
	}
}
