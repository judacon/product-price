package com.gft.productprices.prices.infrastructure.persistence.repository;

import com.gft.productprices.prices.infrastructure.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query(value = " select p from PriceEntity p " +
            "where p.productId = :productId " +
            "and p.brandId = :brandId " +
            "and :applicationDate " +
            "between p.startDate and p.endDate " +
            "order by p.priority DESC " +
            "limit 1")
    PriceEntity findPrice(@Param("productId") Long productId,
                          @Param("brandId") Long brandId,
                          @Param("applicationDate") Date applicationDate);

}
