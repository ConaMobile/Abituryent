package com.abituriyentuz.abituriyent.Models

class GroupModel {
    var id:String? = null
    var name:String? = null


    constructor(id: String?, name: String?) {
        this.id = id
        this.name = name
    }

    override fun toString(): String {
        return "GroupModel(id=$id, name=$name)"
    }

}