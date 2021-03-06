package loginproject.monopol.com.firebasecustomauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import loginproject.monopol.com.firebasecustomauth.arca.SessionManager;

public class AddActivity extends AppCompatActivity {
    private SessionManager session;
    private DatabaseReference mDatabase;

    EditText hashTag;
    String getHashTag;
    Button addButton,backButton;

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
                String key = mDatabase.child("Hashtag").push().getKey();

                HashMap<String, Object> result__ = new HashMap<>();
                result__.put(session.isUid(),true);

                HashMap<String, Object> result = new HashMap<>();
                result.put("title", hashTag.getText().toString());
                result.put("uid",result__);

                HashMap<String, Object> result_ = new HashMap<>();
                result_.put("title", hashTag.getText().toString());
                //result_.put(key, true);

                mDatabase.child("Users").child(session.isUid()).child("Hashtag").child(key).setValue(result_);
                mDatabase.child("Hashtag").child(key).setValue(result);
                getHashTag = hashTag.getText().toString();
                Intent intent = new Intent(AddActivity.this, HomeActivity.class);
                startActivity(intent);
            }

        });

    }
}
