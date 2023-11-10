package com.teamfresh.voc_manage.model.response;

import java.time.LocalDateTime;

public interface CompensationResponse {

    Long getId();
    Long getVocId();

    String getDetail();

    Integer getAmount();

    LocalDateTime getRegDate();
}