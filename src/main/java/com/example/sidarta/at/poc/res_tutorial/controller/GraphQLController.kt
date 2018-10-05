package com.example.sidarta.at.poc.res_tutorial.controller

import com.example.sidarta.at.poc.res_tutorial.repository.PetsService
import graphql.ExecutionInput
import graphql.ExecutionResult
import graphql.GraphQL
import graphql.schema.GraphQLSchema
import io.leangen.graphql.GraphQLSchemaGenerator
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest

@RestController
class GraphQLController(petsService: PetsService) {
    private val graphql: GraphQL

    init {
        val schema = GraphQLSchemaGenerator()
                .withResolverBuilders(
                        //Resolve by annotations
                        AnnotatedResolverBuilder())
                .withOperationsFromSingleton(petsService)
                .withValueMapperFactory(JacksonValueMapperFactory())
                .generate()

        graphql = GraphQL.newGraphQL(schema).build()
    }

    @PostMapping(value = "/graphql", consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    @ResponseBody
    fun graphql(@RequestBody request: Map<String, String>, raw: HttpServletRequest): Map<String, Any> {
        val executionResult = graphql.execute(ExecutionInput.newExecutionInput()
                .query(request["query"])
                .operationName(request["operationName"])
                .context(raw)
                .build())
        return executionResult.toSpecification()
    }
}
