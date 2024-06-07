package Models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private String surname;
    private String email;
    private Order order;
    private LocalDateTime dateTime;
    private String sector;
}
