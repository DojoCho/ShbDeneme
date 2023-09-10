package com.sahibinden.app.Ticket.Controller;

import com.sahibinden.app.Ticket.Dto.Request.TicketCreateDto;
import com.sahibinden.app.Ticket.Dto.Request.TicketUpdateDto;
import com.sahibinden.app.Ticket.Model.Ticket;
import com.sahibinden.app.Ticket.Service.TicketService;
import com.sahibinden.app.Utils.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ticket Controller", description = "Ticket Controller")
@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/create")
    public BaseResponse<Ticket> create(@RequestBody TicketCreateDto ticketCreateDto){
        return ticketService.Create(ticketCreateDto);
    }

    @PutMapping("/update/{id}")
    public BaseResponse<Ticket> update(@PathVariable(value="id") Long id, @RequestBody TicketUpdateDto ticketUpdateDto){
        return ticketService.Update(id, ticketUpdateDto);
    }

    @GetMapping("/soft-delete/{id}")
    public BaseResponse<Ticket> softDelete(@PathVariable(value="id") Long id){
        return ticketService.SoftDelete(id);
    }

    @GetMapping("/list")
    public List<Ticket> list() {
        return ticketService.unDeletedList();
    }
    @GetMapping("/list-deleted")
    public List<Ticket> listDeleted() {
        return ticketService.DeletedList();
    }
}
