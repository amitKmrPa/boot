package com.spring.boot.springbootmvc.controllers.invoice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepo extends JpaRepository<InvoiceEntity, Integer> {
    @Query(value="select u.product_Id,u.total_price,v.product_name from invoices u inner join products_data v on u.product_Id=v.product_Id where u.product_Id=?1 and u.is_deleted=0",nativeQuery = true)
    Object generateInvoice(@Param("productId") String productId,@Param("sellerId") String sellerId,@Param("userId") String userId);

    @Query("select u from InvoiceEntity u where productId=:productId and sellerId=:sellerId and userId=:userId")
    InvoiceEntity getInvoiceIdBy(@Param("productId") String productId,@Param("sellerId") String sellerId,@Param("userId") String userId);
    @Query("select u from InvoiceEntity u ")
    InvoiceEntity getInvoiceDetails();

    
}
