package br.com.computocell.helpdesk.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.computocell.helpdesk.api.security.entity.ChangeStatus;

public interface ChageStatusRepository extends MongoRepository<ChangeStatus, String> {
//    Iterable<ChangeStatus> findbyTicketIdOrderByDateChangeStatusDesc(String tickedId);
    List<ChangeStatus> findbyTicketIdOrderByDateChangeStatusDesc(String tickedId);
    
}
