package grupo3.adopcionPF.DTO;

import com.google.gson.annotations.SerializedName;

public class UploadData {
    @SerializedName("url")
    String  url;
    public UploadData(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
