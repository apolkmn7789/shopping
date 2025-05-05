package com.shop.item;

import com.shop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> ,
        QuerydslPredicateExecutor<Item> {

    // 상품명으로 데이터 조회하기
    List<Item> findByItemNm(String itemNm);
    // 상품과 상품상세설명을 or 조건으로 조회하기
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
    // x보다 작은 값 검색
    List<Item> findByPriceLessThan(Integer price);
    // 내림차순 (Desc) 오름차순(Asc)
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
    List<Item> findByPriceLessThanOrderByPriceAsc(Integer price);
    // @Query 를 사용하여 커스터마이징
    @Query("select i from Item i where i.itemDetail like " +
            "%:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
    // @Query-nativeQuery
    @Query(value = "select * from item i where i.item_detail like " +
            "%:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);

}
