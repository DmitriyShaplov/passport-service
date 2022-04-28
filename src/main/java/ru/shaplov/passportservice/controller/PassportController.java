package ru.shaplov.passportservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.shaplov.passportservice.model.Passport;
import ru.shaplov.passportservice.service.PassportService;

import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {

    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @PostMapping("/save")
    public Passport save(@RequestBody Passport passport) {
        return passportService.save(passport);
    }

    @PutMapping("/update")
    public void update(@RequestParam Long id, @RequestBody Passport passport) {
        passportService.update(id, passport);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        passportService.delete(id);
    }

    @GetMapping("/find")
    public List<Passport> findBySeries(@RequestParam(required = false) String series) {
        return passportService.find(series);
    }

    @GetMapping("/unavailable")
    public List<Passport> findUnavailable() {
        return passportService.findUnavailable();
    }

    @GetMapping("/find-replaceable")
    public List<Passport> findReplaceable() {
        return passportService.findReplaceable();
    }
}
