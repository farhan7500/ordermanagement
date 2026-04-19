package com.nomani.ordermanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderManagementErrorResponse {
    private int statusCode;
    private String errorMessage;
    private long timeStamp;
}
