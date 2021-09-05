package fastlane.fastlanetest.dto;

import lombok.*;

@Builder
@Getter
@Setter
public class UserDto {
    private String id;
    private String password;
}
