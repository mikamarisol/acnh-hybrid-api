package mikamarisol.acnh.hybrid.service;

import mikamarisol.acnh.hybrid.entity.Rose;

import java.util.List;

public interface RoseService {
    List<Rose> getAllRoses();
    Rose getRoseById(int roseID);
}
