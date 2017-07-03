package jocelyn_test03.com.jsontask.Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jocelyn on 22/10/2016.
 */

public class HttpUtil {

    public static String getJsonConnect(String urlString){
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
           // connection.setRequestMethod("POST");
           // connection.setConnectTimeout(20000);
           // connection.setReadTimeout(20000);
           // connection.setDoInput(true);
            connection.connect();
            InputStream stream = connection.getInputStream();

           // int responseCode = connection.getResponseCode();
            //responseCode == 200 / connection.HTTP_OK
            //if(responseCode == 200){
                return ConvetStreamToJson(stream);
           // }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        return null;
    }

    public static String ConvetStreamToJson(InputStream inputStream){
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer response = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null){
                response.append(line);
            }

            return response.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
