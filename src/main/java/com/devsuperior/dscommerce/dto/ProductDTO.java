package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para representar um produto do catálogo") //Documentação OpenAPI
public class ProductDTO {

    @Schema(description = "Identificador único do produto", example = "1", accessMode = Schema.AccessMode.READ_ONLY) //Documentação OpenAPI
    private Long id;
    @Schema(description = "Nome comercial do produto", example = "Notebook") //openAPI documentation
    private String name;
    @Schema(description = "Descrição detalhada das especificações do produto", example = "Processador Intel Core i5") //Documentação OpenAPI
    private String description;
    @Schema(description = "Preço unitário do produto", example = "1200.00") //Documentação OpenAPI
    private Double price;
    @Schema(description = "URL da imagem de exibição do produto", example = "https://www.google.com.br/img.jpg") //Documentação OpenAPI
    private String imgUrl;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
