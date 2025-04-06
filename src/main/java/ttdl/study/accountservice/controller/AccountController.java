package ttdl.study.accountservice.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ttdl.study.accountservice.client.NotificationService;
import ttdl.study.accountservice.client.StatisticService;
import ttdl.study.accountservice.model.AccountDTO;
import ttdl.study.accountservice.model.MessageDTO;
import ttdl.study.accountservice.model.StatisticDTO;
import ttdl.study.accountservice.service.AccountService;


@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final StatisticService statisticService;
    private final NotificationService notificationService;

    // add new
    @PostMapping("/account")
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
        accountService.add(accountDTO);
        statisticService.add(
                StatisticDTO.builder()
                        .message("Account " + accountDTO.getUsername() + " is created at")
                        .createdDate(LocalDateTime.now()).build());
        MessageDTO messageDTO=new MessageDTO();
        messageDTO.setFrom("duytuongkhmt@gmail.com");
        messageDTO.setTo("torinbk02@gmail.com");
        messageDTO.setToName("Tô Tường");
        messageDTO.setSubject("Testing");
        messageDTO.setContent("Hello");
        notificationService.sendNotification(messageDTO);
        return accountDTO;
    }

    // get all
    @GetMapping("/accounts")
    public List<AccountDTO> getAll() {
        statisticService.add(StatisticDTO.builder().message("Get all account").createdDate(LocalDateTime.now()).build());
        return accountService.getAll();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable(name = "id") Long id) {
        statisticService.add(StatisticDTO.builder().message("Get all account").createdDate(LocalDateTime.now()).build());
        return Optional.of(new ResponseEntity<>(accountService.getOne(id), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        accountService.delete(id);
    }

    @PutMapping("/account")
    public void update(@RequestBody AccountDTO accountDTO) {
        accountService.update(accountDTO);
    }

}
