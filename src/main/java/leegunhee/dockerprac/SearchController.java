package leegunhee.dockerprac;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class SearchController {

    private final SearchLogService searchLogService;

    @PostMapping("/searching")
    public ResponseEntity<Response> saveRecentSearchLog(@RequestBody SearchLogSaveRequest request){
        searchLogService.saveRecentSearchLog(1L,request);
        return ResponseEntity.ok(new leegunhee.dockerprac.Response<>("최근 기록 검색 저장 완료"));
    }

    @GetMapping("/searchLogs")
    public ResponseEntity<Response> findRecentSearchLog(@RequestBody SearchLogDeleteRequest request){
        List<SearchLog> recentSearchLogList = searchLogService.findRecentSearchLogs(1L);
        return ResponseEntity.ok(new Response(recentSearchLogList, "최근 검색 기록 조회 완료"));
    }
}
