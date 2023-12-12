package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Subject;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Subject}
 */
public interface SubjectService {
    public List<Subject> getAllSubjects();
    public Subject getSubject(Long id) throws DBObjectNotFoundException;
    public Subject saveSubject(Subject subject);

    /**
     * Function returns {@link Subject} object only with following values populated if not null:
     * - Id
     * - FirstName
     * - MiddleName
     * - LastName
     * - Birth
     *
     * @param id An ID of the {@link Subject} object
     * @return {@link Subject} object populated only with values described above or null
     * @throws DBObjectNotFoundException
     */
    public Subject getSubjectTruncated(Long id) throws DBObjectNotFoundException;
    public Set<Subject> getSubjectsTruncated(Set<Long> ids);
}
