package com.example.demo.controller;

import com.example.demo.model.TvCharacter;
import com.example.demo.service.CharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    public List<TvCharacter> getAllCharacters(
            @RequestParam(required = false) String universe,
            @RequestParam(required = false) String name) {
        return service.getAllCharacters(universe, name);
    }

    @GetMapping("/{id}")
    public TvCharacter getCharacterById(@PathVariable Long id) {
        return service.getCharacterById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TvCharacter createCharacter(@Valid @RequestBody TvCharacter character) {
        return service.createCharacter(character);
    }

    @PutMapping("/{id}")
    public TvCharacter updateCharacter(@PathVariable Long id, @Valid @RequestBody TvCharacter character) {
        return service.updateCharacter(id, character);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable Long id) {
        service.deleteCharacter(id);
    }
}