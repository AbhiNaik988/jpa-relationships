package com.abhinaik.datajpa.serviceImpl;

import com.abhinaik.datajpa.models.Tablet;
import com.abhinaik.datajpa.repository.TabletRepository;
import com.abhinaik.datajpa.service.TabletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabletServiceImpl implements TabletService {

    private TabletRepository tabletRepository;

    @Autowired
    public void setTabletRepository(TabletRepository tabletRepository){
        this.tabletRepository = tabletRepository;
    }

    @Override
    public void addAllTablets(List<Tablet> tabletList) {
        this.tabletRepository.saveAll(tabletList);
    }

    @Override
    public void deleteTablet(long id) {
        this.tabletRepository.deleteById(id);
    }

    @Override
    public Tablet getTabletByBrand(String brand) {
        return this.tabletRepository.findByBrand(brand);
    }
}
