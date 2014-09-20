package my.app.proyectosoftwareandroid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import my.app.proyectosoftwareandroid.CallHelper.InsertarLlamada;
import my.app.proyectosoftwareandroid.SmsSentObserver.InsertarMensaje;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;

public class SMSTrackerActivity extends BroadcastReceiver {
	//Mensajes Recibidos
    private Context mContext;
    private Bundle mBundle;
    private Intent mIntent;
    private  String numero;
	 private String estado;
	 private String fecha;
	 private String cuerpo;
	 private static String url_insertar_mensaje = "http://10.0.0.10:8080/ProyectoSoftwareAndroidAdmin/insertar_mensaje.php";
	 private  TelephonyManager telephonyManager;
	 private  String device_id;
	 static final String TAG = "SMSTRACKER";
    private static final Uri STATUS_URI = Uri.parse("content://sms");
    private static final String TAG_SUCCESS = "success";
	 JSONParser jsonParser = new JSONParser();
    private SmsSentObserver smsSentObserver = null;
    
	public void onReceive(Context context, Intent intent) {
		try{
			
			mContext = context;
			telephonyManager = (TelephonyManager)mContext.getSystemService(Service.TELEPHONY_SERVICE);
			device_id = telephonyManager.getDeviceId();
			mIntent = intent;
			mBundle = intent.getExtras();  
			Log.e(TAG, "Intent Action : "+intent.getAction());
		    if (mBundle != null){
		    	getSMSDetails();
		    }
		    else
		    	Log.e(TAG, "Bundle is Empty!");
		    
		    if(smsSentObserver == null){
			    smsSentObserver = new SmsSentObserver(new Handler(), mContext);
			    mContext.getContentResolver().registerContentObserver(STATUS_URI, true, smsSentObserver);
		    }
		}
		catch(Exception sgh){
			Log.e(TAG, "Error in Init : "+sgh.toString());
		}
	}//fn onReceive

	private void getSMSDetails(){	     
	    SmsMessage[] msgs = null;
		try{
			Object[] pdus = (Object[]) mBundle.get("pdus");
			if(pdus != null){
				msgs = new SmsMessage[pdus.length];
				Log.e(TAG, "pdus length : "+pdus.length);
				for(int k=0; k<msgs.length; k++){
					msgs[k] = SmsMessage.createFromPdu((byte[])pdus[k]);  
				    TelephonyManager telephonyManager = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
				    String device_id =telephonyManager.getDeviceId();
					//Log.e(TAG, "getDisplayMessageBody : "+msgs[k].getDisplayMessageBody());
					//Log.e(TAG, "getDisplayOriginatingAddress : "+msgs[k].getDisplayOriginatingAddress());
					Log.e(TAG, "getOriginatingAddress : "+msgs[k].getOriginatingAddress());
					String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
					Log.e(TAG, "getMessageBody : "+msgs[k].getMessageBody());
					
					//Log.e(TAG, "getProtocolIdentifier : "+msgs[k].getProtocolIdentifier());
					//Log.e(TAG, "getStatus : "+msgs[k].getStatus());
					//Log.e(TAG, "getStatusOnIcc : "+msgs[k].getStatusOnIcc());
					//Log.e(TAG, "getStatusOnSim : "+msgs[k].getStatusOnSim());
					
					fecha =  new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	        		numero = msgs[k].getOriginatingAddress();
	        		cuerpo = msgs[k].getMessageBody();
	        		estado = "Entrante";
	        		new InsertarMensaje().execute();
				}
			}
		}
		catch(Exception sfgh){
			Log.e(TAG, "Error in getSMSDetails : "+sfgh.toString());
		}
	}//fn getSMSDetails
	class InsertarMensaje extends AsyncTask<String, String, String> {
    	protected String doInBackground(String... args) {
	    
	        // Building Parameters
	          System.err.println("Hilo de insertar mensaje en base de datos");
	        // Building Parameters
	         Date date = new Date();
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("id_dispositivo", device_id));
	        params.add(new BasicNameValuePair("telefono", numero));
	        params.add(new BasicNameValuePair("fecha", fecha));
	        params.add(new BasicNameValuePair("cuerpo", cuerpo));
	        params.add(new BasicNameValuePair("estatus", estado));
	        // getting JSON Object
	        // Note that create product url accepts POST method
	        JSONObject json = jsonParser.makeHttpRequest(url_insertar_mensaje,
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
	
}//End of class SMSTrackerActivity
