package network;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.*;

public interface JavaApiService {

    @Multipart
    @POST("upload")
    ResponseBody uploadFile(
            @Part MultipartBody.Part file
//        @Part("name") requestBody: RequestBody
    );

    @FormUrlEncoded
    @POST("api/login")
    ResponseBody login(
            @Field("email") String email,
            @Field("password") String password
    );
}
