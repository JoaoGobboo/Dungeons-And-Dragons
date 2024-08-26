package Character

class CharacterCreator {
    private val strategies: MutableList<CharacterCreationStrategy> = mutableListOf()

    fun addStrategy(strategy: CharacterCreationStrategy) {
        strategies.add(strategy)
    }

    fun createCharacter(name: String): Character {
        var character = Character(name)
        for (strategy in strategies) {
            character = strategy.apply(character)
        }
        return character
    }
}