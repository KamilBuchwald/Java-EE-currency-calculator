package kalkulator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.lang.model.element.Element;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


public class ObliczServlet extends HttpServlet {
	


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req,res);
		
	} 
	
	
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
	
	
	double wartosc = Double.parseDouble(req.getParameter("ilosc")); 
	String walwym = req.getParameter("browser");
	String walotr = req.getParameter("browser2");
	double NowaWartosc; 
	double Mnoznik;
	
			
	
	
	
	
	         
	         switch(walwym){
	     	case "PLN":
	     			switch (walotr) {
	     			case "EUR":
	     				
	     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
	     				
	     				URL obj = new URL(url);
	     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     				con.setRequestMethod("GET");
	     				BufferedReader in = new BufferedReader(
	     				        new InputStreamReader(con.getInputStream()));
	     				String inputLine;
	     				StringBuffer response = new StringBuffer();

	     				while ((inputLine = in.readLine()) != null) {
	     					response.append(inputLine);
	     				}
	     				in.close();

	     				 try
	     				    {
	     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	     				        DocumentBuilder db = dbf.newDocumentBuilder();
	     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

	     				        doc.getDocumentElement().normalize();
	     				        
	     				         String wartoscs = doc.getDocumentElement().getLastChild().
	     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
	     				         double kurs = Double.parseDouble(wartoscs);
	     				         
	     				         
	     				        Mnoznik = 1/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				        	
	     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
	     				      df.setMaximumFractionDigits(2);
	     				      df.setMinimumFractionDigits(2);
	     				      String NW = df.format(NowaWartosc);
	     				      
	     				      req.setAttribute("walP", walwym);
	     				      	req.setAttribute("ilosc", wartosc);
	    	     				 req.setAttribute("wartosc", NW);
	    	     				req.setAttribute("waluta", walotr); 
	    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	    	     				 rd.forward(req,res); 
	     				         
	     				  
	     				    }
	     				        
	     				   	 catch (Exception e)
	     				   	    {
	     				   	        e.printStackTrace();
	     				   	    }
	     				
	     				 break;
	     			case "DOL" :
String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
	     				
	     				URL obj2 = new URL(url2);
	     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
	     				con2.setRequestMethod("GET");
	     				BufferedReader in2 = new BufferedReader(
	     				        new InputStreamReader(con2.getInputStream()));
	     				String inputLine2;
	     				StringBuffer response2 = new StringBuffer();

	     				while ((inputLine2 = in2.readLine()) != null) {
	     					response2.append(inputLine2);
	     				}
	     				in2.close();

	     				 try
	     				    {
	     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	     				        DocumentBuilder db = dbf.newDocumentBuilder();
	     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

	     				        doc.getDocumentElement().normalize();
	     				        
	     				         String wartoscs = doc.getDocumentElement().getLastChild().
	     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
	     				         double kurs = Double.parseDouble(wartoscs);
	     				         
	     				         
	     				        Mnoznik = 1/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				        	
	     				        	java.text.DecimalFormat df=new java.text.DecimalFormat();
	     				        	df.setMaximumFractionDigits(2);
	     				        	df.setMinimumFractionDigits(2);
	     				        	String NW = df.format(NowaWartosc);
	     				        	
	     				        	req.setAttribute("walP", walwym);
		     				      	req.setAttribute("ilosc", wartosc);
		    	     				 req.setAttribute("wartosc", NW);
	    	     				req.setAttribute("waluta", walotr); 
	    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	    	     				 rd.forward(req,res); 
	     				         
	     				  
	     				    }
	     				        
	     				   	 catch (Exception e)
	     				   	    {
	     				   	        e.printStackTrace();
	     				   	    }
	     				 
	     				 break;
	     				 
	     				 
	     				 
	     			case "CHF" :
	     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
	     					     				
	     					     				URL obj3 = new URL(url3);
	     					     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
	     					     				con3.setRequestMethod("GET");
	     					     				BufferedReader in3 = new BufferedReader(
	     					     				        new InputStreamReader(con3.getInputStream()));
	     					     				String inputLine3;
	     					     				StringBuffer response3 = new StringBuffer();

	     					     				while ((inputLine3 = in3.readLine()) != null) {
	     					     					response3.append(inputLine3);
	     					     				}
	     					     				in3.close();

	     					     				 try
	     					     				    {
	     					     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	     					     				        DocumentBuilder db = dbf.newDocumentBuilder();
	     					     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

	     					     				        doc.getDocumentElement().normalize();
	     					     				        
	     					     				         String wartoscs = doc.getDocumentElement().getLastChild().
	     					     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
	     					     				         double kurs = Double.parseDouble(wartoscs);
	     					     				         
	     					     				         
	     					     				       Mnoznik = 1/kurs;
	     				     				        	NowaWartosc = wartosc*Mnoznik;
	     				     				        	
	     					     				     java.text.DecimalFormat df=new java.text.DecimalFormat();
	     			     				        	df.setMaximumFractionDigits(2);
	     			     				        	df.setMinimumFractionDigits(2);
	     			     				        	String NW = df.format(NowaWartosc);
	     			     				        	
	     			     				        	req.setAttribute("walP", walwym);
	     				     				      	req.setAttribute("ilosc", wartosc);
	     				    	     				 req.setAttribute("wartosc", NW);
	     					    	     				req.setAttribute("waluta", walotr); 
	     					    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	     					    	     				 rd.forward(req,res); 
	     					     				         
	     					     				  
	     					     				    }
	     					     				        
	     					     				   	 catch (Exception e)
	     					     				   	    {
	     					     				   	        e.printStackTrace();
	     					     				   	    }
	     					
	     			
	     					     				 break;
	     			
	     			case "CAD" :
	     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
	     					     				
	     					     				URL obj4 = new URL(url4);
	     					     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
	     					     				con4.setRequestMethod("GET");
	     					     				BufferedReader in4 = new BufferedReader(
	     					     				        new InputStreamReader(con4.getInputStream()));
	     					     				String inputLine4;
	     					     				StringBuffer response4 = new StringBuffer();

	     					     				while ((inputLine4 = in4.readLine()) != null) {
	     					     					response4.append(inputLine4);
	     					     				}
	     					     				in4.close();

	     					     				 try
	     					     				    {
	     					     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	     					     				        DocumentBuilder db = dbf.newDocumentBuilder();
	     					     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

	     					     				        doc.getDocumentElement().normalize();
	     					     				        
	     					     				         String wartoscs = doc.getDocumentElement().getLastChild().
	     					     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
	     					     				         double kurs = Double.parseDouble(wartoscs);
	     					     				         
	     					     				        Mnoznik = 1/kurs;
	     				     				        	NowaWartosc = wartosc*Mnoznik;
	     				     				        	
	     					     				     java.text.DecimalFormat df=new java.text.DecimalFormat();
	     			     				        	df.setMaximumFractionDigits(2);
	     			     				        	df.setMinimumFractionDigits(2);
	     			     				        	String NW = df.format(NowaWartosc);
	     				     				       
	     			     				        	req.setAttribute("walP", walwym);
	     				     				      	req.setAttribute("ilosc", wartosc);
	     				    	     				 req.setAttribute("wartosc", NW);
	     					    	     				req.setAttribute("waluta", walotr); 
	     					    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	     					    	     				 rd.forward(req,res); 
	     					     				         
	     					     				  
	     					     				    }
	     					     				        
	     					     				   	 catch (Exception e)
	     					     				   	    {
	     					     				   	        e.printStackTrace();
	     					     				   	    }
	     					     				 break;
	     					     				 
	     			case "GBP" :
	     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
	     					     				
	     					     				URL obj5 = new URL(url5);
	     					     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
	     					     				con5.setRequestMethod("GET");
	     					     				BufferedReader in5 = new BufferedReader(
	     					     				        new InputStreamReader(con5.getInputStream()));
	     					     				String inputLine5;
	     					     				StringBuffer response5 = new StringBuffer();

	     					     				while ((inputLine5 = in5.readLine()) != null) {
	     					     					response5.append(inputLine5);
	     					     				}
	     					     				in5.close();

	     					     				 try
	     					     				    {
	     					     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	     					     				        DocumentBuilder db = dbf.newDocumentBuilder();
	     					     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

	     					     				        doc.getDocumentElement().normalize();
	     					     				        
	     					     				         String wartoscs = doc.getDocumentElement().getLastChild().
	     					     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
	     					     				         double kurs = Double.parseDouble(wartoscs);
	     					     				         
	     					     				         
	     					     				       Mnoznik = 1/kurs;
	     				     				        	NowaWartosc = wartosc*Mnoznik;
	     				     				        	
	     					     				     java.text.DecimalFormat df=new java.text.DecimalFormat();
	     			     				        	df.setMaximumFractionDigits(2);
	     			     				        	df.setMinimumFractionDigits(2);
	     			     				        	String NW = df.format(NowaWartosc);
	     				     				       
	     			     				        	req.setAttribute("walP", walwym);
	     				     				      	req.setAttribute("ilosc", wartosc);
	     				    	     				 req.setAttribute("wartosc", NW);
	     					    	     				req.setAttribute("waluta", walotr);
	     					    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	     					    	     				 rd.forward(req,res); 
	     					     				         
	     					     				  
	     					     				    }
	     					     				        
	     					     				   	 catch (Exception e)
	     					     				   	    {
	     					     				   	        e.printStackTrace();
	     					     				   	    }
	     					     				 break;
	     					     				 
	     					     				 
	     			case "JPY" :
	     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
	     					     				
	     					     				URL obj6 = new URL(url6);
	     					     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
	     					     				con6.setRequestMethod("GET");
	     					     				BufferedReader in6 = new BufferedReader(
	     					     				        new InputStreamReader(con6.getInputStream()));
	     					     				String inputLine6;
	     					     				StringBuffer response6 = new StringBuffer();

	     					     				while ((inputLine6 = in6.readLine()) != null) {
	     					     					response6.append(inputLine6);
	     					     				}
	     					     				in6.close();

	     					     				 try
	     					     				    {
	     					     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	     					     				        DocumentBuilder db = dbf.newDocumentBuilder();
	     					     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

	     					     				        doc.getDocumentElement().normalize();
	     					     				        
	     					     				         String wartoscs = doc.getDocumentElement().getLastChild().
	     					     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
	     					     				         double kurs = Double.parseDouble(wartoscs);
	     					     				         
	     					     				         
	     					     				       Mnoznik = 1/kurs;
	     				     				        	NowaWartosc = wartosc*Mnoznik;
	     				     				        	
	     					     				     java.text.DecimalFormat df=new java.text.DecimalFormat();
	     			     				        	df.setMaximumFractionDigits(2);
	     			     				        	df.setMinimumFractionDigits(2);
	     			     				        	String NW = df.format(NowaWartosc);
	     				     				       
	     			     				        	req.setAttribute("walP", walwym);
	     				     				      	req.setAttribute("ilosc", wartosc);
	     				    	     				 req.setAttribute("wartosc", NW);
	     					    	     				req.setAttribute("waluta", walotr);
	     					    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	     					    	     				 rd.forward(req,res); 
	     					     				         
	     					     				  
	     					     				    }
	     					     				        
	     					     				   	 catch (Exception e)
	     					     				   	    {
	     					     				   	        e.printStackTrace();
	     					     				   	    }
	     					     				 break;
	     					     				 
	     					     				 
	     			case "AUD" :
	     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
	     					     				
	     					     				URL obj7 = new URL(url7);
	     					     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
	     					     				con7.setRequestMethod("GET");
	     					     				BufferedReader in7 = new BufferedReader(
	     					     				        new InputStreamReader(con7.getInputStream()));
	     					     				String inputLine7;
	     					     				StringBuffer response7 = new StringBuffer();

	     					     				while ((inputLine7 = in7.readLine()) != null) {
	     					     					response7.append(inputLine7);
	     					     				}
	     					     				in7.close();

	     					     				 try
	     					     				    {
	     					     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	     					     				        DocumentBuilder db = dbf.newDocumentBuilder();
	     					     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

	     					     				        doc.getDocumentElement().normalize();
	     					     				        
	     					     				         String wartoscs = doc.getDocumentElement().getLastChild().
	     					     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
	     					     				         double kurs = Double.parseDouble(wartoscs);
	     					     				         
	     					     				         
	     					     				       Mnoznik = 1/kurs;
	     				     				        	NowaWartosc = wartosc*Mnoznik;
	     				     				        	
	     					     				     java.text.DecimalFormat df=new java.text.DecimalFormat();
	     			     				        	df.setMaximumFractionDigits(2);
	     			     				        	df.setMinimumFractionDigits(2);
	     			     				        	String NW = df.format(NowaWartosc);
	     				     				       
	     			     				        	req.setAttribute("walP", walwym);
	     				     				      	req.setAttribute("ilosc", wartosc);
	     				    	     				 req.setAttribute("wartosc", NW);
	     					    	     				req.setAttribute("waluta", walotr);
	     					    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	     					    	     				 rd.forward(req,res); 
	     					     				         
	     					     				  
	     					     				    }
	     					     				        
	     					     				   	 catch (Exception e)
	     					     				   	    {
	     					     				   	        e.printStackTrace();
	     					     				   	    }
	     					     				 break;
	     					     				 
	     					     				 
	     					     				 
	     			case "CZK" :
	     				String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
	     					     				
	     					     				URL obj8 = new URL(url8);
	     					     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
	     					     				con8.setRequestMethod("GET");
	     					     				BufferedReader in8 = new BufferedReader(
	     					     				        new InputStreamReader(con8.getInputStream()));
	     					     				String inputLine8;
	     					     				StringBuffer response8 = new StringBuffer();

	     					     				while ((inputLine8 = in8.readLine()) != null) {
	     					     					response8.append(inputLine8);
	     					     				}
	     					     				in8.close();

	     					     				 try
	     					     				    {
	     					     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	     					     				        DocumentBuilder db = dbf.newDocumentBuilder();
	     					     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

	     					     				        doc.getDocumentElement().normalize();
	     					     				        
	     					     				         String wartoscs = doc.getDocumentElement().getLastChild().
	     					     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
	     					     				         double kurs = Double.parseDouble(wartoscs);
	     					     				         
	     					     				       Mnoznik = 1/kurs;
	     				     				        	NowaWartosc = wartosc*Mnoznik;
	     					     				         
	     					    	     				 
	     					     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
	     				     				        	df.setMaximumFractionDigits(2);
	     				     				        	df.setMinimumFractionDigits(2);
	     				     				        	String NW = df.format(NowaWartosc);
	     					     				       
	     				     				        	req.setAttribute("walP", walwym);
	     					     				      	req.setAttribute("ilosc", wartosc);
	     					    	     				 req.setAttribute("wartosc", NW);
	     					    	     				req.setAttribute("waluta", walotr);
	     					    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	     					    	     				 rd.forward(req,res); 
	     					     				         
	     					     				  
	     					     				    }
	     					     				        
	     					     				   	 catch (Exception e)
	     					     				   	    {
	     					     				   	        e.printStackTrace();
	     					     				   	    }
	     					     				 break;
	     					     				 
	     					     				 
	     			
	     			case "UAH" :
	     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
	     					     				
	     					     				URL obj9 = new URL(url9);
	     					     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
	     					     				con9.setRequestMethod("GET");
	     					     				BufferedReader in9 = new BufferedReader(
	     					     				        new InputStreamReader(con9.getInputStream()));
	     					     				String inputLine9;
	     					     				StringBuffer response9 = new StringBuffer();

	     					     				while ((inputLine9 = in9.readLine()) != null) {
	     					     					response9.append(inputLine9);
	     					     				}
	     					     				in9.close();

	     					     				 try
	     					     				    {
	     					     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	     					     				        DocumentBuilder db = dbf.newDocumentBuilder();
	     					     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

	     					     				        doc.getDocumentElement().normalize();
	     					     				        
	     					     				         String wartoscs = doc.getDocumentElement().getLastChild().
	     					     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
	     					     				         double kurs =Double.parseDouble(wartoscs);
	     					     				         
	     					     				         
	     					     				       Mnoznik = 1/kurs;
	     				     				        	NowaWartosc = wartosc*Mnoznik;
	     				     				        	
	     					     				     java.text.DecimalFormat df=new java.text.DecimalFormat();
	     			     				        	df.setMaximumFractionDigits(2);
	     			     				        	df.setMinimumFractionDigits(2);
	     			     				        	String NW = df.format(NowaWartosc);
	     				     				       
	     			     				        	req.setAttribute("walP", walwym);
	     				     				      	req.setAttribute("ilosc", wartosc);
	     				    	     				 req.setAttribute("wartosc", NW);
	     					    	     				req.setAttribute("waluta", walotr);
	     					    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	     					    	     				 rd.forward(req,res); 
	     					     				         
	     					     				  
	     					     				    }
	     					     				        
	     					     				   	 catch (Exception e)
	     					     				   	    {
	     					     				   	        e.printStackTrace();
	     					     				   	    }
	     					     				 break;
	     			}
	     			
	     	case "EUR":
     			switch (walotr) {
     			case "DOL":
     				
     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     					String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL obj2 = new URL(url2);
         				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
         				con2.setRequestMethod("GET");
         				BufferedReader in2 = new BufferedReader(
         				        new InputStreamReader(con2.getInputStream()));
         				String inputLine2;
         				StringBuffer response2 = new StringBuffer();

         				while ((inputLine2 = in2.readLine()) != null) {
         					response2.append(inputLine2);
         				}
         				in.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(url2).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     				         
     				  
     				    }
     				        
     				   	 catch (Exception e)
     				   	    {
     				   	        e.printStackTrace();
     				   	    }
     				
     				 break;
     			case "EUR" :
     				
     				         
     						double Domyslny;
     				         
     				        Domyslny=wartosc;
     				       
	     				       
     				        req.setAttribute("wartosc", Domyslny);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rdEUR = req.getRequestDispatcher("/index.jsp");
    	     				 rdEUR.forward(req,res); 
     				         
     				  
     				   
     				 
     				 break;
     				 
     				 
     				 
     			case "CHF" :

     				String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL obj2 = new URL(url2);
     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
     				con2.setRequestMethod("GET");
     				BufferedReader in2 = new BufferedReader(
     				        new InputStreamReader(con2.getInputStream()));
     				String inputLine2;
     				StringBuffer response2 = new StringBuffer();

     				while ((inputLine2 = in2.readLine()) != null) {
     					response2.append(inputLine2);
     				}
     				in2.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					
     			
     					     				 break;
     			
     			case "CAD" :
     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				
     				URL obj3 = new URL(url3);
     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
     				con3.setRequestMethod("GET");
     				BufferedReader in3 = new BufferedReader(
     				        new InputStreamReader(con3.getInputStream()));
     				String inputLine3;
     				StringBuffer response3 = new StringBuffer();

     				while ((inputLine3 = in3.readLine()) != null) {
     					response3.append(inputLine3);
     				}
     				in3.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "GBP" :
     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				
     				URL obj4 = new URL(url4);
     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
     				con4.setRequestMethod("GET");
     				BufferedReader in4 = new BufferedReader(
     				        new InputStreamReader(con4.getInputStream()));
     				String inputLine4;
     				StringBuffer response4 = new StringBuffer();

     				while ((inputLine4 = in4.readLine()) != null) {
     					response4.append(inputLine4);
     				}
     				in4.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "JPY" :
     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				
     				URL obj5 = new URL(url5);
     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
     				con5.setRequestMethod("GET");
     				BufferedReader in5 = new BufferedReader(
     				        new InputStreamReader(con5.getInputStream()));
     				String inputLine5;
     				StringBuffer response5 = new StringBuffer();

     				while ((inputLine5 = in5.readLine()) != null) {
     					response5.append(inputLine5);
     				}
     				in5.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "AUD" :
     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
     				
     				URL obj6 = new URL(url6);
     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
     				con6.setRequestMethod("GET");
     				BufferedReader in6 = new BufferedReader(
     				        new InputStreamReader(con6.getInputStream()));
     				String inputLine6;
     				StringBuffer response6 = new StringBuffer();

     				while ((inputLine6 = in6.readLine()) != null) {
     					response6.append(inputLine6);
     				}
     				in6.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     					     				 
     			case "CZK" :
     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				
     				URL obj7 = new URL(url7);
     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
     				con7.setRequestMethod("GET");
     				BufferedReader in7 = new BufferedReader(
     				        new InputStreamReader(con7.getInputStream()));
     				String inputLine7;
     				StringBuffer response7 = new StringBuffer();

     				while ((inputLine7 = in7.readLine()) != null) {
     					response7.append(inputLine7);
     				}
     				in7.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			
     			case "UAH" :
String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				
     				URL obj8 = new URL(url8);
     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
     				con8.setRequestMethod("GET");
     				BufferedReader in8 = new BufferedReader(
     				        new InputStreamReader(con8.getInputStream()));
     				String inputLine8;
     				StringBuffer response8 = new StringBuffer();

     				while ((inputLine8 = in8.readLine()) != null) {
     					response8.append(inputLine8);
     				}
     				in8.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res);  
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "PLN" :
     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				     				
     				     				URL obj9 = new URL(url9);
     				     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
     				     				con9.setRequestMethod("GET");
     				     				BufferedReader in9 = new BufferedReader(
     				     				        new InputStreamReader(con9.getInputStream()));
     				     				String inputLine9;
     				     				StringBuffer response9 = new StringBuffer();

     				     				while ((inputLine9 = in9.readLine()) != null) {
     				     					response9.append(inputLine9);
     				     				}
     				     				in9.close();

     				     				 try
     				     				    {
     				     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				         				
     				         				URL objP = new URL(urlP);
     				         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
     				         				conP.setRequestMethod("GET");
     				         				BufferedReader inP = new BufferedReader(
     				         				        new InputStreamReader(conP.getInputStream()));
     				         				String inputLineP;
     				         				StringBuffer responseP = new StringBuffer();

     				         				while ((inputLineP = inP.readLine()) != null) {
     				         					responseP.append(inputLineP);
     				         				}
     				         				inP.close();
     				         				
     				         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
     				 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
     				 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

     				 				        doc2.getDocumentElement().normalize();
     				 				        
     				 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
     				 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				 				         double KursPodst = Double.parseDouble(wartoscs2);
     				         				
     				     					 
     				     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

     				     				        doc.getDocumentElement().normalize();
     				     				        
     				     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				     				         double kurs = Double.parseDouble(wartoscs);
     				     				         
     				     				         
     				     				        
     				     				        	
     				     				        	NowaWartosc = wartosc*KursPodst;
     				     				         
     				     				        
     				     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				     				       
     				     				      df.setMaximumFractionDigits(2);
     				     				      df.setMinimumFractionDigits(2);
     				     				      String NW = df.format(NowaWartosc);
     				     				       
     				     				    req.setAttribute("walP", walwym);
     			     				      	req.setAttribute("ilosc", wartosc);
     				    	     				 req.setAttribute("wartosc", NW);
     				    	     				req.setAttribute("waluta", walotr); 
     				    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
     				    	     				 rd.forward(req,res);  
     				     					     				         
     				     					     				  
     				     					     				    }
     				     					     				        
     				     					     				   	 catch (Exception e)
     				     					     				   	    {
     				     					     				   	        e.printStackTrace();
     				     					     				   	    }
     				     					     				 break;
     			}
     			
	     	case "DOL":
     			switch (walotr) {
     			case "DOL":
     				
     				double DomyslnyDOL;
			         
				        DomyslnyDOL=wartosc;
				       
 				       
				     
     				         
     				        
     				       java.text.DecimalFormat dfDOL=new java.text.DecimalFormat();
     				      dfDOL.setMaximumFractionDigits(2);
     				      dfDOL.setMinimumFractionDigits(2);
     				      String NWDOL = dfDOL.format(DomyslnyDOL);
     				       
    	     				 req.setAttribute("wartosc", NWDOL);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rdDOL = req.getRequestDispatcher("/index.jsp");
    	     				 rdDOL.forward(req,res); 
     				         
     				  
     				   
     				
     				 break;
     			case "EUR" :
     				
     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     				   }
				        
  				   	 catch (Exception e)
  				   	    {
  				   	        e.printStackTrace();
  				   	    }
     				  
     				   
     				 
     				 break;
     				 
     				 
     				 
     			case "CHF" :

     				String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL obj2 = new URL(url2);
     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
     				con2.setRequestMethod("GET");
     				BufferedReader in2 = new BufferedReader(
     				        new InputStreamReader(con2.getInputStream()));
     				String inputLine2;
     				StringBuffer response2 = new StringBuffer();

     				while ((inputLine2 = in2.readLine()) != null) {
     					response2.append(inputLine2);
     				}
     				in2.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					
     			
     					     				 break;
     			
     			case "CAD" :
     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				
     				URL obj3 = new URL(url3);
     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
     				con3.setRequestMethod("GET");
     				BufferedReader in3 = new BufferedReader(
     				        new InputStreamReader(con3.getInputStream()));
     				String inputLine3;
     				StringBuffer response3 = new StringBuffer();

     				while ((inputLine3 = in3.readLine()) != null) {
     					response3.append(inputLine3);
     				}
     				in3.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "GBP" :
     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				
     				URL obj4 = new URL(url4);
     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
     				con4.setRequestMethod("GET");
     				BufferedReader in4 = new BufferedReader(
     				        new InputStreamReader(con4.getInputStream()));
     				String inputLine4;
     				StringBuffer response4 = new StringBuffer();

     				while ((inputLine4 = in4.readLine()) != null) {
     					response4.append(inputLine4);
     				}
     				in4.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "JPY" :
     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				
     				URL obj5 = new URL(url5);
     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
     				con5.setRequestMethod("GET");
     				BufferedReader in5 = new BufferedReader(
     				        new InputStreamReader(con5.getInputStream()));
     				String inputLine5;
     				StringBuffer response5 = new StringBuffer();

     				while ((inputLine5 = in5.readLine()) != null) {
     					response5.append(inputLine5);
     				}
     				in5.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "AUD" :
     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
     				
     				URL obj6 = new URL(url6);
     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
     				con6.setRequestMethod("GET");
     				BufferedReader in6 = new BufferedReader(
     				        new InputStreamReader(con6.getInputStream()));
     				String inputLine6;
     				StringBuffer response6 = new StringBuffer();

     				while ((inputLine6 = in6.readLine()) != null) {
     					response6.append(inputLine6);
     				}
     				in6.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     					     				 
     			case "CZK" :
     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				
     				URL obj7 = new URL(url7);
     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
     				con7.setRequestMethod("GET");
     				BufferedReader in7 = new BufferedReader(
     				        new InputStreamReader(con7.getInputStream()));
     				String inputLine7;
     				StringBuffer response7 = new StringBuffer();

     				while ((inputLine7 = in7.readLine()) != null) {
     					response7.append(inputLine7);
     				}
     				in7.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			
     			case "UAH" :
