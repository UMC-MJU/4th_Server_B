package umc.carrot.error.exception;

import umc.carrot.error.ErrorCode;

//찾는 물건이 존재하지 않는 경우 예외
public class ProductNotFoundException extends BusinessException {

    public ProductNotFoundException() {
        super(ErrorCode.PRODUCT_NOT_EXIST);
    }

}
