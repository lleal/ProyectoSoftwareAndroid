package my.app.proyectosoftwareandroid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import my.app.proyectosoftwareandroid.Procesos.InsertarMensaje;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Browser;
import android.telephony.TelephonyManager;
import android.util.Log;


public class SitiosWeb extends BroadcastReceiver {
	final public static String ONE_TIME = "onetime";
	public String tituloAux;
    public String urlAux;
    private  TelephonyManager telephonyManager;
	private  String device_id;
	private static final String TAG_SUCCESS = "success";
	JSONParser jsonParser = new JSONParser();
	private static String url_insertar_sitiosweb = "http://10.0.0.10:8080/ProyectoSoftwareAndroidAdmin/insertar_sitiosweb.php";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		 Intent i = new Intent();
	        i.setClassName("my.app.proyectosoftwareandroid", "my.app.proyectosoftwareandroid.SitiosWebActividad");
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        context.startActivity(i);
	}
	public void SetAlarm(Context context)
    {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, SitiosWeb.class);
        intent.putExtra(ONE_TIME, Boolean.FALSE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        //After after 10 seconds
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() , 1000 * 1 , pi); 
    }
	
	
	
}
