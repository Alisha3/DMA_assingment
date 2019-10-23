package com.example.andriod.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.andriod.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
//    public static final String KEY = "com.example.andriod.key";
    String reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = (EditText) findViewById(R.id.editText_main);
        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);

//        if (savedInstanceState != null){
//             reply = savedInstanceState.getString(SecondActivity.EXTRA_REPLY);
//            mReplyTextView.setText(reply);
//        }

    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked!");

        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
        startActivityForResult(intent, TEXT_REQUEST);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle saveInstanceState) {
//        super.onSaveInstanceState(saveInstanceState);
//        saveInstanceState.putString(SecondActivity.EXTRA_REPLY, reply);
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
                mMessageEditText.setText(null);
            }
        }
    }

}
