package com.avalah.clientlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avalah.clientlist.model.Client;
import com.avalah.clientlist.model.User;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {
	public List<Client> findByUser(User user);
}
