package bruce.com.testhibeaver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xiaomi.mipush.sdk.MiPushClient;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final String APP_ID = "2882303761517551934";
    public static final String APP_KEY = "5591755140934";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiPushClient.registerPush(this, APP_ID, APP_KEY);
        Log.i("hi", "hi");
        try {
            new OkHttpClient.Builder()
                    .build()
                    .newCall(new Request.Builder()
                            .url("http://www.baidu.com")
                            .build()).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.i("hi", "code:" + response.code());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hookXM(Object checkThisBro, Object andThis) {
        Log.i("hookXM", checkThisBro.toString());
        Log.i("hookXM", andThis.toString());
    }
}
