package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionsController
{
    private final PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/get-all")
    public List<Position> getAll() {
        return this.positionService.getAll();
    }
}
