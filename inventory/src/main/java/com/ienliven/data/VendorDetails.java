package com.ienliven.data;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorDetails {
    private String vendorName;
    private String address;
    private Location location;
}
