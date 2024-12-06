package com.example.application.services;

import com.example.application.data.Company;
import com.example.application.data.CompanyRepository;
import com.example.application.data.Contact;
import com.example.application.data.ContactRepository;
import com.example.application.data.Status;
import com.example.application.data.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
@Service
public class CrmService {

    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;

    public CrmService(ContactRepository contactRepository, CompanyRepository companyRepository, StatusRepository statusRepository) {
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }

    public List<Contact> findAllContacts(String filter) {
        if (filter == null || filter.isBlank()) {
            return contactRepository.findAll();
        }
        return contactRepository.search(filter);
    }

    public long countContacts() {
        return contactRepository.count();
    }

    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    public void saveContact(Contact contact) {
        if (contact == null) {
            System.err.println("Contact is null");
        }
        contactRepository.save(contact);
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    public List<Status> findAllStatuses() {
        return statusRepository.findAll();
    }
}
