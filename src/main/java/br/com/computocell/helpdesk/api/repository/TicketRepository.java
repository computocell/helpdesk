package br.com.computocell.helpdesk.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.computocell.helpdesk.api.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket,String> {
    Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String id);

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
            String title, String status, String priority, Pageable pages );

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
            String title, String status,  String priority,Pageable pages);

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAndAssignedUserIdOrderByDateDesc(
            String title, String status,  String priority,Pageable pages);

    Page<Ticket> findByNumber(Integer number,Pageable pages);
}
