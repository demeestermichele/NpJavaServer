package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.PlotDAO;
import com.dione.npjavaserver.dto.PlotDTO;
import com.dione.npjavaserver.dto.PlotDTO;
import com.dione.npjavaserver.dto.PlotDTO;
import com.dione.npjavaserver.model.Plot;
import com.dione.npjavaserver.model.Plot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PlotServiceImpl implements PlotService {
    
    @Autowired
    private PlotDAO plotDAO;
    
    @Override
    public List<PlotDTO> getAll() {
        List<Plot> plots= plotDAO.findAll();
        List<PlotDTO> plotDTOList = new ArrayList<>();
        for (Plot plot : plots) {
            plotDTOList.add(new PlotDTO(plot.getId(), plot.getName(), plot.getDescription(), plot.getBook()));
        }
        return plotDTOList;
    }

    @Override
    public PlotDTO getPlotById(Long id) throws ChangeSetPersister.NotFoundException {
        Plot plot = plotDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return mapToDto(plot);
    }

    @Override
    public PlotDTO createPlot(PlotDTO plotDto) {

        Plot plot = mapToEntity(plotDto);
        Plot createdPlot = plotDAO.save(plot);
        return mapToDto(createdPlot);
    }

    @Override
    public PlotDTO updatePlot(Long id, PlotDTO plotDto) throws ChangeSetPersister.NotFoundException {
        Plot plot = plotDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        plot.setName(plotDto.getName());
        plot.setDescription(plotDto.getDescription());
        Plot updatedPlot = plotDAO.save(plot);
        return mapToDto(updatedPlot);
    }

    @Override
    public void deletePlot(Long id) throws ChangeSetPersister.NotFoundException {
        Plot plot = plotDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        plotDAO.delete(plot);
    }

    private PlotDTO mapToDto(Plot plot) {
        PlotDTO plotDto = new PlotDTO();
        plotDto.setId(plot.getId());
        plotDto.setName(plot.getName());
        plotDto.setDescription(plot.getDescription());
        plotDto.setBook(plot.getBook());
        return plotDto;
    }

    private Plot mapToEntity(PlotDTO plotDto) {
        Plot plot = new Plot();
        plot.setId(plot.getId());
        plot.setName(plotDto.getName());
        plot.setDescription(plotDto.getDescription());
        plot.setBook(plotDto.getBook());
        return plot;
    }
}
