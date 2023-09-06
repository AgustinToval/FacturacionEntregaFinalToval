package com.java.FacturacionToval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.FacturacionToval.model.Product;
import com.java.FacturacionToval.model.ProductDetailRequest;
import com.java.FacturacionToval.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productoRepository;

    public Product crearProducto(Product producto) throws Exception {
        return productoRepository.save(producto);
    }

    public Product obtenerProducto(int id) throws Exception {
        Optional<Product> producto = productoRepository.findById(id);
        if (!producto.isPresent()) {
            throw new Exception("Product with id: " + id + " not found.");
        } else {
            return producto.get();
        }
    }

    public List<Product> getAll() {
        return productoRepository.findAll();
    }

    public List<Product> getProductsById(List<ProductDetailRequest> productListId) throws Exception {
        List<Product> productList = new ArrayList<>();
        for (ProductDetailRequest requestProduct : productListId) {
            Optional<Product> productFound = productoRepository.findById(requestProduct.getProductId());
            if (!productFound.isPresent()) {
                throw new Exception("Product with id: " + requestProduct.getProductId() + " not found.");
            }
            productList.add(productFound.get());
        }
        return productList;
    }

    public void modificarProducto(Product product, int id) throws Exception {
        Optional<Product> productoExistente = productoRepository.findById(id);
        if (!productoExistente.isPresent()) {
            throw new Exception("Product with id: " + id + " not found.");
        } else {
            Product productoEncontrado = productoExistente.get();
            productoEncontrado.setTitle(product.getTitle());
            productoEncontrado.setDescription(product.getDescription());
            productoEncontrado.setCode(product.getCode());
            productoEncontrado.setPrice(product.getPrice());
            productoEncontrado.setStock(product.getStock());
            productoRepository.save(productoEncontrado);
        }
    }

    public void borrarProducto(int id) throws Exception {
        Optional<Product> productoExistente = productoRepository.findById(id);
        if (!productoExistente.isPresent()) {
            throw new Exception("Product with id: " + id + " not found.");
        } else {
            productoRepository.deleteById(id);
        }
    }
}
