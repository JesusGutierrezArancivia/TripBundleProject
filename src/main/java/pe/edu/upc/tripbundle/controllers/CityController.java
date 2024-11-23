package pe.edu.upc.tripbundle.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tripbundle.dtos.CityDTO;
import pe.edu.upc.tripbundle.dtos.QuantityFaunaByCityDTO;
import pe.edu.upc.tripbundle.dtos.QuantityFloraByCityDTO;
import pe.edu.upc.tripbundle.entities.City;
import pe.edu.upc.tripbundle.serviceinterfaces.ICityService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ciudades")

public class CityController {

    @Autowired
    private ICityService cS;

    @GetMapping
    public List<CityDTO> listar(){
        return cS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, CityDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CityDTO dto){
        ModelMapper m=new ModelMapper();
        City ci=m.map(dto, City.class);
        cS.insert(ci);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @GetMapping("/{id}")
    public CityDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CityDTO dto = m.map(cS.listId(id), CityDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody CityDTO dto){
        ModelMapper m=new ModelMapper();
        City ci=m.map(dto, City.class);
        cS.update(ci);
    }

    @GetMapping("/cantidadfloraporciudad")
    public List<QuantityFloraByCityDTO> cantidadFloraPorCiudad() {
        List<String[]> lista = cS.cantidadFloraPorCiudad();
        List<QuantityFloraByCityDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            QuantityFloraByCityDTO dto = new QuantityFloraByCityDTO();
            dto.setNameCity(columna[0]);
            dto.setQuantityFlora(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/cantidadfaunaporciudad")
    public List<QuantityFaunaByCityDTO> cantidadFaunaPorCiudad() {
        List<String[]> lista = cS.cantidadFloraPorCiudad();
        List<QuantityFaunaByCityDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            QuantityFaunaByCityDTO dto = new QuantityFaunaByCityDTO();
            dto.setNameCity(columna[0]);
            dto.setQuantityFauna(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
