package my.app.proyectosoftwareandroid;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
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
	String device_id = tm.getDeviceId();
	JSONParser jsonParser = new JSONParser();
	 private static String url_insertar_llamada = "http://10.0.0.72/ProyectoSoftwareAndroid/insertar_llamada.php";
	 
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
				Date date = new Date();
				System.out.println(date.toString() + device_id);
				Toast.makeText(ctx, 
						"Incoming: "+incomingNumber, 
						Toast.LENGTH_LONG).show();
				new InsertarLlamada.execute();
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
	        String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
	        Date date = new Date();
	        
			System.out.println(date.toString() + device_id);
	        Toast.makeText(ctx, 
	        		"Outgoing: "+number, 
	        		Toast.LENGTH_LONG).show();
	    }
  
	}



	public CallHelper(Context ctx) {
		this.ctx = ctx;
		
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
		 
	    /**
	     * Before starting background thread Show Progress Dialog
	     * */
	    @Override
	    protected void onPreExecute() {
	   
	    }

	    /**
	     * Creating product
	     * */
	    protected String doInBackground(String... args) {
	    
	String textotabla = "Texto desde Aplicación Móvil Android";
	        // Building Parameters
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("textotabla", ""));
	        

	        // getting JSON Object
	        // Note that create product url accepts POST method
	        JSONObject json = jsonParser.makeHttpRequest(url_insertar_llamada,
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

	    /**
	     * After completing background task Dismiss the progress dialog
	     * **/
	    protected void onPostExecute(String file_url) {
	        // dismiss the dialog once done
	    }

	}
}


