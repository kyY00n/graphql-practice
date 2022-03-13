package com.rosie.graphqlServer.graphql.model

data class InputGroupTO(
    var nodes: List<InputGroupNodeTO>
) {

    companion object {
        fun builder(): Builder = Builder()
    }


    class Builder {

        private lateinit var nodes: List<InputGroupNodeTO>

        fun setNodes(nodes: List<InputGroupNodeTO>): Builder {
            this.nodes = nodes
            return this
        }

        fun build(): InputGroupTO {
            return InputGroupTO(nodes)
        }
    }
}