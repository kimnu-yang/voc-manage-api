package com.teamfresh.voc_manage.model.request;

import lombok.Data;

public class CompensationRequest {
    
    @Data
    public static class Create {
        private String detail;
        private Integer amount;
        private Long vocId;
    }
}