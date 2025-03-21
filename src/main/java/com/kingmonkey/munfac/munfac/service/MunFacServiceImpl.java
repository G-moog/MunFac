package com.kingmonkey.munfac.munfac.service;

import com.kingmonkey.munfac.munfac.Entity.Munjae;
import com.kingmonkey.munfac.munfac.dto.MunDTO;
import com.kingmonkey.munfac.munfac.repository.MunFacRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MunFacService")
public class MunFacServiceImpl implements MunFacService {

    private final MunFacRepository munFacRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MunFacServiceImpl(MunFacRepository munFacRepository, ModelMapper modelMapper) {
        this.munFacRepository = munFacRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public int createMun(MunDTO munDTO) throws Exception {

        Munjae munjae = modelMapper.map(munDTO, Munjae.class);
        Object returnObject = munFacRepository.save(munjae);

        if(returnObject == null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public int updateMun(MunDTO munDTO) throws Exception {
        return 0;
    }

    @Override
    public int deleteMun(MunDTO munDTO) throws Exception {
        return 0;
    }

    @Override
    public int selectMun(MunDTO munDTO) throws Exception {
        return 0;
    }
}
