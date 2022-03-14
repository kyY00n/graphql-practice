package com.rosie.graphqlServer.domain.category

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("category_has_template_items")
class CategoryHasTemplateItems(
    @Id
    var id: Long = 0,
    @Column("category_id")
    val categoryId: Int,
    @Column
    val label: String,
    @Column
    val type: String,
    @Column("data_key")
    val dataKey: String,
    @Column
    val required: Boolean,
    @Column
    val sequence: Int,
    @Column("placeholder")
    val placeHolder: String,
    @Column("help_text")
    val helpText: String
) {
    @Column("checkbox_values")
    var checkboxValues: String = ""

    @Column("initial_value")
    var initialValue: String = ""
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CategoryHasTemplateItems

        if (id != other.id) return false
        if (categoryId != other.categoryId) return false
        if (label != other.label) return false
        if (type != other.type) return false
        if (dataKey != other.dataKey) return false
        if (required != other.required) return false
        if (sequence != other.sequence) return false
        if (placeHolder != other.placeHolder) return false
        if (helpText != other.helpText) return false
        if (checkboxValues != other.checkboxValues) return false
        if (initialValue != other.initialValue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + categoryId
        result = 31 * result + label.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + dataKey.hashCode()
        result = 31 * result + required.hashCode()
        result = 31 * result + sequence
        result = 31 * result + placeHolder.hashCode()
        result = 31 * result + helpText.hashCode()
        result = 31 * result + checkboxValues.hashCode()
        result = 31 * result + initialValue.hashCode()
        return result
    }


}