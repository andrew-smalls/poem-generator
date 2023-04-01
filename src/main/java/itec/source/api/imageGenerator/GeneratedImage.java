package itec.source.api.imageGenerator;

import lombok.Data;

@Data
public class GeneratedImage {
    private String url;

    public GeneratedImage(String url) {
        this.url = url;
    }

    public GeneratedImage() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
