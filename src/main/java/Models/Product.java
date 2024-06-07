package Models;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    private Integer amount;
    private Integer stock;

}
