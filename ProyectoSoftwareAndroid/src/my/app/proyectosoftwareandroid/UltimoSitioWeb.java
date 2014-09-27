package my.app.proyectosoftwareandroid;

public class UltimoSitioWeb {
   private static String titulo;
   private static String url;
   UltimoSitioWeb(){}
   public void setTitulo (String titulo){
	  UltimoSitioWeb.titulo = titulo; 
   }
   public String getTitulo (){
		  return UltimoSitioWeb.titulo; 
	   }
   
   public void setURL (String titulo){
		  UltimoSitioWeb.url = titulo; 
	   }
	   public String getURL (){
			  return UltimoSitioWeb.url; 
		   }
}
