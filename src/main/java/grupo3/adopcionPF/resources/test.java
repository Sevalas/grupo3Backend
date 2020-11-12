package grupo3.adopcionPF.resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RestController
@RequestMapping("/api")
public class test {

    @RequestMapping(path = "/imagen", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleUpload(@RequestPart("imagen") MultipartFile imagen) throws IOException {

        return new imgbbAPI().ImgToUrl(imagen);
    }
}
