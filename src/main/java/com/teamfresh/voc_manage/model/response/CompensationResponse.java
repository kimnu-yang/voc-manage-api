package com.teamfresh.voc_manage.model.response;

import java.time.LocalDateTime;

import com.teamfresh.voc_manage.model.enum_data.ArisenFrom;

public interface CompensationResponse {

    Long getId();
    Long getVocId();
    Long getDeliveryId();

    String getDetail();

    Integer getAmount();

    ArisenFrom getArisenFrom();
    LocalDateTime getRegDate();
}