package Models;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderNo;
    private  Product product;
    private Integer amount;

}
