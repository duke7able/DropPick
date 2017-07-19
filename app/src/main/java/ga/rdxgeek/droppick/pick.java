package ga.rdxgeek.droppick;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class pick extends AppCompatActivity {
    private static final String TAG = "pick";
    String url = "http://develop.asambhav.in/consume.php";
    String url1 = "http://develop.asambhav.in/delete.php";
    String name="";
    String quantity="";
    String category="";
    String location="";
    String description="";
    long idd =-1;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
     final int RESULT_CODE = 200;
    ListView listView;
    ArrayList<String> strings;

    ProgressDialog progressDialog;
    Document document;

//    @Override
//    protected void onStart() {
//        super.onStart();
//        setContentView(R.layout.activity_pick);
//        t1=(TextView)findViewById(R.id.TV_D1);
//        t2=(TextView)findViewById(R.id.TV_D2);
//        t3=(TextView)findViewById(R.id.TV_D3);
//        t4=(TextView)findViewById(R.id.TV_D4);
//        t5=(TextView)findViewById(R.id.TV_D5);
//
//        listView = (ListView) findViewById(R.id.listView);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Intent intent=new Intent(pick.this,DetailActivity.class);
////                intent.putExtra("NAME",document.getElementsByTagName("name").item(position).getTextContent());
////                intent.putExtra("CATEGORY",document.getElementsByTagName("category").item(position).getTextContent());
////                intent.putExtra("ID",document.getElementsByTagName("id").item(position).getTextContent());
////                intent.putExtra("DESCRIPTION",document.getElementsByTagName("description").item(position).getTextContent());
////                intent.putExtra("LOCATION",document.getElementsByTagName("location").item(position).getTextContent());
////                intent.putExtra("QUANTITY",document.getElementsByTagName("quantity").item(position).getTextContent());
//                //intent.putExtra("DATE",document.getElementsByTagName("date").item(position).getTextContent());
////                startActivity(intent);
//                name = document.getElementsByTagName("name").item(position).getTextContent();
//                category = document.getElementsByTagName("category").item(position).getTextContent();
//                description = document.getElementsByTagName("description").item(position).getTextContent();
//                location = document.getElementsByTagName("location").item(position).getTextContent();
//                quantity = document.getElementsByTagName("quantity").item(position).getTextContent();
//                idd = Integer.parseInt(document.getElementsByTagName("id").item(position).getTextContent());
//
//                setContentView(R.layout.detail);
////                t1 = (TextView) findViewById(R.id.TV_D1);
////                t2 = (TextView) findViewById(R.id.TV_D2);
////                t3 = (TextView) findViewById(R.id.TV_D3);
////                t4 = (TextView) findViewById(R.id.TV_D4);
////                t5 = (TextView) findViewById(R.id.TV_D5);
//
//
//                Button BT_checkout = (Button) findViewById(R.id.BT_Checkout);
//                BT_checkout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        url1 = "http://develop.asambhav.in/delete.php" + "?checkout=1&" + "id=" + idd;
//                        RequestQueue requestQueue1 = Volley.newRequestQueue(pick.this);
//                        StringRequest req = new StringRequest(url1,
//                                new Response.Listener<String>() {
//                                    @Override
//                                    public void onResponse(String response) {
//                                        Log.d(TAG, "onResponse: " + response);
//                                        onStart();
//                                    }
//                                },
//                                new Response.ErrorListener() {
//                                    @Override
//                                    public void onErrorResponse(VolleyError error) {
//                                        Log.d(TAG, "onErrorResponse: ");
//                                        onStart();
//                                    }
//                                });
//
//                        requestQueue1.add(req);
////                        finish();\
//                        onStart();
//                    }
//                });
//
//                Button BT_cancel = (Button) findViewById(R.id.BT_Cancel);
//                BT_cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        finish();
//                            onStart();
//                    }
//                });
//            }
//        });
//
//        strings=new ArrayList<String>();
//        progressDialog=new ProgressDialog(this);
//        progressDialog.setTitle("Fetching");
//        progressDialog.show();
//
//        RequestQueue requestQueue = Volley.newRequestQueue(pick.this);
//        StringRequest req = new StringRequest(url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.d(TAG, "onResponse: "+response);
//                        progressDialog.dismiss();
//
//                        try {
//                            Log.d(TAG, "onResponse: reached here");
//                            document = ConvertToXML(response);
//
//                            int count = document.getElementsByTagName("item").getLength();
//                            //number of rows
//                            document.getElementsByTagName("name").item(0).getTextContent();
//
//                            for(int i=0;i<count;i++)
//                            {
//                                strings.add(document.getElementsByTagName("name").item(i).getTextContent());
//                            }
//                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(pick.this,
//                                    android.R.layout.simple_list_item_1, android.R.id.text1, strings);
//                            listView.setAdapter(adapter);
//
//                        } catch (ParserConfigurationException e) {
//                            e.printStackTrace();
//                        } catch (SAXException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        progressDialog.dismiss();
//                        Toast.makeText(pick.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, "onErrorResponse: "+error.getMessage());
//                    }
//                });
//
//        requestQueue.add(req);
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);

//        t1=(TextView)findViewById(R.id.TV_D1);
//        t2=(TextView)findViewById(R.id.TV_D2);
//        t3=(TextView)findViewById(R.id.TV_D3);
//        t4=(TextView)findViewById(R.id.TV_D4);
//        t5=(TextView)findViewById(R.id.TV_D5);
//
        listView = (ListView) findViewById(R.id.listView);
