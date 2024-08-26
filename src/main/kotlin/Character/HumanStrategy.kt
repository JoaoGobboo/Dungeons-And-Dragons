package Character

class HumanStrategy : CharacterCreationStrategy {
    override fun apply(character: Character): Character {
        character.strength += 1
        character.dexterity += 1
        character.constitution += 1
        character.intelligence += 1
        character.wisdom += 1
        character.charisma += 1
        return character
    }
}