String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				
     				URL obj8 = new URL(url8);
     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
     				con8.setRequestMethod("GET");
     				BufferedReader in8 = new BufferedReader(
     				        new InputStreamReader(con8.getInputStream()));
     				String inputLine8;
     				StringBuffer response8 = new StringBuffer();

     				while ((inputLine8 = in8.readLine()) != null) {
     					response8.append(inputLine8);
     				}
     				in8.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res);  
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "PLN" :
     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				     				
     				     				URL obj9 = new URL(url9);
     				     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
     				     				con9.setRequestMethod("GET");
     				     				BufferedReader in9 = new BufferedReader(
     				     				        new InputStreamReader(con9.getInputStream()));
     				     				String inputLine9;
     				     				StringBuffer response9 = new StringBuffer();

     				     				while ((inputLine9 = in9.readLine()) != null) {
     				     					response9.append(inputLine9);
     				     				}
     				     				in9.close();

     				     				 try
     				     				    {
     				     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				         				
     				         				URL objP = new URL(urlP);
     				         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
     				         				conP.setRequestMethod("GET");
     				         				BufferedReader inP = new BufferedReader(
     				         				        new InputStreamReader(conP.getInputStream()));
     				         				String inputLineP;
     				         				StringBuffer responseP = new StringBuffer();

     				         				while ((inputLineP = inP.readLine()) != null) {
     				         					responseP.append(inputLineP);
     				         				}
     				         				inP.close();
     				         				
     				         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
     				 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
     				 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

     				 				        doc2.getDocumentElement().normalize();
     				 				        
     				 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
     				 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				 				         double KursPodst = Double.parseDouble(wartoscs2);
     				         				
     				     					 
     				     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

     				     				        doc.getDocumentElement().normalize();
     				     				        
     				     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				     				         double kurs = Double.parseDouble(wartoscs);
     				     				         
     				     				         
     				     				        
     				     				        	
     				     				        	NowaWartosc = wartosc*KursPodst;
     				     				         
     				     				        
     				     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				     				      df.setMaximumFractionDigits(2);
     				     				      df.setMinimumFractionDigits(2);
     				     				      String NW = df.format(NowaWartosc);
     				     				       
     				     				    req.setAttribute("walP", walwym);
     			     				      	req.setAttribute("ilosc", wartosc);
     				    	     				 req.setAttribute("wartosc", NW);
     				    	     				req.setAttribute("waluta", walotr); 
     				    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
     				    	     				 rd.forward(req,res);  
     				     					     				         
     				     					     				  
     				     					     				    }
     				     					     				        
     				     					     				   	 catch (Exception e)
     				     					     				   	    {
     				     					     				   	        e.printStackTrace();
     				     					     				   	    }
     				     					     				 break;
     			}
     			
	    	case "CHF":
     			switch (walotr) {
     			case "CHF":
     				
     				double DomyslnyCHF;
			         
				        DomyslnyCHF=wartosc;
				       
 				       
				     
     				         
     				        
     				       java.text.DecimalFormat dfCHF=new java.text.DecimalFormat();
     				      dfCHF.setMaximumFractionDigits(2);
     				      dfCHF.setMinimumFractionDigits(2);
     				      String NWCHF = dfCHF.format(DomyslnyCHF);
     				       
    	     				 req.setAttribute("wartosc", NWCHF);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rdCHF = req.getRequestDispatcher("/index.jsp");
    	     				 rdCHF.forward(req,res); 
     				         
     				  
     				   
     				
     				 break;
     			case "EUR" :
     				
     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     				   }
				        
  				   	 catch (Exception e)
  				   	    {
  				   	        e.printStackTrace();
  				   	    }
     				  
     				   
     				 
     				 break;
     				 
     				 
     				 
     			case "DOL" :

     				String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				
     				URL obj2 = new URL(url2);
     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
     				con2.setRequestMethod("GET");
     				BufferedReader in2 = new BufferedReader(
     				        new InputStreamReader(con2.getInputStream()));
     				String inputLine2;
     				StringBuffer response2 = new StringBuffer();

     				while ((inputLine2 = in2.readLine()) != null) {
     					response2.append(inputLine2);
     				}
     				in2.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					
     			
     					     				 break;
     			
     			case "CAD" :
     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				
     				URL obj3 = new URL(url3);
     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
     				con3.setRequestMethod("GET");
     				BufferedReader in3 = new BufferedReader(
     				        new InputStreamReader(con3.getInputStream()));
     				String inputLine3;
     				StringBuffer response3 = new StringBuffer();

     				while ((inputLine3 = in3.readLine()) != null) {
     					response3.append(inputLine3);
     				}
     				in3.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "GBP" :
     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				
     				URL obj4 = new URL(url4);
     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
     				con4.setRequestMethod("GET");
     				BufferedReader in4 = new BufferedReader(
     				        new InputStreamReader(con4.getInputStream()));
     				String inputLine4;
     				StringBuffer response4 = new StringBuffer();

     				while ((inputLine4 = in4.readLine()) != null) {
     					response4.append(inputLine4);
     				}
     				in4.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "JPY" :
     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				
     				URL obj5 = new URL(url5);
     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
     				con5.setRequestMethod("GET");
     				BufferedReader in5 = new BufferedReader(
     				        new InputStreamReader(con5.getInputStream()));
     				String inputLine5;
     				StringBuffer response5 = new StringBuffer();

     				while ((inputLine5 = in5.readLine()) != null) {
     					response5.append(inputLine5);
     				}
     				in5.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "AUD" :
     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
     				
     				URL obj6 = new URL(url6);
     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
     				con6.setRequestMethod("GET");
     				BufferedReader in6 = new BufferedReader(
     				        new InputStreamReader(con6.getInputStream()));
     				String inputLine6;
     				StringBuffer response6 = new StringBuffer();

     				while ((inputLine6 = in6.readLine()) != null) {
     					response6.append(inputLine6);
     				}
     				in6.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     					     				 
     			case "CZK" :
     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				
     				URL obj7 = new URL(url7);
     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
     				con7.setRequestMethod("GET");
     				BufferedReader in7 = new BufferedReader(
     				        new InputStreamReader(con7.getInputStream()));
     				String inputLine7;
     				StringBuffer response7 = new StringBuffer();

     				while ((inputLine7 = in7.readLine()) != null) {
     					response7.append(inputLine7);
     				}
     				in7.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			
     			case "UAH" :
