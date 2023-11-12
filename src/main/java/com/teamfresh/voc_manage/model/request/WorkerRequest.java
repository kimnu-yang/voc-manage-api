package com.teamfresh.voc_manage.model.request;

import lombok.Data;

public class WorkerRequest {

    @Data
    public static class Create {
        private String name;
        private String contact;
        private Long transportId;
    }
}