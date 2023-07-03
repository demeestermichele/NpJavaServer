package com.dione.npjavaserver.controller;

import com.dione.npjavaserver.dto.PlotDTO;
import com.dione.npjavaserver.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/plots")
@CrossOrigin("*")
public class PlotController {

    @Autowired
    private PlotService plotService;

    /**
     * List of all Plots
     **/
    @GetMapping("/")
    public ResponseEntity<List<PlotDTO>> getAll() {
        List<PlotDTO> plotDTOs = plotService.getAll();
        return ResponseEntity.ok(plotDTOs);
    }

    /**
     * Get 1 Plot using ID
     **/
    @GetMapping("/{id}")
    public ResponseEntity<PlotDTO> getPlotById(@PathVariable Long id) {
        PlotDTO plotDto = null;
        try {
            plotDto = plotService.getPlotById(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(plotDto);
    }

    /**
     * Create 1 Plot
     **/
    @PostMapping("/create")
    public ResponseEntity<PlotDTO> createPlot(@RequestBody PlotDTO plotDto) {
        PlotDTO createdPlotDto = plotService.createPlot(plotDto);
        return ResponseEntity.created(URI.create("/plot/" + createdPlotDto.getId())).body(createdPlotDto);
    }

    /**
     * Update 1 Plot after finding ID
     **/
    @PutMapping("/{id}")
    public ResponseEntity<PlotDTO> updatePlot(@PathVariable Long id, @RequestBody PlotDTO plotDto) {
        PlotDTO updatedPlotDto = null;
        try {
            updatedPlotDto = plotService.updatePlot(id, plotDto);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(updatedPlotDto);
    }

    /**
     * Delete 1 Plot using ID
     **/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlot(@PathVariable Long id) {
        try {
            plotService.deletePlot(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.noContent().build();
    }
}
