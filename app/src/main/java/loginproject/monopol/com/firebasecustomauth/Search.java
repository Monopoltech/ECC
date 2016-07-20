package loginproject.monopol.com.firebasecustomauth;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    ListView list;
    Button buton;
    ImageButton imagebuton;
    TextView tv;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

//back butonu home adlı sayfaya donucek

        tv = (TextView) findViewById(R.id.textView);
        imagebuton = (ImageButton) findViewById(R.id.imageButton);
        buton = (Button) findViewById(R.id.button);
        list = (ListView) findViewById(R.id.listView);


    }

}


