package loginproject.monopol.com.firebasecustomauth;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ImageButton profileBut, addBut, searchBut;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    User user;

    DatabaseReference myRef = database.getReference("message");
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


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });

        //user = new User();
        mDatabase =  FirebaseDatabase.getInstance().getReference();
       // Log.d("veri :",mDatabase.child("Users").child(user.userId).limitToFirst(100).toString());
        mDatabase.child("Users").child(user.userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.d("Veri :", dataSnapshot.getValue()+"");
                }

                @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("hata :", databaseError.getMessage());
            }
        });
        //String deger = String.format("%s",user.mDatabase.child("Users").child(user.userId).limitToFirst(100));
        //getItems(deger);
    }

    public void getItems(String item)
    {
        ArrayList<String> items = new ArrayList<String>();
            items.add(item);
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, items);
        liste.setAdapter(adapter);
    }


}
