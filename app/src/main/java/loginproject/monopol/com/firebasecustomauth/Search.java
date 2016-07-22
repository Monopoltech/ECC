package loginproject.monopol.com.firebasecustomauth;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Search extends ListActivity {


    private DatabaseReference mDatabase;
    public ArrayList<String> tagsArray = new ArrayList<String>();

    public void getTags(){

        mDatabase.child("Hashtag").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("veri : ",dataSnapshot.getChildren()+"");
               /* Map<String, Object> newPost = (Map<String, Object>)dataSnapshot.getValue();
                Log.d("Author: ", newPost.get("title").toString());
                tagsArray.add(newPost.get("title").toString());*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("Veri Hata search : ",databaseError.getMessage());
            }
        });
    }
    ListView list;

    private GoogleApiClient client;
 @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mDatabase =  FirebaseDatabase.getInstance().getReference();
        getTags();

    }
    public void onListItemClick(ListView parent, View v, int position, long id){
        CheckedTextView item=(CheckedTextView) v;
        Toast.makeText(this,tagsArray.get(position)+" checked : "+item.isChecked(),Toast.LENGTH_SHORT).show();

    }
}



