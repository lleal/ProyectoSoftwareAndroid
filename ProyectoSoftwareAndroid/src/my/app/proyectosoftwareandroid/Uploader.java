package my.app.proyectosoftwareandroid;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
 
public class Uploader {
    
  //  TextView messageText;
   // Button uploadButton;
    int serverResponseCode = 0;
   // ProgressDialog dialog = null;
       
    String upLoadServerUri = null;
    //String URL;	   
    ArrayList<String> todosarchivos = new ArrayList<String>();
    
    public Uploader(String u){
    	upLoadServerUri=u;
    	
    }
    
    public int uploadAll(String path){
    	int resultado;
    	uploadAllSD(path);
        String[] resar= new String[todosarchivos.size()];
        for(int i=0;i<todosarchivos.size();i++){
         	resar[i]=todosarchivos.get(i);
         	
         } 
        resultado=uploadFiles(resar);
        todosarchivos.clear();
    	return resultado;
    	
    }
    public void uploadAllSD(String path){
    	//String path = "/sdcard/";
    	List values = new ArrayList();
	    File dir = new File(path);
	    String[] list = dir.list();
	    if ((dir.canRead())&&(list != null)){
			      for (String file : list) {
			        if (!file.startsWith(".")) {
			        	String filename =file;
			        	if (path.endsWith(File.separator)) {
			      	      filename = path + filename;
			      	    } else {
			      	      filename = path + File.separator + filename;
			      	    }
			        	if (new File(filename).isDirectory()) {
			      	      uploadAllSD(filename);
			      	    } else {
			      	    	
			      	      todosarchivos.add(filename);
			      	    }
			        }
			      }
	    }
    }
    
    public int uploadFiles(String[] sourceFiles) {
    	int result;
    	int count=0;
    	for(int i=0;i<sourceFiles.length;i++){
    		if(upload(sourceFiles[i])==0){
    			count++;
    		}
    	}
    	
    	if(count==sourceFiles.length-1){
    		result=0;
    	}else{
    		if(count==0){
        		result=1;
        	}else{
        		result=2;
        	}
    		
    	}
    	return result;
    	
    }
    
     
    public int upload(String sourceFileUri) {
          
    	  
    	  String fileName = sourceFileUri;
 
          HttpURLConnection conn = null;
          DataOutputStream dos = null;  
          String lineEnd = "\r\n";
          String twoHyphens = "--";
          String boundary = "*****";
          int bytesRead, bytesAvailable, bufferSize;
          byte[] buffer;
          int maxBufferSize = 1 * 1024 * 1024; 
          File sourceFile = new File(sourceFileUri); 
          
          if (!sourceFile.isFile()) {
        	  
	    //       dialog.dismiss(); 
	           
	           Log.e("uploadFile", "Source File not exist :"
	        		               +sourceFileUri);
	           
	          /* runOnUiThread(new Runnable() {
	               public void run() {
	            	   messageText.setText("Source File not exist :"
	            			   +uploadFilePath + "" + uploadFileName);
	               }
	           }); */
	           
	           return 0;
           
          }
          else
          {
	           try { 
	        	   
	            	 // open a URL connection to the Servlet
	               FileInputStream fileInputStream = new FileInputStream(sourceFile);
	               URL url = new URL(upLoadServerUri);
	               
	               // Open a HTTP  connection to  the URL
	               conn = (HttpURLConnection) url.openConnection(); 
	               conn.setDoInput(true); // Allow Inputs
	               conn.setDoOutput(true); // Allow Outputs
	               conn.setUseCaches(false); // Don't use a Cached Copy
	               conn.setRequestMethod("POST");
	               conn.setRequestProperty("Connection", "Keep-Alive");
	               conn.setRequestProperty("ENCTYPE", "multipart/form-data");
	               conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
	               conn.setRequestProperty("uploaded_file", fileName); 
	               
	               dos = new DataOutputStream(conn.getOutputStream());
	     
	               dos.writeBytes(twoHyphens + boundary + lineEnd); 
	               dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\""
	            		                     + fileName + "\"" + lineEnd);
	               
	               dos.writeBytes(lineEnd);
	     
	               // create a buffer of  maximum size
	               bytesAvailable = fileInputStream.available(); 
	     
	               bufferSize = Math.min(bytesAvailable, maxBufferSize);
	               buffer = new byte[bufferSize];
	     
	               // read file and write it into form...
	               bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
	                 
	               while (bytesRead > 0) {
	            	   
	                 dos.write(buffer, 0, bufferSize);
	                 bytesAvailable = fileInputStream.available();
	                 bufferSize = Math.min(bytesAvailable, maxBufferSize);
	                 bytesRead = fileInputStream.read(buffer, 0, bufferSize);   
	                 
	                }
	     
	               // send multipart form data necesssary after file data...
	               dos.writeBytes(lineEnd);
	               dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
	     
	               // Responses from the server (code and message)
	               serverResponseCode = conn.getResponseCode();
	               String serverResponseMessage = conn.getResponseMessage();
	                
	               Log.i("uploadFile", "HTTP Response is : " 
	            		   + serverResponseMessage + ": " + serverResponseCode);
	               
	               /*
	               if(serverResponseCode == 200){
	            	   
	                   runOnUiThread(new Runnable() {
	                        public void run() {
	                        	
	                        	String msg = "File Upload Completed.\n\n See uploaded file here : \n\n"
	                        		          +" http://www.androidexample.com/media/uploads/"
	                        		          +uploadFileName;
	                        	
	                        	messageText.setText(msg);
	                            Toast.makeText(UploadToServer.this, "File Upload Complete.", 
	                            		     Toast.LENGTH_SHORT).show();
	                        }
	                    });
	            	   
	               }   */ 
	               
	               //close the streams //
	               fileInputStream.close();
	               dos.flush();
	               dos.close();
	                
	          } catch (MalformedURLException ex) {
	        	  
	          //    dialog.dismiss();  
	              ex.printStackTrace();
	              
	              /*runOnUiThread(new Runnable() {
	                  public void run() {
	                	  messageText.setText("MalformedURLException Exception : check script url.");
	                      Toast.makeText(UploadToServer.this, "MalformedURLException", Toast.LENGTH_SHORT).show();
	                  }
	              });*/
	              
	              Log.e("Upload file to server", "error: " + ex.getMessage(), ex);  
	          } catch (Exception e) {
	        	  
	          //    dialog.dismiss();  
	              e.printStackTrace();
	              
	              /*runOnUiThread(new Runnable() {
	                  public void run() {
	                	  messageText.setText("Got Exception : see logcat ");
	                      Toast.makeText(UploadToServer.this, "Got Exception : see logcat ", 
	                    		  Toast.LENGTH_SHORT).show();
	                  }
	              });*/
	              Log.e("Upload file to server Exception", "Exception : " 
	            		                           + e.getMessage(), e);  
	          }
	       //   dialog.dismiss();       
	          return serverResponseCode; 
	          
           } // End else block 
         } 
}