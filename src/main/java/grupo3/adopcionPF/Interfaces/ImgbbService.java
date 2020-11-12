package grupo3.adopcionPF.Interfaces;
import grupo3.adopcionPF.DTO.UploadResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ImgbbService {
    @FormUrlEncoded
    @POST("upload")
    Call<UploadResponse> upload(
            @Query("key") String key,
            @Field("image") String data
    );
}

