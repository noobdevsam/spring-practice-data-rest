package com.example.springdatajpa_data_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@SpringBootApplication
public class SpringdatajpaDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaDataRestApplication.class, args);
	}

}


@Data
@NoArgsConstructor
@Entity
class Beer{
        
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
        private UUID id;
        
        @Version
        private Long version;
        
        private String beerName;
        private String upc;
        
        private BeerStyleEnum beerStyle;
        private Integer quantityOnHand;
        private BigDecimal price;
        
        @CreationTimestamp
        @Column(updatable = false)
        private Timestamp createdDate;
        
        @UpdateTimestamp
        private Timestamp lastModifiedDate;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Custormer {
        private UUID id;
        private String name;
}

enum BeerStyleEnum {
        LAGER, PILSNER, STOUT, GOSE, PORTER, ALE, WHEAT, IPA,
        PALE_ALE, SAISON
}

interface BeerRepository extends JpaRepository<Beer, UUID> {
        Page<Beer> findAllByBeerName(String beerName, Pageable pageable);
        Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);
        Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);
        Beer findByUpc(String upc);
}


















