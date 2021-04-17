package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GradeService extends AbstractService<Grade,String>{
    protected GradeService(GradeRepository repository) {
        super(repository);
    }

    @Autowired
    GradeRepository gradeRepository;

    public List<Grade> getAll() {
        return gradeRepository.getAll();
    }
}
