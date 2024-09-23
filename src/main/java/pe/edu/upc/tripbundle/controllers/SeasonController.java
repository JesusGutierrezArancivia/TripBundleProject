package pe.edu.upc.tripbundle.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tripbundle.dtos.*;
import pe.edu.upc.tripbundle.entities.Season;
import pe.edu.upc.tripbundle.serviceinterfaces.ISeasonService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estaciones")

public class SeasonController {
    @Autowired
    private ISeasonService sS;

    @GetMapping
    public List<SeasonDTO> listar() {

        return sS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, SeasonDTO.class);
        }).collect(Collectors.toList());


    }

    @PostMapping
    public void insertar(@RequestBody SeasonDTO dto) {
        ModelMapper m=new ModelMapper();
        Season se=m.map(dto, Season.class);
        sS.insert(se);
    }

    @PutMapping
    public void modificar(@RequestBody SeasonDTO dto){
        ModelMapper m=new ModelMapper();
        Season se=m.map(dto, Season.class);
        sS.update(se);
    }

    @GetMapping("/cantidadfloraporestacion")
    public List<QuantityFloraBySeasonDTO> cantidadFloraPorCiudad() {
        List<String[]> lista = sS.cantidadFloraPorEstacion();
        List<QuantityFloraBySeasonDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            QuantityFloraBySeasonDTO dto = new QuantityFloraBySeasonDTO();
            dto.setNameSeason(columna[0]);
            dto.setQuantityFlora(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/cantidadfaunaporestacion")
    public List<QuantityFaunaBySeasonDTO> cantidadFaunaPorCiudad() {
        List<String[]> lista = sS.cantidadFloraPorEstacion();
        List<QuantityFaunaBySeasonDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            QuantityFaunaBySeasonDTO dto = new QuantityFaunaBySeasonDTO();
            dto.setNameSeason(columna[0]);
            dto.setQuantityFauna(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
