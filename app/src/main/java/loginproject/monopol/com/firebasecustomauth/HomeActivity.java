package loginproject.monopol.com.firebasecustomauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import loginproject.monopol.com.firebasecustomauth.arca.SessionManager;


public class HomeActivity extends AppCompatActivity {
    private SessionManager session;
    ImageButton profileBut, addBut, searchBut;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    User user;

    DatabaseReference myRef = database.getReference("Users");
    private DatabaseReference mDatabase;

    ListView liste;
    private final String TAG = "VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profileBut = (ImageButton)findViewById(R.id.profileButton);
        addBut = (ImageButton)findViewById(R.id.addButton);
        searchBut = (ImageButton)findViewById(R.id.searchButton);
        liste = (ListView)findViewById(R.id.hashList);

        profileBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,Profile.class);
                startActivity(intent);
            }
        });

        addBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });

        searchBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this,Search.class);
                startActivity(intent);

            }
        });



        //user = new User();
        mDatabase =  FirebaseDatabase.getInstance().getReference();
        session = new SessionManager(getApplicationContext());
        if (session.isUid() ==null){
            Log.d("Arc:","Uid yok");
        }else{
            Log.d("Arc:",session.isUid());
        }

        //Log.d("veri :",mDatabase.child("Users").child(user.userId).limitToFirst(100).toString());
        //String deger = String.format("%s",user.mDatabase.child("Users").child(user.userId).limitToFirst(100));
        //getItems(deger);
    }



}
