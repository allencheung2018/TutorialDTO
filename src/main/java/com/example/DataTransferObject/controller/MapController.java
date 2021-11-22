package com.example.DataTransferObject.controller;

import java.util.List;

import com.example.DataTransferObject.dto.UserLocationDTO;
import com.example.DataTransferObject.service.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping("/map")
    @ResponseBody
    public List<UserLocationDTO> getAllUserLocation() {
        List<UserLocationDTO> usersLocation = mapService.getAllUserLocation();
        return usersLocation;
    }
}