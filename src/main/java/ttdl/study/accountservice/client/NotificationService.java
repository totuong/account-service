package ttdl.study.accountservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ttdl.study.accountservice.client.impl.NotificationServiceImpl;
import ttdl.study.accountservice.model.MessageDTO;


@FeignClient(name = "notification-service", fallback = NotificationServiceImpl.class)
public interface NotificationService {
    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MessageDTO messageDTO);
}
