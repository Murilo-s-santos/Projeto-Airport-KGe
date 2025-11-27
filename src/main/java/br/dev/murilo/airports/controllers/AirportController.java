package br.dev.murilo.airports.controllers;

import br.dev.murilo.airports.entities.Airport;
import br.dev.murilo.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController 
{
    @Autowired
    private AirportService airportService;
    
    @GetMapping("/airport")
    public List<Airport> findAll()
    {
        List<Airport> result = airportService.findAll();
        return result;
    }
    
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName)
    {
        List<Airport> result = airportService.findByCity(cityName);
        
        if(result.isEmpty())
        {
            // Lista vazia, irá reotrnar o erro 404
            return ResponseEntity.notFound().build();
        }
        else
        {
            // Há dados, o retorno será 200
            return ResponseEntity.ok(result);
        }
        //return result;
    }
}
