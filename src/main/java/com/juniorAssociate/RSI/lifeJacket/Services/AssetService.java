package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Asset;
import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import com.juniorAssociate.RSI.lifeJacket.Repositories.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

        //public Optional<Role> findByID(){
        //   return roleRepository.findById();
        //  }
        public void deleteAsset(Asset asset) {
            assetRepository.delete(asset);
        }

        public void saveAsset(Asset asset) {
            assetRepository.save(asset);
        }
    }

