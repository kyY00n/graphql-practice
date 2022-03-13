package com.rosie.graphqlServer.graphql.model

data class InputGroupNodeTO(
    var label: String,
    var type: InputGroupNodeTypeTO,
    var dataKey: String,
    var required: Boolean,
    var placeholder: String?,
    var helpText: String?,
    var initialValue: String?
) {

    companion object {
        fun builder(): Builder = Builder()
    }


    class Builder {

        private lateinit var label: String
        private lateinit var type: InputGroupNodeTypeTO
        private lateinit var dataKey: String
        private var required: Boolean = false
        private var placeholder: String? = null
        private var helpText: String? = null
        private var initialValue: String? = null

        fun setLabel(label: String): Builder {
            this.label = label
            return this
        }

        fun setType(type: InputGroupNodeTypeTO): Builder {
            this.type = type
            return this
        }

        fun setDataKey(dataKey: String): Builder {
            this.dataKey = dataKey
            return this
        }

        fun setRequired(required: Boolean): Builder {
            this.required = required
            return this
        }

        fun setPlaceholder(placeholder: String?): Builder {
            this.placeholder = placeholder
            return this
        }

        fun setHelpText(helpText: String?): Builder {
            this.helpText = helpText
            return this
        }

        fun setInitialValue(initialValue: String?): Builder {
            this.initialValue = initialValue
            return this
        }

        fun build(): InputGroupNodeTO {
            return InputGroupNodeTO(label, type, dataKey, required, placeholder, helpText, initialValue)
        }
    }
}
