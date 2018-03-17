
import okhttp3.*;
import java.io.IOException;
public class GetMessageFromCloud {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://yuiotfree.azure-devices.cn/devices/dd/messages/deviceBound?api-version=2016-11-14")
                .get()
                .addHeader("authorization", "SharedAccessSignature sr=yuiotfree.azure-devices.cn%2Fdevices%2Fdd&sig=xpVGxInEer38dkIQKn4OJ%2Fg8bkoGIE271dCP0KgQngQ%3D&se=1521434065")
                .addHeader("cache-control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
