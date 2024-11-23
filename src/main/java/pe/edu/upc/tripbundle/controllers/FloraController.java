package pe.edu.upc.tripbundle.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tripbundle.dtos.FloraDTO;
import pe.edu.upc.tripbundle.entities.Flora;
import pe.edu.upc.tripbundle.serviceinterfaces.IFloraService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/floras")

public class FloraController {
    @Autowired
    private IFloraService flS;

    @GetMapping
    public List<FloraDTO> listar() {

        return flS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, FloraDTO.class);
        }).collect(Collectors.toList());

    }

    @PostMapping
    public void insertar(@RequestBody FloraDTO dto) {
        ModelMapper m=new ModelMapper();
        Flora fl=m.map(dto, Flora.class);
        flS.insert(fl);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        flS.delete(id);
    }

    @GetMapping("/{id}")
    public FloraDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        FloraDTO dto = m.map(flS.listId(id), FloraDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody FloraDTO dto){
        ModelMapper m=new ModelMapper();
        Flora fl=m.map(dto, Flora.class);
        flS.insert(fl);
    }

}
