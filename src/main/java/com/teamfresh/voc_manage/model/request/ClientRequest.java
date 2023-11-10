package com.teamfresh.voc_manage.model.request;

import lombok.Data;

public class ClientRequest {

    @Data
    public static class Create {
        private String name;
        private String manager;
        private String tel;
    }
}