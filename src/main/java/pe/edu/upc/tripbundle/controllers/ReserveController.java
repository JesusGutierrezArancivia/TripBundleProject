package pe.edu.upc.tripbundle.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tripbundle.dtos.ReserveDTO;
import pe.edu.upc.tripbundle.dtos.QuantityActivityByReserveDTO;
import pe.edu.upc.tripbundle.dtos.ReserveDTO;
import pe.edu.upc.tripbundle.entities.Reserve;
import pe.edu.upc.tripbundle.serviceinterfaces.IReserveService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")

public class ReserveController {
    @Autowired
    private IReserveService rS;

    @GetMapping
    public List<ReserveDTO> listar(){

        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ReserveDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ReserveDTO dto){
        ModelMapper m=new ModelMapper();
        Reserve ci=m.map(dto, Reserve.class);
        rS.insert(ci);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rS.delete(id);
    }

    @GetMapping("/{id}")
    public ReserveDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ReserveDTO dto = m.map(rS.listId(id), ReserveDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody ReserveDTO dto){
        ModelMapper m=new ModelMapper();
        Reserve ci=m.map(dto, Reserve.class);
        rS.update(ci);
    }
}
