package ir.mehrdadscomputer.receiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createListOfStrings();
        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        Log.i("ttt2", "message: "+intent.getStringExtra(Intent.EXTRA_TEXT));

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String Result = handleSendText(intent); // Handle text being sent
                Log.i("ttt2", "result: "+Result);
                Intent data = new Intent();
                data.putExtra("MESSAGE", Result);
                setResult(RESULT_OK, data);
                Log.i("ttt3", "result: "+Result);
                finish();
            }
        }
    }
    private void createListOfStrings() {
        mList.add("ir.example.test1");
        mList.add("ir.example.test2");
        mList.add("ir.example.test3");
        mList.add("ir.example.test4");
        mList.add("ir.example.test5");
    }

    String handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        Log.i("ttt0", "sharedText: "+sharedText);
        if (mList.contains(sharedText)) return "Yes";
        else return "No";
    }
}