//        onStart();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(pick.this,DetailActivity.class);
                intent.putExtra("NAME",document.getElementsByTagName("name").item(position).getTextContent());
                intent.putExtra("CATEGORY",document.getElementsByTagName("category").item(position).getTextContent());
                intent.putExtra("ID",document.getElementsByTagName("id").item(position).getTextContent());
                intent.putExtra("DESCRIPTION",document.getElementsByTagName("description").item(position).getTextContent());
                intent.putExtra("LOCATION",document.getElementsByTagName("location").item(position).getTextContent());
                intent.putExtra("QUANTITY",document.getElementsByTagName("quantity").item(position).getTextContent());
                //intent.putExtra("DATE",document.getElementsByTagName("date").item(position).getTextContent());
//                startActivity(intent);

                startActivityForResult(intent, RESULT_CODE);
//                name = document.getElementsByTagName("name").item(position).getTextContent();
//                category = document.getElementsByTagName("category").item(position).getTextContent();
//                description = document.getElementsByTagName("description").item(position).getTextContent();
//                location = document.getElementsByTagName("location").item(position).getTextContent();
//                quantity = document.getElementsByTagName("quantity").item(position).getTextContent();
//                idd = Integer.parseInt(document.getElementsByTagName("id").item(position).getTextContent());
//
//
//                setContentView(R.layout.detail);
//                t1 = (TextView) findViewById(R.id.TV_D1);
//                t2 = (TextView) findViewById(R.id.TV_D2);
//                t3 = (TextView) findViewById(R.id.TV_D3);
//                t4 = (TextView) findViewById(R.id.TV_D4);
//                t5 = (TextView) findViewById(R.id.TV_D5);

//                t1.setText(name);
//                t2.setText(description);
//                t3.setText(category);
//                t4.setText(location);
//                t5.setText(quantity);

//                Button BT_checkout = (Button) findViewById(R.id.BT_Checkout);
//                BT_checkout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        url1 = "http://develop.asambhav.in/delete.php" + "?checkout=1&" + "id=" + idd;
//                        RequestQueue requestQueue1 = Volley.newRequestQueue(pick.this);
//                        StringRequest req = new StringRequest(url1,
//                                new Response.Listener<String>() {
//                                    @Override
//                                    public void onResponse(String response) {
//                                        Log.d(TAG, "onResponse: " + response);
////                                        onStart();
//                                        setContentView(R.layout.detail);
//                                        mainLayout();
//                                    }
//                                },
//                                new Response.ErrorListener() {
//                                    @Override
//                                    public void onErrorResponse(VolleyError error) {
//                                        Log.d(TAG, "onErrorResponse: ");
////                                        onStart();
//                                        setContentView(R.layout.detail);
//                                        mainLayout();
//                                    }
//                                });
//
//                        requestQueue1.add(req);
////                        finish();
////                        onStart();
//                    }
//                });
//
//                Button BT_cancel = (Button) findViewById(R.id.BT_Cancel);
//                BT_cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        finish();
//                        setContentView(R.layout.detail);
//                        mainLayout();
//                    }
//                });
            }
        });

        mainLayout();
//        strings=new ArrayList<String>();
//        progressDialog=new ProgressDialog(this);
//        progressDialog.setTitle("Fetching");
//        progressDialog.show();
//
//        RequestQueue requestQueue = Volley.newRequestQueue(pick.this);
//        StringRequest req = new StringRequest(url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.d(TAG, "onResponse: "+response);
//                        progressDialog.dismiss();
//
//                        try {
//                            document = ConvertToXML(response);
//
//                            int count = document.getElementsByTagName("item").getLength();
//                            //number of rows
//                            document.getElementsByTagName("name").item(0).getTextContent();
//
//                            for(int i=0;i<count;i++)
//                            {
//                                strings.add(document.getElementsByTagName("name").item(i).getTextContent());
//                            }
//                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(pick.this,
//                                    android.R.layout.simple_list_item_1, android.R.id.text1, strings);
//                            listView.setAdapter(adapter);
//
//                        } catch (ParserConfigurationException e) {
//                            e.printStackTrace();
//                        } catch (SAXException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        progressDialog.dismiss();
//                        Toast.makeText(pick.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, "onErrorResponse: "+error.getMessage());
//                    }
//                });
//
//        requestQueue.add(req);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: onACtivityResult top");
//        switch (requestCode){
//            case RESULT_CODE :{
//                if(resultCode == Activity.RESULT_OK){
//                    Log.d(TAG, "onActivityResult: onActivityResult method switch");
//                    mainLayout();
//                }
//                break;
//            }
//        } //screw it ...always refresh
        mainLayout();
    }

    void mainLayout(){
        strings=new ArrayList<String>();
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Fetching");
        progressDialog.show();

        RequestQueue requestQueue = Volley.newRequestQueue(pick.this);
        StringRequest req = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: "+response);
                        progressDialog.dismiss();

                        try {
                            Log.d(TAG, "onResponse: reached here");
                            document = ConvertToXML(response);

                            int count = document.getElementsByTagName("item").getLength();
                            //number of rows
                            document.getElementsByTagName("name").item(0).getTextContent();

                            for(int i=0;i<count;i++)
                            {
                                strings.add(document.getElementsByTagName("name").item(i).getTextContent());
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(pick.this,
                                    android.R.layout.simple_list_item_1, android.R.id.text1, strings);
                            listView.setAdapter(adapter);

                        } catch (ParserConfigurationException e) {
                            e.printStackTrace();
                        } catch (SAXException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(pick.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onErrorResponse: "+error.getMessage());
                    }
                });

        requestQueue.add(req);
    }


    Document ConvertToXML(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));

       return db.parse(is);
    }

}