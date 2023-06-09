package umc.carrot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.carrot.domain.Location;
import umc.carrot.domain.User;
import umc.carrot.dto.UserRequestDto;
import umc.carrot.dto.UserResponseDto;
import umc.carrot.error.exception.UserEmailAlreadyExistsException;
import umc.carrot.error.exception.UserNotFoundException;
import umc.carrot.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true) //읽기에는 readOnly true, 쓰기에 true를 하면 값이 변경안됨
@RequiredArgsConstructor           //final이 있는 필드만으로 생성자 인젝션을 만들어주는 태그
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원 가입
     */
    @Transactional  //우선권을 가져서 readOnly = false가 됨
    public ResponseEntity<UserResponseDto> join(UserRequestDto requestDto) {

        validateDuplicateMember(requestDto);    //중복 회원 검증

        Optional<Location> location = Optional.ofNullable(Location.builder()
                .location_name(requestDto.getLocation())
                .build());

        //회원 객체 생성
        User user = User.builder()
                .nickname(requestDto.getNickname())
                .email(requestDto.getEmail())
                .phone_number(requestDto.getPhone_number())
                .profile_image(requestDto.getProfile_image())
                .location(location.get())
                .build();

        //객체 등록
        userRepository.save(user);

        //response dto 생성
        UserResponseDto responseDto = UserResponseDto.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .phone_number(user.getPhone_number())
                .profile_image(user.getProfile_image())
                .temperature(user.getTemperature())
                .response_rate(user.getResponse_rate())
                .build();

        return ResponseEntity.ok(responseDto);
    }

    private void validateDuplicateMember(UserRequestDto userRequestDto) {
        //이메일로 확인
        List<User> findUsers = userRepository.findAllByEmail(userRequestDto.getEmail());
        if (!findUsers.isEmpty()) {
            throw new UserEmailAlreadyExistsException();
        }
    }

    /**
     * 회원 조회
     */
    public List<User> findUsers() {     //전체
        return userRepository.findAll();
    }

    public ResponseEntity<?> findOne(Long userId) {  //개인
        Optional<User> user = userRepository.findById(userId);

        //아이디가 존재하지 않을 때 예외를 발생시킨다.
        user.orElseThrow(() -> new UserNotFoundException());
        //orElse(T other)와 달리 orElseThrow()는 매개변수로 넣은 동작은 Optional의 값이 null일 때만 동작
        //매개변수에 Supplier가 들어가는데 아래와 같이 매개변수가 없이 무언가 반환해주는 함수를 넣으면 된다.

        UserResponseDto responseDto = UserResponseDto.builder()
                .id(user.get().getId())
                .nickname(user.get().getNickname())
                .email(user.get().getEmail())
                .phone_number(user.get().getPhone_number())
                .profile_image(user.get().getProfile_image())
                .temperature(user.get().getTemperature())
                .response_rate(user.get().getResponse_rate())
                .build();

        return ResponseEntity.ok(responseDto);
    }

}
