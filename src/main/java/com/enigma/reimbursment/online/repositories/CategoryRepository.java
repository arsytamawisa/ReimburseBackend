package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
