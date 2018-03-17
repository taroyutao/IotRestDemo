
import okhttp3.*;
import java.io.IOException;

public class SendRestDemo {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "{\n\tdeviceId:\"dd\"\n\twindSpeed:\"1739.00\"\n}");
        Request request = new Request.Builder()
                .url("https://yuiotfree.azure-devices.cn/devices/dd/messages/events?api-version=2016-02-03")
                .post(body)
                .addHeader("authorization", "SharedAccessSignature sr=yuiotfree.azure-devices.cn%2Fdevices%2Fdd&sig=xpVGxInEer38dkIQKn4OJ%2Fg8bkoGIE271dCP0KgQngQ%3D&se=1521434065")
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();

            System.out.println(response.body().string());

            System.out.println(response.body().byteStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
