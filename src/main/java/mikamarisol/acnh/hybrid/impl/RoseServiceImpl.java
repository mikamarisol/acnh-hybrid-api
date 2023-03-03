package mikamarisol.acnh.hybrid.impl;

import mikamarisol.acnh.hybrid.entity.Rose;
import mikamarisol.acnh.hybrid.repository.RoseRepository;
import mikamarisol.acnh.hybrid.service.RoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoseServiceImpl implements RoseService {

    @Autowired
    RoseRepository roseRepository;

    @Override
    public List<Rose> getAllRoses() {
        return roseRepository.findAll();
    }

    @Override
    public Rose getRoseById(int roseId) {
        Optional<Rose> rose = roseRepository.findById(roseId);
        if (rose.isPresent()) {
            return rose.get();
        }
        else {
            return null;
        }
    }
}
