package com.sparta.spartahomework.dto;

import com.sparta.spartahomework.entity.StatusEnum;
import lombok.Data;

@Data
public class StatusDto {
    private StatusEnum status;
    private String message;
    private Object data;

    public StatusDto() {
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }

    public void ChangeDto(StatusEnum status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
