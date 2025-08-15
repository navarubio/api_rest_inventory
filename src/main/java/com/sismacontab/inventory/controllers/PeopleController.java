package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestParam String usuario, @RequestParam String clave) {
        return peopleRepository.findByNameAndApppassword(usuario, clave)
                .map(people -> ResponseEntity.ok("AUTORIZADO"))
                .orElseGet(() -> {
                    if (!peopleRepository.findByName(usuario).isPresent()) {
                        return ResponseEntity.status(404).body("USUARIO NO EXISTE");
                    } else {
                        return ResponseEntity.status(401).body("CLAVE INCORRECTA");
                    }
                });
    }
}
