package loginproject.monopol.com.firebasecustomauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import loginproject.monopol.com.firebasecustomauth.arca.SessionManager;


public class GirisActivity extends AppCompatActivity {

    public Button checkButton;
    public EditText userName, password;
    public FirebaseAuth mAuth;
    private SessionManager session;
    public String id;
    public static final String TAG = "EmailPassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        checkButton = (Button) findViewById(R.id.signInButton);
        userName = (EditText) findViewById(R.id.userNameText);
        password = (EditText) findViewById(R.id.passwordText);
        session = new SessionManager(getApplicationContext());
        mAuth = FirebaseAuth.getInstance();

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(userName.getText().toString(),password.getText().toString());
            }
        });
    }

    public void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(GirisActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Log.d("uid",task.getResult().getUser().getUid());
                            User user = new User();
                            user.writeNewUser(task.getResult().getUser().getUid(), task.getResult().getUser().getEmail());
                            session.setLogin(true,task.getResult().getUser().getUid());
                            Intent intent = new Intent(GirisActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }
                    }
                });
    }
}
