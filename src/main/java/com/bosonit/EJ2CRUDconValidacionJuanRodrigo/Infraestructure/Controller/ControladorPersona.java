package com.bosonit.EJ2CRUDconValidacionJuanRodrigo.Infraestructure.Controller;

import com.bosonit.EJ2CRUDconValidacionJuanRodrigo.Domain.UsuarioEntity;
import com.bosonit.EJ2CRUDconValidacionJuanRodrigo.Infraestructure.DTO.Input.UsuarioInputDTO;
import com.bosonit.EJ2CRUDconValidacionJuanRodrigo.Infraestructure.DTO.Output.UsuarioOutputDTO;
import com.bosonit.EJ2CRUDconValidacionJuanRodrigo.Infraestructure.Repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    public class ControladorPersona {

        @Autowired
        UsuarioRepositorio usuarioRepositorio;

        @PostMapping("/crearUsuario")
        public UsuarioOutputDTO crearUsuario(@RequestBody UsuarioInputDTO usuarioInputDTO, UsuarioEntity usuarioEntity, UsuarioOutputDTO usuarioOutputDTO) throws Exception {
            if (usuarioInputDTO.usuario().length() < 6 || usuarioInputDTO.usuario().length() > 10)
                throw new Exception("El usuario debe tener entre 6 y 10 carácteres");

            usuarioEntity = new UsuarioEntity(usuarioInputDTO);
            usuarioRepositorio.save(usuarioEntity);
            usuarioOutputDTO = new UsuarioOutputDTO(usuarioEntity);
            return usuarioOutputDTO;

        }

        @GetMapping("/id/{id}")
        public Optional<UsuarioEntity> getUsuarioByID(@PathVariable(value = "id") Integer id) {
            return usuarioRepositorio.findById(id);
        }


        @GetMapping("/usuario/{usuario}")
        public List<UsuarioEntity> getUsuarioByUser(@PathVariable(value = "usuario") String usuario) {
            return usuarioRepositorio.findByUsuario(usuario);
        }

        @GetMapping("/usuario/all")
        public List<UsuarioEntity> getAllUsuarios() {
            return usuarioRepositorio.findAll();
        }

        @PutMapping("/usuario/update/{id}")
        public void updateUsuarioByID(@PathVariable(value = "id") Integer id) {
            UsuarioEntity usuarioEntity1 = usuarioRepositorio.getReferenceById(id);
            usuarioEntity1.setUsuario("Juanro");
            usuarioRepositorio.save(usuarioEntity1);
        }

        @DeleteMapping("/usuario/{id}")
        public void deleteByID(@PathVariable(value = "id") Integer id) {
            usuarioRepositorio.deleteById(id);
        }
    }


