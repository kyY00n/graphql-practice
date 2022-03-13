package com.rosie.graphqlServer.graphql.model

enum class InputGroupNodeTypeTO(val graphqlName: String) {
    TEXTAREA("TEXTAREA"),
    TEXT_INPUT("TEXT_INPUT"),
    DATE_INPUT("DATE_INPUT"),
    NUMBER_INPUT("NUMBER_INPUT"),
    CHECKBOX("CHECKBOX")
}