package umc.naver.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PlaceInfo {

    private String lastBuildDate;

    private int total;

    private int start;

    private int display;

    private List<Places> items;

    @Builder
    public PlaceInfo(String lastBuildDate, int total, int start, int display, List<Places> items) {
        this.lastBuildDate = lastBuildDate;
        this.total = total;
        this.start = start;
        this.display = display;
        this.items = items;
    }
}
