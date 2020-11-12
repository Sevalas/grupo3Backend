package grupo3.adopcionPF.DTO;

import com.google.gson.annotations.SerializedName;

public class UploadResponse {
    @SerializedName("data")
    UploadData data;
    public UploadResponse(UploadData data) {
        this.data = data;
    }

    public UploadData getData() {
        return data;
    }
}
