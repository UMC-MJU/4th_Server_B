package umc.naver.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode { //Enum 타입

    // Product
    INTERNAL_SERVER_ERROR(500, "P001", "internal server error"),
    INVALID_INPUT_VALUE(400, "P002", "invalid input type"),
    METHOD_NOT_ALLOWED(405, "P003", "method not allowed"),
    INVALID_TYPE_VALUE(400, "P004", "invalid type value"),
    PRODUCT_NOT_EXIST(404, "P005", "product not exist"),

    // User
    USER_NOT_EXIST(404, "M001", "user not exist"),
    USER_EMAIL_ALREADY_EXISTS(400, "M002", "user email already exists"),

    // API
    ENCODING_FAILED(404,"A001","unsupported encoding");

    private int status;
    private final String code;
    private final String message;
}
