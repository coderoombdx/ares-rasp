package com.coderoom.ares.adapter.store

import com.coderoom.ares.TimeConstants
import com.coderoom.ares.domain.model.Jeu
import org.springframework.stereotype.Repository
import com.coderoom.ares.domain.model.Enigme as EnigmeModel
import com.coderoom.ares.domain.model.Module as ModuleModel

@Repository
class InMemoryStoreRepository : StoreRepository {
    override fun getJeu() = Jeu(
        compteARebours = StoreSingleton.compteARebours,
        messageAide = StoreSingleton.messageAide,
        derniereAlarme = StoreSingleton.derniereAlarme,
        interrupteurGeneral = StoreSingleton.interrupteurGeneral,
        terraformation = StoreSingleton.terraformation,
        heureMartienneEnSecondes = (TimeConstants.dureeDuJeu - StoreSingleton.compteARebours) + TimeConstants.heureSurMars,
        timestampFishingUtilisateur = Int.MAX_VALUE.toLong(),
        timestampFishingMotDePass = Int.MAX_VALUE.toLong(),
        modules = StoreSingleton.modules.map { module ->
            ModuleModel(
                id = module.id,
                description = module.description,
                idScenario = module.idScenario,
                enigmes = module.enigmes.map { enigme ->
                    EnigmeModel(
                        id = enigme.id,
                        description = enigme.description,
                        resolu = enigme.resolu,
                        code = enigme.code
                    )
                }
            )
        },
    )

    override fun setCompteARebours(valeur: Int) {
        StoreSingleton.compteARebours = valeur
    }

    override fun setInterrupteurGeneral(enMarche: Boolean) {
        StoreSingleton.interrupteurGeneral = enMarche
    }

    override fun setTerraformation(enCours: Boolean) {
        StoreSingleton.terraformation = enCours
    }

    override fun setMessageAide(value: String?) {
        StoreSingleton.messageAide = value
        if (value == null) {
            StoreSingleton.messageAideTTL = 0
        } else {
            StoreSingleton.messageAideTTL = TimeConstants.messageTTL
        }
    }

    override fun getMessageAideTTL(): Int {
        return StoreSingleton.messageAideTTL
    }

    override fun setMessageAideTTL(value: Int) {
        StoreSingleton.messageAideTTL = value
    }

    override fun incDerniereAlarme() {
        StoreSingleton.derniereAlarme++
    }

    override fun resetDerniereAlarme() {
        StoreSingleton.derniereAlarme = 0
    }

    override fun setEnigme(id: String, solutionProposee: String): ResoudreEnigmeResult {
        val enigme = getEnigme(id)
        return if (enigme == null) {
            ResoudreEnigmeResult.NotFound
        } else {
            val solution = enigme.code(getJeu())
            if (solution.any {
                    if (it.startsWith("!")) {
                        it.substring(1).compareTo(solutionProposee, true) != 0
                    } else {
                        it.compareTo(solutionProposee, true) == 0
                    }
                }) {
                enigme.resolu = true
                ResoudreEnigmeResult.Success
            } else {
                enigme.resolu = false
                ResoudreEnigmeResult.Failure(solution = solution.joinToString(separator = ","))
            }
        }
    }

    override fun resetEnigme(id: String): ResetEnigmeResult {
        val enigme = getEnigme(id)
        return if (enigme == null) {
            ResetEnigmeResult.NotFound
        } else {
            enigme.resolu = false
            ResetEnigmeResult.Success
        }
    }

    private fun getEnigme(id: String) = StoreSingleton.modules.map { it.enigmes }.flatten().firstOrNull { it.id == id }

}

private object StoreSingleton {
    var compteARebours: Int = TimeConstants.dureeDuJeu
    var messageAide: String? = null
    var messageAideTTL: Int = 0
    var derniereAlarme: Int = 0
    var interrupteurGeneral: Boolean = false
    var terraformation: Boolean = false
    val modules = listOf(
        ModuleExterieur,
        ModuleHallEntree,
        ModuleSecuriteRoot,
        ModuleLevier,
        ModuleTerraforming,

        ModuleLumiereStation,
        ModuleSystemSolaire,
        ModuleSeulSurMars,
        ModuleSecuritePasswd,
        ModuleHautsParleur,
        ModuleTerraforming2
    )
}
