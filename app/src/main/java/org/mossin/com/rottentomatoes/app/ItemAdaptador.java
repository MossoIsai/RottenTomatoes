package org.mossin.com.rottentomatoes.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mossin on 8/11/14.
 */
public class ItemAdaptador extends BaseAdapter {
   private Context context;
   private List<Item> items;

    public  ItemAdaptador(Context contex,List item)
    {
        this.context = contex;
        this.items = item;

    }

    @Override
    public int getCount() {
        /*Devuelve el numero de elementos de la Lista*/
        return  this.items.size();
    }

    @Override
    public Object getItem(int position) {
        /*Devuelve el elemento de una determinada posicon de la lista*/
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Devuelve el identificador de la fila de una determiana posicion de la lista
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Crea un nuero objeto View
        View filavista = convertView;
        if (convertView == null) {
            //Crea una nueva vista dentro de la lista.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            filavista = inflater.inflate(R.layout.items, parent, false);
        }
        //Establece los datos dentro de la Vista

        ImageView vistaImagen = (ImageView) filavista.findViewById(R.id.image);
        TextView titulo = (TextView) filavista.findViewById(R.id.titulo);

        Item item = this.items.get(position);
        titulo.setText(item.getTitulo());
        vistaImagen.setImageResource(item.getImagen());
        return filavista;
    }

}
