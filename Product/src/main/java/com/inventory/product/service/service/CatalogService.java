package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.CatalogDTO;
import com.inventory.product.service.model.Catalog;

public interface CatalogService {
    public CatalogDTO getProductById(long catalogId);
    public List<CatalogDTO> getAllCatalog();
    public CatalogDTO addCatalog(Catalog catalog);
    public CatalogDTO updateCatalog(Catalog catalog);
    public void deleteCatalog(Catalog catalog);
}