package com.example.demo.service;

import com.example.demo.model.TvCharacter;
import com.example.demo.repository.CharacterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<TvCharacter> getAllCharacters(String universe, String name) {
        if (universe != null && !universe.isBlank()) {
            return repository.findByUniverseIgnoreCase(universe);
        }
        if (name != null && !name.isBlank()) {
            return repository.findByNameContainingIgnoreCase(name);
        }
        return repository.findAll();
    }

    public TvCharacter getCharacterById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found with ID: " + id));
    }

    public TvCharacter createCharacter(TvCharacter character) {
        return repository.save(character);
    }

    public TvCharacter updateCharacter(Long id, TvCharacter updated) {
        TvCharacter existing = getCharacterById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setUniverse(updated.getUniverse());
        existing.setRole(updated.getRole());
        existing.setActiveDate(updated.getActiveDate());
        return repository.save(existing);
    }

    public void deleteCharacter(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}