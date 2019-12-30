package br.com.computocell.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.computocell.helpdesk.api.security.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {
	/**
	 * Lista de alterações por id do ticket
	 * @param ticketId
	 * @return
	 */
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);

}
