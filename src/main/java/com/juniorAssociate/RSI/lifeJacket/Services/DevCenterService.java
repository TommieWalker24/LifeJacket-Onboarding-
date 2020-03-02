package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.DevCenter;
import com.juniorAssociate.RSI.lifeJacket.Repositories.DevCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevCenterService {
        @Autowired
        private DevCenterRepository devCenterRepository;


    public List<DevCenter> getAllDevCenters() {
            return devCenterRepository.findAll();
        }

        public void saveAllDevCenters() {
            List<DevCenter>devCenters = devCenterRepository.findAll();
            devCenterRepository.saveAll(devCenters);
        }

        public List<DevCenter> findAllDevCenters() {
            return devCenterRepository.findAll();
        }

        public DevCenter findByID(String id){
           return devCenterRepository.getOne(id);
          }
        public void deleteDevCenter(String id) {
            devCenterRepository.deleteById(id);
        }

        public void saveDevCenter(String id) {
            DevCenter devCenter = devCenterRepository.getOne(id);
            devCenterRepository.save(devCenter);
        }
    }

