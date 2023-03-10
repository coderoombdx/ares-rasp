package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.JeuMock
import com.coderoom.ares.domain.model.Module
import com.coderoom.ares.domain.model.ModuleMock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.coderoom.ares.api.model.Module as ApiModule

internal class ModuleMapperShould {
    @Test
    internal fun `return ApiModule with empty module`() {
        val module = Module(
            id = "id",
            enigmes = listOf()
        )

        val apiModel = module.toApiModel(JeuMock.default())

        assertEquals("id", apiModel.id)
        assertEquals(0, apiModel.enigmes.size)
        assertEquals(ApiModule.Etat.ADEBUTER, apiModel.etat)
    }

    @Test
    internal fun `return ApiModule EDEBUTER`() {
        val module = ModuleMock.interieur2()

        val apiModel = module.toApiModel(JeuMock.default())

        assertEquals(ApiModule.Etat.ADEBUTER, apiModel.etat)
    }

    @Test
    internal fun `return ApiModule ENCOURS`() {
        val module = ModuleMock.exterieur()

        val apiModel = module.toApiModel(JeuMock.default())

        assertEquals(ApiModule.Etat.ENCOURS, apiModel.etat)
    }

    @Test
    internal fun `return ApiModule TERMINE`() {
        val module = ModuleMock.interieur1()

        val apiModel = module.toApiModel(JeuMock.default())

        assertEquals(ApiModule.Etat.TERMINE, apiModel.etat)
    }
}