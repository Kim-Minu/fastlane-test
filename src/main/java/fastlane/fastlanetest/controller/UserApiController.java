package fastlane.fastlanetest.controller;

import fastlane.fastlanetest.Response.BasicResponse;
import fastlane.fastlanetest.Response.CommonResponse;
import fastlane.fastlanetest.Response.ErrorResponse;
import fastlane.fastlanetest.dto.UserDto;
import fastlane.fastlanetest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    //1. 회원 가입
    @PostMapping("/user")
    public ResponseEntity<? extends BasicResponse> save(@RequestBody UserDto requestDto){

        UserDto findUser = userService.findById(requestDto.getId());

        //아이디 중복체크
        if(findUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("아이디 중복입니다. 사용자 id를 확인해주세요."));
        }

        userService.save(requestDto);

        return ResponseEntity.ok().build();

    }

    //2. 회원 비밀번호 수정
    @PutMapping("/user/{id}")
    public ResponseEntity<? extends BasicResponse> update(@PathVariable String id, @RequestBody UserDto requestDto){

        UserDto findUser = userService.findById(id);

        //가입된 사용자 인지 확인
        if(findUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요."));
        }

        userService.update(id, requestDto);

        return ResponseEntity.ok().build();
    }

    //3. 회원 삭제
    @DeleteMapping("/user/{id}")
    public ResponseEntity<? extends BasicResponse> delete(@PathVariable String id){

        UserDto findUser = userService.findById(id);

        //가입된 사용자 인지 확인
        if(findUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요."));
        }

        userService.delete(id);

        return ResponseEntity.ok().build();
    }



}
