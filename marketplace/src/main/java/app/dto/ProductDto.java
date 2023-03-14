package app.dto;

import app.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {


    private Long id;
    private String title;
    private String description;
    private double price;
    private String image_url;
    

    public ProductDto(Product product) {
    	this.id = product.getId();
    	this.title = product.getName();
    	this.price = product.getPrice();
    	this.description = product.getDescription();
        this.image_url = product.getImageUrl();
    }
}
