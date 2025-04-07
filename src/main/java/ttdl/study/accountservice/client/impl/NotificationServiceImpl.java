package ttdl.study.accountservice.client.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ttdl.study.accountservice.client.NotificationService;
import ttdl.study.accountservice.model.MessageDTO;


@Slf4j
@Component
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendNotification(final MessageDTO messageDTO) {
        log.error("Notification Service is slow");

    }
}
