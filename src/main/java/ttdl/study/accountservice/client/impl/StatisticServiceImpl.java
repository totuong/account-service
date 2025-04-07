package ttdl.study.accountservice.client.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ttdl.study.accountservice.client.StatisticService;
import ttdl.study.accountservice.model.StatisticDTO;

@Slf4j
@Component
public class StatisticServiceImpl implements StatisticService {
    @Override
    public void add(final StatisticDTO statisticDTO) {
        log.error("Statistic Service is slow");
    }
}
