package loginproject.monopol.com.firebasecustomauth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    ImageView iv;
    TextView ka1,mail,pw,pw2;
    Button button1,button2;
    String username,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_profile);
        ka1 = (TextView) findViewById(R.id.textView);
        mail = (TextView) findViewById(R.id.textView2);
        pw = (TextView) findViewById(R.id.textView3);
        pw2 = (TextView) findViewById(R.id.textView4);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
