package umc.carrot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import umc.carrot.dto.ProductRequestDto;
import umc.carrot.dto.VisitProductRequestDto;
import umc.carrot.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //물건 등록
    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDto requestDto) {
        ResponseEntity<?> product = productService.createdProduct(requestDto);
        return product;
    }

    //물건 방문 후 조회수 증가
    @PostMapping("/product/visit")
    public ResponseEntity<?> visitProduct(@RequestBody VisitProductRequestDto requestDto) {
        return productService.visitProduct(requestDto);
    }

}
