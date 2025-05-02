package com.shop.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    // 상품명으로 데이터 조회하기
    List<Item> findByItemNm(String itemNm);
    // 상품과 상품상세설명을 or 조건으로 조회하기
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
    // x보다 작은 값 검색
    List<Item> findByPriceLessThan(Integer price);
    // 내림차순 (Desc) 오름차순(Asc)
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
    List<Item> findByPriceLessThanOrderByPriceAsc(Integer price);

}