String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				
     				URL obj8 = new URL(url8);
     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
     				con8.setRequestMethod("GET");
     				BufferedReader in8 = new BufferedReader(
     				        new InputStreamReader(con8.getInputStream()));
     				String inputLine8;
     				StringBuffer response8 = new StringBuffer();

     				while ((inputLine8 = in8.readLine()) != null) {
     					response8.append(inputLine8);
     				}
     				in8.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res);  
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "PLN" :
     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				     				
     				     				URL obj9 = new URL(url9);
     				     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
     				     				con9.setRequestMethod("GET");
     				     				BufferedReader in9 = new BufferedReader(
     				     				        new InputStreamReader(con9.getInputStream()));
     				     				String inputLine9;
     				     				StringBuffer response9 = new StringBuffer();

     				     				while ((inputLine9 = in9.readLine()) != null) {
     				     					response9.append(inputLine9);
     				     				}
     				     				in9.close();

     				     				 try
     				     				    {
     				     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				         				
     				         				URL objP = new URL(urlP);
     				         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
     				         				conP.setRequestMethod("GET");
     				         				BufferedReader inP = new BufferedReader(
     				         				        new InputStreamReader(conP.getInputStream()));
     				         				String inputLineP;
     				         				StringBuffer responseP = new StringBuffer();

     				         				while ((inputLineP = inP.readLine()) != null) {
     				         					responseP.append(inputLineP);
     				         				}
     				         				inP.close();
     				         				
     				         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
     				 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
     				 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

     				 				        doc2.getDocumentElement().normalize();
     				 				        
     				 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
     				 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				 				         double KursPodst = Double.parseDouble(wartoscs2);
     				         				
     				     					 
     				     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

     				     				        doc.getDocumentElement().normalize();
     				     				        
     				     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				     				         double kurs = Double.parseDouble(wartoscs);
     				     				         
     				     				         
     				     				        
     				     				        	
     				     				        	NowaWartosc = wartosc*KursPodst;
     				     				         
     				     				        
     				     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				     				      df.setMaximumFractionDigits(2);
     				     				      df.setMinimumFractionDigits(2);
     				     				      String NW = df.format(NowaWartosc);
     				     				       
     				     				    req.setAttribute("walP", walwym);
     			     				      	req.setAttribute("ilosc", wartosc);
     				    	     				 req.setAttribute("wartosc", NW);
     				    	     				req.setAttribute("waluta", walotr); 
     				    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
     				    	     				 rd.forward(req,res);  
     				     					     				         
     				     					     				  
     				     					     				    }
     				     					     				        
     				     					     				   	 catch (Exception e)
     				     					     				   	    {
     				     					     				   	        e.printStackTrace();
     				     					     				   	    }
     				     					     				 break;
     			}
     			
     			
     			
     			
     			
     			
     			
    			
	    	case "GBP":
     			switch (walotr) {
     			case "GBP":
     				
     				double DomyslnyCAD;
			         
				        DomyslnyCAD=wartosc;
				       
 				       
				     
     				         
     				        
     				       java.text.DecimalFormat dfCAD=new java.text.DecimalFormat();
     				      dfCAD.setMaximumFractionDigits(2);
     				      dfCAD.setMinimumFractionDigits(2);
     				      String NWCAD = dfCAD.format(DomyslnyCAD);
     				       
    	     				 req.setAttribute("wartosc", NWCAD);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rdCAD = req.getRequestDispatcher("/index.jsp");
    	     				 rdCAD.forward(req,res); 
     				         
     				  
     				   
     				
     				 break;
     			case "EUR" :
     				
     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     				   }
				        
  				   	 catch (Exception e)
  				   	    {
  				   	        e.printStackTrace();
  				   	    }
     				  
     				   
     				 
     				 break;
     				 
     				 
     				 
     			case "DOL" :

     				String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/dol/?format=xml";
     				
     				URL obj2 = new URL(url2);
     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
     				con2.setRequestMethod("GET");
     				BufferedReader in2 = new BufferedReader(
     				        new InputStreamReader(con2.getInputStream()));
     				String inputLine2;
     				StringBuffer response2 = new StringBuffer();

     				while ((inputLine2 = in2.readLine()) != null) {
     					response2.append(inputLine2);
     				}
     				in2.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					
     			
     					     				 break;
     			
     			case "CHF" :
     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL obj3 = new URL(url3);
     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
     				con3.setRequestMethod("GET");
     				BufferedReader in3 = new BufferedReader(
     				        new InputStreamReader(con3.getInputStream()));
     				String inputLine3;
     				StringBuffer response3 = new StringBuffer();

     				while ((inputLine3 = in3.readLine()) != null) {
     					response3.append(inputLine3);
     				}
     				in3.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "CAD" :
     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				
     				URL obj4 = new URL(url4);
     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
     				con4.setRequestMethod("GET");
     				BufferedReader in4 = new BufferedReader(
     				        new InputStreamReader(con4.getInputStream()));
     				String inputLine4;
     				StringBuffer response4 = new StringBuffer();

     				while ((inputLine4 = in4.readLine()) != null) {
     					response4.append(inputLine4);
     				}
     				in4.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "JPY" :
     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				
     				URL obj5 = new URL(url5);
     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
     				con5.setRequestMethod("GET");
     				BufferedReader in5 = new BufferedReader(
     				        new InputStreamReader(con5.getInputStream()));
     				String inputLine5;
     				StringBuffer response5 = new StringBuffer();

     				while ((inputLine5 = in5.readLine()) != null) {
     					response5.append(inputLine5);
     				}
     				in5.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "AUD" :
     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
     				
     				URL obj6 = new URL(url6);
     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
     				con6.setRequestMethod("GET");
     				BufferedReader in6 = new BufferedReader(
     				        new InputStreamReader(con6.getInputStream()));
     				String inputLine6;
     				StringBuffer response6 = new StringBuffer();

     				while ((inputLine6 = in6.readLine()) != null) {
     					response6.append(inputLine6);
     				}
     				in6.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     					     				 
     			case "CZK" :
     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				
     				URL obj7 = new URL(url7);
     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
     				con7.setRequestMethod("GET");
     				BufferedReader in7 = new BufferedReader(
     				        new InputStreamReader(con7.getInputStream()));
     				String inputLine7;
     				StringBuffer response7 = new StringBuffer();

     				while ((inputLine7 = in7.readLine()) != null) {
     					response7.append(inputLine7);
     				}
     				in7.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			
     			case "UAH" :
