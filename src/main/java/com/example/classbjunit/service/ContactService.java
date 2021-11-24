package com.example.classbjunit.service;

import com.example.classbjunit.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> all();

    Contact findByMobilePhone(String mobilePhone);

    List<Contact> findByWorkPhone(String workPhone);

    List<Contact> findByHomePhone(String homePhone);

    Contact findById(Long id);

    Contact create(Contact contact);

    Contact update(Long id, Contact contact);

    void remove(Long id);

    boolean existsById(Long id);
}
