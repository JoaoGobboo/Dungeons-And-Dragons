package Character

class HalfOrcStrategy : CharacterCreationStrategy {
    override fun apply(character: Character): Character {
        character.strength += 2
        character.constitution += 1
        character.intelligence -= 1
        return character
    }
}
