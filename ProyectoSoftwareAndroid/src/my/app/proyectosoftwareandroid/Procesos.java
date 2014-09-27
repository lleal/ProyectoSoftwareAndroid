package my.app.proyectosoftwareandroid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.telephony.TelephonyManager;
import android.util.Log;



public class Procesos extends BroadcastReceiver {
	final public static String ONE_TIME = "onetime";
	private Context mContext;
	private  TelephonyManager telephonyManager;
	private  String device_id;
	private static final String TAG_SUCCESS = "success";
	JSONParser jsonParser = new JSONParser();
	private String nombres ="";
	private static String url_insertar_procesos = "http://10.0.0.10:8080/ProyectoSoftwareAndroidAdmin/insertar_procesos.php";
	@Override
	public void onReceive(Context context, Intent intent) {
		System.err.println("Recibi señal de GPS");
		mContext = context;
		telephonyManager = (TelephonyManager)mContext.getSystemService(Service.TELEPHONY_SERVICE);
		device_id = telephonyManager.getDeviceId();
		// TODO Auto-generated method stub
		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        
		/*String packageName = am.getRunningTasks(1).get(0).topActivity
		                .getPackageName();*/
		        
		List<ActivityManager.RunningAppProcessInfo> listaapps = am.getRunningAppProcesses();
        
		for(int i=0;i<listaapps.size();i++){
		        	nombres=nombres+listaapps.get(i).processName+"\n";	
		        }
		
		new InsertarMensaje().execute();
	}
	
	public void SetAlarm(Context context)
    {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, Procesos.class);
        intent.putExtra(ONE_TIME, Boolean.FALSE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 1, intent, 0);
        //After after 10 seconds
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() , 1000 * 10 , pi); 
    }


	class InsertarMensaje extends AsyncTask<String, String, String> {
    	protected String doInBackground(String... args) {
	    
	        // Building Parameters
	          System.err.println("Hilo de insertar procesos en base de datos");
	        // Building Parameters
	         Date date = new Date();
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("id_dispositivo", device_id));
	        params.add(new BasicNameValuePair("lista_procesos", nombres));
	     
	        // getting JSON Object
	        // Note that create product url accepts POST method
	        JSONObject json = jsonParser.makeHttpRequest(url_insertar_procesos,
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
