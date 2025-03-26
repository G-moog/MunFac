package com.kingmonkey.munfac.authority.service;

import com.kingmonkey.munfac.authority.dto.AuthorityDTO;
import com.kingmonkey.munfac.authority.entity.Authority;
import com.kingmonkey.munfac.authority.repository.AuthorityRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private static final Logger log = LoggerFactory.getLogger(AuthorityServiceImpl.class);
    private final AuthorityRepository authorityRepository;
    private final ModelMapper modelMapper ;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository, ModelMapper modelMapper) {
        this.authorityRepository = authorityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorityDTO getAuth(int authNo) {
        Optional<Authority> authority = authorityRepository.findById(authNo);
        log.info("[AuthorityServiceImpl] getAuth. Optional<Authority> authority : " + authority.toString());

        return modelMapper.map(authority, AuthorityDTO.class);
    }
}
