package com.teamfresh.voc_manage.model.response;

import java.time.LocalDateTime;

import com.teamfresh.voc_manage.model.enum_data.ArisenFrom;
import com.teamfresh.voc_manage.model.enum_data.ConfirmStatus;

public interface VocResponse {

    Long getId();
    Long getDeliveryId();
    Long getClientId();
    Long getTransportId();
    Long getWorkerId();

    String getReason();
    String getCompensationDetail();

    Integer getCompensationAmount();
    Integer getFine();

    LocalDateTime getRegDate();

    ArisenFrom getArisenFrom();
    ConfirmStatus getWorkerConfirm();
}