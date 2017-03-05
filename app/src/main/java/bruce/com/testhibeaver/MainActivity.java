package bruce.com.testhibeaver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static void staticMethod(Object checkThisBro, Object andThis) {
        if (checkThisBro != null) {
            Log.i("staticMethod", checkThisBro.toString());
        }
        Log.i("staticMethod", andThis.toString());
    }
    private void gotoBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setName("big guy");
        Log.i("hey", "hey buddy");
        String url = "http://www.baidu.com";
        gotoBrowser(url);
        if (getName() != null) {
            System.out.print(getName());
        }
        staticMethod(MainActivity.this, "");
        try {
            new OkHttpClient.Builder().build()
                    .newCall(new Request.Builder().url(url).build())
                    .enqueue(new Callback() {
                        public void onFailure(Call call, IOException e) {}
                        public void onResponse(Call call, Response response) throws IOException {
                            Log.i("hey", "code:" + response.code());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
