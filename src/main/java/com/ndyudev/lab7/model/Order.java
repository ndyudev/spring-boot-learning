package com.ndyudev.lab7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Address") // Nên map rõ ràng cho chắc
    private String address;

    // 👇 THÊM DÒNG NÀY ĐỂ KHỚP VỚI SQL 'CreateDate'
    @Column(name = "CreateDate")
    private LocalDate createAt = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "Username") // Sửa 'username' thành 'Username' cho khớp SQL (tùy chọn)
    private Account account;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    // ... Constructor giữ nguyên
}
