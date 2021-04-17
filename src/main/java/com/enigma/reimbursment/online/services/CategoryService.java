package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.entities.Role;
import com.enigma.reimbursment.online.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Category,String> {

    @Autowired
    protected CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
