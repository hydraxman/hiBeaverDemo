package bruce.com.testhibeaver;

import android.util.Log;

/**
 * Created by bushaopeng on 17/5/24.
 */

public class LogU {
    @Erase
    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }
}
