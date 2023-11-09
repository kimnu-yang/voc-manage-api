package com.teamfresh.voc_manage.model.request;

import com.teamfresh.voc_manage.model.enum_data.ArisenFrom;

import lombok.Data;

public class VocRequest {
    
    @Data
    public static class Create {
    
        private String reason;
        private ArisenFrom arisenFrom;
        private Long deliveryId;
    }
}