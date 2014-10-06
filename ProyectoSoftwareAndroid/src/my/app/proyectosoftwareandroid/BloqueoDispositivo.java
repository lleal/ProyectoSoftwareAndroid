package my.app.proyectosoftwareandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.telephony.TelephonyManager;
import android.util.Log;

public class BloqueoDispositivo extends BroadcastReceiver{
	final public static String ONE_TIME = "onetime";
	private static String url_obtener_bloqueo = "http://192.168.90.1/AdministradorTracker/ProyectoSoftwareAndroidAdmin/get_product_details.php";
    
    private static final String TAG_SUCCESS = "success";

    String estado;
    public final static String TAG_BLOQUEO = "bloqueo";
  
    public final static String TAG_BANDERA = "bandera";
    
    static final String TAG = "DevicePolicyDemoActivity";
	DevicePolicyManager devicePolicyManager;
	ComponentName demoDeviceAdmin;
	private  TelephonyManager telephonyManager;
	private  String device_id;
	JSONParser jsonParser = new JSONParser();
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "Recibo señal de bloqueo");
		devicePolicyManager = (DevicePolicyManager) context.getSystemService(context.DEVICE_POLICY_SERVICE);
		demoDeviceAdmin = new ComponentName(context, DemoDeviceAdminReceiver.class);
		telephonyManager = (TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);
		device_id = telephonyManager.getDeviceId();
		boolean active = devicePolicyManager.isAdminActive(demoDeviceAdmin);
	       if (active) {
	    	 try{
               List<NameValuePair> params1 = new ArrayList<NameValuePair>();
               params1.add(new BasicNameValuePair("bandera", TAG_BANDERA));
               params1.add(new BasicNameValuePair("id_dispositivo", device_id));
               JSONObject json1 = jsonParser.makeHttpRequest(
                       url_obtener_bloqueo, "GET", params1);
               int success = json1.getInt(TAG_SUCCESS);
               if (success == 1) {
               	 if (json1.getInt(TAG_BANDERA) == 1)
               	    devicePolicyManager.lockNow();	
               }else{
            	   Log.i(TAG, "No esta bloqueando");
            	   
               }
               	}catch (JSONException e){
               		e.printStackTrace();
               		
               	}
	        } else Log.i(TAG, "No es un administrador");
	}

	public void SetAlarm(Context context)
    {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, BloqueoDispositivo.class);
        intent.putExtra(ONE_TIME, Boolean.FALSE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 4, intent, 0);
        //After after 1 seconds
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() , 1000 * 1 , pi); 
    }
	
	
	
}
