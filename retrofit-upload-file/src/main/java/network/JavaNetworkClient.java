package network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class JavaNetworkClient {


    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://localhost:5000/")
                    .addCallAdapterFactory(OurCallAdapter.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
