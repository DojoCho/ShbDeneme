package com.sahibinden.app.Ticket.Service;

import com.sahibinden.app.Ticket.Dto.Request.TicketCreateDto;
import com.sahibinden.app.Ticket.Dto.Request.TicketUpdateDto;
import com.sahibinden.app.Ticket.Model.Ticket;
import com.sahibinden.app.Ticket.Repository.TicketRepo;
import com.sahibinden.app.Utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepo ticketRepo;
    public BaseResponse<Ticket> Create(TicketCreateDto ticketCreateDto){
        Ticket newTicket = new Ticket();
        newTicket.setTittle(ticketCreateDto.getTittle());
        ticketRepo.save(newTicket);
        return new BaseResponse<>(true, "OK", newTicket);
    }

    public BaseResponse<Ticket> Update(Long id, TicketUpdateDto ticketUpdateDto){
        Optional<Ticket> updatedTicket = ticketRepo.findById(id);
        if (!updatedTicket.isPresent())
        {
            return new BaseResponse<>(false,"Ticket not found", null);
        }
        updatedTicket.get().setTittle(ticketUpdateDto.getTittle());
        ticketRepo.save(updatedTicket.get());
        return new BaseResponse<>(true,"", updatedTicket.get());
    }
    public BaseResponse<Ticket> SoftDelete(Long id){
        Optional<Ticket> updatedTicket = ticketRepo.findById(id);
        if (!updatedTicket.isPresent())
        {
            return new BaseResponse<>(false,"Ticket not found", null);
        }
        updatedTicket.get().setDeleted(true);
        ticketRepo.save(updatedTicket.get());
        return new BaseResponse<>(true,"", updatedTicket.get());
    }
    public List<Ticket> unDeletedList(){
        return ticketRepo.GetUnDeletedTicket();
    }
    public List<Ticket> DeletedList(){
        return ticketRepo.GetDeletedTicket();
    }

}
