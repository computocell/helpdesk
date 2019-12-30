package br.com.computocell.helpdesk.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.computocell.helpdesk.api.repository.ChangeStatusRepository;
import br.com.computocell.helpdesk.api.repository.TicketRepository;
import br.com.computocell.helpdesk.api.security.entity.ChangeStatus;
import br.com.computocell.helpdesk.api.security.entity.Ticket;
import br.com.computocell.helpdesk.api.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	private ChangeStatusRepository changeStatusRepository;
	
	@Override
	public Ticket createdOrUpdate(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(String id) {
		
		return this.ticketRepository.findOne(id);
	}

	@Override
	public void delete(String id) {
		this.ticketRepository.delete(id);
		
	}

	@Override
	public Page<Ticket> listTicket(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findAll(pages);
	}

	@Override
	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return this.changeStatusRepository.save(changeStatus);
	}

	@Override
	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		
		return this.changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
	}

	@Override
	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByUserIdOrderByDateDesc(pages, userId);
	}

	@Override
	public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
		Pageable pages = new PageRequest(page, count);
		
		return this.ticketRepository.
				findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(title, status, priority, pages);
	}

	@Override
	public Page<Ticket> findByParametersAncCurrentUser(int page, int count, String title, String status,
			String priority, String userId) {
		Pageable pages = new PageRequest(page, count);
		
		return this.ticketRepository.
				findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndUserIdOrderByDateDesc(title, status, priority, userId, pages);
	}

	@Override
	public Page<Ticket> findByNumber(int page, int count, Integer number) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByNumber(number, pages);
	}

	@Override
	public Iterable<Ticket> findAll() {
		
		return this.ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, String status,
			String priority, String assignedUser) {
		Pageable pages = new PageRequest(page, count);
		
		return this.ticketRepository.
				findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndAssignedUserIdOrderByDateDesc(title, status, priority, assignedUser, pages);
	}

}
