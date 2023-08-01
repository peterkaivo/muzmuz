package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Subject;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Subject}
 */
public interface SubjectService {
    public List<Subject> getAllSubjects();
    public Subject getSubject(Long id) throws ItemNotFoundException;
    public Subject saveSubject(Subject acquisition);
}
