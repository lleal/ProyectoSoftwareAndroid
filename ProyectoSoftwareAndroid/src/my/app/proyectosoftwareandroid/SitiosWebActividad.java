package my.app.proyectosoftwareandroid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;



import android.telephony.TelephonyManager;
import android.util.Log;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Browser;


public class SitiosWebActividad extends Activity {
	final public static String ONE_TIME = "onetime";
	public String tituloAux;
    public String urlAux;
    private  TelephonyManager telephonyManager;
	private  String device_id;
	private static final String TAG_SUCCESS = "success";
	JSONParser jsonParser = new JSONParser();
	private static String url_insertar_sitiosweb = "http://10.0.0.10:8080/ProyectoSoftwareAndroidAdmin/insertar_sitiosweb.php";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Cursor mCur = managedQuery(Browser.BOOKMARKS_URI,
				Browser.HISTORY_PROJECTION, null, null, null);
		mCur.moveToFirst();
		 Context mContext = getBaseContext();
			telephonyManager = (TelephonyManager)mContext.getSystemService(Service.TELEPHONY_SERVICE);
			device_id = telephonyManager.getDeviceId();
            	mCur.moveToLast();
            	UltimoSitioWeb unico = new UltimoSitioWeb();
                tituloAux =mCur
                        .getString(Browser.HISTORY_PROJECTION_TITLE_INDEX);
                urlAux = mCur
                        .getString(Browser.HISTORY_PROJECTION_URL_INDEX);
                //new InsertarURL().execute();
                if ((unico.getTitulo() == null)){
                	unico.setTitulo(tituloAux);
                	unico.setURL(urlAux);
                	Log.v("titleIdx", mCur
                            .getString(Browser.HISTORY_PROJECTION_TITLE_INDEX));
                    Log.v("urlIdx", mCur
                            .getString(Browser.HISTORY_PROJECTION_URL_INDEX));
                	//Envía tituloAux, urlAux
                    new InsertarURL().execute();
                } else {
                	if ((!tituloAux.equals(unico.getTitulo()))){
                		unico.setTitulo(tituloAux);
                    	unico.setURL(urlAux);
                    	Log.v("titleIdx", mCur
                                .getString(Browser.HISTORY_PROJECTION_TITLE_INDEX));
                        Log.v("urlIdx", mCur
                                .getString(Browser.HISTORY_PROJECTION_URL_INDEX));
                    	//Envia tituloAux, urlAux
                        new InsertarURL().execute();
                	}
                	
                }
	}


	
	class InsertarURL extends AsyncTask<String, String, String> {
    	protected String doInBackground(String... args) {
	    
	        // Building Parameters
	          System.err.println("Hilo de insertar sitio web en base de datos");
	        // Building Parameters
	         Date date = new Date();
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("id_dispositivo", device_id));
	        params.add(new BasicNameValuePair("titulo", tituloAux));
	        params.add(new BasicNameValuePair("url", urlAux));
	     
	        // getting JSON Object
	        // Note that create product url accepts POST method
	        JSONObject json = jsonParser.makeHttpRequest(url_insertar_sitiosweb,
	                "POST", params);

	        // check log cat from response
	        Log.d("Create Response", json.toString());

	        // check for success tag
	        try {
	            int success = json.getInt(TAG_SUCCESS);

	            if (success == 1) {
	                // successfully created product
	                // closing this screen
	            } else {
	                // failed to create product
	            }
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	
	}
	
	
}
