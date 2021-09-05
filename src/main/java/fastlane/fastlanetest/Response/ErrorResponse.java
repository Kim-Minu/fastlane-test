package fastlane.fastlanetest.Response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse extends BasicResponse {
    private String errorMessage;
    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;

    }

}
