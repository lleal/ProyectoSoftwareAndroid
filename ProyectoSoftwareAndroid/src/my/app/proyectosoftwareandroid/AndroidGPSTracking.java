package my.app.proyectosoftwareandroid;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

 
public class AndroidGPSTracking extends BroadcastReceiver {
	final public static String ONE_TIME = "onetime";
	String device_id;
	JSONParser jsonParser = new JSONParser();
	
	 GPSTracker gps;
	
    
    String url_insertar_gps="insertar_gps.php";
    String loc="";
    private static final String TAG_SUCCESS = "success";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.err.println("Recibi se�al de GPS");
		final TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		 device_id = telephonyManager.getDeviceId();
	    	gps = new GPSTracker(context);
	    	double latitude=-1;
			double longitude=-1;
			// check if GPS enabled		
	        if(gps.canGetLocation()){
	        	
	        	latitude = gps.getLatitude();
	        	longitude = gps.getLongitude();
	        	
	        	// \n is for new line
	        	//Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();	
	        	loc= "" + latitude + " " + longitude;
	        	new InsertarGPS().execute();
	        }else{
	        	// can't get location
	        	// GPS or Network is not enabled
	        	// Ask user to enable GPS/network in settings
	        	//gps.showSettingsAlert();
	        	System.err.println("No se pudo obtener ubicacion");
	        }
	        
			 
	        
	        
	        
	}
	public void SetAlarm(Context context)
    {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AndroidGPSTracking.class);
        intent.putExtra(ONE_TIME, Boolean.FALSE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 2, intent, 0);
        //After after 5 seconds
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 10 , pi); 
    }
	
	class InsertarGPS extends AsyncTask<String, String, String> {
    	protected String doInBackground(String... args) {
	    
	        // Building Parameters
	       
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("loc", loc));
	        params.add(new BasicNameValuePair("imei", device_id));
	        EnvioWeb envioMensajes = new EnvioWeb (url_insertar_gps, params);
	        envioMensajes.envio();
	        return null;
    	}

	
	}	
	
}
    
