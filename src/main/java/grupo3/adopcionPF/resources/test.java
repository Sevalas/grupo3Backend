package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DTO.UploadData;
import grupo3.adopcionPF.DTO.UploadResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;
import sun.misc.BASE64Encoder;

import java.io.IOException;


@RestController
@RequestMapping("/api")
public class test {

    ImgbbService service;
    BASE64Encoder base64Encoder = new BASE64Encoder();

    public test() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.imgbb.com/1/").addConverterFactory(GsonConverterFactory.create()).build();

        service = retrofit.create(ImgbbService.class);
    }

    public interface ImgbbService {
        @FormUrlEncoded
        @POST("upload")
        Call<UploadResponse> upload(
                @Query("key") String key,
                @Field("image") String data
        );
    }

    @RequestMapping(path = "/imagen", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleUpload(@RequestPart("imagen") MultipartFile imagen) throws IOException {

        String img1 = base64Encoder.encode(imagen.getBytes());
        Response<UploadResponse> response = service.upload("2c9bcf61c8014cee3542685d80ba3a4a",img1).execute();
        UploadResponse uploadResponse = response.body();
        UploadData uploadData = uploadResponse.getData();
        String url = uploadData.getUrl();
        return url;
    }
}
