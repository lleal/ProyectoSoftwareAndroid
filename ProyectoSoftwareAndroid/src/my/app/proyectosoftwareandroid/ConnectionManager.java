package my.app.proyectosoftwareandroid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
/*CLASE AUXILIAR PARA EL ENVIO DE PETICIONES A NUESTRO SISTEMA
 * Y MANEJO DE RESPUESTA.*/
public class ConnectionManager {
		
	    public static boolean loginstatus(String username ,String password, Httppostaux post, String URL_connect) {
	    	int logstatus=-1;
	    	int logstatus2=-1;
	    	
	    	/*Creamos un ArrayList del tipo nombre valor para agregar los datos recibidos por los parametros anteriores
	    	 * y enviarlo mediante POST a nuestro sistema para relizar la validacion*/ 
	    	ArrayList<NameValuePair> postparameters2send= new ArrayList<NameValuePair>();
	    	
			    		postparameters2send.add(new BasicNameValuePair("usuario",username));
			    		postparameters2send.add(new BasicNameValuePair("password",password));
			   
			    		
			   //realizamos una peticion y como respuesta obtenes un array JSON
	      		JSONArray jdata=post.getserverdata(postparameters2send, URL_connect);

	      		/*como estamos trabajando de manera local el ida y vuelta sera casi inmediato
	      		 * para darle un poco realismo decimos que el proceso se pare por unos segundos para poder
	      		 * observar el progressdialog
	      		 * la podemos eliminar si queremos
	      		 */
			  //  SystemClock.sleep(950);
			    		
			    //si lo que obtuvimos no es null
			    	if (jdata!=null && jdata.length() > 0){

			    		JSONObject json_data; //creamos un objeto JSON
						try {
							json_data = jdata.getJSONObject(0); //leemos el primer segmento en nuestro caso el unico
							 logstatus=json_data.getInt("logstatus");//accedemos al valor 
							 Log.e("loginstatus","logstatus= "+logstatus);//muestro por log que obtuvimos
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		            
			             
						//validamos el valor obtenido
			    		 if (logstatus==0){// [{"logstatus":"0"}] 
			    			 Log.e("loginstatus ", "invalido");
			    			 return false;
			    		 }
			    		 else{// [{"logstatus":"1"}]
			    			
			    			 //***************************************
			    			 
			    	
			    			 
			    			 //***************************************
			    			 
			    			 Log.e("loginstatus ", "valido");
			    			 return true;
			    		 }
			    		 
				  }else{	//json obtenido invalido verificar parte WEB.
			    			 Log.e("JSON  ", "ERROR");
				    		return false;
				  }
	    	
	    }
	    
	    public static boolean logingpsstatus(String username ,String password , String location,  Httppostaux post, String URL_connect) {
	    	int logstatus=-1;
	    	//int logstatus2=-1;
	    	
	    	/*Creamos un ArrayList del tipo nombre valor para agregar los datos recibidos por los parametros anteriores
	    	 * y enviarlo mediante POST a nuestro sistema para relizar la validacion*/ 
	    	ArrayList<NameValuePair> postparameters2send= new ArrayList<NameValuePair>();
	    //	ArrayList<NameValuePair> postparameters2send2= new ArrayList<NameValuePair>();
			    		postparameters2send.add(new BasicNameValuePair("usuario",username));
			    		postparameters2send.add(new BasicNameValuePair("password",password));
			    		postparameters2send.add(new BasicNameValuePair("gps",location));
			    		
			    		
			   //realizamos una peticion y como respuesta obtenes un array JSON
	      		JSONArray jdata=post.getserverdata(postparameters2send, URL_connect);

	      		/*como estamos trabajando de manera local el ida y vuelta sera casi inmediato
	      		 * para darle un poco realismo decimos que el proceso se pare por unos segundos para poder
	      		 * observar el progressdialog
	      		 * la podemos eliminar si queremos
	      		 */
			  //  SystemClock.sleep(950);
			    		
			    //si lo que obtuvimos no es null
	      		if (jdata!=null && jdata.length() > 0){

		    		JSONObject json_data; //creamos un objeto JSON
					try {
						json_data = jdata.getJSONObject(0); //leemos el primer segmento en nuestro caso el unico
						 logstatus=json_data.getInt("logstatus");//accedemos al valor 
						 Log.e("loginstatus","logstatus= "+logstatus);//muestro por log que obtuvimos
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		            
		             
					//validamos el valor obtenido
		    		 if (logstatus==0){// [{"logstatus":"0"}] 
		    			 Log.e("loginstatus ", "invalido");
		    			 return false;
		    		 }
		    		 else{// [{"logstatus":"1"}]
		    			 Log.e("loginstatus ", "valido");
		    			// JSONArray jdata2=post.getserverdata(postparameters2send, URL_connect2);
		    			 
		    			 return true;
		    		 }
		    		 
			  }else{	//json obtenido invalido verificar parte WEB.
		    			 Log.e("JSON  ", "ERROR");
			    		return false;
			  }
	    	
	    }
	    
	    public boolean gpsstatus(String location,  Httppostaux post, String URL_connect) {
	    	int logstatus=-1;
	    	
	    	/*Creamos un ArrayList del tipo nombre valor para agregar los datos recibidos por los parametros anteriores
	    	 * y enviarlo mediante POST a nuestro sistema para relizar la validacion*/ 
	    	ArrayList<NameValuePair> postparameters2send= new ArrayList<NameValuePair>();
	     		
			    	//	postparameters2send.add(new BasicNameValuePair("usuario",username));
			    	//	postparameters2send.add(new BasicNameValuePair("password",password));
			    		postparameters2send.add(new BasicNameValuePair("gps",location));
			    		
			    		
			   //realizamos una peticion y como respuesta obtenes un array JSON
	      		JSONArray jdata=post.getserverdata(postparameters2send, URL_connect);

	      		/*como estamos trabajando de manera local el ida y vuelta sera casi inmediato
	      		 * para darle un poco realismo decimos que el proceso se pare por unos segundos para poder
	      		 * observar el progressdialog
	      		 * la podemos eliminar si queremos
	      		 */
			  //  SystemClock.sleep(950);
			    		
			    //si lo que obtuvimos no es null
			    	if (jdata!=null && jdata.length() > 0){

			    		JSONObject json_data; //creamos un objeto JSON
						try {
							json_data = jdata.getJSONObject(0); //leemos el primer segmento en nuestro caso el unico
							 logstatus=json_data.getInt("gpsstatus");//accedemos al valor 
							 Log.e("locationstatus","gpsstatus= "+logstatus);//muestro por log que obtuvimos
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		            
			             
						//validamos el valor obtenido
			    		 if (logstatus==0){// [{"logstatus":"0"}] 
			    			 Log.e("locationstatus ", "invalido");
			    			 return false;
			    		 }
			    		 else{// [{"logstatus":"1"}]
			    			 Log.e("locationstatus ", "valido");
			    			 return true;
			    		 }
			    		 
				  }else{	//json obtenido invalido verificar parte WEB.
			    			 Log.e("JSON  ", "ERROR");
				    		return false;
				  }
	    	
	    }
	    
	    
	    
	    
	    
	    

	}	
  


	  
	  
