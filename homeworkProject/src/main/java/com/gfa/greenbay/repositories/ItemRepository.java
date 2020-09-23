package com.gfa.greenbay.repositories;


import com.gfa.greenbay.models.SellableItem;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<SellableItem, Long> {

  Optional<SellableItem> findSellableItemByName(String name);

  List<SellableItem> findAllBySellableIsTrue();

}
