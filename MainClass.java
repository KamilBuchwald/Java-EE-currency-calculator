import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainClass {

	

	    public static void main(String[] args) throws Exception {
	    	
	    	String currencyTo = "pln";
	    	String currencyFrom="pln";
	    	int v = 1;
	    	String URLfrom ="";
	    	String URLto ="";
	    	double From= 0;
	    	double To = 0;
	    	String calculation ="";
	    	if(currencyFrom.equals("pln")&&currencyTo.equals("pln")) {
	    		System.out.println(v);
	    		
	    	}else if(currencyTo.equals("pln")) {
	    		
	    		To=1;
	    		URLfrom = UrlAdress(currencyFrom);
	    		From = RateTo(URLfrom);
	    		calculation = calculate(From,To,v);
	    		
	    	}else if(currencyFrom.equals("pln")){
	    		
	    		From=1;
	    		URLfrom = UrlAdress(currencyTo);
	    		To = RateFrom(URLfrom);
	    		calculation = calculate(From,To,v);
	    	}else 
	    	{
	    	
	    	URLfrom = UrlAdress(currencyTo);
	    	URLto = UrlAdress(currencyFrom);
	    	From = RateFrom(URLfrom);
	    	To = RateTo(URLto);
	    	calculation = calculate(From,To,v);
	    	}
	    	
	    	System.out.println(calculation);
	    	}
	    

	    private static String UrlAdress(String currency){
	    	
	    	
	    	
	    	String query = currency;
	    	String format = "?format=xml";
	    	String URL = "http://api.nbp.pl/api/exchangerates/rates/a/";
	    	String UrlA = URL+query+format;
	    	
	    	return UrlA;
	    	
	    }
	    
	    private static double RateFrom(String URL) throws IOException {
	    	
	    	
	    		
	    		double rateFrom = 0.00;
	  
				
				URL obj = new URL(URL);
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
				        org.w3c.dom.Document doc = db.parse(new URL(URL).openStream());

				        doc.getDocumentElement().normalize();
				        
				         String wartoscs = doc.getDocumentElement().getLastChild().
				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
				          rateFrom = Double.parseDouble(wartoscs);
				    
				    }
				        
				   	 catch (Exception e)
				   	    {
				   	        e.printStackTrace();
				   	    }
				 
				
				
	    	
	    	return rateFrom;
	    }
	    
	    private static double RateTo(String URL) throws IOException {
	    
    		double rateTo = 0;
  
			
			URL obj = new URL(URL);
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
			        org.w3c.dom.Document doc = db.parse(new URL(URL).openStream());

			        doc.getDocumentElement().normalize();
			        
			         String wartoscs = doc.getDocumentElement().getLastChild().
			                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
			          rateTo = Double.parseDouble(wartoscs);
			     
			
			    }
			        
			   	 catch (Exception e)
			   	    {
			   	        e.printStackTrace();
			   	    }
    	
    	return rateTo;
    }
	    
	    
	 private static String calculate(double From, double To, int value) {
		 
		 double multipler =From/To;
		 double calculations = multipler*value;
		 
		  java.text.DecimalFormat df=new java.text.DecimalFormat();
	      df.setMaximumFractionDigits(2);
	      df.setMinimumFractionDigits(2);
	      String FinalValue = df.format(calculations);
		 
		 return FinalValue;
	 }
	}


