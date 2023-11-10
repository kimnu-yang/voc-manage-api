package com.teamfresh.voc_manage.model.request;

import java.util.List;

import lombok.Data;

@Data
public class BookLendRequest {
    private List<Long> bookIds;
    private Long memberId;
    public Long getBookId() {
        return null;
    }
}
