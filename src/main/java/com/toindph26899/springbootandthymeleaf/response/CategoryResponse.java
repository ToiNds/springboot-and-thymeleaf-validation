package com.toindph26899.springbootandthymeleaf.response;

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
public class CategoryResponse {

    private Long id;

    private String categoryCode;

    private String categoryName;

}
