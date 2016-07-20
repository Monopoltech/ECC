package loginproject.monopol.com.firebasecustomauth;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    ImageButton profileBut, addBut, searchBut;

    ListView hashmapListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profileBut = (ImageButton)findViewById(R.id.profileButton);
        addBut = (ImageButton)findViewById(R.id.addButton);
        searchBut = (ImageButton)findViewById(R.id.searchButton);



    }
}
