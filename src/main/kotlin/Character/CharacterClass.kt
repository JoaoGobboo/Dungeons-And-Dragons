package Character

class CharacterClass(
    val name: String,
    val description: String,
    val bonusStats: Map<String, Int>
)

fun getClasses(): List<CharacterClass> {
    return listOf(
        CharacterClass(
            name = "Warrior",
            description = "Especialista em combate corpo a corpo com alta resistência. Força +4, Constituição +3",
            bonusStats = mapOf("força" to 4, "constituição" to 3)
        ),
        CharacterClass(
            name = "Archer",
            description = "Especialista em combate à distância com alta agilidade. Destreza +4, Carisma +2",
            bonusStats = mapOf("destreza" to 4, "carisma" to 2)
        ),
        CharacterClass(
            name = "Mage",
            description = "Especialista em magia com alta inteligência e habilidades mágicas. Inteligência +5",
            bonusStats = mapOf("inteligência" to 5)
        )
    )
}

fun applyClassBonus(character: Character, characterClass: CharacterClass) {
    characterClass.bonusStats.forEach { (stat, bonus) ->
        when (stat.toLowerCase()) {
            "força" -> character.strength += bonus
            "destreza" -> character.dexterity += bonus
            "constituição" -> character.constitution += bonus
            "inteligência" -> character.intelligence += bonus
            "sabedoria" -> character.wisdom += bonus
            "carisma" -> character.charisma += bonus
        }
    }
}
