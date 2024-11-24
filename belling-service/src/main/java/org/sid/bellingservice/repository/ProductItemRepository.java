package org.sid.bellingservice.repository;

import org.sid.bellingservice.entities.Bill;
import org.sid.bellingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
