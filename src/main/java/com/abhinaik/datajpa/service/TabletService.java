package com.abhinaik.datajpa.service;

import com.abhinaik.datajpa.models.Tablet;

import java.util.List;

public interface TabletService {
    void addAllTablets(List<Tablet> tabletList);

    void deleteTablet(long id);

    Tablet getTabletByBrand(String brand);
}
