package com.example.classbjunit.Repository;

import com.example.classbjunit.model.Contact;
import com.example.classbjunit.repository.ContactRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

@DataJpaTest
@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContactsRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @BeforeAll
    public void insertData(){
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(109L,"Kai","0718888881"));
        contacts.add(new Contact("Harv","Kai","0783384212"));
        contacts.add(new Contact("Name","Kai","0783384212"));
        contacts.add(new Contact("Fiston","Kai","0783384212"));
        contacts.add(new Contact("Shuni","Kai","0718888081"));
        contacts.add(new Contact("Never","Kai","0718808881"));
        contacts.add(new Contact("Shams","Kai","0728888881"));
        contacts.add(new Contact(103L,"Kai","07188838881"));
        contacts.add(new Contact(104L,"Kai","0710888881"));
        contacts.add(new Contact(105L,"Kai","0718888081"));
        contacts.add(new Contact(106L,"Kai","0718889881"));
        contacts.add(new Contact(107L,"Kai","0718888581"));
        contacts.add(new Contact(108L,"Kai","0718088881"));
        contacts.add(new Contact(110L,"Kai","0718888481"));

        contactRepository.saveAll(contacts);
    }

    @Test
    public void findAll_test() {
        List<Contact> contacts = contactRepository.findAll();
        System.out.println("-------------------- hey");
        for(Contact contact: contacts){
            System.out.println(contact.getFirstName());
        }
        assertEquals(contacts.size(), 14);
    }

    @Test
    public void findById_test() {
        Optional<Contact> contact = contactRepository.findById(109L);

        if (!contact.isPresent())
            fail("User with this id is not found");

        assertEquals(contact.get().getMobilePhone(), "0718888881");
    }

    @Test
    public void findByMobilePhone_test() {
        Optional<Contact> contact = contactRepository.findByMobilePhone("0718888881");

        if (!contact.isPresent())
            fail("User with this mobile phone number is not found");

        assertEquals(contact.get().getId(), Long.valueOf(109));
    }

    @Test
    public void findByWorkPhone_test() {
        List<Contact> contacts = contactRepository.findByWorkPhone("0783384212");

        assertEquals(contacts.size(), 3);
    }

    @Test
    public void findByHomePhone_test() {
        List<Contact> contacts = contactRepository.findByHomePhone(null);

        assertEquals(contacts.size(), 14);
    }

    @Test
    public void remove_test(){
        contactRepository.deleteById(109L);

        List<Contact> contacts = contactRepository.findAll();

        // it would be 14 but I removed 1 now remaining 13

        assertEquals(contacts.size(), 13);
    }
}
