package com.memento.service.impl;

import com.memento.model.City;
import com.memento.repository.CityRepository;
import com.memento.service.CityService;
import com.memento.shared.exception.BadRequestException;
import com.memento.shared.exception.ResourceNotFoundException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Primary
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Set<City> getAll() {
        return Set.copyOf(cityRepository.findAll());
    }

    @Override
    @Transactional
    public City save(@NonNull final City city) {
        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public City update(@NonNull final Long id, @NonNull final City city) {
        if (!id.equals(city.getId())) {
            throw new BadRequestException(String.format("Идентефикаторите не съвпадат. Първият е %d. Вторият е %d", id, city.getId()));
        }

        final City oldCity = findById(id);
        oldCity.getNeighborhoods().clear();

        final City newCity = City.builder()
                .id(oldCity.getId())
                .name(city.getName())
                .neighborhoods(city.getNeighborhoods())
                .build();

        return cityRepository.save(newCity);
    }

    @Override
    public City findById(@NonNull final Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Град с идентификатор %d не съществува", id)));
    }
}
