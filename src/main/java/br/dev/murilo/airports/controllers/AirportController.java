package br.dev.murilo.airports.controllers;

import br.dev.murilo.airports.DTO.AirportMinDTO;
import br.dev.murilo.airports.DTO.AirportNearMeDTO;
import br.dev.murilo.airports.entities.Airport;
import br.dev.murilo.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName)
    {
        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        
        if(result.isEmpty())
        {
            // Lista vazia, retorna o erro 404
            return ResponseEntity.notFound().build();
        }
        else
        {
            // A lista contém dados, portanto, o retorno será o código 200
            return ResponseEntity.ok(result);
        }
    }
    
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode)
    {
        Airport result = airportService.findByIataCode(iataCode);
        
        if(result == null)
        {
            // Aeroporto vazio, retorna o código 404
            return ResponseEntity.notFound().build();
        }
        else
        {
            // Há dados, retorna o código 200
            return ResponseEntity.ok(result);            
        }
    }
    
    @GetMapping("/nearme")
    public ResponseEntity<List<AirportNearMeDTO>> findNearMe(
        @RequestParam double latitude,
        @RequestParam double longitude )
    {
        List<AirportNearMeDTO> result = airportService.findNearMe(latitude, longitude);
        
        if(result.isEmpty())
        {
            // Lista vazia, retorno 404
            return ResponseEntity.notFound().build();
        }
        else
        {
            // Há dados, retorna código 200
            return ResponseEntity.ok(result);
        }
    }
            
    
}
