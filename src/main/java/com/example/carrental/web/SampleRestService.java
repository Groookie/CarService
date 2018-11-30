package com.example.carrental.web;

import com.example.carrental.model.Sample;
import com.example.carrental.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleRestService {

    private List<Sample> samples = new ArrayList<Sample>();

    @Autowired
    private SampleService sampleService;

    public SampleRestService() {
    }

    @RequestMapping(value = "/samples", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Sample> getListOfCars() {
        return sampleService.findAll();
    }

    @RequestMapping(value = "/samples", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addCar(@RequestBody Sample sample) throws Exception {
        System.out.println(samples);
        sampleService.save(sample);
    }

}
