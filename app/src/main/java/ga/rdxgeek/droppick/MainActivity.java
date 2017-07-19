package ga.rdxgeek.droppick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button BT_drop = (Button) findViewById(R.id.BT_drop);
        BT_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,drop.class);
                startActivity(intent);
            }
        });

        Button BT_pick = (Button) findViewById(R.id.BT_pick);
        BT_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,pick.class);
                startActivity(intent);
            }
        });
    }
}
