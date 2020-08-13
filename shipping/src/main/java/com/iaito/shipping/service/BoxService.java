package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.BoxDTO;
import com.iaito.shipping.model.Box;

public interface BoxService {

    public BoxDTO getBoxById(long boxId);
    public List<BoxDTO> getAllBoxes();
    public BoxDTO addBox(Box box);
    public BoxDTO updateBox(Box box);
    public void deleteBox(long boxId);
}
