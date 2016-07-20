package loginproject.monopol.com.firebasecustomauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    TextView tv;

    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);



        tv=(TextView) findViewById(R.id.newHashtag);
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddActivity.this,GirisActivity.class);
                startActivity(intent);
            }

        });


    }
}
