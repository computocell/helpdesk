package br.com.computocell.helpdesk.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.computocell.helpdesk.api.security.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {
	/**
	 * Retorna um ticket por usuario.
	 * 
	 * @param pages
	 * @param userId
	 * @return
	 */
	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String userId);
	/**
	 * Retorna um ticket por parametros
	 * 
	 * @param title
	 * @param status
	 * @param priority
	 * @param pages
	 * @return
	 */
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(String title, String status, String priority, Pageable pages);
	/**
	 * Retorna um ticket por parametros de acordo com o usuario logado
	 * 
	 * @param title
	 * @param status
	 * @param priority
	 * @param userId
	 * @param pages
	 * @return
	 */
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndUserIdOrderByDateDesc(String title, String status, String priority, String userId, Pageable pages);
	/**
	 * Retorna um ticket pelo numero
	 * @param number
	 * @param pages
	 * @return
	 */
	Page<Ticket> findByNumber(Integer number, Pageable pages);
	/**
	 * 
	 * 
	 * @param title
	 * @param status
	 * @param priority
	 * @param assignedUser
	 * @param pages
	 * @return
	 */
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndAssignedUserIdOrderByDateDesc(
			String title, String status, String priority, String assignedUser, Pageable pages);
}
