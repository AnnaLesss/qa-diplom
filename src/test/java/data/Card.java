package data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Card {
    private String number;
    private String months;
    private String year;
    private String name;
    private String cvc;
}

