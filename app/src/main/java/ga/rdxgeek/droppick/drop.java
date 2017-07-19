package ga.rdxgeek.droppick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class drop extends AppCompatActivity {

    private static final String TAG = "drop";
    private EditText name;
    private EditText category;
    private EditText location;
    private EditText quantity;
    private EditText description;

    String Name="";
    String Category="";
    String Location="";
    String Quantity="";
    String Description="";

    String url = "http://develop.asambhav.in/insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop);

//        name.setError(null);
//        category.setError(null);
//        location.setError(null);
//        quantity.setError(null);
//        description.setError(null);

        name = (EditText)findViewById(R.id.ET_name);
        category = (EditText)findViewById(R.id.ET_category);
        location = (EditText)findViewById(R.id.ET_location);
        quantity = (EditText)findViewById(R.id.ET_quantity);
        description = (EditText)findViewById(R.id.ET_description);

        Button BT_ok = (Button) findViewById(R.id.BT_submitdrop);
        BT_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name =name.getText().toString();
                Category =category.getText().toString();
                Quantity =quantity.getText().toString();
                Location =location.getText().toString();
                Description =description.getText().toString();

                url = "http://develop.asambhav.in/insert.php" + "?name=" + Name + "&category=" + Category + "&quantity=" + Quantity + "&location=" + Location + "&Description=" + Description;

                RequestQueue requestQueue = Volley.newRequestQueue(drop.this);
                StringRequest req = new StringRequest(url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d(TAG, "onResponse: "+response);
                                Toast.makeText(drop.this, "item put", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "onErrorResponse: ");
                                finish();
                            }
                        });

                requestQueue.add(req);
            }
        });

        Button BT_cancel = (Button) findViewById(R.id.BTN_back);
        BT_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
