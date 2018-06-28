package ir.mehrdadscomputer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    List<String> mList = new ArrayList<>();

    public static final String CUSTOM_BROADCAST_ACTION2 = "test2";

    @Override
    public void onReceive(Context context, Intent intent) {

        createListOfStrings();

        // Get intent, action and MIME type
        String type = intent.getType();

        String Result = handleSendText(intent); // Handle text being sent
        Log.i("ttt2", "result: " + Result);

        // send message to receiver
        Intent intent2 = new Intent();
        intent2.setAction("customreceiveraction");
        intent2.putExtra("message", Result);
        context.sendBroadcast(intent2);

        }

    String handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra("receiverTestValue");
        Log.i("ttt0", "sharedText: " + sharedText);
        if (mList.contains(sharedText)) return "Yes";
        else return "No";
    }

    private void createListOfStrings() {
        mList.add("ir.example.test1");
        mList.add("ir.example.test2");
        mList.add("ir.example.test3");
        mList.add("ir.example.test4");
        mList.add("ir.example.test5");
    }
}
