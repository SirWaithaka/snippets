package network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

class NetworkClient {

    private var retrofit: Retrofit? = null

    fun getRetrofitInstance(): Retrofit {

        val okHttpClient = OkHttpClient.Builder().build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("http://localhost:5000/")
                .client(okHttpClient)
                .build()
        }
        return retrofit!!
    }
}