String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				
     				URL obj8 = new URL(url8);
     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
     				con8.setRequestMethod("GET");
     				BufferedReader in8 = new BufferedReader(
     				        new InputStreamReader(con8.getInputStream()));
     				String inputLine8;
     				StringBuffer response8 = new StringBuffer();

     				while ((inputLine8 = in8.readLine()) != null) {
     					response8.append(inputLine8);
     				}
     				in8.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res);  
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "PLN" :
     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				     				
     				     				URL obj9 = new URL(url9);
     				     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
     				     				con9.setRequestMethod("GET");
     				     				BufferedReader in9 = new BufferedReader(
     				     				        new InputStreamReader(con9.getInputStream()));
     				     				String inputLine9;
     				     				StringBuffer response9 = new StringBuffer();

     				     				while ((inputLine9 = in9.readLine()) != null) {
     				     					response9.append(inputLine9);
     				     				}
     				     				in9.close();

     				     				 try
     				     				    {
     				     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				         				
     				         				URL objP = new URL(urlP);
     				         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
     				         				conP.setRequestMethod("GET");
     				         				BufferedReader inP = new BufferedReader(
     				         				        new InputStreamReader(conP.getInputStream()));
     				         				String inputLineP;
     				         				StringBuffer responseP = new StringBuffer();

     				         				while ((inputLineP = inP.readLine()) != null) {
     				         					responseP.append(inputLineP);
     				         				}
     				         				inP.close();
     				         				
     				         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
     				 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
     				 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

     				 				        doc2.getDocumentElement().normalize();
     				 				        
     				 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
     				 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				 				         double KursPodst = Double.parseDouble(wartoscs2);
     				         				
     				     					 
     				     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

     				     				        doc.getDocumentElement().normalize();
     				     				        
     				     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				     				         double kurs = Double.parseDouble(wartoscs);
     				     				         
     				     				         
     				     				        
     				     				        	
     				     				        	NowaWartosc = wartosc*KursPodst;
     				     				         
     				     				        
     				     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				     				      df.setMaximumFractionDigits(2);
     				     				      df.setMinimumFractionDigits(2);
     				     				      String NW = df.format(NowaWartosc);
     				     				       
     				     				    req.setAttribute("walP", walwym);
     			     				      	req.setAttribute("ilosc", wartosc);
     				    	     				 req.setAttribute("wartosc", NW);
     				    	     				req.setAttribute("waluta", walotr); 
     				    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
     				    	     				 rd.forward(req,res);  
     				     					     				         
     				     					     				  
     				     					     				    }
     				     					     				        
     				     					     				   	 catch (Exception e)
     				     					     				   	    {
     				     					     				   	        e.printStackTrace();
     				     					     				   	    }
     				     					     				 break;
     			}
     			
     			
     			
     			
     			
     			
     			
     			
     			
	    	case "CAD":
     			switch (walotr) {
     			case "CAD":
     				
     				double DomyslnyCAD;
			         
				        DomyslnyCAD=wartosc;
				       
 				       
				     
     				         
     				        
     				       java.text.DecimalFormat dfCAD=new java.text.DecimalFormat();
     				      dfCAD.setMaximumFractionDigits(2);
     				      dfCAD.setMinimumFractionDigits(2);
     				      String NWCAD = dfCAD.format(DomyslnyCAD);
     				       
    	     				 req.setAttribute("wartosc", NWCAD);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rdCAD = req.getRequestDispatcher("/index.jsp");
    	     				 rdCAD.forward(req,res); 
     				         
     				  
     				   
     				
     				 break;
     			case "EUR" :
     				
     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     				   }
				        
  				   	 catch (Exception e)
  				   	    {
  				   	        e.printStackTrace();
  				   	    }
     				  
     				   
     				 
     				 break;
     				 
     				 
     				 
     			case "DOL" :

     				String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				
     				URL obj2 = new URL(url2);
     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
     				con2.setRequestMethod("GET");
     				BufferedReader in2 = new BufferedReader(
     				        new InputStreamReader(con2.getInputStream()));
     				String inputLine2;
     				StringBuffer response2 = new StringBuffer();

     				while ((inputLine2 = in2.readLine()) != null) {
     					response2.append(inputLine2);
     				}
     				in2.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					
     			
     					     				 break;
     			
     			case "CHF" :
     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL obj3 = new URL(url3);
     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
     				con3.setRequestMethod("GET");
     				BufferedReader in3 = new BufferedReader(
     				        new InputStreamReader(con3.getInputStream()));
     				String inputLine3;
     				StringBuffer response3 = new StringBuffer();

     				while ((inputLine3 = in3.readLine()) != null) {
     					response3.append(inputLine3);
     				}
     				in3.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "GBP" :
     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				
     				URL obj4 = new URL(url4);
     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
     				con4.setRequestMethod("GET");
     				BufferedReader in4 = new BufferedReader(
     				        new InputStreamReader(con4.getInputStream()));
     				String inputLine4;
     				StringBuffer response4 = new StringBuffer();

     				while ((inputLine4 = in4.readLine()) != null) {
     					response4.append(inputLine4);
     				}
     				in4.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "JPY" :
     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				
     				URL obj5 = new URL(url5);
     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
     				con5.setRequestMethod("GET");
     				BufferedReader in5 = new BufferedReader(
     				        new InputStreamReader(con5.getInputStream()));
     				String inputLine5;
     				StringBuffer response5 = new StringBuffer();

     				while ((inputLine5 = in5.readLine()) != null) {
     					response5.append(inputLine5);
     				}
     				in5.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "AUD" :
     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
     				
     				URL obj6 = new URL(url6);
     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
     				con6.setRequestMethod("GET");
     				BufferedReader in6 = new BufferedReader(
     				        new InputStreamReader(con6.getInputStream()));
     				String inputLine6;
     				StringBuffer response6 = new StringBuffer();

     				while ((inputLine6 = in6.readLine()) != null) {
     					response6.append(inputLine6);
     				}
     				in6.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     					     				 
     			case "CZK" :
     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				
     				URL obj7 = new URL(url7);
     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
     				con7.setRequestMethod("GET");
     				BufferedReader in7 = new BufferedReader(
     				        new InputStreamReader(con7.getInputStream()));
     				String inputLine7;
     				StringBuffer response7 = new StringBuffer();

     				while ((inputLine7 = in7.readLine()) != null) {
     					response7.append(inputLine7);
     				}
     				in7.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			
     			case "UAH" :
