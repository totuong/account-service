package ttdl.study.accountservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ttdl.study.accountservice.model.StatisticDTO;

@FeignClient(name="statistic-service",url="http://localhost:9082")
public interface StatisticService {
    @PostMapping("/statistic")
    void add(@RequestBody StatisticDTO statisticDTO);
}
