package com.example.repository

import com.example.model.DataProduct
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

@ApplicationScoped
class DataProductRepository {
    private val products = ConcurrentHashMap<UUID, DataProduct>()

    fun getAll(): List<DataProduct> = products.values.toList()

    fun getById(id: UUID): DataProduct? = products[id]

    fun create(product: DataProduct): DataProduct {
        products[product.id] = product
        return product
    }

    fun update(id: UUID, product: DataProduct): DataProduct? {
        if (products.containsKey(id)) {
            products[id] = product
            return product
        }
        return null
    }

    fun delete(id: UUID): Boolean = products.remove(id) != null
}
