package com.coderoom.ares.adapter.tableauCommande

import com.coderoom.ares.domain.model.TableauCommande

interface TableauCommandeRepository {

    fun readData(): TableauCommande

}