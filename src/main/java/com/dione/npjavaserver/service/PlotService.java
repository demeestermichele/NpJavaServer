package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.PlotDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface PlotService {

    List<PlotDTO> getAll();

    PlotDTO getPlotById(Long id) throws ChangeSetPersister.NotFoundException;

    PlotDTO createPlot(PlotDTO plotDto);

    PlotDTO updatePlot(Long id, PlotDTO plotDto) throws ChangeSetPersister.NotFoundException;

    void deletePlot(Long id) throws ChangeSetPersister.NotFoundException;
}
