package jocelyn_test03.com.jsontask.JsonTools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import jocelyn_test03.com.jsontask.JavaBean.Person;


/**
 * Created by Jocelyn on 23/10/2016.
 */

public class JsonTools {

    public static ArrayList<Person> parseJson(String jsonString){

        ArrayList<Person> psList = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(jsonString);
           JSONArray jbA = jo.getJSONArray("person");
           for(int i = 0; i < jbA.length();i++){
               JSONObject valueObj = jbA.getJSONObject(i);
               Person person = new Person();
               person.setId(valueObj.getInt("id"));
               person.setName(valueObj.getString("name"));
               person.setAge(valueObj.getInt("age"));
               person.setAddress(valueObj.getString("address"));

               psList.add(person);
               return psList;
           }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
