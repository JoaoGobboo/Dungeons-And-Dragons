package Character.Menus.Rules

class AttributeDistributor {
    private val pointBuyCosts = mapOf(
        8 to 0, 9 to 1, 10 to 2, 11 to 3, 12 to 4,
        13 to 5, 14 to 7, 15 to 9
    )

    fun distributePoints(): Map<String, Int> {
        val initialAttributes = mutableMapOf(
            "Força" to 8,
            "Destreza" to 8,
            "Constituição" to 8,
            "Inteligência" to 8,
            "Sabedoria" to 8,
            "Carisma" to 8
        )

        var pointsRemaining = 27

        for (attribute in initialAttributes.keys) {
            while (true) {
                println("Você tem $pointsRemaining pontos")
                println("$attribute:")

                val increase = readLine()?.toIntOrNull()

                if (increase == null || increase !in 8..15) {
                    println("Valor inválido. Insira um número entre 8 e 15.")
                    continue
                }

                val currentValue = initialAttributes[attribute]!!
                val newValue = increase
                val cost = pointBuyCosts.getValue(newValue) - pointBuyCosts.getValue(currentValue)

                if (cost > pointsRemaining) {
                    println("Você não tem pontos suficientes para aumentar este atributo.")
                } else {
                    initialAttributes[attribute] = newValue
                    pointsRemaining -= cost
                    break
                }
            }
        }

        return initialAttributes
    }
}
