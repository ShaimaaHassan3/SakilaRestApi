package com.myapi.persistence.repositoryImp.address;

import com.myapi.persistence.entities.address.City;
import com.myapi.persistence.repository.address.CityRepo;
import com.myapi.persistence.repositoryImp.BaseRepoImp;

public class CityRepoImp extends BaseRepoImp<City> implements CityRepo {

    @Override
    public City getCityById(int ID) {
        return getById(ID);
    }
}
