package leegunhee.dockerprac;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLogService {

    private final RedisTemplate<String, SearchLog>redisTemplate;

    public void saveRecentSearchLog(Long memberId, SearchLogSaveRequest request){
        String key = "SearchLog" + memberId;
        SearchLog value = SearchLog.builder()
                .content(request.getContent())
                .build();
        Long size = redisTemplate.opsForList().size(key);
        if (size==10) redisTemplate.opsForList().rightPop(key);
        redisTemplate.opsForList().leftPush(key,value);
    }

    public List<SearchLog> findRecentSearchLogs(Long memberId){
        String key = "SearchLog"+memberId;
        List<SearchLog> logs = redisTemplate.opsForList().range(key, 0, 10);
        return logs;
    }
    public void deleteRecentSearchLog(Long memberId, SearchLogDeleteRequest request){
        String key = "SearchLog" + memberId;
        SearchLog value = SearchLog.builder()
                .content(request.getContent())
                .build();
        Long count = redisTemplate.opsForList().remove(key, 1, value);
        if (count==0){
            throw new IllegalStateException("존재x");
        }
    }

}
