package com.memento.web.endpoint;

import com.memento.model.Neighborhood;
import com.memento.service.NeighborhoodService;
import com.memento.web.endpoint.api.NeighborhoodApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.memento.web.RequestUrlConstant.NEIGHBORHOOD_BASE_URL;

@RestController
@RequestMapping(value = NEIGHBORHOOD_BASE_URL, produces = {MediaType.APPLICATION_JSON_VALUE})
public class NeighborhoodApiController implements NeighborhoodApi {

    private final NeighborhoodService neighborhoodService;

    @Autowired
    public NeighborhoodApiController(final NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    @Override
    @GetMapping(value = "/city/{cityName}")
    public ResponseEntity<List<Neighborhood>> findAllByCityName(@PathVariable(value = "cityName") final String cityName) {
        return ResponseEntity.ok(neighborhoodService.findAllByCityName(cityName));
    }

}
