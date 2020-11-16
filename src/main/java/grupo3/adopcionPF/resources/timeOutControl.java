package grupo3.adopcionPF.resources;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class timeOutControl {
    public static void timeOutControl() {
        OkHttpClient innerClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES) // connect timeout
                .writeTimeout(5, TimeUnit.MINUTES) // write timeout
                .readTimeout(5, TimeUnit.MINUTES) // read timeout
                .build();
    }
}
