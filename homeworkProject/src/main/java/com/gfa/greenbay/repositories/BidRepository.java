package com.gfa.greenbay.repositories;


import com.gfa.greenbay.models.Bid;
import com.gfa.greenbay.models.SellableItem;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends CrudRepository<Bid, Long> {



}
