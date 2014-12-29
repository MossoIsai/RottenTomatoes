package org.mossin.com.rottentomatoes.app;
/**
 * Created by mossin on 8/11/14.
 */
public class Item {
   private int imagen;
   private String titulo;
   private String url;

    //Contructor que recibe los 3 parametros/7
    public Item(int imagen,String titulo,String url){
      super();
       this.imagen = imagen;
        this.titulo = titulo;
        this.url = url;

    }
    //Setters and Getters

    public void setImagen(int imagen){
        this.imagen = imagen;
    }
    public int getImagen(){
        return imagen;
    }
    public void etTitulo(String titulo){
       this.titulo = titulo;

    }
    public String getTitulo(){
        return titulo;
    }
   public void setUrl(String url){
       this.url = url;

   }
   public String getUrl(){
       return url;
   }

}