String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				
     				URL obj8 = new URL(url8);
     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
     				con8.setRequestMethod("GET");
     				BufferedReader in8 = new BufferedReader(
     				        new InputStreamReader(con8.getInputStream()));
     				String inputLine8;
     				StringBuffer response8 = new StringBuffer();

     				while ((inputLine8 = in8.readLine()) != null) {
     					response8.append(inputLine8);
     				}
     				in8.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res);  
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "PLN" :
     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				     				
     				     				URL obj9 = new URL(url9);
     				     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
     				     				con9.setRequestMethod("GET");
     				     				BufferedReader in9 = new BufferedReader(
     				     				        new InputStreamReader(con9.getInputStream()));
     				     				String inputLine9;
     				     				StringBuffer response9 = new StringBuffer();

     				     				while ((inputLine9 = in9.readLine()) != null) {
     				     					response9.append(inputLine9);
     				     				}
     				     				in9.close();

     				     				 try
     				     				    {
     				     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				         				
     				         				URL objP = new URL(urlP);
     				         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
     				         				conP.setRequestMethod("GET");
     				         				BufferedReader inP = new BufferedReader(
     				         				        new InputStreamReader(conP.getInputStream()));
     				         				String inputLineP;
     				         				StringBuffer responseP = new StringBuffer();

     				         				while ((inputLineP = inP.readLine()) != null) {
     				         					responseP.append(inputLineP);
     				         				}
     				         				inP.close();
     				         				
     				         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
     				 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
     				 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

     				 				        doc2.getDocumentElement().normalize();
     				 				        
     				 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
     				 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				 				         double KursPodst = Double.parseDouble(wartoscs2);
     				         				
     				     					 
     				     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

     				     				        doc.getDocumentElement().normalize();
     				     				        
     				     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				     				         double kurs = Double.parseDouble(wartoscs);
     				     				         
     				     				         
     				     				        
     				     				        	
     				     				        	NowaWartosc = wartosc*KursPodst;
     				     				         
     				     				        
     				     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				     				      df.setMaximumFractionDigits(2);
     				     				      df.setMinimumFractionDigits(2);
     				     				      String NW = df.format(NowaWartosc);
     				     				       
     				     				    req.setAttribute("walP", walwym);
     			     				      	req.setAttribute("ilosc", wartosc);
     				    	     				 req.setAttribute("wartosc", NW);
     				    	     				req.setAttribute("waluta", walotr); 
     				    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
     				    	     				 rd.forward(req,res);  
     				     					     				         
     				     					     				  
     				     					     				    }
     				     					     				        
     				     					     				   	 catch (Exception e)
     				     					     				   	    {
     				     					     				   	        e.printStackTrace();
     				     					     				   	    }
     				     					     				 break;
     			}
     			
     			
	    	case "JPY":
     			switch (walotr) {
     			case "JPY":
     				
     				double DomyslnyCAD;
			         
				        DomyslnyCAD=wartosc;
				       
 				       
				     
     				         
     				        
     				       java.text.DecimalFormat dfCAD=new java.text.DecimalFormat();
     				      dfCAD.setMaximumFractionDigits(2);
     				      dfCAD.setMinimumFractionDigits(2);
     				      String NWCAD = dfCAD.format(DomyslnyCAD);
     				       
    	     				 req.setAttribute("wartosc", NWCAD);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rdCAD = req.getRequestDispatcher("/index.jsp");
    	     				 rdCAD.forward(req,res); 
     				         
     				  
     				   
     				
     				 break;
     			case "EUR" :
     				
     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     				   }
				        
  				   	 catch (Exception e)
  				   	    {
  				   	        e.printStackTrace();
  				   	    }
     				  
     				   
     				 
     				 break;
     				 
     				 
     				 
     			case "DOL" :

     				String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				
     				URL obj2 = new URL(url2);
     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
     				con2.setRequestMethod("GET");
     				BufferedReader in2 = new BufferedReader(
     				        new InputStreamReader(con2.getInputStream()));
     				String inputLine2;
     				StringBuffer response2 = new StringBuffer();

     				while ((inputLine2 = in2.readLine()) != null) {
     					response2.append(inputLine2);
     				}
     				in2.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					
     			
     					     				 break;
     			
     			case "CHF" :
     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL obj3 = new URL(url3);
     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
     				con3.setRequestMethod("GET");
     				BufferedReader in3 = new BufferedReader(
     				        new InputStreamReader(con3.getInputStream()));
     				String inputLine3;
     				StringBuffer response3 = new StringBuffer();

     				while ((inputLine3 = in3.readLine()) != null) {
     					response3.append(inputLine3);
     				}
     				in3.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "GBP" :
     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				
     				URL obj4 = new URL(url4);
     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
     				con4.setRequestMethod("GET");
     				BufferedReader in4 = new BufferedReader(
     				        new InputStreamReader(con4.getInputStream()));
     				String inputLine4;
     				StringBuffer response4 = new StringBuffer();

     				while ((inputLine4 = in4.readLine()) != null) {
     					response4.append(inputLine4);
     				}
     				in4.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "CAD" :
     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				
     				URL obj5 = new URL(url5);
     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
     				con5.setRequestMethod("GET");
     				BufferedReader in5 = new BufferedReader(
     				        new InputStreamReader(con5.getInputStream()));
     				String inputLine5;
     				StringBuffer response5 = new StringBuffer();

     				while ((inputLine5 = in5.readLine()) != null) {
     					response5.append(inputLine5);
     				}
     				in5.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "AUD" :
     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
     				
     				URL obj6 = new URL(url6);
     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
     				con6.setRequestMethod("GET");
     				BufferedReader in6 = new BufferedReader(
     				        new InputStreamReader(con6.getInputStream()));
     				String inputLine6;
     				StringBuffer response6 = new StringBuffer();

     				while ((inputLine6 = in6.readLine()) != null) {
     					response6.append(inputLine6);
     				}
     				in6.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     					     				 
     			case "CZK" :
     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				
     				URL obj7 = new URL(url7);
     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
     				con7.setRequestMethod("GET");
     				BufferedReader in7 = new BufferedReader(
     				        new InputStreamReader(con7.getInputStream()));
     				String inputLine7;
     				StringBuffer response7 = new StringBuffer();

     				while ((inputLine7 = in7.readLine()) != null) {
     					response7.append(inputLine7);
     				}
     				in7.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			
     			case "UAH" :
