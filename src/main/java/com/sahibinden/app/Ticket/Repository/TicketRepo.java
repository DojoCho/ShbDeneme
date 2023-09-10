package com.sahibinden.app.Ticket.Repository;

import com.sahibinden.app.Ticket.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    @Query("select c from Ticket c where c.isDeleted = false")
    public List<Ticket> GetUnDeletedTicket();

    @Query("select c from Ticket c where c.isDeleted = true")
    public List<Ticket> GetDeletedTicket();

}
