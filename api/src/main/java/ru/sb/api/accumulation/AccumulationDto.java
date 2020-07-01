package ru.sb.api.accumulation;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccumulationDto {

    private Integer id;

    @NotNull
    private Integer ownerId;

    @NotEmpty
    private String name;

    @NotNull
    private double amount;

    @NotEmpty
    private String currency;

    private Date start_date;

    private Date valid_date;

    private double rate;

}
