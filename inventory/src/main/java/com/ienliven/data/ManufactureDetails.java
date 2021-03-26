package com.ienliven.data;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManufactureDetails {
    private String manufacturingCompany;
    private String address;
}
