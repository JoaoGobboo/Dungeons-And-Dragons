package Character

class DwarfStrategy : CharacterCreationStrategy {
    override fun apply(character: Character): Character {
        character.constitution += 2
        character.wisdom += 1
        return character
    }
}
