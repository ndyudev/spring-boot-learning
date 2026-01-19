package com.ndyudev.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Staff {
    @Builder.Default
    private String id = "chauunhatduyyit@gmail.com";

    @Builder.Default
    private String fullName = "Châu Nhật Duy";

    @Builder.Default
    private String photo = "anime.jpg";

    @Builder.Default
    private Boolean gender = true;

    @Builder.Default
    private Date birthday = new Date();

    @Builder.Default
    private Double salary = 123467.68;

    @Builder.Default
    private Integer level = 0;
}