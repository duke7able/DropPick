package ga.rdxgeek.droppick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

public class DetailActivity extends Activity {
    private static final String TAG = "DetailActivity";
    String url = "http://develop.asambhav.in/delete.php";
    String name ="";
    String description = "";
    String category = "";
    String location = "";
    String quantity = "";
    Integer id = -1 ;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        t1=(TextView)findViewById(R.id.TV_D1);
        t2=(TextView)findViewById(R.id.TV_D2);
        t3=(TextView)findViewById(R.id.TV_D3);
        t4=(TextView)findViewById(R.id.TV_D4);
        t5=(TextView)findViewById(R.id.TV_D5);
        //t6=(TextView)findViewById(R.id.TV_D6);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
//            Toast.makeText(this, bundle.getString("NAME"), Toast.LENGTH_SHORT).show();
            name = bundle.getString("NAME");
            description = bundle.getString("DESCRIPTION");
            category = bundle.getString("CATEGORY");
            location = bundle.getString("LOCATION");
            quantity = bundle.getString("QUANTITY");
            id = Integer.parseInt(bundle.getString("ID"));

            t1.setText(name);
            t2.setText(description);
            t3.setText(category);
            t4.setText(location);
            t5.setText(quantity);
            //t1.setText(id);
            Log.d(TAG, "onCreate: setText should be done till now");
        }



        Button BT_checkout = (Button) findViewById(R.id.BT_Checkout);
        BT_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                url = "http://develop.asambhav.in/delete.php" + "?checkout=1&" + "id=" + id ;
                RequestQueue requestQueue = Volley.newRequestQueue(DetailActivity.this);
                StringRequest req = new StringRequest(url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d(TAG, "onResponse: "+response);
                                Toast.makeText(DetailActivity.this, "Item taken successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent();
                                setResult(RESULT_OK, intent);
                                finish();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "onErrorResponse: ");
                                Intent intent = new Intent();
                                setResult(RESULT_CANCELED, intent);
                                finish();
                            }
                        });

                requestQueue.add(req);
                finish();

            }
        });

        Button BT_cancel = (Button) findViewById(R.id.BT_Cancel);
        BT_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });


    }
}
