
import okhttp3.*;
import java.io.IOException;
public class GetDeviceDemo {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://yuiotfree.azure-devices.cn/devices?api-version=2016-11-14")
                .get()
                .addHeader("authorization", "SharedAccessSignature sr=yuiotfree.azure-devices.cn&sig=m9nxaHAB9kueyGiU61KTEw6bcYKgK9TTgrcU5LN05MQ%3D&se=1552631260&skn=iothubowner")
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
