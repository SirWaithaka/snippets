import kotlinx.coroutines.runBlocking
import network.ApiService
import network.NetworkClient
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

fun main() {

    val apiService: ApiService = NetworkClient()
        .getRetrofitInstance()
        .create(ApiService::class.java)

    runBlocking {

        val file = File("/home/waithaka/Pictures/Htop Output.png")
        val fileReqBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("file", file.name, fileReqBody)
        val response = apiService.uploadFile(part)

        println("Response: ${response.string()}")
    }
}