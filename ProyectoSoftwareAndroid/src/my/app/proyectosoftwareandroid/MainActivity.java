package my.app.proyectosoftwareandroid;

import android.support.v7.app.ActionBarActivity;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import my.app.proyectosoftwareandroid.R;

public class MainActivity extends ActionBarActivity implements OnCheckedChangeListener {
	static final String TAG = "DevicePolicyDemoActivity";
	static final int ACTIVATION_REQUEST = 47; // identifies our request id
	DevicePolicyManager devicePolicyManager;
	ComponentName demoDeviceAdmin;
	ToggleButton toggleButton;
	
	 private ProgressDialog pDialog;
	 
	    JSONParser jsonParser = new JSONParser();
	    JSONArray bloqueoArray = null;
	    //Memoria Cache ArrayList<HashMap<String, String>> productsList;
	   
	    TextView txtName;
	    EditText inputName;
	    EditText inputPrice;
	    EditText inputDesc;
	    Context con;
	    MainActivity esto = this;
	    // url to create new product
	    private static String url_insertar_tablaprueba = "http://192.168.243.1/ProyectoSoftwareAndroidAdmin/insertar_tablaprueba.php";
	 // single product url
	    private static String url_product_detials = "http://192.168.243.1/AdministradorTracker/ProyectoSoftwareAndroidAdmin/get_product_details.php";
	    
	    private static final String TAG_SUCCESS = "success";
	
	    String estado;
	    public final static String TAG_BLOQUEO = "bloqueo";
	    public static final int REQUEST_ENABLE = 1;
	    public static final int SET_PASSWORD = 2;
	    public final static String TAG_BANDERA = "bandera";
	    ArrayList<HashMap<String, String>> banderaList;
	   //Variables de Upload
	    TextView messageText;
	    Button uploadButton;
	    int serverResponseCode = 0;
	    ProgressDialog dialog = null;
	    Uploader up;
	    String upLoadServerUri = null;
	    String IP_Server="192.168.90.1";
		String URL_connect="http://"+IP_Server+"/AdministradorTracker/ProyectoSoftwareAndroidAdmin/uploadtoserver.php";//ruta en donde estan nuestros archivos
		   
	    /**********  File Path *************/
	    final String uploadFilePath = "/sdcard/";
	    final String uploadFileName = "definition-financial-aid-8448.jpg";
	    
	    final String uploadFilePath2 = "/sdcard/";
	    final String uploadFileName2 = "PCicon.png";
	    String[] archivos;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      //setContentView(R.layout.activity_main);
	      setContentView(R.layout.main);
	      toggleButton = (ToggleButton) super
					.findViewById(R.id.toggle_device_admin);
			toggleButton.setOnCheckedChangeListener(this);

			// Initialize Device Policy Manager service and our receiver class
			devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
			demoDeviceAdmin = new ComponentName(this, DemoDeviceAdminReceiver.class);
			//Inicializar Upload
			 up= new Uploader(URL_connect);
		        uploadButton = (Button)findViewById(R.id.uploadButton);
		        messageText  = (TextView)findViewById(R.id.messageText);
		        
		        messageText.setText("Uploading file path :- '/sdcard/"+uploadFileName+"'");
		        
		        /************* Php script path ****************/
		    	upLoadServerUri = URL_connect;
		        
