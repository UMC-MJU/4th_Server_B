package umc.naver.error.exception;

import umc.naver.error.ErrorCode;

//문자열 utf-8 인코딩 실패
public class UnsupportedEncodingException extends BusinessException {

    public UnsupportedEncodingException() {
        super(ErrorCode.ENCODING_FAILED);
    }

}
