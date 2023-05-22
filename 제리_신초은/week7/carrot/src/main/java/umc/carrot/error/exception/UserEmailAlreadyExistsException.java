package umc.carrot.error.exception;

import umc.carrot.error.ErrorCode;

//회원가입한 이메일이 이미 존재하는 경우 예외
public class UserEmailAlreadyExistsException extends BusinessException{

    public UserEmailAlreadyExistsException() {
        super(ErrorCode.USER_EMAIL_ALREADY_EXISTS);
    }

}
