package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionManager implements PositionService
{
    private final PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        super();
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<>(this.positionDao.findAll(), "Position list returned successfully");
    }

    @Override
    public Result add(Position position) {
        List<Position> positions = this.positionDao.findAll();
        for(Position pos : positions) {
            if(pos.getName().equals(position.getName())) {
                return new ErrorResult("Position already exists!");
            }
        }

        this.positionDao.save(position);
        return new SuccessResult("Position added");
    }
}
