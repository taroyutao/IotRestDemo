import okhttp3.*;
import java.io.IOException;

public class PostManDemo {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"url\": \"http://www.gjstars.com/img/2017-4-17-67.jpg\"\r\n}");
        Request request = new Request.Builder()
                .url("https://api.cognitive.azure.cn/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&returnFaceAttributes=age")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Ocp-Apim-Subscription-Key", "73db498eb79943768d2a012a39b03e5f")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "715400ac-fb98-b4ae-9c55-c7cf105e44be")
                .build();
        Response response = client.newCall(request).execute();
        //打印输出结果
        System.out.println(response.body().string());
    }
}
