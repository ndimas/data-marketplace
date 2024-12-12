package com.example.resource

import com.example.model.DataProduct
import com.example.repository.DataProductRepository
import com.example.service.AuthenticationService
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.HttpHeaders
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.SecurityContext
import java.util.UUID

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class DataProductResource {

    @Inject
    lateinit var repository: DataProductRepository

    @Inject
    lateinit var authService: AuthenticationService

    @GET
    fun getAllProducts(): List<DataProduct> = repository.getAll()

    @GET
    @Path("/{id}")
    fun getProductById(@PathParam("id") id: UUID): Response {
        val product = repository.getById(id)
        return if (product != null) {
            Response.ok(product).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @POST
    fun createProduct(product: DataProduct, @Context headers: HttpHeaders): Response {
        if (!isAuthenticated(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).build()
        }
        val createdProduct = repository.create(product)
        return Response.status(Response.Status.CREATED).entity(createdProduct).build()
    }

    @PUT
    @Path("/{id}")
    fun updateProduct(@PathParam("id") id: UUID, product: DataProduct, @Context headers: HttpHeaders): Response {
        if (!isAuthenticated(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).build()
        }
        val updatedProduct = repository.update(id, product)
        return if (updatedProduct != null) {
            Response.ok(updatedProduct).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @DELETE
    @Path("/{id}")
    fun deleteProduct(@PathParam("id") id: UUID, @Context headers: HttpHeaders): Response {
        if (!isAuthenticated(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).build()
        }
        val deleted = repository.delete(id)
        return if (deleted) {
            Response.noContent().build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    private fun isAuthenticated(headers: HttpHeaders): Boolean {
        val authHeader = headers.getHeaderString("Authorization")
        return authService.authenticate(authHeader)
    }

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    fun login(): Response {
        val authHeader = authService.generateBasicAuthHeader()
        return Response.ok(authHeader).build()
    }
}
