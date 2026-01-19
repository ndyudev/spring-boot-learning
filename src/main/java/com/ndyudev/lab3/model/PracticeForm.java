package com.ndyudev.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PracticeForm {
    // Biến hứng giá trị từ Select Box (Dòng 1)
    private String staffIdForSelect;

    // Biến hứng giá trị từ Radio Group (Dòng 2)
    private String staffIdForRadio;

    // Biến hứng danh sách sở thích
    private List<String> hobbies;
}