String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				
     				URL obj8 = new URL(url8);
     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
     				con8.setRequestMethod("GET");
     				BufferedReader in8 = new BufferedReader(
     				        new InputStreamReader(con8.getInputStream()));
     				String inputLine8;
     				StringBuffer response8 = new StringBuffer();

     				while ((inputLine8 = in8.readLine()) != null) {
     					response8.append(inputLine8);
     				}
     				in8.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res);  
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "PLN" :
     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				     				
     				     				URL obj9 = new URL(url9);
     				     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
     				     				con9.setRequestMethod("GET");
     				     				BufferedReader in9 = new BufferedReader(
     				     				        new InputStreamReader(con9.getInputStream()));
     				     				String inputLine9;
     				     				StringBuffer response9 = new StringBuffer();

     				     				while ((inputLine9 = in9.readLine()) != null) {
     				     					response9.append(inputLine9);
     				     				}
     				     				in9.close();

     				     				 try
     				     				    {
     				     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				         				
     				         				URL objP = new URL(urlP);
     				         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
     				         				conP.setRequestMethod("GET");
     				         				BufferedReader inP = new BufferedReader(
     				         				        new InputStreamReader(conP.getInputStream()));
     				         				String inputLineP;
     				         				StringBuffer responseP = new StringBuffer();

     				         				while ((inputLineP = inP.readLine()) != null) {
     				         					responseP.append(inputLineP);
     				         				}
     				         				inP.close();
     				         				
     				         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
     				 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
     				 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

     				 				        doc2.getDocumentElement().normalize();
     				 				        
     				 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
     				 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				 				         double KursPodst = Double.parseDouble(wartoscs2);
     				         				
     				     					 
     				     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

     				     				        doc.getDocumentElement().normalize();
     				     				        
     				     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				     				         double kurs = Double.parseDouble(wartoscs);
     				     				         
     				     				         
     				     				        
     				     				        	
     				     				        	NowaWartosc = wartosc*KursPodst;
     				     				         
     				     				        
     				     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				     				      df.setMaximumFractionDigits(2);
     				     				      df.setMinimumFractionDigits(2);
     				     				      String NW = df.format(NowaWartosc);
     				     				       
     				     				    req.setAttribute("walP", walwym);
     			     				      	req.setAttribute("ilosc", wartosc);
     				    	     				 req.setAttribute("wartosc", NW);
     				    	     				req.setAttribute("waluta", walotr); 
     				    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
     				    	     				 rd.forward(req,res);  
     				     					     				         
     				     					     				  
     				     					     				    }
     				     					     				        
     				     					     				   	 catch (Exception e)
     				     					     				   	    {
     				     					     				   	        e.printStackTrace();
     				     					     				   	    }
     				     					     				 break;
     			}
     			
     			
     			
     			
	    	case "AUD":
     			switch (walotr) {
     			case "AUD":
     				
     				double DomyslnyCAD;
			         
				        DomyslnyCAD=wartosc;
				       
 				       
				     
     				         
     				        
     				       java.text.DecimalFormat dfCAD=new java.text.DecimalFormat();
     				      dfCAD.setMaximumFractionDigits(2);
     				      dfCAD.setMinimumFractionDigits(2);
     				      String NWCAD = dfCAD.format(DomyslnyCAD);
     				       
    	     				 req.setAttribute("wartosc", NWCAD);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rdCAD = req.getRequestDispatcher("/index.jsp");
    	     				 rdCAD.forward(req,res); 
     				         
     				  
     				   
     				
     				 break;
     			case "EUR" :
     				
     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     				   }
				        
  				   	 catch (Exception e)
  				   	    {
  				   	        e.printStackTrace();
  				   	    }
     				  
     				   
     				 
     				 break;
     				 
     				 
     				 
     			case "DOL" :

     				String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				
     				URL obj2 = new URL(url2);
     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
     				con2.setRequestMethod("GET");
     				BufferedReader in2 = new BufferedReader(
     				        new InputStreamReader(con2.getInputStream()));
     				String inputLine2;
     				StringBuffer response2 = new StringBuffer();

     				while ((inputLine2 = in2.readLine()) != null) {
     					response2.append(inputLine2);
     				}
     				in2.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					
     			
     					     				 break;
     			
     			case "CHF" :
     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL obj3 = new URL(url3);
     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
     				con3.setRequestMethod("GET");
     				BufferedReader in3 = new BufferedReader(
     				        new InputStreamReader(con3.getInputStream()));
     				String inputLine3;
     				StringBuffer response3 = new StringBuffer();

     				while ((inputLine3 = in3.readLine()) != null) {
     					response3.append(inputLine3);
     				}
     				in3.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "GBP" :
     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				
     				URL obj4 = new URL(url4);
     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
     				con4.setRequestMethod("GET");
     				BufferedReader in4 = new BufferedReader(
     				        new InputStreamReader(con4.getInputStream()));
     				String inputLine4;
     				StringBuffer response4 = new StringBuffer();

     				while ((inputLine4 = in4.readLine()) != null) {
     					response4.append(inputLine4);
     				}
     				in4.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "JPY" :
     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				
     				URL obj5 = new URL(url5);
     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
     				con5.setRequestMethod("GET");
     				BufferedReader in5 = new BufferedReader(
     				        new InputStreamReader(con5.getInputStream()));
     				String inputLine5;
     				StringBuffer response5 = new StringBuffer();

     				while ((inputLine5 = in5.readLine()) != null) {
     					response5.append(inputLine5);
     				}
     				in5.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "CAD" :
     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				
     				URL obj6 = new URL(url6);
     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
     				con6.setRequestMethod("GET");
     				BufferedReader in6 = new BufferedReader(
     				        new InputStreamReader(con6.getInputStream()));
     				String inputLine6;
     				StringBuffer response6 = new StringBuffer();

     				while ((inputLine6 = in6.readLine()) != null) {
     					response6.append(inputLine6);
     				}
     				in6.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     					     				 
     			case "CZK" :
     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				
     				URL obj7 = new URL(url7);
     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
     				con7.setRequestMethod("GET");
     				BufferedReader in7 = new BufferedReader(
     				        new InputStreamReader(con7.getInputStream()));
     				String inputLine7;
     				StringBuffer response7 = new StringBuffer();

     				while ((inputLine7 = in7.readLine()) != null) {
     					response7.append(inputLine7);
     				}
     				in7.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			
     			case "UAH" :
