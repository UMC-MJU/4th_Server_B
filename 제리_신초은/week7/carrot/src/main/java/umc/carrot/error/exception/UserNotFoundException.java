package umc.carrot.error.exception;

import umc.carrot.error.ErrorCode;

//찾을 유저가 없는 경우 예외처리
public class UserNotFoundException extends BusinessException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_EXIST);
    }

}
