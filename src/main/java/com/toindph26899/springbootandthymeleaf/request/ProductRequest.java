package com.toindph26899.springbootandthymeleaf.request;

import com.toindph26899.springbootandthymeleaf.validation.PriceValidation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductRequest {

    private Long id;

    @NotNull(message = "Ban chua ban Category")
    private Long categoryId;

    private Long statusId;

    @NotNull(message = "Ban chua ban Company")
    private Long companyId;

    @NotNull(message = "Khong duoc bo trong, Vui long nhap product code")
    @Size(min = 1, message = "Vui long khong bo trong")
    private String productCode;

    @NotNull(message = "Khong duoc bo trong, Vui long nhap product name")
    @Size(min = 1, message = "Vui long khong bo trong")
    private String productName;

    @NotNull(message = "Khong duoc bo trong, Vui long nhap color")
    @Size(min = 1, message = "Vui long khong bo trong")
    private String color;

    @NotNull(message = "Khong duoc bo trong, Vui long nhap quantity")
    @Min(value = 1, message = "So luong phai la so nguyen duong")
    @Max(value = 99999, message = "So luong khong duoc qua 99999")
    private Long quantity;

    @NotNull(message = "Khong duoc bo trong, Vui long nhap description")
    @Size(min = 1, message = "Vui long khong bo trong")
    private String description;

    @NotNull(message = "Khong duoc bo trong, Vui long nhap origin price")
    @Min(value = 1)
    private Double originPrice;

    @NotNull(message = "Khong duoc bo trong, Vui long nhap sell price")
    @Min(value = 1, message = "Gia ban khong duoc nho hon gia goc")
    private Double sellPrice;

}
