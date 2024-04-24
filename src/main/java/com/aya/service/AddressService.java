package com.aya.service;

import com.aya.dto.AddressDTO;
import com.aya.dto.WeatherDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> findAll();

    AddressDTO findById(Long id) throws Exception;

    AddressDTO update(AddressDTO addressDTO) throws Exception;

    AddressDTO create(AddressDTO addressDTO) throws Exception;

    WeatherDTO getCurrentWeather(String city);

}
