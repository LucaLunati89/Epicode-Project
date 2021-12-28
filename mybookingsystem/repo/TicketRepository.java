package it.mybookingsystem.repo;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.mybookingsystem.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
public List<Ticket> findByUserIdAndEmissionDate(long userId, LocalDate emissionDate);
}
