package pe.edu.upc.tripbundle.controllers;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tripbundle.dtos.FaunaDTO;
import pe.edu.upc.tripbundle.entities.Fauna;
import pe.edu.upc.tripbundle.serviceinterfaces.IFaunaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faunas")

public class FaunaController {

    @Autowired
    private IFaunaService fS;

    @GetMapping
    public List<FaunaDTO> listar() {

        return fS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, FaunaDTO.class);
        }).collect(Collectors.toList());

    }

    @PostMapping
    public ResponseEntity<Fauna> insertar(@RequestBody FaunaDTO dto) throws IOException {
        ModelMapper m=new ModelMapper();
        Fauna fauna=m.map(dto, Fauna.class);
        Fauna faunaReturn=fS.insert(fauna);
        return new ResponseEntity<Fauna>(faunaReturn, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        fS.delete(id);
    }

    @GetMapping("/{id}")
    public FaunaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        FaunaDTO dto = m.map(fS.listId(id), FaunaDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody FaunaDTO dto){
        ModelMapper m=new ModelMapper();
        Fauna fa=m.map(dto, Fauna.class);
        fS.update(fa);
    }

    @PutMapping(value = "/{id}/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public  ResponseEntity<Fauna> updateFaunaImage(@PathVariable("id") int id,
                                                        @RequestPart(name="image") MultipartFile image) throws IOException {
        Fauna foundFauna = fS.updateImage(id, image.getBytes());
        //photo.getSize()
        return new ResponseEntity<Fauna>(foundFauna, HttpStatus.OK);
    }


}
