package Character.Menus

import Character.*
import Character.Menus.Rules.AttributeDistributor

class CharacterCreator {

    fun createCharacter(): Character {
        println("Bem-vindo à criação de personagem!")

        // Permitir que o jogador escolha uma classe
        val availableClasses = getClasses()
        println("Escolha uma classe:")
        availableClasses.forEachIndexed { index, characterClass ->
            println("${index + 1}. ${characterClass.name} - ${characterClass.description}")
        }

        val classChoice = readLine()?.toIntOrNull() ?: 1
        val chosenClass = availableClasses.getOrNull(classChoice - 1) ?: availableClasses.first()

        // Usar a classe AttributeDistributor para distribuir os atributos
        val distributor = AttributeDistributor()
        val attributes = distributor.distributePoints()

        val character = Character(
            name = getNameFromUser(),
            strength = attributes["Força"]!!,
            dexterity = attributes["Destreza"]!!,
            constitution = attributes["Constituição"]!!,
            intelligence = attributes["Inteligência"]!!,
            wisdom = attributes["Sabedoria"]!!,
            charisma = attributes["Carisma"]!!
        )

        // Aplicar os bônus da classe escolhida ao personagem
        applyClassBonus(character, chosenClass)

        // Exibir os pontos de vida calculados
        println("Pontos de vida do personagem: ${character.healthPoints}")

        // Exibir os atributos finais do personagem
        println("Personagem criado:")
        println("${character.name} - Força: ${character.strength}, Destreza: ${character.dexterity}, Inteligência: ${character.intelligence}")
        println("Constituição: ${character.constitution}, Sabedoria: ${character.wisdom}, Carisma: ${character.charisma}")

        return character
    }

    private fun getNameFromUser(): String {
        println("Digite o nome do personagem:")
        return readLine() ?: "Sem Nome"
    }
}
