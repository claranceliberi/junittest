package com.example.classbjunit.controller;

import com.example.classbjunit.model.Contact;
import com.example.classbjunit.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class Contacts {

    private final ContactService contactService;

    @Autowired
    public Contacts(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(contactService.all());
    }

    @GetMapping("/by-mobile-phone/{mobilePhone}")
    public ResponseEntity<?> findByMobilePhone(@PathVariable String mobilePhone) {
        return ResponseEntity.ok(contactService.findByMobilePhone(mobilePhone));
    }

    @GetMapping("/by-work-phone/{workPhone}")
    public ResponseEntity<?> findByWorkPhone(@PathVariable String workPhone) {
        return ResponseEntity.ok(contactService.findByWorkPhone(workPhone));
    }

    @GetMapping("/by-home-phone/{homePhone}")
    public ResponseEntity<?> findByHomePhone(@PathVariable String homePhone) {
        return ResponseEntity.ok(contactService.findByHomePhone(homePhone));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(contactService.findById(id));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Contact contact) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.create(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Contact contact) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(contactService.update(id, contact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {

        contactService.remove(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Removed");
    }
}
