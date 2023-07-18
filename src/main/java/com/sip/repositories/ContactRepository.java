package com.sip.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sip.entities.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long>, 
JpaSpecificationExecutor<Contact> {
}