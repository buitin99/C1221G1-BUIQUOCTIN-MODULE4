package com.quoctin.dto;
import com.quoctin.common.Validate;
import com.quoctin.model.OrderProduct;
import com.quoctin.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class OrderProductDto implements Validator {

    private Integer id;
    private String date;
    @NotNull(message = "không được để trống")
    @Positive(message = "số lượng không được âm!")
    private Integer amount;
    private Product product;

    public OrderProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderProduct orderProduct = (OrderProduct) target;
    }
}
