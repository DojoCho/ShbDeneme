package com.sahibinden.app.Ticket.Dto.Request;

public class TicketCreateDto {

    private String tittle;
    private String message;
    private Long UserID;
    private Integer status;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
