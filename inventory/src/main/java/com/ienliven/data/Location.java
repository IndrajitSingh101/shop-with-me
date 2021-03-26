package com.ienliven.data;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String type;
    private Double latitude;
    private Double longitude;
}
