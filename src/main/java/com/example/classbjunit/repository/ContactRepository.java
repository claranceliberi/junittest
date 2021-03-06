package com.example.classbjunit.repository;

import com.example.classbjunit.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findByMobilePhone(String mobilePhone);

    List<Contact> findByWorkPhone(String workPhone);

    List<Contact> findByHomePhone(String homePhone);
}