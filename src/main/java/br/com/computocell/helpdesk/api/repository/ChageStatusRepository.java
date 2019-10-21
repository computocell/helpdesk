package br.com.computocell.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.computocell.helpdesk.api.entity.ChangeStatus;

public interface ChageStatusRepository extends MongoRepository<ChangeStatus, String> {
    Iterable<ChangeStatus> findbyTicketIdOrderByDateChangeStatusDesc(String tickedId);
}
