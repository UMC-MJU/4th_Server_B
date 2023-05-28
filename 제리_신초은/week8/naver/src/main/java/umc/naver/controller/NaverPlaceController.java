package umc.naver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import umc.naver.dto.NaverPlaceDto;
import umc.naver.dto.NaverRequestVariableDto;
import umc.naver.service.NaverPlaceService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class NaverPlaceController {

    private final NaverPlaceService naverPlaceService;

    //물건 등록
    @PostMapping("/search")
    public ResponseEntity<Map<String, Object>> createProduct(@RequestBody NaverRequestVariableDto requestDto) throws IOException {
        List<NaverPlaceDto> naverPlaceDtos = naverPlaceService.naverMapSearchAPI(requestDto);

        Map<String, Object> result = new HashMap<>();
        result.put("place", naverPlaceDtos);
        result.put("count", naverPlaceDtos.size());

        return ResponseEntity.ok().body(result);
    }

}
