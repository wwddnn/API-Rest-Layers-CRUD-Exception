package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
@Tag(name = "Produtos", description = "Endpoints para o gerenciamento do catálogo de produtos") //Documentação OpenAPI
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(summary = "Retornar o produto conforme o número do id") //Documentação OpenAPI
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto =  service.findById(id);
        return ResponseEntity.ok(dto); //codigo 200
    }

    @Operation(summary = "Listar todos os produtos de forma paginada") //Documentação OpenAPI

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(@ParameterObject Pageable pageable) { //Documentação OpenAPI
        Page<ProductDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto); //codigo 200
    }

    @Operation(summary = "Inserir um novo produto") //Documentação OpenAPI
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto); //codigo 201
    }

    @Operation(summary = "Atualizar o produto conforme o número do id") //Documentação OpenAPI
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        dto =  service.update(id, dto);
        return ResponseEntity.ok(dto); //codigo 200
    }

    @Operation(summary = "Deletar o produto conforme o número do id") //Documentação OpenAPI
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); //codigo 204
    }

}
