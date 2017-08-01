package ayurvihar.somaiya.com.ayurvihar.underfive;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import ayurvihar.somaiya.com.ayurvihar.MainActivity;
import ayurvihar.somaiya.com.ayurvihar.R;
import ayurvihar.somaiya.com.ayurvihar.utility.UnderFiveCr;
import ayurvihar.somaiya.com.ayurvihar.utility.UnderFiveImm;

/**
 * Created by heretic on 1/8/17.
 */

public abstract class UnderFiveSearch1CrOutput extends AppCompatActivity implements View.OnClickListener {

    ListView childlist;
    ProgressDialog dialog;
    ArrayList<String> poss;

    String fname, lname, dob, vacc, id, date = "";

    public static final DatabaseReference CHILD_DB = MainActivity.DATABASE_ROOT.child("Underfive");
    public static final DatabaseReference databaseChildHr=CHILD_DB.child("GenRec");
    public static final DatabaseReference databaseChildImm=CHILD_DB.child("ImmRec");

    UnderFiveSearch1CrOutput(String date)
    {
        this.date=date;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.underfive_search1cr_output);

        childlist = (ListView) findViewById(R.id.childlist);
        dialog = new ProgressDialog(UnderFiveSearch1CrOutput.this);

        Intent i= getIntent();
        date = i.getStringExtra(ayurvihar.somaiya.com.ayurvihar.underfive.UnderFiveSearch1Cr.message);

        poss= new ArrayList<>();


        if(poss.size()!=0)
            poss.clear();
        else {
            databaseChildHr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        UnderFiveCr ufc = ds.getValue(UnderFiveCr.class);
                        UnderFiveImm ifc = ds.getValue(UnderFiveImm.class);
                        Pair<String,String> val= ifc.getVal(date);
                        if(val.first != "" ) {
                            id = val.first;
                            fname = ufc.getFname();
                            lname = ufc.getLname();
                            if (lname == "")
                                lname = "\t";
                            dob = ufc.getDob();
                            vacc = val.second;
                            String str = vacc + "\t\t" + fname + " " + lname + "\t" + dob;
                            poss.add(str);
                        }
                    }

                    Collections.sort(poss);
                    String str1= "Vaccine\tName\t\t\tDOB";
                    poss.add(0,str1);
                    childlist.setAdapter(new ArrayAdapter<>(UnderFiveSearch1CrOutput.this,R.layout.child_textview,poss));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                        }
            });
        }

    }

}



