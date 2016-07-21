package loginproject.monopol.com.firebasecustomauth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Random;

import loginproject.monopol.com.firebasecustomauth.arca.SessionManager;
public class AddActivity extends AppCompatActivity {
    private Random random;
    private SessionManager session;
    private DatabaseReference mDatabase;

    EditText hashTag;
    String getHashTag;
    Button addButton,backButton;
    GirisActivity giris;

    FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        hashTag = (EditText)findViewById(R.id.newHashtag);
        addButton=(Button) findViewById(R.id.button);
        backButton=(Button) findViewById(R.id.button4);

        session = new SessionManager(getApplicationContext());
        if (session.isUid() != null){
            Log.d("Session: ", session.isUid());
        }else{
            Log.d("Session :", "yok");
        }
        mDatabase =  FirebaseDatabase.getInstance().getReference();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> result = new HashMap<>();
                random = new Random();
                int idNumber = random.nextInt(123456);
                result.put("title", hashTag.getText().toString());
                mDatabase.child("Users").child(session.isUid()).child("Hashtag").child(session.isUid()+idNumber).setValue(result);
                mDatabase.child("Hashtag").child(session.isUid()+idNumber).setValue(result);
                getHashTag = hashTag.getText().toString();
                Intent intent = new Intent(AddActivity.this, HomeActivity.class);
                startActivity(intent);
            }

        });

    }
}
