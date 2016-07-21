package loginproject.monopol.com.firebasecustomauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import loginproject.monopol.com.firebasecustomauth.arca.SessionManager;

public class HomeActivity extends AppCompatActivity {
    private SessionManager session;

    ImageButton profileBut, addBut, searchBut;

    public String getItems;

    AddActivity addActivity = new AddActivity();

    public ArrayList<String> arrayList = new ArrayList<String>();

    FirebaseDatabase database = FirebaseDatabase.getInstance();

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
            finish();
        }else{
            Log.d("Arc:",session.isUid());
        }


        mDatabase.child("Users").child(session.isUid()).child("Hashtag").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("Veriler:",dataSnapshot.getValue()+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("Errorlog",databaseError.getMessage());

            }
        });

        mDatabase.child("Users").child(session.isUid()).child("Hashtag").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map<String, Object> newPost = (Map<String, Object>)dataSnapshot.getValue();
                Log.d("Author: ", newPost.get("title").toString());
                arrayList.add(newPost.get("title").toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //Log.d("veri :",mDatabase.child("Users").child(user.userId).limitToFirst(100).toString());
        //String deger = String.format("%s",user.mDatabase.child("Users").child(user.userId).limitToFirst(100));
        //getItems(deger);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,arrayList);
        liste.setAdapter(arrayAdapter);
    }



}
