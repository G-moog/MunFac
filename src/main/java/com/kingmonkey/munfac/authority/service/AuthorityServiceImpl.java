package com.kingmonkey.munfac.authority.service;

import com.kingmonkey.munfac.authority.dto.AuthorityDTO;
import com.kingmonkey.munfac.authority.entity.Authority;
import com.kingmonkey.munfac.authority.repository.AuthorityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private final AuthorityRepository authorityRepository;
    private final ModelMapper modelMapper ;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository, ModelMapper modelMapper) {
        this.authorityRepository = authorityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorityDTO getAuth(int authNo) {
        Authority authority = authorityRepository.findByAuthNo(authNo);

        return modelMapper.map(authority, AuthorityDTO.class);
    }
}
