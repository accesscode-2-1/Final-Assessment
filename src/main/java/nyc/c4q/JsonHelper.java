package nyc.c4q;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by Hoshiko on 9/1/15.
 */
public class JsonHelper {

    // TODO: This class converts the raw JSON data into java objects (within an ArrayList) to be accessed by LibraryActivity.java

    public static ArrayList<Book> loadBookJsonRawUsingGson(Context context, int jsonResource) {

        InputStream raw = context.getResources().openRawResource(jsonResource);
        Reader rd = new BufferedReader(new InputStreamReader(raw));
        Gson gson = new Gson();
        // TODO: TypeToken forces JSON to convert into an ArrayList of Books instead of just ONE book
        ArrayList<Book> bookResponse = gson.fromJson(rd, new TypeToken<ArrayList<Book>>() {}.getType());
        return bookResponse;
    }

    public static ArrayList<Member> loadMemberJsonRawUsingGson(Context context, int jsonResource) {

        InputStream raw = context.getResources().openRawResource(jsonResource);
        Reader rd = new BufferedReader(new InputStreamReader(raw));
        Gson gson = new Gson();

        ArrayList<Member> memberResponse = gson.fromJson(rd, new TypeToken<ArrayList<Member>>() {}.getType());

        return memberResponse;
    }
}
