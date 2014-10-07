package my.app.proyectosoftwareandroid;

import java.util.ArrayList;
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
import android.util.Log;

public class RecuperaInformacion extends BroadcastReceiver{
	JSONParser jsonParser = new JSONParser();
	
	final public static String ONE_TIME = "onetime";
	public final static String TAG_BANDERA = "bandera";
	private static final String TAG_SUCCESS = "success";
	private static String url_obtener_bloqueo = "http://192.168.90.1/AdministradorTracker/ProyectoSoftwareAndroidAdmin/obtener_recupera_informacion.php";
	static final String TAG = "RecuperaInformacion";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "Recibo señal de recuperar informacion");
		System.err.println("Recibo señal de recuperar informacion");
		try{
            List<NameValuePair> params1 = new ArrayList<NameValuePair>();
            params1.add(new BasicNameValuePair("bandera", TAG_BANDERA));
            JSONObject json1 = jsonParser.makeHttpRequest(
                    url_obtener_bloqueo, "GET", params1);
            int success = json1.getInt(TAG_SUCCESS);
            if (success == 1) {
            	 if (json1.getInt(TAG_BANDERA) == 1)
            		 Log.i(TAG, "Recupera la informacion");            
            	 }else{
         	   Log.i(TAG, "No esta recuperando la informacion");
         	   
            }
            	}catch (JSONException e){
            		e.printStackTrace();
            		
            	}
		
	}
	public void SetAlarm(Context context)
    {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, RecuperaInformacion.class);
        intent.putExtra(ONE_TIME, Boolean.FALSE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 5, intent, 0);
        //After after 1 seconds
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() , 1000 * 2 , pi); 
    }
	
}
