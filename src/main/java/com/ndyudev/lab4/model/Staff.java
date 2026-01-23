package com.ndyudev.lab4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @NotBlank(message = "Chưa nhập email")
    @Email(message = "Email không đúng định dạng")
    private String id;
    @NotBlank(message = "Chưa nhập họ và tên")
    private String fullName;

    @Builder.Default
    private String photo = "photo.jpg";

    @Builder.Default
    @NotNull(message = "Chưa chọn giới tính")
    private Boolean gender = true;

    @Builder.Default
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Chưa nhập ngày sinh")
    @Past(message = "Ngày sinh không hợp lệ")
    private Date birthday = new Date();

    @Builder.Default
    @Min(value = 1000, message = "Lương tối thiểu phải là 1000")
    @NotNull(message = "Chưa nhập lương")
    private Double salary = 12345678.0;

    @Builder.Default
    private Integer level = 0;
}