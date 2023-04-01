package itec.source.api.imageGenerator;

import java.util.List;

public class ImageResponse {
    private Long created;
    private List<Data> data;

    public Long getCreated() {
        return created;
    }

    public List<Data> getData() {
        return data;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}