String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				
     				URL obj8 = new URL(url8);
     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
     				con8.setRequestMethod("GET");
     				BufferedReader in8 = new BufferedReader(
     				        new InputStreamReader(con8.getInputStream()));
     				String inputLine8;
     				StringBuffer response8 = new StringBuffer();

     				while ((inputLine8 = in8.readLine()) != null) {
     					response8.append(inputLine8);
     				}
     				in8.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res);  
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "PLN" :
     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				     				
     				     				URL obj9 = new URL(url9);
     				     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
     				     				con9.setRequestMethod("GET");
     				     				BufferedReader in9 = new BufferedReader(
     				     				        new InputStreamReader(con9.getInputStream()));
     				     				String inputLine9;
     				     				StringBuffer response9 = new StringBuffer();

     				     				while ((inputLine9 = in9.readLine()) != null) {
     				     					response9.append(inputLine9);
     				     				}
     				     				in9.close();

     				     				 try
     				     				    {
     				     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
     				         				
     				         				URL objP = new URL(urlP);
     				         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
     				         				conP.setRequestMethod("GET");
     				         				BufferedReader inP = new BufferedReader(
     				         				        new InputStreamReader(conP.getInputStream()));
     				         				String inputLineP;
     				         				StringBuffer responseP = new StringBuffer();

     				         				while ((inputLineP = inP.readLine()) != null) {
     				         					responseP.append(inputLineP);
     				         				}
     				         				inP.close();
     				         				
     				         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
     				 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
     				 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

     				 				        doc2.getDocumentElement().normalize();
     				 				        
     				 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
     				 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				 				         double KursPodst = Double.parseDouble(wartoscs2);
     				         				
     				     					 
     				     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

     				     				        doc.getDocumentElement().normalize();
     				     				        
     				     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				     				         double kurs = Double.parseDouble(wartoscs);
     				     				         
     				     				         
     				     				        
     				     				        	
     				     				        	NowaWartosc = wartosc*KursPodst;
     				     				         
     				     				        
     				     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				     				      df.setMaximumFractionDigits(2);
     				     				      df.setMinimumFractionDigits(2);
     				     				      String NW = df.format(NowaWartosc);
     				     				       
     				     				    req.setAttribute("walP", walwym);
     			     				      	req.setAttribute("ilosc", wartosc);
     				    	     				 req.setAttribute("wartosc", NW);
     				    	     				req.setAttribute("waluta", walotr); 
     				    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
     				    	     				 rd.forward(req,res);  
     				     					     				         
     				     					     				  
     				     					     				    }
     				     					     				        
     				     					     				   	 catch (Exception e)
     				     					     				   	    {
     				     					     				   	        e.printStackTrace();
     				     					     				   	    }
     				     					     				 break;
     			}
     			
	    	case "CZK":
     			switch (walotr) {
     			case "CZK":
     				
     				double DomyslnyCAD;
			         
				        DomyslnyCAD=wartosc;
				       
 				       
				     
     				         
     				        
     				       java.text.DecimalFormat dfCAD=new java.text.DecimalFormat();
     				      dfCAD.setMaximumFractionDigits(2);
     				      dfCAD.setMinimumFractionDigits(2);
     				      String NWCAD = dfCAD.format(DomyslnyCAD);
     				       
    	     				 req.setAttribute("wartosc", NWCAD);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rdCAD = req.getRequestDispatcher("/index.jsp");
    	     				 rdCAD.forward(req,res); 
     				         
     				  
     				   
     				
     				 break;
     			case "EUR" :
     				
     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     				   }
				        
  				   	 catch (Exception e)
  				   	    {
  				   	        e.printStackTrace();
  				   	    }
     				  
     				   
     				 
     				 break;
     				 
     				 
     				 
     			case "DOL" :

     				String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				
     				URL obj2 = new URL(url2);
     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
     				con2.setRequestMethod("GET");
     				BufferedReader in2 = new BufferedReader(
     				        new InputStreamReader(con2.getInputStream()));
     				String inputLine2;
     				StringBuffer response2 = new StringBuffer();

     				while ((inputLine2 = in2.readLine()) != null) {
     					response2.append(inputLine2);
     				}
     				in2.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					
     			
     					     				 break;
     			
     			case "CHF" :
     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL obj3 = new URL(url3);
     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
     				con3.setRequestMethod("GET");
     				BufferedReader in3 = new BufferedReader(
     				        new InputStreamReader(con3.getInputStream()));
     				String inputLine3;
     				StringBuffer response3 = new StringBuffer();

     				while ((inputLine3 = in3.readLine()) != null) {
     					response3.append(inputLine3);
     				}
     				in3.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "GBP" :
     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				
     				URL obj4 = new URL(url4);
     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
     				con4.setRequestMethod("GET");
     				BufferedReader in4 = new BufferedReader(
     				        new InputStreamReader(con4.getInputStream()));
     				String inputLine4;
     				StringBuffer response4 = new StringBuffer();

     				while ((inputLine4 = in4.readLine()) != null) {
     					response4.append(inputLine4);
     				}
     				in4.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "JPY" :
     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				
     				URL obj5 = new URL(url5);
     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
     				con5.setRequestMethod("GET");
     				BufferedReader in5 = new BufferedReader(
     				        new InputStreamReader(con5.getInputStream()));
     				String inputLine5;
     				StringBuffer response5 = new StringBuffer();

     				while ((inputLine5 = in5.readLine()) != null) {
     					response5.append(inputLine5);
     				}
     				in5.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "AUD" :
     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
     				
     				URL obj6 = new URL(url6);
     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
     				con6.setRequestMethod("GET");
     				BufferedReader in6 = new BufferedReader(
     				        new InputStreamReader(con6.getInputStream()));
     				String inputLine6;
     				StringBuffer response6 = new StringBuffer();

     				while ((inputLine6 = in6.readLine()) != null) {
     					response6.append(inputLine6);
     				}
     				in6.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     					     				 
     			case "CAD" :
     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				
     				URL obj7 = new URL(url7);
     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
     				con7.setRequestMethod("GET");
     				BufferedReader in7 = new BufferedReader(
     				        new InputStreamReader(con7.getInputStream()));
     				String inputLine7;
     				StringBuffer response7 = new StringBuffer();

     				while ((inputLine7 = in7.readLine()) != null) {
     					response7.append(inputLine7);
     				}
     				in7.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			
     			case "UAH" :
