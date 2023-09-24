package com.mobile.mobileapp.models

/**
 * Class: [Item]
 * @constructor: [Int] [String] [String]
 * @param idDoItem: Int
 * @param nomeDoItem: String
 * @param descricaoItem: String?
 *
 * Methods: [toString]
 *
 * A descrição do Item está como que pode ou não ser nula. Ela é opcional.
 */
data class Item(var idDoItem: Int, var nomeDoItem: String, var descricaoItem: String? = null) {
    override fun toString(): String {
        return nomeDoItem
    }
}
