package com.teamfresh.voc_manage.model.request;

import lombok.Data;

public class DeliveryRequest {

    @Data
    public static class Create {
        private String detail;
        private Long clientId;
        private Long workerId;
    }
}