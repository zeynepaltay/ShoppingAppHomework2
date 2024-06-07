package Models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private Integer amount;
    private Order order;
    private Customer customer;
    private LocalDateTime dateTime;

}
