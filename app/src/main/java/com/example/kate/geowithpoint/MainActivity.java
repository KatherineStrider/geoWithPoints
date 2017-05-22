package com.example.kate.geowithpoint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnFind;
    EditText textRequest;

    SharedPreferences preferences;
    String textPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getPreferences(MODE_PRIVATE);
        textPoint = null;

        initView();
    }

    private void initView(){

        btnFind = (Button) findViewById(R.id.btnFind);
        textRequest = (EditText) findViewById(R.id.textRequest);

        btnFind.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            textPoint = textRequest.getText().toString();

            String geo = "geo:0,0?q=" + textRequest.getText().toString().trim();

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geo));

            MainActivity.this.startActivity(intent);
        }
    };
}