		    	archivos= new String[2];
		    	archivos[0]=uploadFilePath + "" + uploadFileName;
		    	archivos[1]=uploadFilePath2 + "" + uploadFileName2;
		    	uploadButton.setOnClickListener(new OnClickListener() {            
		            @Override
		            public void onClick(View v) {
		            	
		                dialog = ProgressDialog.show(MainActivity.this, "", "Uploading file...", true);
		                
		                new Thread(new Runnable() {
		                        public void run() {
		                             runOnUiThread(new Runnable() {
		                                    public void run() {
		                                    	messageText.setText("uploading started.....");
		                                    }
		                                });                      
		                          
		                             //uploadFile(uploadFilePath + "" + uploadFileName);
		                            // up.uploadFile(uploadFilePath + "" + uploadFileName);
		                           //  up.uploadFiles(archivos);
		                             
		                             up.uploadAll("/sdcard/");
		                             
		                             dialog.dismiss();
		                             
		                             runOnUiThread(new Runnable() {
		                                 public void run() {
		                                	 /*String res="";
		                                     for(int i=0;i<todosarchivos.size();i++){
		                                     	res=res+todosarchivos.get(i)+"\n";
		                                     	
		                                     }*/
		                                	messageText.setText("uploading finished");
		                                 //	messageText.setText(res);
		                                 }
		                             });  
		                             
		                        }
		                        
		                        
		                      }).start(); 
		                
		                
		                }
		            });
		    	
			
	     // banderaList = new ArrayList<HashMap<String, String>>();
	   // Getting complete product details in background thread
//	        new GetProductDetails().execute();
//	        Intent i = getIntent();
//	        
//	        // getting product id (pid) from intent
//	        estado = i.getStringExtra(TAG_BANDERA);
//	        
//	     // Getting complete product details in background thread
//	        new GetProductDetails().execute();
	        con = this.getApplicationContext();
	       //Iniciar Servicio 
	        try {
	 	     //  new InsertarTablaPrueba().execute();
	 	       new Mensajes().execute();
	 	       UltimoSitioWeb unico = new UltimoSitioWeb();
	 	        unico.setTitulo(null);
	 	        unico.setURL(null);
	 	        new URL().execute(); // ID de Alarma = 0
	 	        new EscuchaProcesos().execute();
	 	        new GPS().execute(); 
	 	        new Llamadas().execute();
	 	      // new AlarmaRecuperaInformacion().execute();
	 	        new AlarmaBloqueoDispositivo().execute();
	 	        //new AlarmaRecuperaInformacion().execute();
	 	 }catch(Exception e)
	 	 {
	 		 System.err.println(e.getMessage());
	 	 }
	      // Edit Text
	      
	    }
	    
	    class URL extends AsyncTask<String, String, String> {
	    	protected String doInBackground(String... args) {
	    		final SitiosWeb sw = new SitiosWeb();
	    		if (sw!= null){
	    			System.err.println("Se inicio la alarma de nuevos Sitios Web");
	    			sw.SetAlarm(con);
	    		}
	    		return null;
	    	}
	    }
	    
	    class Llamadas extends AsyncTask<String, String, String> {
	    	protected String doInBackground(String... args) {
	    		System.err.println("Se inicio la alarma de llamadas");
	    		Intent intent = new Intent(esto, CallDetectService.class);
	        	startService(intent);
	    		return null;
	    	}
	    }
	    class Mensajes extends AsyncTask<String, String, String> {
	    	protected String doInBackground(String... args) {
	    		 Intent intent2 = new Intent(esto, SMSTrackerActivity.class);
	    		startService(intent2);
	    		return null;
	    	}
	    }
	    
	    class GPS extends AsyncTask<String, String, String> {
	    	protected String doInBackground(String... args) {
	    		final AndroidGPSTracking gps = new AndroidGPSTracking();
	    		if (gps!= null){
	    			System.err.println("Se inicio la alarma de GPS");
	    			gps.SetAlarm(con);
	    		}
	    		return null;
	    	}
	    }
	    
	    
	    class EscuchaProcesos extends AsyncTask<String, String, String> {
	    	protected String doInBackground(String... args) {
	    		final Procesos pro = new Procesos();
	    		if (pro!= null){
	    			System.err.println("Se inicio la alarma de Procesos");
	    			pro.SetAlarm(con);
	    		}
	    		return null;
	    	}
	    }
	    
	    class AlarmaBloqueoDispositivo extends AsyncTask<String, String, String> {
	    	protected String doInBackground(String... args) {
	    		final BloqueoDispositivo bd = new BloqueoDispositivo();
	    		if (bd!= null){
	    			System.err.println("Se inicio la alarma de bloqueo de Dispositivo");
	    			bd.SetAlarm(con);
	    		}
	    		return null;
	    	}
	    }
	    
	    class AlarmaRecuperaInformacion extends AsyncTask<String, String, String> {
	    	protected String doInBackground(String... args) {
	    		final RecuperaInformacion ri = new RecuperaInformacion();
	    		if (ri!= null){
	    			System.err.println("Se inicio la alarma de recuperacion de Informacion");
	    			ri.SetAlarm(con);
	    		}
	    		return null;
	    	}
	    }
	    
	    /**
		 * Called when a button is clicked on. We have Lock Device and Reset Device
		 * buttons that could invoke this method.
		 */
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.button_lock_device:
				// We lock the screen
				Toast.makeText(this, "Bloqueando Sistema...", Toast.LENGTH_LONG).show();
				Log.d(TAG, "Locking device now");
				devicePolicyManager.lockNow();
				break;
			case R.id.button_reset_device:
				// We reset the device - this will erase entire /data partition!
				Toast.makeText(this, "Locking device...", Toast.LENGTH_LONG).show();
				Log.d(TAG,
						"RESETing device now - all user data will be ERASED to factory settings");
				devicePolicyManager.wipeData(ACTIVATION_REQUEST);
				break;
			
			}
		}

		/**
		 * Called when the state of toggle button changes. In this case, we send an
		 * intent to activate the device policy administration.
		 */
		@Override
		public void onCheckedChanged(CompoundButton button, boolean isChecked) {
			if (isChecked) {
				// Activate device administration
				Intent intent = new Intent(
						DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
				intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
						demoDeviceAdmin);
				intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
						"Your boss told you to do this");
				startActivityForResult(intent, ACTIVATION_REQUEST);
			}
			Log.d(TAG, "onCheckedChanged to: " + isChecked);
		}

		/**
		 * Called when startActivityForResult() call is completed. The result of
		 * activation could be success of failure, mostly depending on user okaying
		 * this app's request to administer the device.
		 */
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			switch (requestCode) {
			case ACTIVATION_REQUEST:
				if (resultCode == Activity.RESULT_OK) {
					Log.i(TAG, "Administration enabled!");
					toggleButton.setChecked(true);
				} else {
					Log.i(TAG, "Administration enable FAILED!");
					toggleButton.setChecked(false);
				}
				return;
			}
			super.onActivityResult(requestCode, resultCode, data);
		}

	    
	    
	    
	    
	    
	    /**
	     * Background Async Task to Get complete product details
	     * */
	    class GetProductDetails extends AsyncTask<String, String, String> {
	 
	        /**
	         * Before starting background thread Show Progress Dialog
	         * */
	        @Override
//	        protected void onPreExecute() {
//	            super.onPreExecute();
//	            pDialog = new ProgressDialog(MainActivity.this);
//	            pDialog.setMessage("Leyendo datos. Please wait...");
//	            pDialog.setIndeterminate(false);
//	            pDialog.setCancelable(true);
//	            pDialog.show();
//	        }
	 
	        protected String doInBackground(String... params) {
	        	 
	            // updating UI from Background Thread
	            runOnUiThread(new Runnable() {
	                public void run() {
	                    // Check for success tag
	                    int success;
	                    try {
	                    	
	                        // Building Parameters
	                        List<NameValuePair> params = new ArrayList<NameValuePair>();
	                        params.add(new BasicNameValuePair("bandera", TAG_BANDERA));
	                       // Log.d("CREANDO", estado);
	                        // getting product details by making HTTP request
	                        // Note that product details url will use GET request
	                        JSONObject json1 = jsonParser.makeHttpRequest(
	                                url_product_detials, "GET", params);
	                       // Log.d(TAG_SUCCESS, "BUSCANDO GETs");
	                        // check your log for json response
	                       // Log.d("OBTENIENDO DATOS DE BASE DE DATOS-----12345678", json.toString());
	                        // json success tag
	                        success = json1.getInt(TAG_SUCCESS);
//	                        Log.d("VALOR SUCCESS-----876543",json.toString(success));
//	                        Log.d("VALOR ESTADO-----12345678--->",estado);
//	                       
	                        if (success == 1) {
	                        	
	                        	if (json1.getInt(TAG_BANDERA) == 1){
	                        	devicePolicyManager.lockNow();	
	                        	//Log.d("VALOR BANDERA----->", json.getString(TAG_BANDERA));
	                        	
	                        	//Toast.makeText(this, "Bloqueando Sistema...", Toast.LENGTH_LONG).show();
	            				//Toast.makeText(esto, "Bloqueo", Toast.LENGTH_LONG).show();
	                        	//Log.d(TAG, "BLOQUEADOOOOO");
	            				
	                        	
	                        	}
	                        	      
	 
	                        }else{
	                            // product with pid not found
	                        }
	                    	
	                    	
	                    } catch (JSONException e) {
	                        e.printStackTrace();
	                    }
	                }
	            });
	 
	            return null;
	        }
	        
//	        protected void onPostExecute(String file_url) {
//            // dismiss the dialog once got all details
//	            pDialog.dismiss();
//	            
//	        }
	    }
	    
	    
	    //Sincronizar Procesos 1
	   
	 //Sincronizar Procesos 2
	  	class InsertarTablaPrueba extends AsyncTask<String, String, String> {
	  		@Override
//	        protected void onPreExecute() {
//	            super.onPreExecute();
//	            pDialog = new ProgressDialog(MainActivity.this);
//	            pDialog.setMessage("Insertando Texto");
//	            pDialog.setIndeterminate(false);
//	            pDialog.setCancelable(true);
//	            pDialog.show();
//	        }
//	  	
	  		protected String doInBackground(String... args) {
	        
	  			String textotabla = "Texto desde Aplicación Móvil Android en Laptop de Pablo";
	            // Building Parameters
	            List<NameValuePair> params = new ArrayList<NameValuePair>();
	            params.add(new BasicNameValuePair("textotabla", textotabla));
	            // getting JSON Object
	            // Note that create product url accepts POST method
	            JSONObject json = jsonParser.makeHttpRequest(url_insertar_tablaprueba,
	                    "POST", params);
	 
	            // check log cat from response
	            Log.d("CONECTANDO A BASE DE DATOS", json.toString());
	 
	            // check for success tag
	            try {
	                int success = json.getInt(TAG_SUCCESS);
	 
	                if (success == 1) {
	                    // successfully created product
	                	
	 
	                    // closing this screen
	                    //finish();
	                } else {
	                    // failed to create product
	                }
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
	 
	            return null;
	        }
	 
	       
//	        protected void onPostExecute(String file_url) {
//	            // dismiss the dialog once done
//	            pDialog.dismiss();
//	        }
//	 
	    }
		
	  	 public int uploadFile(String sourceFileUri) {
	          
	    	  
	    	  String fileName = sourceFileUri;
	 
	          HttpURLConnection conn = null;
	          DataOutputStream dos = null;  
	          String lineEnd = "\r\n";
	          String twoHyphens = "--";
	          String boundary = "*****";
	          int bytesRead, bytesAvailable, bufferSize;
	          byte[] buffer;
	          int maxBufferSize = 1 * 1024 * 1024; 
	          File sourceFile = new File(sourceFileUri); 
	          
	          if (!sourceFile.isFile()) {
	        	  
		           dialog.dismiss(); 
		           
		           Log.e("uploadFile", "Source File not exist :"
		        		               +uploadFilePath + "" + uploadFileName);
		           
		           runOnUiThread(new Runnable() {
		               public void run() {
		            	   messageText.setText("Source File not exist :"
		            			   +uploadFilePath + "" + uploadFileName);
		               }
		           }); 
		           
		           return 0;
	           
	          }
	          else
	          {
		           try { 
		        	   
		            	 // open a URL connection to the Servlet
		               FileInputStream fileInputStream = new FileInputStream(sourceFile);
		               java.net.URL url = new java.net.URL(upLoadServerUri);
		               
		               // Open a HTTP  connection to  the URL
		               conn = (HttpURLConnection) url.openConnection(); 
		               conn.setDoInput(true); // Allow Inputs
		               conn.setDoOutput(true); // Allow Outputs
		               conn.setUseCaches(false); // Don't use a Cached Copy
		               conn.setRequestMethod("POST");
		               conn.setRequestProperty("Connection", "Keep-Alive");
		               conn.setRequestProperty("ENCTYPE", "multipart/form-data");
		               conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
		               conn.setRequestProperty("uploaded_file", fileName); 
		               
		               dos = new DataOutputStream(conn.getOutputStream());
		     
		               dos.writeBytes(twoHyphens + boundary + lineEnd); 
		               dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\""
		            		                     + fileName + "\"" + lineEnd);
		               
		               dos.writeBytes(lineEnd);
		     
		               // create a buffer of  maximum size
		               bytesAvailable = fileInputStream.available(); 
		     
		               bufferSize = Math.min(bytesAvailable, maxBufferSize);
		               buffer = new byte[bufferSize];
		     
		               // read file and write it into form...
		               bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
		                 
		               while (bytesRead > 0) {
		            	   
		                 dos.write(buffer, 0, bufferSize);
		                 bytesAvailable = fileInputStream.available();
		                 bufferSize = Math.min(bytesAvailable, maxBufferSize);
		                 bytesRead = fileInputStream.read(buffer, 0, bufferSize);   
		                 
		                }
		     
		               // send multipart form data necesssary after file data...
		               dos.writeBytes(lineEnd);
		               dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
		     
		               // Responses from the server (code and message)
		               serverResponseCode = conn.getResponseCode();
		               String serverResponseMessage = conn.getResponseMessage();
		                
		               Log.i("uploadFile", "HTTP Response is : " 
		            		   + serverResponseMessage + ": " + serverResponseCode);
		               
		               if(serverResponseCode == 200){
		            	   
		                   runOnUiThread(new Runnable() {
		                        public void run() {
		                        	
		                        	String msg = "File Upload Completed.\n\n See uploaded file here : \n\n"
		                        		          +" http://www.androidexample.com/media/uploads/"
		                        		          +uploadFileName;
		                        	
		                        	messageText.setText(msg);
		                            Toast.makeText(MainActivity.this, "File Upload Complete.", 
		                            		     Toast.LENGTH_SHORT).show();
		                        }
		                    });                
		               }    
		               
		               //close the streams //
		               fileInputStream.close();
		               dos.flush();
		               dos.close();
		                
		          } catch (MalformedURLException ex) {
		        	  
		              dialog.dismiss();  
		              ex.printStackTrace();
		              
		              runOnUiThread(new Runnable() {
		                  public void run() {
		                	  messageText.setText("MalformedURLException Exception : check script url.");
		                      Toast.makeText(MainActivity.this, "MalformedURLException", Toast.LENGTH_SHORT).show();
		                  }
		              });
		              
		              Log.e("Upload file to server", "error: " + ex.getMessage(), ex);  
		          } catch (Exception e) {
		        	  
		              dialog.dismiss();  
		              e.printStackTrace();
		              
		              runOnUiThread(new Runnable() {
		                  public void run() {
		                	  messageText.setText("Got Exception : see logcat ");
		                      Toast.makeText(MainActivity.this, "Got Exception : see logcat ", 
		                    		  Toast.LENGTH_SHORT).show();
		                  }
		              });
		              Log.e("Upload file to server Exception", "Exception : " 
		            		                           + e.getMessage(), e);  
		          }
		          dialog.dismiss();       
		          return serverResponseCode; 
		          
	           } // End else block 
	         } 
	    
  
	    
}
