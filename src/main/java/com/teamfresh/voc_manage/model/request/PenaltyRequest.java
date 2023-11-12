package com.teamfresh.voc_manage.model.request;

import java.time.LocalDateTime;

import com.teamfresh.voc_manage.model.enum_data.ConfirmStatus;

import lombok.Data;

public class PenaltyRequest {

    @Data
    public static class Create {
        private Integer fine;
        private Long compensationId;
    }

    @Data
    public static class Confirm {
        private ConfirmStatus confirmStatus;
        private String comment;
        private LocalDateTime confDate;
    }
}
