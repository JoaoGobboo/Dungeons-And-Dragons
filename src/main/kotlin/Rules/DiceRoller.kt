package Character.Menus.Rules

import kotlin.random.Random

class DiceRoller {

    // Rolagem de um dado com o número especificado de lados
    fun roll(sides: Int): Int {
        require(sides > 0) { "O número de lados deve ser positivo." }
        return Random.nextInt(1, sides + 1)
    }

    // Rolagem de múltiplos dados com o mesmo número de lados
    fun rollMultiple(sides: Int, count: Int): List<Int> {
        require(count > 0) { "O número de dados deve ser positivo." }
        return List(count) { roll(sides) }
    }

    // Rolagem de dados padrão para D&D (ex: 4d6)
    fun roll4d6DropLowest(): Int {
        val rolls = rollMultiple(6, 4)
        return rolls.sorted().drop(1).sum()  // Descarta o menor valor e soma os 3 maiores
    }
}
