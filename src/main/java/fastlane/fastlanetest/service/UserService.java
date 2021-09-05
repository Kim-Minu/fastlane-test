package fastlane.fastlanetest.service;

import fastlane.fastlanetest.dto.UserDto;
import fastlane.fastlanetest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Transactional
    public void save(UserDto requestDto){
        userMapper.save(requestDto.getId(), requestDto.getPassword());
    }

    public UserDto findById(String id) {
        Optional<UserDto> entity = Optional.ofNullable(userMapper.findById(id));
        return entity.orElse(null);
    }

    @Transactional
    public void update(String id, UserDto requestDto) {
        userMapper.update(requestDto.getPassword(), id);
    }

    @Transactional
    public void delete(String id){
        userMapper.delete(id);
    }

}
