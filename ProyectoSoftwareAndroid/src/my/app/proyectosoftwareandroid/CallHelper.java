package my.app.proyectosoftwareandroid;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.provider.Settings.Secure;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import my.app.proyectosoftwareandroid.MainActivity.Mensajes;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Clase que detecta y procesa llamadas entrtantes y salientes del dispositivo
 * 
 *
 */
public class CallHelper {
	private Context ctx;
	private TelephonyManager tm;
	private CallStateListener callStateListener;
	private OutgoingReceiver outgoingReceiver;
	String device_id;
	JSONParser jsonParser = new JSONParser();
	 private static String url_insertar_llamada = "http://10.0.0.10:8080/ProyectoSoftwareAndroidAdmin/insertar_llamada.php";
	 private String numero;
	 private String estado;
	    private static final String TAG_SUCCESS = "success";
	    
	/**
	 * Listener to detect incoming calls. (Llamadas Entrantes)
	 */
	private class CallStateListener extends PhoneStateListener {
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_RINGING:
				// called when someone is ringing to this phone
				System.err.println("Recibio llamada");
				Toast.makeText(ctx, 
						"Incoming: "+incomingNumber, 
						Toast.LENGTH_LONG).show();
				numero = incomingNumber;
				estado = "Entrante";
				new InsertarLlamada().execute();
				break;
			}
		}
	}
	
	/**
	 * Broadcast receiver to detect the outgoing calls. (Llamadas Salientes)
	 */
	public class OutgoingReceiver extends BroadcastReceiver {
	    public OutgoingReceiver() {
	    }

	    @Override
	    public void onReceive(Context context, Intent intent) {
	        numero = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
	        Date date = new Date();
	        
			System.out.println(date.toString() + device_id);
	        Toast.makeText(ctx, 
	        		"Outgoing: "+numero, 
	        		Toast.LENGTH_LONG).show();
	        estado = "Saliente";
	        new InsertarLlamada().execute();
	    }
  
	}



	public CallHelper(Context ctx) {
		this.ctx = ctx;
		this.tm = (TelephonyManager)this.ctx.getSystemService(Context.TELEPHONY_SERVICE);
		this.device_id = tm.getDeviceId();
		callStateListener = new CallStateListener();
		outgoingReceiver = new OutgoingReceiver();
	}
	

	/**
	 * Start calls detection.
	 */
	public void start() {
		tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
		tm.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
		
		IntentFilter intentFilter = new IntentFilter(Intent.ACTION_NEW_OUTGOING_CALL);
		ctx.registerReceiver(outgoingReceiver, intentFilter);
	}
	
	/**
	 * Stop calls detection.
	 */
	public void stop() {
		tm.listen(callStateListener, PhoneStateListener.LISTEN_NONE);
		ctx.unregisterReceiver(outgoingReceiver);
	}
	
	class InsertarLlamada extends AsyncTask<String, String, String> {
    	protected String doInBackground(String... args) {
	    	System.err.println("Hilo de insertar llamada en base de datos");
	        // Building Parameters
	         Date date = new Date();
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("id_dispositivo", device_id));
	        params.add(new BasicNameValuePair("telefono", numero));
	        params.add(new BasicNameValuePair("fecha", date.toString()));
	        params.add(new BasicNameValuePair("estatus", estado));
	        // getting JSON Object
	        // Note that create product url accepts POST method
	        JSONObject json = jsonParser.makeHttpRequest(url_insertar_llamada,
	                "POST", params);

	        // check log cat from response
	        

	        // check for success tag
	        try {
	        	Log.d("Create Response", json.toString());
	            int success = json.getInt(TAG_SUCCESS);

	            if (success == 1) {
	                // successfully created product
	                // closing this screen
	            } else {
	                // failed to create product
	            }
	        } catch (JSONException e) {
	            e.printStackTrace();
	    		return null;
	    	}
	    return null;
    	}
	}
}


