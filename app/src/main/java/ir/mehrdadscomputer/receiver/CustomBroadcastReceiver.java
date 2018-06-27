package ir.mehrdadscomputer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if("ir.mehrdadscomputer.broadcast.CUSTOM_BROADCAST".equals(action)) {
            // When receive it will show an toast popup message.
            Toast.makeText(context, "Custom Broadcast Receiver Receive Message.", Toast.LENGTH_SHORT).show();
        }
    }
}
