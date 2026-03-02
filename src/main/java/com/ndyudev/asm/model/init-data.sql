-- ==============================================================
-- TẠO DATABASE (nếu chưa có)
-- ==============================================================
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'infinity_digital_ecom')
BEGIN
    CREATE DATABASE infinity_digital_ecom;
END
GO

USE infinity_digital_ecom;
GO

-- ==============================================================
-- TẠO BẢNG Products (dựa theo Product.java)
-- ==============================================================
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Products')
BEGIN
    CREATE TABLE Products (
        id          BIGINT IDENTITY(1,1) PRIMARY KEY,   -- @Id @GeneratedValue
        name        NVARCHAR(255)    NULL,               -- String name
        image       NVARCHAR(500)    NULL,               -- String image
        price       FLOAT            NULL,               -- Double price
        CreateDate  DATE             DEFAULT GETDATE(),  -- @Column(name="CreateDate") LocalDate
        available   BIT              NULL,               -- Boolean available (0=còn hàng, 1=hết hàng)
        quantity    INT              NULL,               -- Integer quantity
        isActive    BIT              NULL                -- Boolean isActive (true=hiện, false=ẩn)
    );
END
GO

-- ==============================================================
-- INSERT 10 RECORDS MẪU
-- ==============================================================
IF NOT EXISTS (SELECT 1 FROM Products)
BEGIN
    INSERT INTO Products (name, image, price, CreateDate, available, quantity, isActive) VALUES
    (N'Laptop Acer Aspire 5',       'https://via.placeholder.com/80?text=Laptop',    2345.0,  '2026-01-01', 0, 21,  1),
    (N'Laptop Dell Inspiron 15',    'https://via.placeholder.com/80?text=Dell',       4569.0,  '2026-01-05', 0, 19,  1),
    (N'Áo sơ mi nam',               'https://via.placeholder.com/80?text=Shirt',      3000.0,  '2026-01-10', 0, 100, 1),
    (N'Áo trẻ em',                  'https://via.placeholder.com/80?text=Kid',        1200.0,  '2026-01-12', 0, 45,  1),
    (N'Bếp từ đôi',                 'https://via.placeholder.com/80?text=Bep',        2000.0,  '2026-01-15', 0, 25,  1),
    (N'Tai nghe Sony WH-1000XM5',   'https://via.placeholder.com/80?text=Sony',       350.0,   '2026-01-20', 0, 30,  1),
    (N'Điện thoại Samsung Galaxy',  'https://via.placeholder.com/80?text=Samsung',    799.0,   '2026-01-22', 0, 50,  1),
    (N'Bàn phím cơ Keychron K2',    'https://via.placeholder.com/80?text=Keyboard',   120.0,   '2026-01-25', 0, 60,  1),
    (N'Chuột Logitech MX Master 3', 'https://via.placeholder.com/80?text=Mouse',      99.0,    '2026-01-28', 0, 80,  1),
    (N'Màn hình LG 27 inch 4K',     'https://via.placeholder.com/80?text=Monitor',    450.0,   '2026-02-01', 0, 15,  1);
END
GO

-- ==============================================================
-- UPDATE ẢNH THÀNH FILE TRONG /static (phone1.jpg ... phone10.jpg)
-- Chạy lại nếu image vẫn còn là placeholder
-- ==============================================================
UPDATE Products SET image = 'phone1.jpg'  WHERE id = 1;
UPDATE Products SET image = 'phone2.jpg'  WHERE id = 2;
UPDATE Products SET image = 'phone3.jpg'  WHERE id = 3;
UPDATE Products SET image = 'phone4.jpg'  WHERE id = 4;
UPDATE Products SET image = 'phone5.jpg'  WHERE id = 5;
UPDATE Products SET image = 'phone6.jpg'  WHERE id = 6;
UPDATE Products SET image = 'phone7.jpg'  WHERE id = 7;
UPDATE Products SET image = 'phone8.jpg'  WHERE id = 8;
UPDATE Products SET image = 'phone9.jpg'  WHERE id = 9;
UPDATE Products SET image = 'phone10.jpg' WHERE id = 10;
GO

-- ==============================================================
-- KIỂM TRA KẾT QUẢ
-- ==============================================================
SELECT * FROM Products;
GO