String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				
     				URL obj8 = new URL(url8);
     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
     				con8.setRequestMethod("GET");
     				BufferedReader in8 = new BufferedReader(
     				        new InputStreamReader(con8.getInputStream()));
     				String inputLine8;
     				StringBuffer response8 = new StringBuffer();

     				while ((inputLine8 = in8.readLine()) != null) {
     					response8.append(inputLine8);
     				}
     				in8.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res);  
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "PLN" :
     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				     				
     				     				URL obj9 = new URL(url9);
     				     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
     				     				con9.setRequestMethod("GET");
     				     				BufferedReader in9 = new BufferedReader(
     				     				        new InputStreamReader(con9.getInputStream()));
     				     				String inputLine9;
     				     				StringBuffer response9 = new StringBuffer();

     				     				while ((inputLine9 = in9.readLine()) != null) {
     				     					response9.append(inputLine9);
     				     				}
     				     				in9.close();

     				     				 try
     				     				    {
     				     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				         				
     				         				URL objP = new URL(urlP);
     				         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
     				         				conP.setRequestMethod("GET");
     				         				BufferedReader inP = new BufferedReader(
     				         				        new InputStreamReader(conP.getInputStream()));
     				         				String inputLineP;
     				         				StringBuffer responseP = new StringBuffer();

     				         				while ((inputLineP = inP.readLine()) != null) {
     				         					responseP.append(inputLineP);
     				         				}
     				         				inP.close();
     				         				
     				         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
     				 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
     				 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

     				 				        doc2.getDocumentElement().normalize();
     				 				        
     				 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
     				 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				 				         double KursPodst = Double.parseDouble(wartoscs2);
     				         				
     				     					 
     				     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

     				     				        doc.getDocumentElement().normalize();
     				     				        
     				     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				     				         double kurs = Double.parseDouble(wartoscs);
     				     				         
     				     				         
     				     				        
     				     				        	
     				     				        	NowaWartosc = wartosc*KursPodst;
     				     				         
     				     				        
     				     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				     				      df.setMaximumFractionDigits(2);
     				     				      df.setMinimumFractionDigits(2);
     				     				      String NW = df.format(NowaWartosc);
     				     				       
     				     				    req.setAttribute("walP", walwym);
     			     				      	req.setAttribute("ilosc", wartosc);
     				    	     				 req.setAttribute("wartosc", NW);
     				    	     				req.setAttribute("waluta", walotr); 
     				    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
     				    	     				 rd.forward(req,res);  
     				     					     				         
     				     					     				  
     				     					     				    }
     				     					     				        
     				     					     				   	 catch (Exception e)
     				     					     				   	    {
     				     					     				   	        e.printStackTrace();
     				     					     				   	    }
     				     					     				 break;
     			}
     			
     			
     			
     			
     			
     			
     			
     			
     			
     			
     			
	    	case "UAH":
     			switch (walotr) {
     			case "UAH":
     				
     				double DomyslnyCAD;
			         
				        DomyslnyCAD=wartosc;
				       
 				       
				     
     				         
     				        
     				       java.text.DecimalFormat dfCAD=new java.text.DecimalFormat();
     				      dfCAD.setMaximumFractionDigits(2);
     				      dfCAD.setMinimumFractionDigits(2);
     				      String NWCAD = dfCAD.format(DomyslnyCAD);
     				       
    	     				 req.setAttribute("wartosc", NWCAD);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rdCAD = req.getRequestDispatcher("/index.jsp");
    	     				 rdCAD.forward(req,res); 
     				         
     				  
     				   
     				
     				 break;
     			case "EUR" :
     				
     				String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     				   }
				        
  				   	 catch (Exception e)
  				   	    {
  				   	        e.printStackTrace();
  				   	    }
     				  
     				   
     				 
     				 break;
     				 
     				 
     				 
     			case "DOL" :

     				String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				
     				URL obj2 = new URL(url2);
     				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
     				con2.setRequestMethod("GET");
     				BufferedReader in2 = new BufferedReader(
     				        new InputStreamReader(con2.getInputStream()));
     				String inputLine2;
     				StringBuffer response2 = new StringBuffer();

     				while ((inputLine2 = in2.readLine()) != null) {
     					response2.append(inputLine2);
     				}
     				in2.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url2).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					
     			
     					     				 break;
     			
     			case "CHF" :
     				String url3 = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL obj3 = new URL(url3);
     				HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
     				con3.setRequestMethod("GET");
     				BufferedReader in3 = new BufferedReader(
     				        new InputStreamReader(con3.getInputStream()));
     				String inputLine3;
     				StringBuffer response3 = new StringBuffer();

     				while ((inputLine3 = in3.readLine()) != null) {
     					response3.append(inputLine3);
     				}
     				in3.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url3).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "GBP" :
     				String url4 = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				
     				URL obj4 = new URL(url4);
     				HttpURLConnection con4 = (HttpURLConnection) obj4.openConnection();
     				con4.setRequestMethod("GET");
     				BufferedReader in4 = new BufferedReader(
     				        new InputStreamReader(con4.getInputStream()));
     				String inputLine4;
     				StringBuffer response4 = new StringBuffer();

     				while ((inputLine4 = in4.readLine()) != null) {
     					response4.append(inputLine4);
     				}
     				in4.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url4).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "JPY" :
     				String url5 = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/?format=xml";
     				
     				URL obj5 = new URL(url5);
     				HttpURLConnection con5 = (HttpURLConnection) obj5.openConnection();
     				con5.setRequestMethod("GET");
     				BufferedReader in5 = new BufferedReader(
     				        new InputStreamReader(con5.getInputStream()));
     				String inputLine5;
     				StringBuffer response5 = new StringBuffer();

     				while ((inputLine5 = in5.readLine()) != null) {
     					response5.append(inputLine5);
     				}
     				in5.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url5).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			case "AUD" :
     				String url6 = "http://api.nbp.pl/api/exchangerates/rates/a/aud/?format=xml";
     				
     				URL obj6 = new URL(url6);
     				HttpURLConnection con6 = (HttpURLConnection) obj6.openConnection();
     				con6.setRequestMethod("GET");
     				BufferedReader in6 = new BufferedReader(
     				        new InputStreamReader(con6.getInputStream()));
     				String inputLine6;
     				StringBuffer response6 = new StringBuffer();

     				while ((inputLine6 = in6.readLine()) != null) {
     					response6.append(inputLine6);
     				}
     				in6.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url6).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     					     				 
     			case "CZK" :
     				String url7 = "http://api.nbp.pl/api/exchangerates/rates/a/czk/?format=xml";
     				
     				URL obj7 = new URL(url7);
     				HttpURLConnection con7 = (HttpURLConnection) obj7.openConnection();
     				con7.setRequestMethod("GET");
     				BufferedReader in7 = new BufferedReader(
     				        new InputStreamReader(con7.getInputStream()));
     				String inputLine7;
     				StringBuffer response7 = new StringBuffer();

     				while ((inputLine7 = in7.readLine()) != null) {
     					response7.append(inputLine7);
     				}
     				in7.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url7).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res); 
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     					     				 
     			
     			case "CAD" :
String url8 = "http://api.nbp.pl/api/exchangerates/rates/a/cad/?format=xml";
     				
     				URL obj8 = new URL(url8);
     				HttpURLConnection con8 = (HttpURLConnection) obj8.openConnection();
     				con8.setRequestMethod("GET");
     				BufferedReader in8 = new BufferedReader(
     				        new InputStreamReader(con8.getInputStream()));
     				String inputLine8;
     				StringBuffer response8 = new StringBuffer();

     				while ((inputLine8 = in8.readLine()) != null) {
     					response8.append(inputLine8);
     				}
     				in8.close();

     				 try
     				    {
     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
         				
         				URL objP = new URL(urlP);
         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
         				conP.setRequestMethod("GET");
         				BufferedReader inP = new BufferedReader(
         				        new InputStreamReader(conP.getInputStream()));
         				String inputLineP;
         				StringBuffer responseP = new StringBuffer();

         				while ((inputLineP = inP.readLine()) != null) {
         					responseP.append(inputLineP);
         				}
         				inP.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url8).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	Mnoznik = KursPodst/kurs;
     				        	NowaWartosc = wartosc*Mnoznik;
     				         
     				        
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NowaWartosc);
     				       
     				     req.setAttribute("walP", walwym);
  				      	req.setAttribute("ilosc", wartosc);
    	     				 req.setAttribute("wartosc", NW);
    	     				req.setAttribute("waluta", walotr); 
    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	     				 rd.forward(req,res);  
     					     				         
     					     				  
     					     				    }
     					     				        
     					     				   	 catch (Exception e)
     					     				   	    {
     					     				   	        e.printStackTrace();
     					     				   	    }
     					     				 break;
     					     				 
     			case "PLN" :
     				String url9 = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				     				
     				     				URL obj9 = new URL(url9);
     				     				HttpURLConnection con9 = (HttpURLConnection) obj9.openConnection();
     				     				con9.setRequestMethod("GET");
     				     				BufferedReader in9 = new BufferedReader(
     				     				        new InputStreamReader(con9.getInputStream()));
     				     				String inputLine9;
     				     				StringBuffer response9 = new StringBuffer();

     				     				while ((inputLine9 = in9.readLine()) != null) {
     				     					response9.append(inputLine9);
     				     				}
     				     				in9.close();

     				     				 try
     				     				    {
     				     					String urlP = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				         				
     				         				URL objP = new URL(urlP);
     				         				HttpURLConnection conP = (HttpURLConnection) objP.openConnection();
     				         				conP.setRequestMethod("GET");
     				         				BufferedReader inP = new BufferedReader(
     				         				        new InputStreamReader(conP.getInputStream()));
     				         				String inputLineP;
     				         				StringBuffer responseP = new StringBuffer();

     				         				while ((inputLineP = inP.readLine()) != null) {
     				         					responseP.append(inputLineP);
     				         				}
     				         				inP.close();
     				         				
     				         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
     				 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
     				 				        org.w3c.dom.Document doc2 = db2.parse(new URL(urlP).openStream());

     				 				        doc2.getDocumentElement().normalize();
     				 				        
     				 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
     				 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				 				         double KursPodst = Double.parseDouble(wartoscs2);
     				         				
     				     					 
     				     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				     				        org.w3c.dom.Document doc = db.parse(new URL(url9).openStream());

     				     				        doc.getDocumentElement().normalize();
     				     				        
     				     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				     				         double kurs = Double.parseDouble(wartoscs);
     				     				         
     				     				         
     				     				        
     				     				        	
     				     				        	NowaWartosc = wartosc*KursPodst;
     				     				         
     				     				        
     				     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				     				      df.setMaximumFractionDigits(2);
     				     				      df.setMinimumFractionDigits(2);
     				     				      String NW = df.format(NowaWartosc);
     				     				       
     				     				    req.setAttribute("walP", walwym);
     			     				      	req.setAttribute("ilosc", wartosc);
     				    	     				 req.setAttribute("wartosc", NW);
     				    	     				req.setAttribute("waluta", walotr); 
     				    	     				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
     				    	     				 rd.forward(req,res);  
     				     					     				         
     				     					     				  
     				     					     				    }
     				     					     				        
     				     					     				   	 catch (Exception e)
     				     					     				   	    {
     				     					     				   	        e.printStackTrace();
     				     					     				   	    }
     				     					     				 break;
     			}
     			
     			
     			
     			
     			
     			
     			
     			
     			
     			
	     			
	     			default:  RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	     			 rd.forward(req,res); 
	         
	     			
	         }
}



}
	         
	   
	 
	
	   
	

	
	
	
	
	

	 
	
	
	
	
	
	
		
	



