package ttdl.study.accountservice.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticDTO {
    private Long id;
    @NotNull
    private String message;
    @NotNull
    private LocalDateTime createdDate;
}
