package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Benedict on 24.10.2017.
 */

public class Data {
    private static List<Entry> entries = null;

    public static void addEntry(Entry entry)
    {
        if(entries == null) {
            entries = new LinkedList<Entry>();
        }
        entries.add(entry);
    }

    public static int getEntryNumbers()
    {
        if(entries == null)
            return 0;
        else
            return entries.size();
    }

    public static JsonObject getEntryListJson()
    {
        JsonObject jsonList = new JsonObject();
        if(entries != null)
        {
            for(Entry e: entries)
            {
                JsonObject eObj = new JsonObject();
                eObj.addProperty("title", e.getTitle());
                eObj.addProperty("value", e.getValue());
                eObj.addProperty("time", e.getTimestamp());
                jsonList.add(String.valueOf(e.getId()), eObj);
            }
        }
        return jsonList;
    }
    /*
    public static initList(String jsonList)
    {

    }
    */
}
