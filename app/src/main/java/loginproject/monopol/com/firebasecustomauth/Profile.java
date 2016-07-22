package loginproject.monopol.com.firebasecustomauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import loginproject.monopol.com.firebasecustomauth.arca.SessionManager;
import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {

    private SessionManager session;
    ImageView iv;
    TextView ka1,mail,pw,pw2;
    Button SaveBtn,LogOutBtn;
    String username,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            Intent intent = new Intent(Profile.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        iv =  (ImageView) findViewById(R.id.imageView);
        ka1 = (TextView) findViewById(R.id.textView);
        mail = (TextView) findViewById(R.id.textView2);
        pw = (TextView) findViewById(R.id.textView3);
        pw2 = (TextView) findViewById(R.id.textView4);
        SaveBtn = (Button) findViewById(R.id.button);
        LogOutBtn = (Button) findViewById(R.id.button2);

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items();
            }
        });


        LogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.setLogin(false,null);
                FirebaseAuth.getInstance().signOut();
                Intent intent =new Intent(Profile.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void items()
    {
        username = ka1.getText().toString();
        password = pw.getText().toString();
        email    = mail.getText().toString();
    }


}
