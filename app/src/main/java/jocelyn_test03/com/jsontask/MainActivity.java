package jocelyn_test03.com.jsontask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jocelyn_test03.com.jsontask.Http.HttpUtil;
import jocelyn_test03.com.jsontask.JavaBean.Person;
import jocelyn_test03.com.jsontask.JsonTools.JsonTools;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProgressDialog dialog;
    private final String conUrl = "http://192.168.1.5:8081/jsonaction/JsonServlet";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Notily");
        dialog.setMessage("Loading...");
        listView = (ListView)findViewById(R.id.lv);
        new myTask().execute(conUrl);

    }

    public class myTask extends AsyncTask<String,Void,List<Person>>{
        ArrayList<Person> psnList = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           dialog.show();
        }

        @Override
        protected ArrayList<Person> doInBackground(String... params) {

            String jsonString = HttpUtil.getJsonConnect(params[0]);
            psnList.clear();
            psnList = JsonTools.parseJson(jsonString);

            return psnList;
        }

        @Override
        protected void onPostExecute(List<Person> result) {
            super.onPostExecute(result);
            PersonAdapter adapter = new PersonAdapter(MainActivity.this,R.layout.row,result);
            listView.setAdapter(adapter);
            dialog.dismiss();
        }
    }

    public class PersonAdapter extends ArrayAdapter{


        private List<Person> psnlist ;
        private int resource;
        private LayoutInflater inflater;



        public PersonAdapter(Context context, int resource, List<Person> objects) {
            super(context, resource, objects);
            psnlist = objects;
            this.resource = resource;
            inflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           if(convertView == null){
                convertView = inflater.inflate(resource,null);
           }
            ImageView imgView;
            TextView txvId;
            TextView txvName;
            TextView txvAge;
            TextView txvAddress;

            imgView = (ImageView)convertView.findViewById(R.id.imageView);
            txvId = (TextView)convertView.findViewById(R.id.textView);
            txvName = (TextView)convertView.findViewById(R.id.textView2);
            txvAge  = (TextView)convertView.findViewById(R.id.textView3);
            txvAddress  = (TextView)convertView.findViewById(R.id.textView4);

            txvId.setText(psnlist.get(position).getId());
           // imgView.setImageIcon(psnlist.get(position).getImageIcon());
            txvName.setText(psnlist.get(position).getName());
            txvAge.setText(psnlist.get(position).getAge());
            txvAddress.setText(psnlist.get(position).getAddress());
            return convertView;
        }
    }
}
