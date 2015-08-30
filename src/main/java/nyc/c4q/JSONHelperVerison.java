package nyc.c4q;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by c4q-marbella on 8/30/15.
 */
public class JSONHelperVerison {

    public static List<MemberInfo> loadStaticMemberJsonRawUsingGson(Context context, int jsonResource) {

        InputStream raw = context.getResources().openRawResource(jsonResource);
        Reader rd = new BufferedReader(new InputStreamReader(raw));
        Gson gson = new Gson();

        String jsonOutput = "Your JSON String";
        Type listType = new TypeToken<List<MemberInfo>>(){}.getType();
        List<MemberInfo> memberInfos = (List<MemberInfo>) gson.fromJson(jsonOutput, listType);
        return memberInfos;
    }

    public static String convertToJsonUsingGson(MemberInfo memberInfo) {
        Gson gson = new Gson();
        String json =  gson.toJson(memberInfo);
        return json;
    }


    public static BookInfo loadStaticBookJsonRawUsingGson(Context context, int jsonResource) {

        InputStream raw = context.getResources().openRawResource(jsonResource);
        Reader rd = new BufferedReader(new InputStreamReader(raw));
        Gson gson = new Gson();
        BookInfo bookInfo = gson.fromJson(rd, BookInfo.class);
        return bookInfo;
    }

    public static String convertToJsonUsingGson(BookInfo bookInfo) {
        Gson gson = new Gson();
        String json =  gson.toJson(bookInfo);
        return json;
    }
}
