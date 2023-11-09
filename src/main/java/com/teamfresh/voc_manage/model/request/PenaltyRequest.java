package com.teamfresh.voc_manage.model.request;

import lombok.Data;

public class PenaltyRequest {

    @Data
    public static class Create {
        private Integer fine;
        private Long compensationId;
    }
}
