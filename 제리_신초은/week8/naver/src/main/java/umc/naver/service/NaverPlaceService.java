package umc.naver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import umc.naver.domain.PlaceInfo;
import umc.naver.domain.Places;
import umc.naver.dto.NaverPlaceDto;
import umc.naver.dto.NaverRequestVariableDto;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true) //읽기에는 readOnly true, 쓰기에 true를 하면 값이 변경안됨
@RequiredArgsConstructor           //final이 있는 필드만으로 생성자 인젝션을 만들어주는 태그
public class NaverPlaceService {

    @Value("${NAVER-CLIENT-ID}")
    String clientId;
    @Value("${NAVER-CLIENT-SECRET}")
    String clientSecret;

    public List<NaverPlaceDto> naverMapSearchAPI(NaverRequestVariableDto naverVariable) throws IOException {

        //참고 url: https://ssong915.tistory.com/36
        String url = "https://openapi.naver.com";

        //URL 세팅
        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .path("/v1/search/local.json")
                .queryParam("query", naverVariable.getQuery())
                .queryParam("display", naverVariable.getDisplay())
                .queryParam("start", naverVariable.getStart())
                .queryParam("sort", naverVariable.getSort())
                .encode()
                .build()
                .toUri();
        log.info("uri : {}", uri);
        RestTemplate restTemplate = new RestTemplate();

        // HEADER를 추가하기 위해서 RequestEntity 사용
        // Get으로 넣을것이기 때문에 Void로 지정
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        List<NaverPlaceDto> naverPlaceDtos = fromJSONtoNaverPlace(result.getBody());

        log.info("result ={}", naverPlaceDtos);
        return naverPlaceDtos;

    }

    //내가 만든 api에서 반환할 Dto
    private List<NaverPlaceDto> fromJSONtoNaverPlace(String result) throws JsonProcessingException, IOException {

        //jackson objectmapper 객체 생성
        ObjectMapper mapper = new ObjectMapper();

        //JsonNode 생성(readValue)
        JsonNode jsonNode = mapper.readValue(result, JsonNode.class);

        //JsonNode 읽기
        PlaceInfo placeInfo = readJsonNodeWithGet(jsonNode);

        //NaverPlaceDto로 데이터 가공
        List<NaverPlaceDto> naverPlaceDtos = new ArrayList<>();

        for(int i = 0; i<placeInfo.getTotal(); i++) {

            NaverPlaceDto naverPlaceDto = NaverPlaceDto.builder()
                    .title(placeInfo.getItems().get(i).getTitle())
                    .link(placeInfo.getItems().get(i).getLink())
                    .address(placeInfo.getItems().get(i).getAddress())
                    .roadAddress(placeInfo.getItems().get(i).getRoadAddress())
                    .build();

            naverPlaceDtos.add(naverPlaceDto);
        }

        return naverPlaceDtos;

    }

    //받아온 api에서 Places, PlaceInfo 추출
    private PlaceInfo readJsonNodeWithGet(JsonNode jsonNode) {

        //jsonNode의 값을 가져오는 메소드는 path(), get(), at() 모두 가능
        String lastBuildDate = jsonNode.path("lastBuildDate").asText();
        int total = jsonNode.path("total").asInt();
        int start = jsonNode.path("start").asInt();
        int display = jsonNode.path("display").asInt();

        List<Places> placesList = new ArrayList<>();
        for(int i = 0; i < total ; i++) {

            //값 추출해서 객체 채우기
            Places place = Places.builder()
                    .title(jsonNode.path("items").path(i).path("title").asText())
                    .link(jsonNode.path("items").path(i).path("link").asText())
                    .category(jsonNode.path("items").path(i).path("category").asText())
                    .description(jsonNode.path("items").path(i).path("description").asText())
                    .telephone(jsonNode.path("items").path(i).path("telephone").asText())
                    .address(jsonNode.path("items").path(i).path("address").asText())
                    .roadAddress(jsonNode.path("items").path(i).path("roadAddress").asText())
                    .mapx(jsonNode.path("items").path(i).path("mapx").asText())
                    .mapy(jsonNode.path("items").path(i).path("mapy").asText())
                    .build();

            //리스트에 객체 추가
            placesList.add(place);
        }

        PlaceInfo placeInfo = PlaceInfo.builder()
                .lastBuildDate(lastBuildDate)
                .total(total)
                .start(start)
                .display(display)
                .items(placesList)
                .build();

        return placeInfo;
    }

}
