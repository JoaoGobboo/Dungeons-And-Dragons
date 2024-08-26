package Character.Menus

import Character.Character
import Character.Menus.Rules.DiceRoller

class CharacterManager {

    private val characters = mutableListOf<Character>()
    private val characterCreator = CharacterCreator()
    private val diceRoller = DiceRoller()

    fun displayMenu() {
        while (true) {
            println("Menu:")
            println("1. Criar um novo personagem")
            println("2. Listar personagens criados")
            println("3. Rolagem de dados")
            println("4. Sair")

            when (readLine()?.toIntOrNull()) {
                1 -> createCharacter()
                2 -> listCharacters()
                3 -> rollDice()
                4 -> return
                else -> println("Opção inválida. Tente novamente.")
            }
        }
    }

    private fun createCharacter() {
        val character = characterCreator.createCharacter()
        characters.add(character)
    }

    private fun listCharacters() {
        if (characters.isEmpty()) {
            println("Nenhum personagem criado ainda.")
            return
        }

        println("Personagens criados:")
        characters.forEach { character ->
            println("${character.name} - Força: ${character.strength}, Destreza: ${character.dexterity}, Inteligência: ${character.intelligence}")
            println("Constituição: ${character.constitution}, Sabedoria: ${character.wisdom}, Carisma: ${character.charisma}")
            println("Pontos de vida: ${character.healthPoints}")
            println()
        }
    }

    private fun rollDice() {
        println("Rolagem de Dados:")
        println("Escolha o tipo de dado:")
        println("1. D4")
        println("2. D6")
        println("3. D8")
        println("4. D10")
        println("5. D12")
        println("6. D20")
        println("7. 4d6 (descartar o menor)")

        when (readLine()?.toIntOrNull()) {
            1 -> println("Resultado do D4: ${diceRoller.roll(4)}")
            2 -> println("Resultado do D6: ${diceRoller.roll(6)}")
            3 -> println("Resultado do D8: ${diceRoller.roll(8)}")
            4 -> println("Resultado do D10: ${diceRoller.roll(10)}")
            5 -> println("Resultado do D12: ${diceRoller.roll(12)}")
            6 -> println("Resultado do D20: ${diceRoller.roll(20)}")
            7 -> println("Resultado de 4d6 (descartando o menor): ${diceRoller.roll4d6DropLowest()}")
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}
