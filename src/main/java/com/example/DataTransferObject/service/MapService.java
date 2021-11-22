package com.example.DataTransferObject.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.DataTransferObject.dto.UserLocationDTO;
import com.example.DataTransferObject.model.Location;
import com.example.DataTransferObject.model.User;
import com.example.DataTransferObject.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    public List<UserLocationDTO> getAllUserLocation() {
        return ((List<User>) userRepository
            .findAll())
            .stream()
            .map(this::convertToUserLocationDTO)
            .collect(Collectors.toList());
    }

    private UserLocationDTO conveToUserLocationDTO(User user){
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUserId(user.getId());
        userLocationDTO.setUsername(user.getUsername());
        Location location = user.getLocation();
        userLocationDTO.setLat(location.getLat());
        userLocationDTO.setLng(location.getLng());
        userLocationDTO.setPlace(location.getPlace());
        return userLocationDTO;
    }

    private UserLocationDTO convertToUserLocationDTO(User user){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO = mapper.map(user, UserLocationDTO.class);
        return userLocationDTO;
    }
}
