package loginproject.monopol.com.firebasecustomauth;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by BcK on 20.07.2016.
 */
public class Post {

    public String uid;
    public String author;
    public String title;
    public String body;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    private DatabaseReference mDatabase;

    public Post()
    {

    }
    public Post(String uid, String author, String title, String body)
    {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public Map<String, Object> toMap()
    {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("body", body);
        result.put("startCount", starCount);
        result.put("stars", stars);
        return result;
    }

    public void writeNewPost(String userId, String userName, String title, String body)
    {
        String key = mDatabase.child("posts").push().getKey();
        Post post = new Post(userId, userName, title, body);
        Map<String, Object> postValues = post.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key,postValues);
        childUpdates.put("/user-posts/" + userId + "/" + key, postValues);
        mDatabase.updateChildren(childUpdates);
    }







}
