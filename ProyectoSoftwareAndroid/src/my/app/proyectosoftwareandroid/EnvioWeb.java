package my.app.proyectosoftwareandroid;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class EnvioWeb {
	private String url = "http://192.168.90.1/ProyectoSoftwareAndroidAdmin/";
	List<NameValuePair> params;
	JSONParser jsonParser = new JSONParser();
	private static final String TAG_SUCCESS = "success";
	EnvioWeb (String url, List<NameValuePair> params){
		this.url = this.url + url;
		this.params = params;
	}
	public void envio(){
		 // getting JSON Object
        // Note that create product url accepts POST method
        JSONObject json = jsonParser.makeHttpRequest(url,
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
        
	}
	
}
