package Character

interface CharacterCreationStrategy {
    fun apply(character: Character): Character
}
