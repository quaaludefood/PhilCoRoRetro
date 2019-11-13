package com.example.philcororetro.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "actions")
data class Action(

    @ColumnInfo(name = Actions.Column.identifier)
    @SerializedName("Identifier")
     val identifier:String,

    @PrimaryKey
    @ColumnInfo(name = Actions.Column.action_id)
    @SerializedName("Action_Id")
    val action_id:Int,

    @ColumnInfo(name = Actions.Column.active)
    @SerializedName("Active")
    val active:Boolean,

    @ColumnInfo(name = Actions.Column.name)
    @SerializedName("Name")
    val name:String

) {
    object Actions {
        const val tableName = "actions"

        object Column {
            const val identifier = "identifier"
            const val action_id = "action_id"
            const val active = "active"
            const val name = "name"

        }
    }
}