import network.JavaApiService;
import network.JavaNetworkClient;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.io.File;
import java.io.IOException;

public class JavaClient {

    public static void main(String[] args) {

        JavaApiService apiService = JavaNetworkClient
                .getRetrofitInstance()
                .create(JavaApiService.class);

        try {
            File file = new File("/home/waithaka/Pictures/Htop Output.png");
            RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), fileReqBody);
            ResponseBody response = apiService.uploadFile(part);

            System.out.println("Response: " + response.string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}