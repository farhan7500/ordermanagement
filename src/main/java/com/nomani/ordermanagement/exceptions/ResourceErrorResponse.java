package com.nomani.ordermanagement.exceptions;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceErrorResponse {
    private int statusCode;
    private String statusMessage;
    private long timeStamp;
}
