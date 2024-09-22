package pe.edu.upc.tripbundle.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tripbundle.dtos.ActivityDTO;
import pe.edu.upc.tripbundle.dtos.QuantityActivityByReserveDTO;
import pe.edu.upc.tripbundle.entities.Activity;
import pe.edu.upc.tripbundle.serviceinterfaces.IActivityService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividades")

public class ActivityController {
    @Autowired
    private IActivityService aS;

    @GetMapping
    public List<ActivityDTO> Listar(){

        return aS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ActivityDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ActivityDTO dto){
        ModelMapper m=new ModelMapper();
        Activity ac=m.map(dto,Activity.class);
        aS.insert(ac);
    }

    @PutMapping
    public void modificar(@RequestBody ActivityDTO dto){
        ModelMapper m=new ModelMapper();
        Activity ac=m.map(dto,Activity.class);
        aS.update(ac);
    }

    @DeleteMapping("/id")
    public void eliminar(@PathVariable("id") Integer id){
        aS.delete(id);
    }

    @GetMapping("/cantidades")
    public List<QuantityActivityByReserveDTO> obtenerCantidad(){
        List<String[]>lista=aS.cantidadactividades();
        List<QuantityActivityByReserveDTO>listaDTO=new ArrayList<>();
        for (String[] columna:lista){
            QuantityActivityByReserveDTO dto=new QuantityActivityByReserveDTO();
            dto.setDescriptionreserve(columna[0]);
            dto.setQuantityactivity(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
