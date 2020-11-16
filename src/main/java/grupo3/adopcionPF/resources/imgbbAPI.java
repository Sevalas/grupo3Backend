package grupo3.adopcionPF.resources;
import grupo3.adopcionPF.DTO.UploadData;
import grupo3.adopcionPF.DTO.UploadResponse;
import grupo3.adopcionPF.Interfaces.ImgbbService;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sun.misc.BASE64Encoder;
import java.io.IOException;

public class imgbbAPI {
    ImgbbService service;
    BASE64Encoder base64Encoder = new BASE64Encoder();

    public imgbbAPI() {
        timeOutControl.timeOutControl();
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.imgbb.com/1/").addConverterFactory(GsonConverterFactory.create()).build();

        service = retrofit.create(ImgbbService.class);

    }

    public String ImgToUrl (MultipartFile img) throws IOException {
        String imgBase64 = base64Encoder.encode(img.getBytes());
        Response<UploadResponse> response = service.upload("2c9bcf61c8014cee3542685d80ba3a4a",imgBase64).execute();
        UploadResponse uploadResponse = response.body();
        UploadData uploadData = uploadResponse.getData();
        String url = uploadData.getUrl();
        return url;

    }
}
