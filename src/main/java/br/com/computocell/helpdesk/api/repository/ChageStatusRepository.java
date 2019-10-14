package br.com.computocell.helpdesk.api.repository;

import br.com.computocell.helpdesk.api.entity.ChangeStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChageStatusRepository extends MongoRepository<ChangeStatus, String> {
    Iterable<ChangeStatus> findbyTicketIdOrderByDateChangeStatusDesc(String tickedId);
}
