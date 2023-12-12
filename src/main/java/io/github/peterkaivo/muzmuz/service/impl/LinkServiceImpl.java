package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.LinkRepository;
import io.github.peterkaivo.muzmuz.repository.model.DLink;
import io.github.peterkaivo.muzmuz.service.LinkService;
import io.github.peterkaivo.muzmuz.service.model.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class LinkServiceImpl implements LinkService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LinkService.class);

    @Autowired
    LinkRepository linkRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Link> getAllLinks() {
        List<DLink> dLinks = (List<DLink>) linkRepository.findAll();

        return dLinks.stream().map(this::fromDLink).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Link getLink(Long id) throws DBObjectNotFoundException {
        DLink dLink = linkRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DLink.class, id));

        return fromDLink(dLink);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Link> getLinkSet(Set<Long> ids) {
        Set<Link> links = new HashSet<>();

        for (Long id : ids) {
            try {
                links.add(getLink(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getLinkSet() - DB inconsistency found for DLink with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return links;
    }

    @Override
    public Link saveLink(Link link) {
        linkRepository.save(toDLink(link));

        return link;
    }

    private Link fromDLink(DLink dLink) {
        Link link = new Link();
        link.setId(dLink.getId());
        link.setName(dLink.getName());
        link.setFileName(dLink.getFileName());
        link.setDescription(dLink.getDescription());
        link.setComments(dLink.getComments());
        link.setUrl(dLink.getUrl());

        return link;
    }

    private DLink toDLink(Link link) {
        DLink dLink = new DLink();
        dLink.setId(link.getId());
        dLink.setName(link.getName());
        dLink.setFileName(link.getFileName());
        dLink.setDescription(link.getDescription());
        dLink.setComments(link.getComments());
        dLink.setUrl(link.getUrl());

        return dLink;
    }
}
