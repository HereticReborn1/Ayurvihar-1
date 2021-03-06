package ayurvihar.somaiya.com.ayurvihar.underfive;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import ayurvihar.somaiya.com.ayurvihar.R;

/**
 * Created by mikasa on 6/7/17.
 */

public class UnderFiveHome extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.underfive_home);

        ImageButton add=(ImageButton)findViewById(R.id.AddNew);
        ImageButton update=(ImageButton) findViewById(R.id.Update);
        ImageButton hlthrep=(ImageButton) findViewById(R.id.hlthrep);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UnderFiveAddCr.class);
                startActivity(i);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), UnderFiveUpdateCr.class);
                startActivity(i);
            }
        });

        hlthrep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),UnderFiveHealthRep.class);
                startActivity(i);
            }
        });
    }
}
