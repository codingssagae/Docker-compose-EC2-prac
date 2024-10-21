package leegunhee.dockerprac;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Response<T> {
    private List<T> data;
    private String message;

    public Response(String message) {
        this.message = message;
    }
}
