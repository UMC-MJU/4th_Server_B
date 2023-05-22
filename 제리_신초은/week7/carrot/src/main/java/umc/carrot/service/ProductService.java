package umc.carrot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.carrot.domain.Location;
import umc.carrot.domain.Product;
import umc.carrot.domain.User;
import umc.carrot.dto.ProductRequestDto;
import umc.carrot.dto.ProductResponseDto;
import umc.carrot.dto.VisitProductRequestDto;
import umc.carrot.dto.VisitProductResponseDto;
import umc.carrot.error.exception.ProductNotFoundException;
import umc.carrot.error.exception.UserNotFoundException;
import umc.carrot.repository.ProductRepository;
import umc.carrot.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true) //읽기에는 readOnly true, 쓰기에 true를 하면 값이 변경안됨
@RequiredArgsConstructor           //final이 있는 필드만으로 생성자 인젝션을 만들어주는 태그
public class ProductService {

    //@RequiredArgsConstructor에는 final 붙이기
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    //파는 물건 생성
    @Transactional  //우선권을 가져서 readOnly = false가 됨
    public ResponseEntity<?> createdProduct(ProductRequestDto requestDto) {

        //사용자 엔티티 조회
        Optional<User> user = userRepository.findById(requestDto.getUser_id());
        Optional<Location> location = Optional.ofNullable(Location.builder()
                .location_name(requestDto.getLocation())
                .build());

        //아이디가 존재하지 않을 때 예외를 발생
        user.orElseThrow(() -> new UserNotFoundException());

        //물건 생성
        Product product = Product.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .photo(requestDto.getPhoto())
                .price(requestDto.getPrice())
                .user(user.get())
                .location(location.get())
                .build();

        //객체 저장
        productRepository.save(product);

        //응답 dto 생성
        ProductResponseDto responseDto = ProductResponseDto.builder()
                .title(product.getTitle())
                .content(product.getContent())
                .photo(product.getPhoto())
                .price(product.getPrice())
                .location(product.getLocation())
                .createdAt(product.getCreatedAt())
                .modifiedAt(product.getModifiedAt())
                .build();

        return ResponseEntity.ok(responseDto);
        //responseEntity는 스프링부트가 해주는 라이브러리
        //created는 201(클라이언트가 서버에 요청해서 자원이 생성됐다), 생성된 자원의 위치 URL로 반환
        //ok는 200
    }

    //물건 조회
    public ResponseEntity<?> visitProduct(VisitProductRequestDto requestDto) {

        Optional<Product> product = productRepository.findById(requestDto.getProduct_id());

        if (product.isPresent()) {
            //조회수 1 증가
            product.get().addHits();
        } else {
            throw new ProductNotFoundException();
        }
        
        //응답 dto 생성
        VisitProductResponseDto visitProductResponseDto = VisitProductResponseDto.builder()
                .hit(product.get().getHits())
                .title(product.get().getTitle())
                .user(product.get().getUser())
                .build();
        
        return ResponseEntity.ok(visitProductResponseDto);

    }

}
