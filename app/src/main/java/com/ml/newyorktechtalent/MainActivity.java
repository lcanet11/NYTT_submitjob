package com.ml.newyorktechtalent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper jobsDB;

    Button viewJobs;
    EditText companyText,positionText,descriptionText,linkText;
    private Button submitJob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobsDB = new DatabaseHelper(this);

        companyText=(EditText) findViewById(R.id.companyText);
        positionText=(EditText) findViewById(R.id.positionText);
        descriptionText=(EditText) findViewById(R.id.descriptionText);
        linkText=(EditText) findViewById(R.id.linkText);
        submitJob = (Button) findViewById(R.id.submitJob);

        SubmitJob();
    }


    public void SubmitJob(){
        submitJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String company = companyText.getText().toString();
            String position = positionText.getText().toString();
            String description = descriptionText.getText().toString();
            String link = linkText.getText().toString();

            boolean insertData=jobsDB.submitJob(company, position, description, link);

            if(insertData==true){
                Toast.makeText(MainActivity.this, "Your job has been submitted!",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Something went wrong. " +
                        "Please email luci@nytechtalent.io with your error.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
