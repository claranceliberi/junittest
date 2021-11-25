package com.example.classbjunit.service;
import com.example.classbjunit.model.Contact;
import com.example.classbjunit.repository.ContactRepository;
import com.example.classbjunit.service.impl.ContactServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    @Test
    public void all_test() {
        when(contactRepository.findAll()).thenReturn(Arrays.asList(new Contact(1L, "Kaisa", "+250783384212"), new Contact(2L, "Mugabe", "+250")));

        assertEquals("Mugabe", contactService.all().get(1).getFirstName());
    }

    @Test
    public void findByMobilePhone_test() {
        when(contactRepository.findByMobilePhone(anyString())).thenReturn(Optional.of(new Contact(1L, "Kaisa", "+250783384212")));

        assertEquals("Kaisa", contactService.findByMobilePhone("+250783384212").getFirstName());
    }

    @Test
    public void findByWorkPhone_test() {
        when(contactRepository.findByWorkPhone(anyString())).thenReturn(Arrays.asList(new Contact(1L, "Kaisa", "+250783384212"), new Contact(2L, "Mugabe", "+250")));

        assertEquals("Mugabe", contactService.findByWorkPhone("+250783384212").get(1).getFirstName());
    }

    @Test
    public void findByHomePhone_test() {
        when(contactRepository.findByHomePhone(anyString())).thenReturn(Arrays.asList(new Contact(1L, "Kaisa", "+250783384212"), new Contact(2L, "Mugabe", "+250")));

        assertEquals("Mugabe", contactService.findByHomePhone("+250783384212").get(1).getFirstName());
    }

    @Test
    public void findById_test() throws Exception {
        when(contactRepository.findById(anyLong())).thenReturn(Optional.of(new Contact(1L, "Kaisa", "+250783384212")));

        assertEquals("Kaisa", contactService.findById(1L).getFirstName());
    }

    @Test
    public void findById_testFail() throws Exception {
        when(contactRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException
                .class, () -> {
            contactService.findById(1L);
        });

        String expectedMessage = "Contact with Id not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void create_test() {
        when(contactRepository.save(any(Contact.class))).thenReturn(new Contact(1L, "Kaisa", "+250783384212"));

        assertEquals("Kaisa", contactService.create(new Contact()).getFirstName());
    }

    @Test
    public void update_test() {
        when(contactRepository.existsById(anyLong())).thenReturn(true);
        when(contactRepository.save(any(Contact.class))).thenReturn(new Contact(1L, "Kaisa", "+250783384212"));

        Contact updated = contactService.update(1L, new Contact());

        assertEquals("Kaisa", updated.getFirstName());
    }
}
