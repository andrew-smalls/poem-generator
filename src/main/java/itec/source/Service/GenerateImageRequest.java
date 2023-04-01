package itec.source.Service;

import lombok.Data;

@Data
public class GenerateImageRequest {
        private String prompt;

        private String size="512x512";
}
