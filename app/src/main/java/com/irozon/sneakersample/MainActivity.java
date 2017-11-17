package com.irozon.sneakersample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Sneaker.OnSneakerClickListener {

    Button btShowError;
    Button btShowSuccess;
    Button btShowWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShowError = (Button) findViewById(R.id.btShowError);
        btShowSuccess = (Button) findViewById(R.id.btShowSuccess);
        btShowWarning = (Button) findViewById(R.id.btShowWarning);

        btShowError.setOnClickListener(this);
        btShowSuccess.setOnClickListener(this);
        btShowWarning.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btShowError:
                Sneaker.with(this)
                        .setTitle("Error!!")
                        .setMessage("This is the error message")
                        .setTypeface(Typeface.createFromAsset(this.getAssets(), "font/" + "Slabo27px-Regular.ttf"))
                        .sneakError();
                break;
            case R.id.btShowSuccess:
                Sneaker.with(this)
                        .setTitle("Success!!")
                        .setMessage("This is the success message")
                        .sneakSuccess();
                break;
            case R.id.btShowWarning:
//                Sneaker.with(this)
//                        .setTitle("Warning!!")
//                        .setMessage("This is the warning message")
//                        .sneakWarning();


                Sneaker.with(this)
                        .setTitle("Title", R.color.colorWhite)
                        .setMessage("This is the message.", R.color.colorWhite)
                        .setDuration(4000)
                        .autoHide(true)
                        .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                        .setOnSneakerClickListener(this)
                        .setIcon(R.drawable.ic_no_connection, R.color.colorWhite, false)
                        .setTypeface(Typeface.createFromAsset(this.getAssets(), "font/" + "Oregon LDO Extended Bold.ttf")).sneak(R.color.colorAccent);


                break;
        }
    }

    @Override
    public void onSneakerClick(View view) {
        Toast.makeText(this,"This is test",Toast.LENGTH_LONG).show();
    }
}