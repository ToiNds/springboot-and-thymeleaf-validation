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
@ToString
@Builder
public class CompanyResponse {

    private Long id;

    private String companyCode;

    private String companyName;

}
