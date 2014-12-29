package org.mossin.com.rottentomatoes.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lista;
    private WebView vistaWeb;
    private ProgressDialog VistadeProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Despliega una barra de progeso Indetermianada
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        this.setContentView(R.layout.activity_main);

        this.lista =(ListView)findViewById(R.id.listview);
        this.vistaWeb =(WebView)findViewById(R.id.vistaWeb);

        List items = new ArrayList();
        items.add( new Item(R.drawable.uno,"Big Hero 6","http://www.rottentomatoes.com/m/big_hero_6/"));
        items.add( new Item(R.drawable.dos,"Elsa and Fred","http://www.rottentomatoes.com/m/elsa_and_fred_2014/"));
        items.add( new Item(R.drawable.tres,"why dont you play in hell","http://www.rottentomatoes.com/m/why_dont_you_play_in_hell/"));
        items.add( new Item(R.drawable.cuatro,"Jessabelle","http://www.rottentomatoes.com/m/jessabelle/"));
        items.add( new Item(R.drawable.cinco,"The Thoery of Everything","http://www.rottentomatoes.com/m/the_theory_of_everything_2014/"));
        items.add( new Item(R.drawable.seis,"Open Window","http://www.rottentomatoes.com/m/open_windows_2013/"));
        items.add( new Item(R.drawable.siete,"Interstellar","http://www.rottentomatoes.com/m/interstellar_2014/?search=inter"));
        items.add( new Item(R.drawable.ocho,"21 Years","http://www.rottentomatoes.com/m/21_years_richard_linklater/?search=21%20year"));
        items.add( new Item(R.drawable.nueve,"The Way He Look","http://www.rottentomatoes.com/m/the_way_he_looks/?search=the%20way%20he%20l"));
        items.add( new Item(R.drawable.diez,"On Any Sunday","http://www.rottentomatoes.com/m/on_any_sunday_the_next_chapter/?search=on%20any"));
        items.add( new Item(R.drawable.once,"Mr. Pip","http://www.rottentomatoes.com/m/mr_pip/"));
        items.add( new Item(R.drawable.doce,"The Better Angel","http://www.rottentomatoes.com/m/the_better_angels/?search=the%20better"));
        items.add( new Item(R.drawable.catorce,"Nation Gallery","http://www.rottentomatoes.com/m/national_gallery/?search=Nation%20ga"));
        items.add( new Item(R.drawable.quince,"SEXED","http://www.rottentomatoes.com/m/sex_ed_2014/"));

        this.lista.setAdapter( new ItemAdaptador(this,items));
        lista.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setProgressBarIndeterminateVisibility(true);

                 VistadeProgreso = ProgressDialog.show(MainActivity.this,"Espere unos momentos","Cargando");
                vistaWeb.getSettings().setJavaScriptEnabled(true);
                vistaWeb.setWebViewClient( new miClienteWeb());

                Item item = (Item)lista.getAdapter().getItem(position);
                vistaWeb.loadUrl(item.getUrl());

            }
        });

    }
    private class miClienteWeb extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            setProgressBarIndeterminateVisibility(false);
            VistadeProgreso.dismiss();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
