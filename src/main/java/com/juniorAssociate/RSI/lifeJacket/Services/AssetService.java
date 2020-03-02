package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Asset;
import com.juniorAssociate.RSI.lifeJacket.Repositories.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class AssetService {
    //todo: find correct user then insert or update
    //todo: for update join by username/email to insert/edit

        @Autowired
        private AssetsRepository assetRepository;


    public List<Asset> getAllAssets() {
            return assetRepository.findAll();
        }

        public void saveAllAssets() {
            List<Asset> assets = assetRepository.findAll();
            assetRepository.saveAll(assets);
        }

        public List<Asset> findAllAssets() {
            return assetRepository.findAll();
        }
        public Asset findByID(Long id){
           return assetRepository.getOne(id);
          }
        public void deleteAsset(Long id) {
             assetRepository.deleteById(id);
        }

        public void saveAsset(Long id) {
            Asset asset = assetRepository.getOne(id);
            assetRepository.save(asset);
        }
    }

