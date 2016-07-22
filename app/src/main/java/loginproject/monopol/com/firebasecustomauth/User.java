package loginproject.monopol.com.firebasecustomauth;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

/**
 * Created by BcK on 20.07.2016.
 */
public class User {

    public String username;
    public String email;
    public String userId;
    public HomeActivity home;
    public GirisActivity giris;

    public DatabaseReference mDatabase;
    public FirebaseAuth mAuth;

    public User()
    {
        mDatabase =  FirebaseDatabase.getInstance().getReference();
    }

    public User(String userId, String username,String email)
    {
        this.userId = userId;
        this.username = username;
        this.email = email;
        mAuth = FirebaseAuth.getInstance();
    }

    public void writeNewUser(String userId, String username)
    {
        giris = new GirisActivity();
        HashMap<String, Object> result = new HashMap<>();
        result.put("username",username);
        Log.d("writenewuser: ",userId);
        Log.d("writenewuser2: ",result.toString());
        mDatabase.child("Users").child(userId).setValue(result);
        home = new HomeActivity();
    }

}
