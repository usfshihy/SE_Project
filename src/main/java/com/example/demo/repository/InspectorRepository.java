package com.example.demo.repository;


import com.example.demo.domain.Inspector;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InspectorRepository extends PagingAndSortingRepository<Inspector, Long> {

    Iterable<Inspector> findByMajordOrMinordOrPdsizeOrPdtimeOrPdrateOrEstyield(String majord, String minord, String pdsize, String pdtime, String pdrate, String estyield);

}