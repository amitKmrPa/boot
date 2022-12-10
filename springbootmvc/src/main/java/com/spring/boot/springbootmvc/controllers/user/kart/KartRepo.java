package com.spring.boot.springbootmvc.controllers.user.kart;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface KartRepo extends JpaRepository<Kart , Long>{
    @Query(value="select u.product_count,v.product_name,v.price,v.product_Id,v.product_type,u.seller_Id,v.product_Img_Id from kart u inner join products_data v on u.product_Id=v.product_Id where u.user_Id=?1 and u.is_deleted=0",nativeQuery = true)
    // @Query("select u from Kart u inner join ProductEntity v on u.productId=v.productId where u.userId=:userId")
    List<Object> addToKart(@Param("userId") String userId);

    @Query(value="select u.product_count,v.product_name,v.price,v.product_Id,v.product_type,u.seller_Id,v.product_Img_Id from kart u inner join products_data v on u.product_Id=v.product_Id where u.user_Id=?1 and u.is_deleted=0",nativeQuery = true)
    List<Object> viewUserKart(@Param("userId")String userId);

    @Query("select u from Kart u where userId=:userId and sellerId=:sellerId and productId=:productId")
    Kart removeFromKart(@Param("productId") String productId,@Param("sellerId") String sellerId,@Param("userId") String userId);

    @Query("select u from Kart u where userId=:userId and productId=:productId")
    Kart getKartDetailsByProductIdAndUserId(@Param("productId")String productId, @Param("userId") String userId);

    @Query(value="select u.product_count,v.product_name,v.price,v.product_Id,v.product_type,u.seller_Id from kart u inner join products_data v on u.product_Id=v.product_Id where u.user_Id=?1 and u.is_deleted=0",nativeQuery = true)
    List<Object> kartList(@Param("userId") String userId);
    
}
